package com.ry.cds.print.mapper;

import org.mapstruct.Mapper;

/**
 * 打印任务表mapper
 * 
 * @author Administrator
 *
 */
@Mapper
public interface PrintTaskMapper {
	/**
	 * 获取数据库当前时间戳
	 * 
	 * @return
	 */
	public long getTimestamp();

	/**
	 * 打印任务迁移
	 * 
	 * @param timestamp
	 */
	public int printTaskMigrate(long timestamp);

	/**
	 * 删除已迁移的打印任务
	 * 
	 * @param timestamp
	 */
	public int removeMigratedPrintTask(long timestamp);
}