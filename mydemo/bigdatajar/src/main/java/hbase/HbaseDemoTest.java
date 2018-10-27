package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created by supercena on 2017-06-10.
 */
public class HbaseDemoTest {

        public static void main(String[] args) {
                try {
                        Configuration configuration = HBaseConfiguration.create();
                        configuration.set("hbase.zookeeper.quorum", "mini1:2181,mini2:2181,mini3:2181");
                        Connection connection = ConnectionFactory.createConnection();
                        Admin admin = connection .getAdmin();
                        TableName tableName = TableName.valueOf("testtable");
                        HTableDescriptor desc = new HTableDescriptor(tableName);
                        HColumnDescriptor coldef = new HColumnDescriptor(   Bytes.toBytes("colfam1"));
                        desc.addFamily(coldef);
                        admin.createTable(desc);
                } catch (IOException e) {
                        e.printStackTrace();
                }

        }

}
