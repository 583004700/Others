package com.demo.yunxi.mergeSort;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileReader;

public class FileInfo {
    private File file;
    private FileReader fileReader;
    private boolean move = true;
    private Integer r;

    public FileInfo(File file) throws Exception{
        setFile(file);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) throws Exception{
        this.file = file;
        this.fileReader = new FileReader(file.getAbsoluteFile());
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public boolean getMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public Integer getNext() throws Exception{
        move = false;
        StringBuilder sb = new StringBuilder();
        char c = ' ';
        while ((c = (char) fileReader.read()) != ' ' && c!='\uFFFF') {
            sb.append(c);
        }
        String n = sb.toString();
        Integer nn = null;
        if (StringUtils.isNotEmpty(n)) {
            nn = Integer.valueOf(n);
        }
        r = nn;
        return nn;
    }

    public Integer getR(){
        return this.r;
    }
}
