package com.ry.xk.springbootframe.couchbase;

import java.io.IOException;

import com.couchbase.client.java.document.AbstractDocument;

public interface ICouchBaseOperationObject {
	public <T extends AbstractDocument<byte[]>> void reckon(T t) throws IOException;
}
