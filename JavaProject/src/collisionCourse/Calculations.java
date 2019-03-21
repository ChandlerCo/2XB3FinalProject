package collisionCourse;

import java.util.ArrayList;

import collisionCourse.CustomDataTypes.*;

public class Calculations {
	public static ArrayList<Entry> filter(ArrayList<Entry> data, Field field, int value, int range){
		ArrayList<Entry> filtered = new ArrayList<Entry>();
		
		// use merge sort on data 
		Algorithms.mergeSort(data, field);
		
		// use binary search to find range of values
		int start = Algorithms.binSearchBegin(data, field, value - range);
		int end = Algorithms.binSearchEnd(data, field, value + range);
		
		for (int i = start; i <= end; i++) {
			filtered.add(data.get(i));
		}
		
		return filtered;
	}
	
	public static double dangerPercent(ArrayList<Entry> data, int size) {
		return data.size() * 1.0/size;
	}
	
	public static double dangerSev(ArrayList<Entry> data, int sev) {
		int total = 0;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).get(Field.P_Isev) == sev) {
				total++;
			}
		}
		return (total * 1.0)/data.size();
	}
	
	public static double[] danger(Entry input, int range, ArrayList<Entry> data) {
		double[] calculations = new double[10];
		ArrayList<Entry> all = null;
		ArrayList<Entry> copy;
		boolean first = true;
		for (Field f : Field.values()) {
			if (input.get(f) >= 0) {
				if (first) {
					copy = data;
				}else {
					copy = all;
				}
				all = filter(copy, f, input.get(f), range);
			}
		}
		calculations[0] = dangerPercent(all, data.size());
		calculations[1] = dangerSev(all, 2);
		
		return calculations;
	}
}
