package handler.command.impl;

import executor.BaseExecutor;
import handler.command.OtherCommandHandler;
import thread.ThreadManager;

import java.io.PrintWriter;
import java.lang.reflect.Method;

public class JavaMethodHandler extends OtherCommandHandler implements Runnable{
    public JavaMethodHandler(String completeCommand, BaseExecutor executor) {
        super(completeCommand, executor);
    }

    @Override
    public Object handler() {
        ThreadManager.getExecutorService().execute(this);
        return null;
    }

    @Override
    public void run() {
        String command = getCommand();
        PrintWriter pw = getPrintWriter();
        try {
            String method = command;
            int left = method.indexOf("(");
            int right = method.lastIndexOf(")");
            int lastDot = method.substring(0,left).lastIndexOf(".");
            String methodName = method.substring(lastDot + 1, left);
            String className = method.substring(0, lastDot);
            String param = method.substring(left + 1, right);
            Class c = null;
            c = Class.forName(className);
            Method[] methods = c.getDeclaredMethods();
            for (Method m : methods) {
                if (m.getName().equals(methodName)) {
                    Object obj = c.newInstance();
                    Object ret = null;
                    if("".equals(param)){
                        ret = m.invoke(obj);
                    }else {
                        ret = m.invoke(obj, param.split(","));
                    }
                    pw.println(methodName+">方法返回值为>"+ret+">方法执行成功");
                    pw.flush();
                }
            }
        } catch (Exception e) {
            pw.println(e);
            pw.flush();
        }
    }
}
