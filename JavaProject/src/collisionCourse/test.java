/**
 * 
 */
package collisionCourse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import collisionCourse.CustomDataTypes.Field;

/**
 * @author 
 *
 */
class test {
	private ArrayList<Entry> data;
	private Entry user;
	private Entry x;
	private Entry y;
	private Entry z;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		data = new ArrayList<Entry>();
		x = new Entry(2005, 2, 1, 3, 1, 1, 2, 2000, 2, 22, 1);
		y = new Entry(2012, 4, 22, 1, 2, 2, 1, 2008, 1, 31, 2);
		z = new Entry(2007, 1, 12, 2, 1, 4, 1, 2001, 1, 26, -1);
		data.add(x);
		data.add(y);
		data.add(z);
		user = new Entry(-1, 1,1, 16, 2, 5, 1, 2007, 1, 27, -1);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Testing binSearchBegin algorithm. It finds the smallest index where 
	 * the value is greater than or equal to the input value. Because all
	 * values are greater or equal to 1 the output should be 0, the first index
	 */
	@Test
	void testBinSearchBegin() {
		int num;
		num = Algorithms.binSearchBegin(data, Field.C_Hour, 1);
		assertTrue(num == 0);
	}
	/**
	 * Testing binSearchEnd algorithm. Finds the last index where the value 
	 * is less than or equal to the input value. Because the first entry has 
	 * a value of 3 for hour the returned index will not be 0. Instead it will
	 * be 1 because the second entry has a value of 1 for hour.
	 */
	@Test
	void testBinSearchEnd() {
		int num;
		num = Algorithms.binSearchEnd(data, Field.C_Hour, 1);
		assertTrue(num == 1);
	}
	
	@Test
	/**
	 * Testing mergeSort algorithm. Will sort data in numerical order by any input
	 * field. When hour is inputed the first entry will have an hour of 1, the second
	 * will be 2, and the third will be 3. 
	 */
	void testMergeSort() {
		Algorithms.mergeSort(data, Field.C_Hour);
		assertTrue(data.get(1).getHour() == 2);
	}
	
	/**
	 * Testing sortHeap algorithm. Will sort data in numerical order by any input
	 * field. When hour is inputed the first entry will have an hour of 1, the second
	 * will be 2, and the third will be 3. 
	 */
	@Test
	void testHeapSort() {
		Algorithms.sortHeap(data, Field.C_Hour);
		assertTrue(data.get(2).getHour() == 3);
	}
	
	/**
	 * Testing filter. Will filter data depending on the field, value of said field, and
	 * range. For instance, if we input hour as the field, filtering for all values of 1
	 * with a range of 1, the new array will only contain entries with a value for hour that
	 * is between 0-2. Therefore, once filtered only 2 entries remain in the new array.
	 */
	@Test
	void testFilter() {
		ArrayList<Entry> filtered = new ArrayList<Entry>();
		filtered = Calculations.filter(data, Field.C_Hour, 1, 1);
		assertTrue(filtered.get(0).getHour() == 1);
		assertTrue(filtered.get(1).getHour() == 2);
	}
	
	/**
	 * Testing dangerPercent. Takes the size of the data and divides it by the input value.
	 * For instance, the data size is 3 in this case and if 4 is inputed then the percentage
	 * will be 75% or 0.75.
	 */
	@Test
	void testDangerPercent() {
		double percent;
		percent = Calculations.dangerPercent(data, 4);
		assertTrue(percent == 3.0/4.0);
	}
	
	/**
	 * Testing dangerSev. Calculates the percentage of a certain number of collisions with a 
	 * minimum severity. For instance, if we input the number of collision as 3 because our data
	 * size is 3 and a severity of 1, then it will calculate the number of entries that had a severity
	 * of 1 or greater which in this case is 2/3.
	 *
	 */
	@Test
	void testDangerSev() {
		double percent;
		percent = Calculations.dangerSev(data, 1, 3);
		assertTrue(percent == 2.0/3.0);
	}
	/**
	 * Testing danger. Calculates a most dangerous factors based on a given user profile. For instance,
	 * we define our user inputs in setup() and we put the number 5 to represent a range of certain
	 * information we want such as include the information of everyone within a 5 year range. Next
	 * it calculates percentages that match the criteria given the entries in data, what the user 
	 * inputed, and the range. After that it will calculate the percentage of severity that matches 
	 * the initial percentage. So, in this case the user entered '1' as gender. In data there are two
	 * entries with '1', therefore one percentage will be 2/3 = 66%. After that it will calculate who 
	 * out of that 66% were involved in a severe collision, and out of the two only one was involved
	 * in a severe collision, therefore that percentage will be 1/2 = 50%. And then the function 
	 * continues these types of calculations for other factors.
	 */
	@Test
	void testDanger() {
		Values info = Calculations.danger(user, 5, data);
		System.out.println(info.allPer() + " | " + info.allSev());
		for (int i = 0; i < 3; i++) {
			System.out.println(info.tpType(i) + ": " + info.tpPer(i) * 100 + " | " + info.tpSev(i) * 100);
		}
		System.out.println("---");
		for (int i = 0; i < 3; i++) {
			System.out.println(info.tsType(i) + ": " + info.tsPer(i) * 100 + " | " + info.tsSev(i) * 100);
		}
		assertTrue(info.tpPer(0) == 2.0/3.0);
		assertTrue(info.tpSev(0) == 1.0/2.0);
		assertTrue(info.tpPer(1) == 2.0/3.0);
		assertTrue(info.tpSev(1) == 1.0/2.0);
		assertTrue(info.tpPer(2) == 3.0/3.0);
		assertTrue(info.tpSev(2) == 1.0/3.0);
		assertTrue(info.tsPer(0) == 2.0/3.0);
		assertTrue(info.tsSev(0) == 1.0/2.0);
		assertTrue(info.tsPer(1) == 1.0/3.0);
		assertTrue(info.tsSev(1) == 1.0/1.0);
		assertTrue(info.tsPer(2) == 1.0/3.0);
		assertTrue(info.tsSev(2) == 1.0/1.0);
	}
	
}
