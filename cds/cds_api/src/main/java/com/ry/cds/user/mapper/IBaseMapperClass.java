package com.ry.cds.user.mapper;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public abstract class IBaseMapperClass<Entity>{
	@Autowired
	IBaseMapper iBaseMapper;
	//表名
	protected String tableName;
	//表的主键
	protected String primaryKey;
	//Entity对应的Calss类
	protected Class<Entity> entityClass;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IBaseMapperClass(String tableName, String primaryKey) {
		this.tableName = tableName;
		this.primaryKey = primaryKey;
		// 1获取子类的class(在创建子类对象的时候,会返回父类的构造方法)
        Class<? extends IBaseMapperClass> clazz = this.getClass();
        // 2获取当前类的带有泛型的父类类型
        ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
        // 3返回实际参数类型(泛型可以写多个)
        Type[] types = type.getActualTypeArguments();
        // 4 获取第一个参数(泛型的具体类) Person.class
        entityClass = (Class<Entity>) types[0];
	}

	/**
     * 通过主键查找固定的列,固定列名必须首字母必须小写，且和entity类的属性完全一致
	 * @param columnNames
     * @param primaryValue
     * @return
     */
	public Entity findByPrimaryKey(String columnNames,String primaryValue){
		return this.findSingByColumnName(columnNames, this.primaryKey, primaryValue);
	}

	/**
     * 通过列名查找固定的列,单条记录,固定列名必须首字母必须小写，且和entity类的属性完全一致
	 * @param columnNames
     * @param columnName
     * @param columnValue
     * @return
     */
	public Entity findSingByColumnName(String columnNames,String columnName,String columnValue){
		Map<String, String> map = new HashMap<String,String>();
		if(columnNames.indexOf(this.primaryKey)<0){
			columnNames = this.primaryKey+","+columnNames;
		}
		if(columnNames.indexOf(",") == columnNames.length()-1){
			columnNames = columnNames.substring(0,columnNames.length()-1);
		}
		map.put("tableName", this.tableName);
		map.put("columnNames", columnNames);
		map.put("columnName", columnName);
		map.put("columnValue", columnValue);
		Entity entity = null;
		try {
			entity = entityClass.newInstance();
			BeanUtils.populate(entity, iBaseMapper.findSingByColumnName(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	/**
     * 添加一条记录
	 * @param entity
     * @return
     */
	public int addOne(Entity entity) {
		String columnName = "";
		String values = "";
		Map<String, String> map = new HashMap<String,String>();
		try {
			Map<String,String> beanMap = BeanUtils.describe(entity);
			for (Map.Entry<String,String> entry : beanMap.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				if(!StringUtils.isEmpty(value) && !"class".equals(key)) {
					columnName += (key+",");
					values += ("'"+value+"',");
				}
			}
			columnName = columnName.substring(0,columnName.length()-1);
			values = values.substring(0,values.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("tableName", this.tableName);
		map.put("columnName", columnName);
		map.put("values", values);
		return iBaseMapper.addOne(map);
	}

	/**
	 * 通过主键更新记录
	 * @param entity
	 * @param primaryValue
	 * @return
	 */
	public int updateOne(Entity entity,String primaryValue){
		String keyValues = "";
		Map<String, String> map = new HashMap<String,String>();
		try {
			Map<String,String> beanMap = BeanUtils.describe(entity);
			for (Map.Entry<String,String> entry : beanMap.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				if(!StringUtils.isEmpty(value) && !"class".equals(key)) {
					keyValues += (key+"='"+value+"',");
				}
			}
			keyValues = keyValues.substring(0,keyValues.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("tableName", this.tableName);
		map.put("keyValues",keyValues);
		map.put("columnName", this.primaryKey);
		map.put("columnValue", primaryValue);
		return iBaseMapper.updateOne(map);
	}
}
