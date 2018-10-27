package com.zwb.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class TestHdfs {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://zwb107:9000");
        System.setProperty("HADOOP_USER_NAME", "root");
        FileSystem fileSystem = FileSystem.get(conf);
//        RemoteIterator<LocatedFileStatus> listFiles = fileSystem.listFiles(new Path("/"),false);
//        while(listFiles.hasNext()){
//            LocatedFileStatus lfs = listFiles.next();
//            Path path = lfs.getPath();
//            String filename = path.getName();
//            System.out.println(filename);
//        }

//        fileSystem.copyFromLocalFile(new Path("d:/hello.txt"), new Path("/"));
//        fileSystem.close();

        fileSystem.copyToLocalFile(new Path("/hello.txt"),new Path("d:/test"));
        //fileSystem.copyToLocalFile(false,new Path("/hello.txt"),new Path("d:/test"),true);
        fileSystem.close();
    }
}
