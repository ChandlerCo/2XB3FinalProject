package collisionCourse;

import java.util.ArrayList;

import collisionCourse.CustomDataTypes.*;

//import CustomDataTypes.java;
// searching (binary search)
// sorting (merge sort)
public class Algorithms {

	// binary search - needs to be able to find the first and last occurrences of a value
	/**
	 * Finds the smallest index where the value is greater than or equal to the input value
	 * 
	 * @param data The array of Entry values sorted according to field
	 * @param field The type of value being compared
	 * @param value The numeric value being compared against
	 * @return The index
	 */
	public static int binSearchBegin(ArrayList<Entry> data, Field field, int value) {
		int lo = 0;
        int hi = data.size() - 1;
        while (lo <= hi) {
            
            int mid = (hi + lo) / 2;
            
            if (value > data.get(mid).get(field)) {
            	lo = mid + 1;
            }else{
            	if (mid == 0) {
            		return 0;
            	}
            	if (value > data.get(mid - 1).get(field)) {
            		return mid;
            	}
            	hi = mid - 1;
            }
        }
        // means given value is greater than all entries, and will
        // return the length of the array
		return lo;
	}
	
	/**
	 * Finds the last index where the value is less than or equal to the input value
	 * 
	 * @param data The array of Entry values sorted according to field
	 * @param field The type of value being compared
	 * @param value The numeric value being compared against
	 * @return The index
	 */
	public static int binSearchEnd(ArrayList<Entry> data, Field field, int value) {
		int lo = 0;
        int hi = data.size() - 1;
        while (lo <= hi) {
            
            int mid = (hi + lo) / 2;
            
            if (value < data.get(mid).get(field)) {
            	hi = mid - 1;
            }else{
            	if (mid == data.size() - 1) {
            		return mid;
            	}
            	if (value < data.get(mid + 1).get(field)) {
            		return mid;
            	}
            	lo = mid + 1;
            }
        }
        // means given value is less than all entries 
		return -1;
	}
	
	// merge sort (cause its stable)
	/**
	 * In place merge sort
	 * 
	 * @param data The ArrayList of type Entry to be sorted 
	 * @param field The field type to be sorted on
	 */
	public static void mergeSort(ArrayList<Entry> data, Field field) {
		merge(data, field, 0, data.size() - 1);
	}
	
	private static void merge(ArrayList<Entry> data, Field field, int lo, int hi) {
		if ((hi - lo) < 7) {
			insertion(data, field, lo, hi);
			return;
		}
		
		int mid = (lo + hi)/ 2;
		
		merge(data, field, lo, mid);
		merge(data, field, mid + 1, hi);
		
		if (!less(data.get(mid + 1), data.get(mid), field)) {
			insertion(data, field, lo, hi);
	    }
	}
	
	private static void insertion(ArrayList<Entry> data, Field field, int lo, int hi) {
		for (int i = lo; i < hi + 1; i++) {
            for (int j = i; j > lo && less(data.get(j), data.get(j-1), field); j--) {
                exchange(data, j, j - 1);
            }
		}
	}
	
	private static boolean less(Entry a, Entry b, Field field) {
		return a.compareTo(b, field) < 0;
	}
	
	private static void exchange(ArrayList<Entry> data, int i, int j) {
		Entry tmp = data.get(i);
		data.set(i, data.get(j));
		data.set(i, tmp);
	}
}
