package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadManager {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static ExecutorService fileExecutorService;
    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

    public static ExecutorService getExecutorService(){
        return executorService;
    }

    public synchronized static ExecutorService getFileExecutorService(){
        if(fileExecutorService == null){
            fileExecutorService = Executors.newFixedThreadPool(15);
        }
        return fileExecutorService;
    }

    public static ScheduledExecutorService getScheduledExecutorService(){
        return scheduledExecutorService;
    }
}
