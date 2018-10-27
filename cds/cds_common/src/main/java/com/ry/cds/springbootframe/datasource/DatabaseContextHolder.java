package com.ry.cds.springbootframe.datasource;

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
