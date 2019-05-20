package common.mapper;

import common.annotation.Column;
import common.annotation.Id;
import common.annotation.Table;
import common.annotation.Transient;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.lang.reflect.Field;

public final class EntityProvider {
    public String insert(Object obj) throws Exception{
        MetaObject metaObject = SystemMetaObject.forObject(obj);
        String[] getterNames = metaObject.getGetterNames();
        String tableName = obj.getClass().getAnnotation(Table.class) != null ? ((Table)obj.getClass().getAnnotation(Table.class)).name() : null;
        tableName = tableName != null ? tableName : obj.getClass().getSimpleName();
        StringBuilder sb = new StringBuilder("insert into "+tableName);
        StringBuilder cols = new StringBuilder("(");
        StringBuilder values = new StringBuilder(" values(");
        int index = 0;
        for (int i = 0; i < getterNames.length; i++) {
            String propertyName = getterNames[i];
            Object value = metaObject.getValue(propertyName);
            boolean b = false;
            Field field = obj.getClass().getDeclaredField(propertyName);
            b = field.getAnnotation(Transient.class) == null;
            if (value != null && !value.equals("") && b) {
                String columnName = field.getAnnotation(Column.class) != null ? field.getAnnotation(Column.class).name() : null;
                columnName = columnName != null ? columnName : propertyName;
                cols.append(index == 0 ? columnName : ("," + columnName));
                values.append(index == 0 ? ("#{" + propertyName + "}") : (",#{" + propertyName + "}"));
                index++;
            }
        }
        cols.append(")");
        values.append(")");
        sb.append(cols).append(values);
        return sb.toString();
    }

    public String updateByPrimaryKey(Object obj) throws Exception{
        MetaObject metaObject = SystemMetaObject.forObject(obj);
        String[] getterNames = metaObject.getGetterNames();
        String tableName = obj.getClass().getAnnotation(Table.class) != null ? ((Table)obj.getClass().getAnnotation(Table.class)).name() : null;
        tableName = tableName != null ? tableName : obj.getClass().getSimpleName();
        StringBuilder sb = new StringBuilder("update "+tableName+" set ");
        StringBuilder colsValues = new StringBuilder();
        StringBuilder where = new StringBuilder(" where ");
        int columnIndex = 0;
        int whereIndex = 0;
        for (int i = 0; i < getterNames.length; i++) {
            String propertyName = getterNames[i];
            Object value = metaObject.getValue(propertyName);
            boolean b = false;
            Field field = obj.getClass().getDeclaredField(propertyName);
            b = field.getAnnotation(Transient.class) == null;
            Id id = field.getAnnotation(Id.class);
            String columnName = field.getAnnotation(Column.class) != null ? field.getAnnotation(Column.class).name() : null;
            columnName = columnName != null ? columnName : propertyName;
            if (value != null && !value.equals("") && b) {
                if(id != null){
                    where.append(whereIndex == 0 ? columnName+"="+("#{"+propertyName+"}") : (" and " + columnName+"="+("#{"+propertyName+"}")));
                    whereIndex++;
                }else{
                    colsValues.append(columnIndex == 0 ? columnName+"="+("#{"+propertyName+"}") : ("," + columnName+"="+("#{"+propertyName+"}")));
                    columnIndex++;
                }
            }
        }
        sb.append(colsValues).append(where);
        return sb.toString();
    }

    public String update(String propertyColumns,String whereColumns,Object obj) throws Exception{
        String[] propertyColumnsArr = propertyColumns.split(",");
        String[] whereColumnsArr = whereColumns.split(",");
        return updateP(propertyColumnsArr,whereColumnsArr,obj);
    }

    private String updateP(String[] propertyColumns,String[] whereColumns,Object obj) throws Exception{
        MetaObject metaObject = SystemMetaObject.forObject(obj);
        String tableName = obj.getClass().getAnnotation(Table.class) != null ? ((Table)obj.getClass().getAnnotation(Table.class)).name() : null;
        tableName = tableName != null ? tableName : obj.getClass().getSimpleName();
        StringBuilder sb = new StringBuilder("update "+tableName+" set ");
        StringBuilder colsValues = new StringBuilder();
        StringBuilder where = new StringBuilder(" where ");
        int columnIndex = 0;
        int whereIndex = 0;
        for (int i = 0; i < propertyColumns.length; i++) {
            String propertyName = propertyColumns[i];
            Object value = metaObject.getValue(propertyName);
            boolean b = false;
            Field field = obj.getClass().getDeclaredField(propertyName);
            b = field.getAnnotation(Transient.class) == null;
            String columnName = field.getAnnotation(Column.class) != null ? field.getAnnotation(Column.class).name() : null;
            columnName = columnName != null ? columnName : propertyName;
            if (value != null && !value.equals("") && b) {
                colsValues.append(columnIndex == 0 ? columnName+"="+("#{"+propertyName+"}") : ("," + columnName+"="+("#{"+propertyName+"}")));
                columnIndex++;
            }
        }
        for (int i = 0; i < whereColumns.length; i++) {
            String propertyName = whereColumns[i];
            Field field = obj.getClass().getDeclaredField(propertyName);
            String columnName = field.getAnnotation(Column.class) != null ? field.getAnnotation(Column.class).name() : null;
            columnName = columnName != null ? columnName : propertyName;
            where.append(whereIndex == 0 ? columnName+"="+("#{"+propertyName+"}") : (" and " + columnName+"="+("#{"+propertyName+"}")));
            whereIndex++;
        }
        sb.append(colsValues).append(where);
        return sb.toString();
    }

}
