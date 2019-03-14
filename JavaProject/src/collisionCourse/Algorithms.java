package collisionCourse;

import collisionCourse.CustomDataTypes.*;

//import CustomDataTypes.java;
// searching (binary search)
// sorting (merge sort)
public class Algorithms {

	// binary search - needs to be able to find the first and last occurrences of a value
	/**
	 * Finds the index such that the value at that index is greater than or equal to the input value
	 * At the same time, the value at the index one below should be less than or null
	 * Can also be used to find the first valid element for a range.
	 * 
	 * @param data The sorted array of collision entries
	 * @param field The type being compared
	 * @param value The value to be found
	 * @return The index
	 */
	public static int binSearchBegin(Entry[] data, Field field, int value) {
		int lo = 0;
        int hi = data.length - 1;
        while (lo <= hi) {
            
            int mid = (hi + lo) / 2;
            
            if (value > data[mid].get(field)) {
            	lo = mid + 1;
            }else{
            	if (mid == 0) {
            		return 0;
            	}
            	if (value > data[mid - 1].get(field)) {
            		return mid;
            	}
            	hi = mid - 1;
            }
        }
        // means given value is greater than all entries, and will
        // return the length of the array
		return lo;
	}
	
	public static int binSearchEnd(Entry[] data, Field field, int value) {
		int lo = 0;
        int hi = data.length - 1;
        while (lo <= hi) {
            
            int mid = (hi + lo) / 2;
            
            if (value < data[mid].get(field)) {
            	hi = mid - 1;
            }else{
            	if (mid == data.length - 1) {
            		return mid;
            	}
            	if (value < data[mid + 1].get(field)) {
            		return mid;
            	}
            	lo = mid + 1;
            }
        }
        // means given value is less than all entries 
		return -1;
	}
	
	// merge sort (cause its stable)
}
