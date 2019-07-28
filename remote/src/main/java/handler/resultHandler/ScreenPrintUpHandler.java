package handler.resultHandler;

import command.entity.JavaMethod;
import command.entity.OperatorComputer;
import executor.OperatorExecutor;
import handler.BaseHandler;
import handler.Handler;

import java.io.PrintWriter;

public class ScreenPrintUpHandler extends BaseResultHandler implements Runnable{
    private PrintWriter pw;

    public ScreenPrintUpHandler(String result) {
        super(result);
    }

    @Override
    public void run() {
        String[] arr = getResult().split(">");
        String ret = arr[2];
        if("success".equals(ret)){
            String filePath1 = arr[3];
            String filePath2 = JavaMethod.pFilePath+ OperatorExecutor.getOtherKey()+"/";
            String completeCommand = Handler.DOWNFILE+ BaseHandler.separator +filePath1+">"+filePath2;
            OperatorComputer.submitCommand(completeCommand);
            System.out.println("ScreenPrintUpHandler执行"+completeCommand);
        }
    }

    public PrintWriter getPw() {
        return pw;
    }

    public ScreenPrintUpHandler setPw(PrintWriter pw) {
        this.pw = pw;
        return this;
    }
}
