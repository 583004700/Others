package ssh.fileliisener;

import java.io.File;
import java.util.Date;

public class FileListener {
    private String filePath;
    /**
     * 文件上次改变时间
     */
    private long preModified;
    private File file;
    public FileListener(String filePath){
        this.filePath = filePath;
        preModified = new Date().getTime();
        this.file = new File(filePath);
    }

    /**
     * 判断当前文件是否发生变化
     * @return
     */
    public boolean isChange(){
        boolean isChange = false;
        long lastModified = file.lastModified();
        if(lastModified-preModified > 0){
            isChange = true;
            preModified = lastModified;
        }
        return isChange;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getPreModified() {
        return preModified;
    }

    public void setPreModified(long preModified) {
        this.preModified = preModified;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
