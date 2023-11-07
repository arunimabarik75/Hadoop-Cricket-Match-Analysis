package total_runs_player_wise;

import org.apache.hadoop.mapreduce.*;
import java.io.IOException;
import org.apache.hadoop.io.*;

public class ReducerClass extends Reducer<Text,IntWritable,Text,IntWritable>{
	@Override
	protected void reduce(Text key, Iterable<IntWritable> value,
			Reducer<Text, IntWritable, Text, IntWritable>.Context op) throws IOException, InterruptedException {
		
		int sum = 0;
		for(IntWritable data : value) {
			int b = data.get();
			sum = sum + b;
		}
		Text key1 = key;
		IntWritable oa = new IntWritable(sum);
		op.write(key1, oa);
	}
}
