package ssh.fileliisener;

import java.util.ArrayList;
import java.util.List;

public class FilesChangeListener implements Runnable{
    private List<FileChangeHandler> fileChangeHandlers = new ArrayList<FileChangeHandler>();

    public FilesChangeListener addFileListener(FileChangeHandler fileChangeHandler){
        fileChangeHandlers.add(fileChangeHandler);
        return this;
    }

    @Override
    public void run() {
        while(true) {
            for (FileChangeHandler fileChangeHandler : fileChangeHandlers) {
                fileChangeHandler.handler();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
