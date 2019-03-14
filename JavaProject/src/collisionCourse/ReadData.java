package collisionCourse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
	Entry[] Entries = new Entry[1];
	BufferedReader reader;{
	try {
		reader = new BufferedReader(new FileReader("NCDB_2016.txt"));
		reader.readLine();
		String line = reader.readLine();
		String [] array = line.split(",");
		int year = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int day = Integer.parseInt(array[2]);
        int hour = Integer.parseInt(array[3]);
        int wthr = Integer.parseInt(array[7]);
        int rsur = Integer.parseInt(array[8]);
        int vType = Integer.parseInt(array[12]);
        int vYear = Integer.parseInt(array[13]);
        int pSex = Integer.parseInt(array[15]);
        int pAge = Integer.parseInt(array[16]);
        int isev = Integer.parseInt(array[18]);
		Entries[0] = new Entry(year, month, day, hour, wthr, rsur, vType, vYear, pSex, pAge, isev);
	}catch (IOException e) {
		e.printStackTrace();
	}
}
}


