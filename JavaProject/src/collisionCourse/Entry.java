package collisionCourse;

import collisionCourse.CustomDataTypes.*;

public class Entry implements Comparable<Entry> {
    // variables
    private final int C_YEAR;
    private final int C_MONTH;
    private final int C_WDAY;
    private final int C_HOUR;
    private final int C_WTHR;
    private final int C_RSUR;
    
    private final int V_TYPE;
    private final int V_YEAR;
    
    private final int P_SEX;
    private final int P_AGE;
    private final int P_ISEV;
    
    // constructors
    public Entry(int cYear, int cMonth, int cDay, int cHour, int cWthr, int cRsur, int vType, int vYear, int pSex, int pAge, int pIsev) {
        this.C_YEAR = cYear;
        this.C_MONTH = cMonth;
        this.C_WDAY = cDay;
        this.C_HOUR = cHour;
        this.C_WTHR = cWthr;
        this.C_RSUR = cRsur;
        
        this.V_TYPE = vType;
        this.V_YEAR = vYear;
        
        this.P_SEX = pSex;
        this.P_AGE = pAge;
        this.P_ISEV = pIsev;
        
    }
    
    // accessors
    public int get(Field theField) {
    	if (theField == Field.C_Year) {
    		return this.C_YEAR;
    	}else if (theField == Field.C_Month) {
    		return this.C_MONTH;
    	}else if (theField == Field.C_Wday) {
    		return this.C_WDAY;
    	}else if (theField == Field.C_Hour) {
    		return this.C_HOUR;
    	}else if (theField == Field.C_Wthr) {
    		return this.C_WTHR;
    	}else if (theField == Field.C_Rsur) {
    		return this.C_RSUR;
    	}else if (theField == Field.V_Type) {
    		return this.V_TYPE;
    	}else if (theField == Field.V_Year) {
    		return this.V_YEAR;
    	}else if (theField == Field.P_Sex) {
    		return this.P_SEX;
    	}else if (theField == Field.P_Age) {
    		return this.P_AGE;
    	}else if (theField == Field.P_Isev) {
    		return this.P_ISEV;
    	}
    	return 0;
    }
    public int getYear() {
        return this.C_YEAR;
    }
    public int getMonth() {
        return this.C_MONTH;
    }
    public int getDay() {
        return this.C_WDAY;
    }
    public int getHour() {
        return this.C_HOUR;
    }
    public int getWthr() {
        return this.C_WTHR;
    }
    public int getRsur() {
        return this.C_RSUR;
    }
    
    public int getVType() {
        return this.V_TYPE;
    }
    public int getVYear() {
        return this.V_YEAR;
    }
    
    public int getPSex() {
        return this.P_SEX;
    }
    public int getPAge() {
        return this.P_AGE;
    }
    public int getPSev() {
        return this.P_ISEV;
    }
    // methods
    public String toString() {
        return "Year: " + this.getYear() + "\nMonth: " + this.getMonth() + "\nDay: " + this.getDay() + 
        		"\nWeather Condition: " + this.getWthr() + "\nRoad Surface" + this.getRsur() + 
        		"\nVehicle Type: " + this.getVType() + "\nVehicle Year: " + this.getVYear() +
        		"\nGender: " + this.getPSex() + "\nAge: " + this.getPAge() + "\nSeverity: " +
        		this.getPSev() + "\n";
    }
    
    // Don't use this method. It doesn't select which entry to compare on
    @Override
    public int compareTo(Entry that) {
        System.out.println("Use compareTo(Entry that, String value)");
        System.out.println("Where value is the value to compare, like C_WDAY");
        return 0;
    }
    
    
    public int compareTo(Entry that, Field value) {
        // TODO
        return this.get(value) - that.get(value);
    }
}
