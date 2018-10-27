package flowsum;

import common.Const;
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

//实现流量汇总，并按照总流量大小倒序 处理的数据是已经汇总的文件
public class FlowSumSort {
    public static class FlowSumSortMapper extends Mapper<LongWritable,Text,FlowBean,Text>{
        FlowBean flowBean = new FlowBean();
        Text v = new Text();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            String line = value.toString();
            String[] fields = line.split("\t");
            String phoneNumber = fields[0];
            long upFlowSum = Long.parseLong(fields[1]);
            long downFlowSum = Long.parseLong(fields[2]);
            flowBean.setUpFlow(upFlowSum);
            flowBean.setDownFlow(downFlowSum);
            v.set(phoneNumber);
            context.write(flowBean,v);
        }
    }

    public static class FlowSumSortReducer extends Reducer<FlowBean,Text,Text,FlowBean>{
        @Override
        protected void reduce(FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            Text phoneNumber = values.iterator().next();
            context.write(phoneNumber,key);
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
        job.setJarByClass(FlowSumSort.class);

        //告诉程序，我们的程序所用的mapper类和reducer类是什么
        job.setMapperClass(FlowSumSortMapper.class);
        job.setReducerClass(FlowSumSortReducer.class);

        //告诉框架，我们程序输出的数据类型
        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //设置分组规则
        //job.setGroupingComparatorClass(GroupComp.class);

        //告诉框架，我们程序使用的数据读取组件 结果输出所用的组件是什么
        //TextInputFormat是mapreduce程序中内置的一种读取数据组件  准确的说 叫做 读取文本文件的输入组件
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        //告诉框架，我们要处理的数据文件在那个路劲下
        //FileInputFormat.setInputPaths(job, new Path("/flowsum/input"));
        FileInputFormat.setInputPaths(job, new Path("d://flowsum/output"));

        //告诉框架，我们的处理结果要输出到什么地方
        //FileOutputFormat.setOutputPath(job, new Path("/flowsum/output"));
        FileOutputFormat.setOutputPath(job, new Path("d://flowsum/outputsort"));

        boolean res = job.waitForCompletion(true);
        System.exit(res?0:1);
    }
}
