package com.demo.ssh.fileliisener;

import com.demo.ssh.fileliisener.FileChangeUp;
import com.demo.ssh.SSHOperator;

/**
 * 文件改变时上传文件到服务器并重启
 */
public class FileChangeUpAndReset extends FileChangeUp {
    public FileChangeUpAndReset(String filePath, SSHOperator sshOperator, String toDir){
        super(filePath,sshOperator,toDir);
    }

    @Override
    public void handler() {
        //上传到服务器
        super.handler();
        reset();
    }

    protected void reset(){
        System.out.println("重启服务器");
    }
}
