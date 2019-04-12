package collisionCourse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadData {
	/**
	 * In the ReadData class there is only one function called Read that reads from the data file,
	 * puts all the information needed to an ArrayList of type Entry to easily manipulate
	 * @param file The file name of the data set
	 * @return returns an ArrayList of type Entry that contains all the necessary information
	 * 		   from the data set
	 * @throws IOException
	 */
	public static ArrayList<Entry> Read(String file) throws IOException{
		int year;
		int month;
		int day;
		int hour;
		int wthr;
		int rsur;
		int vType;
		int vYear;
		int pSex;
		int pAge;
		int iSev;
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(file));
		ArrayList<Entry> Data = new ArrayList<Entry>();
		String line = reader.readLine();
		while(true) {
			line = reader.readLine();
			if(line == null) {
				break;
			}
			String[] array = line.split(",");
			year = Integer.parseInt(array[0]);
			
			if(array[1].contentEquals("UU") || array[1].contentEquals("XX")) {
				month = -1;
			}
			else {
				month = Integer.parseInt(array[1]);
			}
			
	        if(array[2].contentEquals("U") || array[2].contentEquals("X")) {
	        	 day = -1;
	        }
	        else {
	        	day = Integer.parseInt(array[2]);
	        }
	        
	        if(array[3].contentEquals("UU") || array[3].contentEquals("XX")) {
	        	hour = -1;
	        }
	        else {
	        	hour = Integer.parseInt(array[3]);
	        }
	        
	        if(array[8].equals("Q") || array[8].equals("U") || array[8].equals("X")) {
	        	wthr = -1;
	        }
	        else {
	        	wthr = Integer.parseInt(array[8]);
	        }
	        
	        if(array[9].contentEquals("Q") || array[9].contentEquals("U") || array[9].contentEquals("X")) {
	        	rsur = -1;
	        }
	        else {
		        rsur = Integer.parseInt(array[9]);
	        }
	        
	        if(array[13].contentEquals("NN") || array[13].contentEquals("QQ") 
	        		|| array[13].contentEquals("UU") || array[13].contentEquals("XX")) {
	        	vType = -1;
	        }
	        else {
	        	vType = Integer.parseInt(array[13]);
	        }
	        
	        if(array[14].contentEquals("NNNN") || array[14].contentEquals("UUUU") 
	        		|| array[14].contentEquals("XXXX")) {
	        	vYear = -1;
	        }
	        else {
	        	vYear = Integer.parseInt(array[14]);
	        }
	        
	        if(array[16].contentEquals("F")) {
	        	pSex = 1;
	        }
	        else if(array[16].contentEquals("M")) {
	        	pSex = 2;
	        }
	        else {
	        	pSex = -1;
	        }
	        
	        if(array[17].contentEquals("NN") || array[17].contentEquals("UU") 
	        		|| array[17].contentEquals("XX")) {
	        	pAge = -1;
	        }
	        else {
	        	pAge = Integer.parseInt(array[17]);
	        }
	        
	        if(array[19].contentEquals("N") || array[19].contentEquals("U") 
	        		|| array[19].contentEquals("X")) {
	        	iSev = -1;
	        }
	        else {
	        	iSev = Integer.parseInt(array[19]);
	        }
	        
	        Data.add(new Entry(year, month, day, hour, wthr, rsur, vType, vYear, pSex, pAge, iSev));
		}
		reader.close();
		return Data;
	}
	/*
	public static void main(String args[]) throws IOException{
		ArrayList<Entry> Data = Read("data/NCDB_2016.csv");
		System.out.println(Data.get(0).toString());
	}*/
}