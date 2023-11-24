package top_3_bowler;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class PartitionerClass extends Partitioner<Text,Text>{

	String team1;

	PartitionerClass(){
		this.team1 = "";
	}

	@Override
	public int getPartition(Text arg0, Text arg1, int arg2) {
		
		String key = arg0.toString();
		String [] k = key.split("[,]");
		
		if(this.team1.equals("")) {
			this.team1 = k[1];
		}

		if(k[1].equals(this.team1)) {
			return 0;
		}
		else {
			return 1;
		}
	}
}