package top_3_bowler;

import org.apache.hadoop.mapreduce.*;
import java.io.IOException;
import org.apache.hadoop.io.*;

public class MapperClass extends Mapper<LongWritable,Text,Text,Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		String data = value.toString();
		String [] k = data.split("[,]");
		if(k[10].equals("caught")||k[10].equals("bowled")) {
			if(k[4].equals("Australia")) {
				String v = k[7]+",England";
				Text oa = new Text(v);
				Text ob = new Text("1");
				context.write(oa, ob);
			}
			else {
				String v = k[7] +",Australia";
				Text oc = new Text(v);
				Text od = new Text("1");
				context.write(oc, od);
			}
		}
	}

}
