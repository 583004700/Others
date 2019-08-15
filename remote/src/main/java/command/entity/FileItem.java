package command.entity;

public class FileItem {
    //文件名称
    private String fileName;
    //文件大小
    private String fileSize;
    //文件类型
    private String fileType;
    //最后修改时间
    private String lastM;
    //文件路径
    private String realPath;

    public String getFileName() {
        return fileName;
    }

    public FileItem setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getFileSize() {
        return fileSize;
    }

    public FileItem setFileSize(String fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public String getFileType() {
        return fileType;
    }

    public FileItem setFileType(String fileType) {
        this.fileType = fileType;
        return this;
    }

    public String getLastM() {
        return lastM;
    }

    public FileItem setLastM(String lastM) {
        this.lastM = lastM;
        return this;
    }

    public String getRealPath() {
        return realPath;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }
}
