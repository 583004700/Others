package com.ry.cds.springbootframe.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		Object object = DatabaseContextHolder.getDatabaseType();
		return object;
	}

}