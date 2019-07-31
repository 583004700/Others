package com.demo.ssh;

import com.demo.ssh.fileliisener.FileChangeUp;
import com.demo.ssh.fileliisener.FilesChangeListener;
import com.demo.ssh.thread.ThreadManager;

public class Main {
    //ssh操作的会话
    public static SSHOperator sshOperator = new SSHOperator("root","root","192.168.33.11",22);

    public static void main(String[] args) {
        dealFile();
    }

    public static void dealFile(){
        FilesChangeListener filesChangeListener = new FilesChangeListener();
        filesChangeListener.addFileListener(new FileChangeUp("D:/remotefile/你好.txt",sshOperator,"/weblogic/remotefile"));

        ThreadManager.getExecutorService().execute(filesChangeListener);
    }
}
