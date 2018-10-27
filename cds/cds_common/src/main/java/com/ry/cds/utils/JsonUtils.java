package com.ry.cds.utils;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json工具类
 */
public class JsonUtils {

	private static ObjectMapper mapper;

	public static synchronized ObjectMapper getMapperInstance() {
		if (null == mapper) {
			mapper = new ObjectMapper();
		}
		return mapper;
	}
	
	/**
	 * 将对象转为json字符串
	 * @param obj
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String BeanToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = getMapperInstance();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		return objectMapper.writeValueAsString(obj);
	}

	public static Object JsonToBean(String json, JavaType javaType) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = getMapperInstance();
		return objectMapper.readValue(json, javaType);
	}
	
	/**
	 * 将json字符串转为对象类型
	 * @param json
	 * @param cls
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T JsonToBean(String json, Class<T> cls) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = getMapperInstance();
		return objectMapper.readValue(json, cls);
	}

	public static <T> T JsonToListBean(String json, TypeReference<T> valueTypeRef) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = getMapperInstance();
		return objectMapper.readValue(json, valueTypeRef);
	}
}