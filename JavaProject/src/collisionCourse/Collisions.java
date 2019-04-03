package collisionCourse;

import java.io.IOException;
import java.util.ArrayList;

// contains the main function
public class Collisions {
	public static void main(String[] args) throws IOException{
		// int cYear, int cMonth, int cDay, int cHour, int cWthr, int cRsur, int vType, int vYear, int pSex, int pAge, int pIsev
		ArrayList<Entry> data = ReadData.Read("data\\NCDB_2016.csv");
		Entry userProfile = new Entry(-1, 1,1, 1, 1, 2, 1, 1999, 2, 20, -1);
		Values info = Calculations.danger(userProfile, 3, data);
		
		System.out.println(info.allPer() + " | " + info.allSev());
		for (int i = 0; i < 3; i++) {
			System.out.println(info.tpType(i) + ": " + info.tpPer(i) * 100 + " | " + info.tpSev(i) * 100);
		}
		System.out.println("---");
		for (int i = 0; i < 3; i++) {
			System.out.println(info.tsType(i) + ": " + info.tsPer(i) * 100 + " | " + info.tsSev(i) * 100);
		}
	}
}
