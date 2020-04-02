package thread;

import java.util.concurrent.*;

public class ThreadManager {
    private static int threadNum = Runtime.getRuntime().availableProcessors() * 100;

    private static ExecutorService executorService = new ThreadPoolExecutor(threadNum, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());
    private static ExecutorService fileExecutorService;
    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(20);

    public static ExecutorService getExecutorService(){
        return executorService;
    }

    public synchronized static ExecutorService getFileExecutorService(){
        if(fileExecutorService == null){
            fileExecutorService = Executors.newFixedThreadPool(threadNum);
        }
        return fileExecutorService;
    }

    public static ScheduledExecutorService getScheduledExecutorService(){
        return scheduledExecutorService;
    }
}
