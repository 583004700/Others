package com.ry.cds.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;
import com.ry.cds.user.bo.OssFile;
import com.ry.cds.user.bo.SystemConfig;

/**
 * OSS文档工具类
 * 
 * @author 幸仁强
 * @createtime 2018-2-23
 */
public class FileOperator {
	private static Logger logger = LoggerFactory.getLogger(FileOperator.class);
	private static String _accessId;

	private static String _accessKey;

	private static String _baseUrl;

	private static String _bucketName;

	private static String _downloadBaseUrl;

	public FileOperator(String accessId, String accessKey, String aliyunKey, String baseUrl, String bucketName,
			String downloadBaseUrl) throws Exception {
		_accessId = CryptogramHelper.decryptThreeDESECB(accessId, aliyunKey);
		_accessKey = CryptogramHelper.decryptThreeDESECB(accessKey, aliyunKey);
		_baseUrl = baseUrl;
		_bucketName = bucketName;
		_downloadBaseUrl = downloadBaseUrl;
	}

	public FileOperator(SystemConfig ossView) throws Exception {
		_accessId = CryptogramHelper.decryptThreeDESECB(ossView.getAliyunAccessId(), ossView.getConfigKey());
		_accessKey = CryptogramHelper.decryptThreeDESECB(ossView.getAliyunAccessKey(), ossView.getConfigKey());
		_baseUrl = ossView.getAliyunBaseUrl();
		_bucketName = ossView.getCdsFileBucket();
		_downloadBaseUrl = ossView.getAliyunDownloadBaseUrl();
	}

	public OssFile UploadFile(String filename, InputStream sm, ObjectMetadata data, String directory,
			boolean isFileNameEncode) throws Exception {
		try {
			ClientConfiguration clientconfig = new ClientConfiguration();
			//设置连接不超时
			clientconfig.setConnectionTimeout(ClientConfiguration.DEFAULT_CONNECTION_REQUEST_TIMEOUT);
			//创建oss客户端
			OSSClient oss = new OSSClient("http://" + _baseUrl, _accessId, _accessKey, clientconfig);
			Tuple<String> ossKey = GetOssKey(filename, directory, isFileNameEncode);
			oss.putObject(_bucketName, ossKey._(1), sm, data);
			OssFile of = new OssFile();
			String hostUrl = String.format("http://%s.%s/", _bucketName, _downloadBaseUrl);
			String key = ossKey._(0);
			of.setHostUrl(hostUrl);
			of.setKey(key);
			return of;
		} catch (Exception ex) {
			logger.error(String.format("上传文件失败,filename：%s", filename), ex);
			throw ex;
		}
	}

	public OssFile UploadFile(String filename, InputStream sm, String directory, boolean isFileNameEncode)
			throws Exception {
		try {
			ClientConfiguration clientconfig = new ClientConfiguration();
			clientconfig.setConnectionTimeout(ClientConfiguration.DEFAULT_CONNECTION_REQUEST_TIMEOUT);
			OSSClient oss = new OSSClient("http://" + _baseUrl, _accessId, _accessKey, clientconfig);
			Tuple<String> ossKey = GetOssKey(filename, directory, isFileNameEncode);
			ObjectMetadata data = new ObjectMetadata();
			data.setContentType(getContentType(filename));
			data.setContentLength(sm.available());
			oss.putObject(_bucketName, ossKey._(1), sm, data);
			OssFile of = new OssFile();
			String hostUrl = String.format("http://%s.%s/", _bucketName, _downloadBaseUrl);
			String key = ossKey._(0);
			of.setHostUrl(hostUrl);
			of.setKey(key);
			return of;
		} catch (Exception ex) {
			logger.error(String.format("上传文件失败,filename：%s", filename), ex);
			throw ex;
		}
	}

	/**
	 * 得到处理后缀名的文件全路径和没有经过处理后缀名的文件全路径
	 * @param filename
	 * @param directory
	 * @param isFileNameEncode
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private Tuple<String> GetOssKey(String filename, String directory, boolean isFileNameEncode)
			throws UnsupportedEncodingException {
		//得到文件拓展名
		String fileNameIncludeExtension = filename.substring(filename.lastIndexOf("/") + 1);
		if (isFileNameEncode) {
			fileNameIncludeExtension = URLEncoder.encode(fileNameIncludeExtension, "UTF-8");
		}
		//用来保存文件全路径包含拓展名
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isNotBlank(directory)) {
			sb.append(directory.toLowerCase()).append("/");
			filename = MessageFormat.format("{0}/{1}", directory.toLowerCase(), filename);
		}
		sb.append(fileNameIncludeExtension);
		Tuple<String> tuple = Tuple.make(sb.toString(), filename);
		return tuple;
	}

	/**
	 * 从OSS下载文件得到文件流
	 * @param fileName
	 * @param directory
	 * @param isFileNameEncode
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public InputStream DownLoadFile(String fileName, String directory, boolean isFileNameEncode)
			throws UnsupportedEncodingException {
		if (StringUtils.isBlank(fileName)) {
			return null;
		}
		if (isFileNameEncode) {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		}
		OSSClient oss = new OSSClient("http://" + _baseUrl, _accessId, _accessKey);
		String key = fileName;
		if (StringUtils.isNotBlank(directory)) {
			key = MessageFormat.format("{0}/{1}", directory.toLowerCase(), key);
		}
		OSSObject ossObj = oss.getObject(_bucketName, key);
		return ossObj.getObjectContent();
	}
	/**
	 * 从OSS下载得到文件对象
	 * @param fileName
	 * @param directory
	 * @param isFileNameEncode
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public OSSObject DownLoadFileObject(String fileName, String directory, boolean isFileNameEncode)
			throws UnsupportedEncodingException {
		OSSClient oss = new OSSClient("http://" + _baseUrl, _accessId, _accessKey);
		if (isFileNameEncode) {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		}
		String key = fileName;
		if (StringUtils.isNotBlank(directory)) {
			key = MessageFormat.format("{0}/{1}", directory.toLowerCase(), key);
		}
		OSSObject result = oss.getObject(new GetObjectRequest(_bucketName, key));
		return result;
	}
	
	/**
	 * 从OSS删除文件
	 * @param fileName
	 * @param directory
	 * @param isFileNameEncode
	 * @throws Exception
	 */
	public void DeleteFile(String fileName, String directory, boolean isFileNameEncode) throws Exception {
		try {
			OSSClient oss = new OSSClient("http://" + _baseUrl, _accessId, _accessKey);
			if (isFileNameEncode) {
				fileName = URLEncoder.encode(fileName, "UTF-8");
			}
			String key = fileName;
			if (StringUtils.isNotBlank(directory)) {
				key = MessageFormat.format("{0}/{1}", directory.toLowerCase(), key);
			}
			oss.deleteObject(_bucketName, key);
		} catch (Exception ex) {
			logger.error("文件不存在", ex);
			throw ex;
		}
	}

	private List<String> GetFileByMarker(OSSClient oss, String prefix, String marker) {
		try {
			ListObjectsRequest request = new ListObjectsRequest(FileOperator._bucketName);
			request.setMaxKeys(1000);
			request.setPrefix(prefix);
			request.setDelimiter("/");
			request.setMarker(marker);
			ObjectListing listing = oss.listObjects(request);
			List<OSSObjectSummary> ossObjList = listing.getObjectSummaries();
			List<String> fileList = new ArrayList<String>();
			for (OSSObjectSummary ossobj : ossObjList) {
				fileList.add(ossobj.getKey());
			}
			return fileList;
		} catch (Exception ex) {
			logger.error(MessageFormat.format("获取目录下文件出错,Prefix:{0},Marker:{1}", prefix, marker), ex);
			return Collections.emptyList();
		}
	}

	public List<String> GetFiles(String prefix, String mark, List<String> allowFiles) {
		List<String> result = new ArrayList<String>();
		ClientConfiguration clientconfig = new ClientConfiguration();
		clientconfig.setConnectionTimeout(ClientConfiguration.DEFAULT_CONNECTION_REQUEST_TIMEOUT);
		OSSClient oss = new OSSClient("http://" + _baseUrl, _accessId, _accessKey, clientconfig);
		List<String> tempFiles = GetFileByMarker(oss, prefix, mark);
		for (String file : tempFiles) {
			String ext = file.substring(file.lastIndexOf(".") + 1);
			if (StringUtils.isNotBlank(ext) && (allowFiles == null || allowFiles.contains(ext.toLowerCase()))) {
				result.add(file);
			}
			mark = file;
		}
		while (ListHelper.isNotEmpty(tempFiles) && tempFiles.size() == 1000 && StringUtils.isNotBlank(mark)) {
			tempFiles = GetFileByMarker(oss, prefix, mark);
			for (String file : tempFiles) {
				String ext = file.substring(file.lastIndexOf(".") + 1);
				if (StringUtils.isNotBlank(ext) && (allowFiles == null || allowFiles.contains(ext.toLowerCase()))) {
					result.add(file);
				}
				mark = file;
			}
		}
		return result;
	}

	/**
	 * 通过文件名判断并获取OSS服务文件上传时文件的contentType
	 * 
	 * @param fileName
	 *            文件名
	 * @return 文件的contentType
	 */
	public static final String getContentType(String fileName) {
		Path path = Paths.get(fileName);
		String contentType = null;
		try {
			contentType = Files.probeContentType(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentType;
	}
}
