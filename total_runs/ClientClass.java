package total_runs;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.io.*;

public class ClientClass {
	public static void main(String [] arg)throws Exception{
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(ClientClass.class);
		job.setMapperClass(MapperClass.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		job.setReducerClass(ReducerClass.class);
		Path input_path = new Path(arg[0]);
		Path output_path = new Path(arg[1]);
		FileInputFormat.addInputPath(job, input_path);
		FileOutputFormat.setOutputPath(job, output_path);
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		job.waitForCompletion(true);
    }
}
