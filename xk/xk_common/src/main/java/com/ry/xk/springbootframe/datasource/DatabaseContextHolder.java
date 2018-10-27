package com.ry.xk.springbootframe.datasource;

import com.ry.xk.common.DatabaseType;

public class DatabaseContextHolder {
	private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<DatabaseType>();

	public static void setDatabaseType(DatabaseType databaseType) {
		contextHolder.set(databaseType);
	}

	public static DatabaseType getDatabaseType() {
		return (DatabaseType) contextHolder.get();
	}

	public static void clearDatabaseType() {
		contextHolder.remove();
	}
}
