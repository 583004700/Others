package com.ry.cds.springbootframe.couchbase;

public enum CouchBaseSectionType {
	USER(1), PRINT(2);

	private int index;

	CouchBaseSectionType(int index) {
		this.index = index;
	}

	public int getIndex() {
		return this.index;
	}
}
