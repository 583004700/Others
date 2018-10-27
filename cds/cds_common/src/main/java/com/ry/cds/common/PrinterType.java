package com.ry.cds.common;

public enum PrinterType {
	ES(1), EM(2),EC(3);

	private int index;

	PrinterType(int index) {
		this.index = index;
	}

	public int getIndex() {
		return this.index;
	}
}
