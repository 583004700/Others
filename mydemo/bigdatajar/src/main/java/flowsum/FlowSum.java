package flowsum;

import common.Const;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.util.Iterator;

public class FlowSum {
    //在kv中传输我们的对象是可以的，不过必须要实现hadoop的序列化机制，也就是实现Writeable
    public static class FlowSumMap extends Mapper<LongWritable,Text,Text,FlowBean>{
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String[] fields = StringUtils.split(line,"\t");
            String phoneNumber = fields[1];
            long upFlow = Long.parseLong(fields[fields.length-3]);
            long downFlow = Long.parseLong(fields[fields.length-2]);
            context.write(new Text(phoneNumber),new FlowBean(upFlow,downFlow));
        }
    }

    public static class FlowSumReducer extends Reducer<Text,FlowBean,Text,FlowBean>{
        @Override
        protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
            Iterator<FlowBean> iterator = values.iterator();
            FlowBean sum = new FlowBean();
            while(iterator.hasNext()){
                FlowBean flowBean = iterator.next();
                sum.setUpFlow(sum.getUpFlow()+flowBean.getUpFlow());
                sum.setDownFlow(sum.getDownFlow()+flowBean.getDownFlow());
            }
            context.write(new Text(key),sum);
        }
    }

    public static void main(String[] args) throws Exception{
        System.setProperty(Const.HADOOP_HOME_KEY, Const.HADOOP_HOME_VALUE);

        Configuration conf = new Configuration();
        //注释掉下面那行,本地调试模式
        //conf.set("fs.defaultFS", "hdfs://zwb107:9000");
//		conf.set("mapreduce.framework.name", "yarn");
//		conf.set("yarn.resourcemanager.hostname", "zwb107");
        Job job = Job.getInstance(conf);

        //$JAVA_HOMEbin -cp hdfs-2.3.4.jar:mapreduce-2.0.6.4.jar;
        //告诉框架，我们的的程序所在jar包的位置
//		job.setJar("/root/wordcount.jar");
        job.setJarByClass(FlowSum.class);

        //告诉程序，我们的程序所用的mapper类和reducer类是什么
        job.setMapperClass(FlowSumMap.class);
        job.setReducerClass(FlowSumReducer.class);

        //告诉框架，我们程序输出的数据类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //告诉框架，我们程序使用的数据读取组件 结果输出所用的组件是什么
        //TextInputFormat是mapreduce程序中内置的一种读取数据组件  准确的说 叫做 读取文本文件的输入组件
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        //告诉框架，我们要处理的数据文件在那个路劲下
        //FileInputFormat.setInputPaths(job, new Path("/flowsum/input"));
        FileInputFormat.setInputPaths(job, new Path("d://flowsum/input"));

        //告诉框架，我们的处理结果要输出到什么地方
        //FileOutputFormat.setOutputPath(job, new Path("/flowsum/output"));
        FileOutputFormat.setOutputPath(job, new Path("d://flowsum/output"));

        boolean res = job.waitForCompletion(true);

        System.exit(res?0:1);
    }
}
