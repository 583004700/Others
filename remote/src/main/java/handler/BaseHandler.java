package handler;

public abstract class BaseHandler<T> implements Handler<T>{
    protected Object[] param;
    public BaseHandler(Object... param){
        this.param = param;
    }
}
