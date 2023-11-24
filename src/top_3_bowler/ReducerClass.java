package top_3_bowler;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class ReducerClass extends Reducer<Text,Text,Text,Text>{

	@Override
	protected void reduce(Text key, Iterable<Text> value, Reducer<Text, Text, Text, Text>.Context op)
			throws IOException, InterruptedException {
		
		String ar1[] = new String[10000];
		String ar2[] = new String[10000];
		int ar3[] = new int[10000];
		int a = 0;

		for(Text data : value) {
			String v = data.toString();
			String [] k = v.split("[,]");

			ar1[a] = k[0];
			ar2[a] = k[1];
			ar3[a] = Integer.parseInt(k[2]);
			++a;
		}

		String ss ="";
		int t =0;
		for(int i =0 ;i<a;++i) {
			for(int j=0;j<a-1;++j) {
				if(ar3[j]<ar3[j+1]) {
					ss = ar1[j];
					ar1[j] = ar1[j+1];
					ar1[j+1] = ss;
					ss= ar2[j];
					ar2[j]= ar2[j+1];
					ar2[j+1] = ss;
					t = ar3[j];
					ar3[j] = ar3[j+1];
					ar3[j+1] = t;
				}
			}
		}

		if(ar1[0] != null) {
		Text oa = new Text(ar1[0]+",against "+ar2[0]);
		Text ob = new Text(Integer.toString(ar3[0]));
		op.write(oa, ob);
		}
		
		if(ar1[1] != null) {
		Text oc = new Text(ar1[1]+",against "+ar2[1]);
		Text od = new Text(Integer.toString(ar3[1]));
		op.write(oc, od);
		}

		if(ar1[2] != null) {
		Text oe = new Text(ar1[2]+",against "+ar2[2]);
		Text of = new Text(Integer.toString(ar3[2]));
		op.write(oe, of);
		}
	}
}