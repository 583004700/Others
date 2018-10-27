package com.demo.quartzdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class LoadXmlTests {

    static Log logger = LogFactory.getLog(Listing_3_6.class);

    private Scheduler createScheduler() throws SchedulerException {//创建调度器
        return new StdSchedulerFactory("quartz.properties").getScheduler();
    }

    public static void main(String[] args) {
        LoadXmlTests loadXmlTests = new LoadXmlTests();
        try {
            Scheduler scheduler = loadXmlTests.createScheduler();

            // Start the scheduler running
            scheduler.start();

            logger.info("Scheduler started at " + new Date());

            // Stop the scheduler after 10 second
            Thread.sleep(20000);
            //scheduler.shutdown();
        } catch (SchedulerException e) {
            logger.error(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
