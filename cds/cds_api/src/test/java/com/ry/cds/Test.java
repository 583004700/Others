package com.ry.cds;

import com.ry.cds.common.CommonConst;
import com.ry.cds.utils.CryptogramHelper;

public class Test {

	public static void main(String[] args) throws Exception {
		/**
		 * Cluster cluster = CouchbaseCluster.create("10.0.2.190"); Bucket bucket =
		 * cluster.openBucket("MOTK-User", "ruanyun2014", 3000, TimeUnit.SECONDS);
		 * 
		 * byte[] gzipUnCompressByte = GZipUtil
		 * .uncompress(bucket.get("test_king_arthur",
		 * ByteArrayDocument.class).content()); UserInfo userinfo=
		 * ProtoBufUtil.deserializer(gzipUnCompressByte, UserInfo.class);
		 * System.out.println("deSerializerResult:" + userinfo.toString());
		 **/
		// User user = new User();
		// System.out.println(user.couchbaseSection().getIndex());

		String pdfUrl = "hudongyjp.oss-cn-hanzhou.aliyuncs.com";

		System.out.println(
				CryptogramHelper.decryptThreeDESECB(String.valueOf("TWeRPPJpvU9v9m3clBw/RQ=="), CommonConst.DESKEY));
		System.out.println(CryptogramHelper.decryptThreeDESECB(String.valueOf("8ktpcMcXRkA="), CommonConst.DESKEY));

		System.out.println(CryptogramHelper.encryptThreeDESECB(String.valueOf(65), CommonConst.DESKEY));

	}

}
