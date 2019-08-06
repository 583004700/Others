package command;

import executor.ServerExecutor;
import handler.Handler;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import thread.ThreadManager;
import util.IOUtil;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class SocketServer {
    static class HeartThread implements Runnable{
        @Override
        public void run() {
            Set<Map.Entry<String,Socket>> set = registerSockets.entrySet();
            for(Map.Entry<String,Socket> r : set){
                Socket socket = r.getValue();
                PrintWriter printWriter = null;
                try {
                    printWriter = IOUtil.wrapPrintWriter(socket.getOutputStream(),PropertiesConst.appEncoding);
                    printWriter.println(Handler.HEART+Handler.separator);
                    printWriter.flush();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        HeartThread heartThread = new HeartThread();
        ThreadManager.getScheduledExecutorService().scheduleWithFixedDelay(heartThread,30,30, TimeUnit.SECONDS);
    }

    public static ConcurrentHashMap<String, Socket> registerSockets = new ConcurrentHashMap<String, Socket>();
    private static Hashtable<String, Socket> filesSockets = new Hashtable<String, Socket>();
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
                    ThreadManager.getExecutorService().execute(serverExecutor);
                    System.out.println("-----------------------------------------------");
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
//        Socket socket = SocketProxy.getInstance(filesSockets,key,target);
        return target;
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
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String,Socket>> entries = registerSockets.entrySet();
        for(Map.Entry<String,Socket> m:entries){
            sb.append(m.getKey());
            sb.append(",");
        }
        return sb.toString();
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
