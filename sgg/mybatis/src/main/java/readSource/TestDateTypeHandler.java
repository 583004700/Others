package readSource;

import org.apache.ibatis.type.DateTypeHandler;

import java.sql.Timestamp;
import java.util.Date;

public class TestDateTypeHandler {
    public static void main(String[] args) {
        DateTypeHandler dateTypeHandler = new DateTypeHandler();
        System.out.println(dateTypeHandler.getRawType());
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());
    }
}
