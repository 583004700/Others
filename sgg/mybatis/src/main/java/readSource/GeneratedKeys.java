package readSource;

import java.sql.*;

public class GeneratedKeys {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "root");
        DatabaseMetaData databaseMetaData = conn.getMetaData();
        boolean s = databaseMetaData.supportsGetGeneratedKeys();

        String sql = "insert into cat(cat_age,cat_name) values(?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,33);
        preparedStatement.setString(2,"张三");
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        int key = resultSet.getInt(2);
        System.out.println(key);
    }
}
