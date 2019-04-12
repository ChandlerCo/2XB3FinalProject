package collisionCourse;

import java.util.ArrayList;

import collisionCourse.CustomDataTypes.*;

/**
 * Uses algorithms to manipulate data to get meaningful results
 * Finds the total percentage and severity percentage
 * 
 * @author Chandler Co
 *
 */
public class Calculations {
	/**
	 * Filters a data set only taking items matching a criteria
	 * 
	 * @param data The dataset to search through
	 * @param field The Attribute being compared
	 * @param value The value of the attribute
	 * @param range The range of the value
	 * @return A list of relevant collisions
	 */
	public static ArrayList<Entry> filter(ArrayList<Entry> data, Field field, int value, int range){
		ArrayList<Entry> filtered = new ArrayList<Entry>();
		
		// use merge sort on data 
		Algorithms.sortHeap(data, field);
		//System.out.println(">" + data.get(0).getPAge());
		// use binary search to find range of values
		int start = Algorithms.binSearchBegin(data, field, value - range);
		int end = Algorithms.binSearchEnd(data, field, value + range);
		/*System.out.println(start + " - " + end);
		for (int i = 0; i < 30; i++) {
			System.out.println(data.get(i).getPAge());
		}
		*/
		for (int i = start; i <= end; i++) {
			filtered.add(data.get(i));
		}
		
		return filtered;
	}
	
	/**
	 * Calculates the percentage of total collisions matching a criteria
	 * 
	 * @param data The array of collision entries matching the criteria
	 * @param size The total number of collisions
	 * @return The percentage
	 */
	public static double dangerPercent(ArrayList<Entry> data, int size) {
		return data.size() * 1.0/size;
	}
	
	/**
	 * Calculates the percentage of collisions with a minimum severity
	 * 
	 * @param data The array of collision entries to be looked at
	 * @param sev The severity level to filter upon
	 * @param size The total number of collisions to be used for percentage
	 * @return The percentage
	 */
	public static double dangerSev(ArrayList<Entry> data, int sev, int size) {
		int total = 0;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).get(Field.P_Isev) >= sev) {
				total++;
			}
		}
		return (total * 1.0)/size;
	}
	
	/**
	 * Calculates a most dangerous factors based on a given user profile
	 * 
	 * @param input The user profile information
	 * @param range The desired range for select values. Ex for age, provide a range +/-
	 * @param data The complete collision data to be referenced
	 * @return The values in an object holding percentages and associated fields
	 */
	public static Values danger(Entry input, int range, ArrayList<Entry> data) {
		Values calcs = new Values();
		// entries matching all criteria
		ArrayList<Entry> all = data;
		for (Field f : Field.values()) {
			if (input.get(f) >= 0) {
				if (f == Field.C_Hour || f == Field.V_Year || f == Field.P_Age) {
					all = filter(all, f, input.get(f), range);
				}else {
					all = filter(all, f, input.get(f), 0);
				}
			}
		}
		calcs.setAll(dangerPercent(all, data.size()), dangerSev(all, 1, all.size()));
		
		// entries of all, saving top
		all = data;
		ArrayList<Entry> copy = null;
		for (Field f : Field.values()) {
			if (input.get(f) >= 0) {
				//System.out.println(input.get(f) + " " + all.size());
				if (f == Field.C_Hour || f == Field.V_Year || f == Field.P_Age) {
					copy = filter(all, f, input.get(f), range);
				}else {
					copy = filter(all, f, input.get(f), 0);
				}
				calcs.setTop(dangerPercent(copy, data.size()), dangerSev(copy, 2, copy.size()), f);
			}
		}
		return calcs;
	}
}
