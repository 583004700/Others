package com.ry.cds;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ry.cds.user.service.AbstractFileProcessor;
import com.ry.cds.user.service.FileProcessor;
import com.ry.cds.utils.DateUtil;
import com.ry.cds.utils.FileUtil;

@Component
public class FileProcessorController {
	private static Logger log = LoggerFactory.getLogger(FileProcessorController.class);
	private List<AbstractFileProcessor> _processors = new ArrayList<AbstractFileProcessor>();
	private static String Processed_Flag = ".processed";
	private static String Backup_Path = "/backup/";

	private static String Error_Path = "/error/";

	@Autowired
	FileProcessor printedFileProcessor;

	public void Register() {
		_processors.add(printedFileProcessor);
	}

	/**
	 * 扫描文件 对每一个FileProcessor提供的文件夹进行扫描
	 */
	public void scan() {
		for (AbstractFileProcessor processor : _processors) {
			if (!processor.isBusy()) {
				try {
					createDirectory(processor.getPath());
					String file = getOneFile(processor.getPath());
					if (file != null) {
						process(processor, file);
					}
				} catch (Exception ex) {
					log.error(String.format("Process: {%s}", processor.getClass().toString()), ex);
				}

			}
		}
	}

	/**
	 * 创建或检查backup和error文件夹
	 * 
	 * @param path
	 */
	private void checkAndCreateBackupOrErrorPath(String path) {
		File buckupDirectory = new File(path + Backup_Path);
		if (!buckupDirectory.isDirectory()) {
			buckupDirectory.mkdirs();
		}
		File errorDirectory = new File(path + Error_Path);
		if (!errorDirectory.isDirectory()) {
			errorDirectory.mkdirs();
		}
	}

	/**
	 * 进行一个文件处理
	 * 
	 * @param processor
	 *            文件处理器
	 * @param file
	 *            当前处理的文件路径
	 */
	private void process(AbstractFileProcessor processor, String fileUrl) {
		int count = 0;
		try {
			count = processor.process(fileUrl);
		} catch (Exception ex) {

			log.error(String.format("文件处理错误 %s by %s", fileUrl, processor.toString()), ex);
			count = -1;
		}
		checkAndCreateBackupOrErrorPath(processor.getPath());
		backup(count, fileUrl, processor.getPath());

	}

	/**
	 * Backup文件
	 * 
	 * @param count
	 *            处理成功的数据条数
	 * @param file
	 *            当前处理文件的路径
	 * @param path
	 *            备份路径
	 */
	private void backup(int count, String file, String path) {
		String destFilePath = path + Backup_Path + FileUtil.getFileNameWithoutExtension(file) + "."
				+ DateUtil.getDateString("yyyy-MM-dd-HH-mm-ss");
		if (count == -1) {
			destFilePath = path + Error_Path + FileUtil.getFileNameWithoutExtension(file) + "."
					+ DateUtil.getDateString("yyyy-MM-dd-HH-mm-ss");
		}
		if (count > 0 || count == -1) {
			try {
				File afile = new File(file);
				afile.renameTo(new File(destFilePath));
			} catch (Exception ex) {
				log.error(String.format("移动文件出错,destFilePath:%s", destFilePath), ex);
			}
		} else {
			try {
				File afile = new File(file);
				afile.delete();
			} catch (Exception ex) {
				log.error(String.format("删除文件出错,file:%s", file), ex);
			}
		}
	}

	/**
	 * 获取一个可以处理的文件
	 * 
	 * @param path
	 *            获取文件的目录
	 * @return
	 */
	private String getOneFile(String path) {
		File folder = new File(path);
		// 获得该文件夹内的所有文件
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.getPath().indexOf(Processed_Flag) < 0 && file.getPath().indexOf(".txt") > -1) {
				String newFileName = file.getPath().replace("\\", "/") + Processed_Flag;
				if (DateUtil.dateCompare(DateUtil.getDateString("yyyy-MM-dd HH:mm:ss"),
						getDateTimeFromFileName(file.getPath())) >= 0) {
					try {
						File afile = new File(file.getPath());
						afile.renameTo(new File(newFileName));
						return newFileName;
					} catch (Exception ex) {

					}
				}
			}
		}
		return null;
	}

	/**
	 * 从文件名字中获取时间
	 * 
	 * @param file
	 *            当前处理的文件路径
	 * @return
	 */
	private String getDateTimeFromFileName(String file) {
		try {
			String dateTimeInfo = FileUtil.getFileNameWithoutExtension(file).split("_")[1];
			String[] numbers = dateTimeInfo.split("-");
			String month = numbers[0];
			String day = numbers[1];
			String year = numbers[2];
			String hour = "00";
			if (numbers.length > 3) {
				hour = numbers[3];
			}

			String minutes = "00";
			String second = "00";
			String dateTime = year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + second;
			return dateTime;
		} catch (Exception ex) {
			log.error(String.format("从文件名字中获取时间出错,file:%s", file), ex);
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + 10);
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

		}
	}

	/**
	 * 创建文件夹
	 * 
	 * @param folder
	 *            文件夹路径
	 */
	private void createDirectory(String folder) {

		File directory = new File(folder);
		if (!directory.isDirectory()) {
			directory.mkdirs();
		}
	}

}