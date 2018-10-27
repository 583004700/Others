package com.demo.quartzdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class SchedulerMain {
    static Log logger = LogFactory.getLog(SchedulerMain.class);

    public static void main(String[] args) {
        SchedulerMain app = new SchedulerMain();
        app.startScheduler();
    }
    public void startScheduler() {
        try {
            // Create an instance of the Scheduler
            Scheduler scheduler =
                    StdSchedulerFactory.getDefaultScheduler();

            logger.info("Scheduler starting up...");
            scheduler.start();
            final Runtime runtime = Runtime.getRuntime();
            Process process = null;//
            final String cmd = "rundll32 url.dll FileProtocolHandler file://D:\\工作资料\\需要看的流程规范";
            try {
                process = runtime.exec(cmd);
            } catch (final Exception e) {
                System.out.println("Error exec!");
            }
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

}
