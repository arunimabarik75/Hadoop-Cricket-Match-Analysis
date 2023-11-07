package total_runs_player_wise;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class PartitionerClass extends Partitioner<Text,IntWritable>{

	PartitionerClass() {
		String team1 = "";
	}

	@Override
	public int getPartition(Text arg0, IntWritable arg1, int arg2) {
		String key = arg0.toString();
		String [] k = key.split("[,]");
		String c = k[1];

		if (team1 == ""){
			team1 = c;
		}

		if(c.equals(team1)) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
