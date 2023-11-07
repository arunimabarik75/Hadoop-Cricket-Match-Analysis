package total_runs_player_wise;

import org.apache.hadoop.mapreduce.*;
import java.io.IOException;
import org.apache.hadoop.io.*;

public class MapperClass extends Mapper<LongWritable,Text,Text,IntWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String data = value.toString();
		String [] k = data.split("[,]");
		String t ="";
		t = t + k[5]+","+ k[4];
		int val = Integer.parseInt(k[8]);
		Text oa = new Text(t);
		IntWritable ob = new IntWritable(val);
		context.write(oa, ob);
	}

}
