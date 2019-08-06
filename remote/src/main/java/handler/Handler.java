package handler;

/**
 * 处理不同的指令类型
 */
public interface Handler{
    //命令分隔符
    String separator = ":";
    //cmd指令
    String CMD = "cmd";
    //添加OtherComputer
    String REGISTER = "register";

    String OPERATE = "operate";
    //下载文件
    String DOWNFILE = "downfile";
    //上传文件
    String UPFILE = "upfile";
    //代表下载时较验成功，能创建文件
    String DOWNFILESUCCESS = "downfilesuccess";
    //代表上传时较验成功，能找到文件
    String UPFILESUCCESS = "upfilesuccess";

    //cmd交互
    String CMDBEGIN = "cmdbegin";
    String CMDEND = "cmdend";
    //java方法
    String JAVA = "java";
    //查看列表
    String LIST = "list";
    //心跳检测
    String HEART = "heart";

    Object handler();

    //------------------------------------------获取到反馈后要进行处理的----------------------------------

    //截图上传方法，如果截图成功，则再上传到我的电脑
    String screenPrintUp = "screenPrintUp>";
    //文件上传成功，对方接收到之后，作相应的处理
    String receiveSuccess = "receiveSuccess>";
    //返回列表
    String returnList = "returnList:";
}
