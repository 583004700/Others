package command;

import executor.ServerExecutor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import util.IOUtil;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SocketServer {
    private static ConcurrentHashMap<String, Socket> registerSockets = new ConcurrentHashMap<String, Socket>();
    private static ConcurrentHashMap<String, Socket> filesSockets = new ConcurrentHashMap<String, Socket>();
    private static ConcurrentHashMap<String, Socket> registerOperators = new ConcurrentHashMap<String, Socket>();
    private Socket socket;

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(PropertiesConst.serverLocalPort);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                String inetAddressStr = socket.getInetAddress().toString();
                System.out.println(inetAddressStr);
                InputStream in = socket.getInputStream();
                String str = IOUtil.readLinStr(in, PropertiesConst.appEncoding);
                if(str == null){
                    System.out.println("null");
                }else {
                    System.out.println("SocketServer:" + str);

                    SocketServer socketServer = new SocketServer();
                    socketServer.setSocket(socket);

                    ServerExecutor serverExecutor = new ServerExecutor(str,socketServer);
                    serverExecutor.execute();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void registerSocket(String key,Socket value){
        registerSockets.put(key,value);
    }

    public void registerOperatorsSocket(String key,Socket value){
        registerOperators.put(key,value);
    }

    public Socket getFileSocket(String key){
        Socket target = filesSockets.get(key);
        Socket socket = SocketProxy.getInstance(filesSockets,key,target);
        return socket;
    }

    public void addFileSocket(String key,Socket value){
        filesSockets.put(key,value);
    }

    public void removeFileSocket(String key){
        filesSockets.remove(key);
    }

    public Socket getRegisterSocket(String key){
        Socket target = registerSockets.get(key);
        Socket socket = SocketProxy.getInstance(registerSockets,key,target);
        return socket;
    }

    //获取列表
    public String getRegisterSocketList(){
        return registerSockets.toString();
    }

    public Socket getRegisterOperatorSocket(String key){
        Socket target = registerOperators.get(key);
        Socket socket = SocketProxy.getInstance(registerOperators,key,target);
        return socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}


/**
 * socket close时，每次都要把map中的数据remove掉
 */
class SocketProxy implements MethodInterceptor{
    private Map<String,Socket> map;
    private String key;
    private Object target;

    private SocketProxy(Map<String, Socket> map, String key, Object target) {
        this.map = map;
        this.key = key;
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("close")){
            if(map.containsKey(key)){
                System.out.println("从map中移除");
                map.remove(key);
            }
        }
        return method.invoke(target,objects);
    }

    public static Socket getInstance(Map<String, Socket> map, String key, Object target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Socket.class);
        enhancer.setCallback(new SocketProxy(map,key,target));
        return target == null ? null : (Socket)enhancer.create();
    }
}
