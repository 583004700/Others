package ssh.fileliisener;

/**
 * 文件改变时要做的处理
 */
public abstract class FileChangeHandler {
    private FileListener fileListener;
    public FileChangeHandler(FileListener fileListener){
        this.fileListener = fileListener;
    }

    public FileListener getFileListener() {
        return fileListener;
    }

    public void setFileListener(FileListener fileListener) {
        this.fileListener = fileListener;
    }

    abstract void handler();
}
