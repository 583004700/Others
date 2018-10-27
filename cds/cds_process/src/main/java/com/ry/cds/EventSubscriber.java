package com.ry.cds;

import com.ry.cds.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventSubscriber implements DisposableBean, Runnable {
	private static Logger log = LoggerFactory.getLogger(EventSubscriber.class);
	private Thread thread;
	private volatile boolean someCondition = true;

	EventSubscriber() {
		System.out.println("EventSubscriber"+this+"初始化");
		this.thread = new Thread(this);
	}

	@Autowired
	FileProcessorController fileProcessorController;

	@Override
	public void run() {
		fileProcessorController.Register();
		while (someCondition) {
			try {
				fileProcessorController.scan();
				System.out.println("扫描文件");
				Object object = SpringContextUtil.getBean("fileProcessorController");
				System.out.println("fileProcessorController"+object);
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				log.error("文件扫描处理异常：", e);
			}
		}
	}

	@Override
	public void destroy() {
		someCondition = false;
		System.out.println("EventSubscriber"+this+"销毁");
	}

}