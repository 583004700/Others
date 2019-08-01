package handler.resultHandler;

import command.entity.JavaMethod;
import command.entity.OperatorComputer;
import executor.OperatorExecutor;
import handler.BaseHandler;
import handler.Handler;

public class ScreenPrintUpHandler extends BaseResultHandler implements Runnable{
    public ScreenPrintUpHandler(OperatorComputer operatorComputer, String result) {
        super(operatorComputer,result);
    }

    @Override
    public void run() {
        String[] arr = getResult().split(">");
        String ret = arr[2];
        if("success".equals(ret)){
            String filePath1 = arr[3];
            String filePath2 = JavaMethod.pFilePath+ OperatorExecutor.getOtherKey()+"/";
            String completeCommand = Handler.DOWNFILE+ BaseHandler.separator +filePath1+">"+filePath2;
            getOperatorComputer().submitCommand(completeCommand);
            System.out.println("ScreenPrintUpHandler执行"+completeCommand);
        }
    }

}
