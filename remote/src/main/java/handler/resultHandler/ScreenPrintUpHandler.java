package handler.resultHandler;

import command.entity.JavaMethod;
import command.entity.Operator;
import executor.OperatorExecutor;
import handler.BaseHandler;
import handler.Handler;

public class ScreenPrintUpHandler extends BaseResultHandler implements Runnable{
    public ScreenPrintUpHandler(Operator operator, String result) {
        super(operator,result);
    }

    @Override
    public void run() {
        String[] arr = getResult().split(">");
        String ret = arr[2];
        if("success".equals(ret)){
            String filePath1 = arr[3];
            String filePath2 = JavaMethod.pFilePath+ getOperator().getOtherKey()+"/";
            String completeCommand = Handler.DOWNFILE+ BaseHandler.separator +filePath1+">"+filePath2;
            getOperator().submitCommand(completeCommand);
            System.out.println("ScreenPrintUpHandler执行"+completeCommand);
        }
    }

}
