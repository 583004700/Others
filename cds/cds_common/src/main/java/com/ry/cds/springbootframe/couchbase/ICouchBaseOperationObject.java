package com.ry.cds.springbootframe.couchbase;

import java.io.IOException;

import com.couchbase.client.java.document.AbstractDocument;

public interface ICouchBaseOperationObject {
	public <T extends AbstractDocument<byte[]>> void subtract(T t) throws IOException;
}
