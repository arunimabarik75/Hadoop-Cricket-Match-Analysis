package top_3_bowler;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class PartitionerClass extends Partitioner<Text,Text>{
	@Override
	public int getPartition(Text arg0, Text arg1, int arg2) {
		
		String key = arg0.toString();
		String [] k = key.split("[,]");
		if(k[1].equals("Australia")) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
