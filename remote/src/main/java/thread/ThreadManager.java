package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static ExecutorService getExecutorService(){
        return executorService;
    }

}
