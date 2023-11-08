package top_3_batsman;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class CombinerClass extends Reducer<Text,Text,Text,Text>{
	@Override
	protected void reduce(Text key, Iterable<Text> value, Reducer<Text, Text, Text, Text>.Context op)
			throws IOException, InterruptedException {
		
		int sum = 0;
		for(Text data : value){
			String t = data.toString();
			int b = Integer.parseInt(t);
			sum = sum + b;
		}
		String k = Integer.toString(sum);
		
		String s = key.toString();
		Text oa = new Text("player");
		s = s+","+k;
		Text ob = new Text(s);
		op.write(oa, ob);
	}
	
}
