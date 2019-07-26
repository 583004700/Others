package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static ExecutorService fileExecutorService;

    public static ExecutorService getExecutorService(){
        return executorService;
    }

    public synchronized static ExecutorService getFileExecutorService(){
        if(fileExecutorService == null){
            fileExecutorService = Executors.newFixedThreadPool(15);
        }
        return fileExecutorService;
    }
}
