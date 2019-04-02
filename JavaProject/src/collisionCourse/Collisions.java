package collisionCourse;

import java.io.IOException;
import java.util.ArrayList;

// contains the main function
public class Collisions {
	public static void main(String[] args) throws IOException{
		ArrayList<Entry> data = ReadData.Read("data\\NCDB_2016.csv");
		Entry userProfile = new Entry(-1, 1,1, 1, 1, 2, 1, 1999, 2, 20, -1);
		Values info = Calculations.danger(userProfile, 2, data);
		
		System.out.println(info.allPer() + " | " + info.allSev());
		for (int i = 0; i < 3; i++) {
			System.out.println(info.topType(i) + ": " + info.topPer(i) + " | " + info.topSev(i));
		}
	}
}
