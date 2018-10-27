package com.ry.cds.print.dao;

/**
 * 打印任务持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface IPrintTaskDao {
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