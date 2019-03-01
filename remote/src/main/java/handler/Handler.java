package handler;

/**
 * 处理不同的指令类型
 */
public interface Handler <T>{
    T handler();
}
