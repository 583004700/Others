package com.ry.cds.springbootframe.couchbase;

public interface ICouchBaseStoredObject {
	/**
	 * couchbase中的Key
	 * 
	 * @return
	 */
	String key();

	/**
	 * Key的格式
	 * 
	 * @return
	 */
	String keyFormat();

	/**
	 * 将存储到哪个Bucket
	 * 
	 * @return
	 */
	CouchBaseSectionType couchbaseSection();
}
