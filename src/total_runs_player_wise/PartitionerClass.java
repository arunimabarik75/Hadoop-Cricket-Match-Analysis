package total_runs_player_wise;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class PartitionerClass extends Partitioner<Text,IntWritable>{

	String team1;
	
	PartitionerClass() {
		this.team1 = "";
	}

	@Override
	public int getPartition(Text arg0, IntWritable arg1, int arg2) {
		String key = arg0.toString();
		String [] k = key.split("[,]");
		String c = k[1];

		if (this.team1 == ""){
			this.team1 = c;
		}

		if(c.equals(this.team1)) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
