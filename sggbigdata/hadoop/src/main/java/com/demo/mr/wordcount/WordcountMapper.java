package com.demo.mr.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// 输入数据key 输入数据value 输出数据key 输出数据value
public class WordcountMapper extends Mapper<LongWritable, Text,Text, IntWritable> {

}
