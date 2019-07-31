package com.demo.ssh.fileliisener;

import com.demo.ssh.fileliisener.FileChangeHandler;
import com.demo.ssh.SSHOperator;

/**
 * 文件改变时上传到服务器
 */
public class FileChangeUp extends FileChangeHandler {
    private String toDir;
    private SSHOperator sshOperator;

    public FileChangeUp(String filePath,SSHOperator sshOperator,String toDir) {
        super(new ssh.fileliisener.FileListener(filePath));
        this.sshOperator = sshOperator;
        this.toDir = toDir;
    }

    @Override
    public void handler() {
        try {
            //如果文件发生了改变，则上传到服务器
            if(getFileListener().isChange()) {
                sshOperator.putFile(getFileListener().getFile().getParent(), getFileListener().getFile().getName(), toDir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
