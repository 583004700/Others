package readSource;

import java.sql.*;

/**
 * ResultSet.TYPE_FORWORD_ONLY 结果集的游标只能向下滚动。

 ResultSet.TYPE_SCROLL_INSENSITIVE 结果集的游标可以上下移动，当数据库变化时，当前结果集不变。

 ResultSet.TYPE_SCROLL_SENSITIVE 返回可滚动的结果集，当数据库变化时，当前结果集同步改变。

 参数 int concurrency

 ResultSet.CONCUR_READ_ONLY 不能用结果集更新数据库中的表。

 ResultSet.CONCUR_UPDATETABLE 能用结果集更新数据库中的表。
 */

public class ResultSetType {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "root");

        String selectAll = "select * from cat";
        PreparedStatement p = conn.prepareStatement(selectAll,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet r = p.executeQuery();


        String sql = "insert into cat(cat_age,cat_name) values(?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,33);
        preparedStatement.setString(2,"张三");
        preparedStatement.execute();
        int row = preparedStatement.getUpdateCount();

        r = p.executeQuery();
        r.last();
        System.out.println(r.getRow());
        System.out.println(row);
    }
}
