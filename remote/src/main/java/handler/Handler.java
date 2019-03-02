package handler;

/**
 * 处理不同的指令类型
 */
public interface Handler{
    //cmd指令
    String CMD = "cmd";
    //添加
    String REGISTER = "register";
    Object handler();
}
