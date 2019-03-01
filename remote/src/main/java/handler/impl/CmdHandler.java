package handler.impl;

import command.CmdUtil;
import handler.BaseHandler;

/**
 * cmd命令处理
 */
public class CmdHandler<T> extends BaseHandler<T>{

    public CmdHandler(Object[] param){
        super(param);
    }

    @Override
    public T handler() {
        String result = CmdUtil.execCloseReturnStr(((String)param[0]).split("&"));
        return (T)result;
    }
}
