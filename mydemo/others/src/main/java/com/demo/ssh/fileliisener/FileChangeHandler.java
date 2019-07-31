package com.demo.ssh.fileliisener;

/**
 * 文件改变时要做的处理
 */
public abstract class FileChangeHandler {
    private ssh.fileliisener.FileListener fileListener;
    public FileChangeHandler(ssh.fileliisener.FileListener fileListener){
        this.fileListener = fileListener;
    }

    public ssh.fileliisener.FileListener getFileListener() {
        return fileListener;
    }

    public void setFileListener(ssh.fileliisener.FileListener fileListener) {
        this.fileListener = fileListener;
    }

    abstract void handler();
}
