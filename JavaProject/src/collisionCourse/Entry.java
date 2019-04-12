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
    /**
     * Creates a collision entry
     * 
     * @param cYear Year of the collision
     * @param cMonth Month of the collision
     * @param cDay Weekday of the collision
     * @param cHour Hour of the collision in 24 hour format
     * @param cWthr Weather conditions of collision
     * @param cRsur Road surface conditions of collision
     * @param vType Vehicle type
     * @param vYear Vehicle model year
     * @param pSex Person sex
     * @param pAge Person age
     * @param pIsev Person severity
     */
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
    /**
     * Gets value based on field
     * 
     * @param theField The field value wanted
     * @return The value
     */
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
    /**
     * Gets the collision year
     * 
     * @return the collision year
     */
    public int getYear() {
        return this.C_YEAR;
    }
    
    /**
     * Gets the collision month
     * 
     * @return the collision month
     */
    public int getMonth() {
        return this.C_MONTH;
    }
    
    /**
     * Gets the collision weekday 
     * 
     * @return the collision weekday
     */
    public int getDay() {
        return this.C_WDAY;
    }
    
    /**
     * Gets the collision hour
     * 
     * @return the collision hour
     */
    public int getHour() {
        return this.C_HOUR;
    }
    
    /**
     * Gets the collision weather
     * 
     * @return the collision weather
     */
    public int getWthr() {
        return this.C_WTHR;
    }
    
    /**
     * Gets the collision road surface
     * 
     * @return the collision road surface
     */
    public int getRsur() {
        return this.C_RSUR;
    }
    
    /**
     * Gets the vehicle type
     * 
     * @return the vehicle type
     */
    public int getVType() {
        return this.V_TYPE;
    }
    
    /**
     * Gets the vehicle model year
     * 
     * @return the vehicle model year
     */
    public int getVYear() {
        return this.V_YEAR;
    }
    
    /**
     * Gets the person's sex
     * 
     * @return the person's sex
     */
    public int getPSex() {
        return this.P_SEX;
    }
    
    /**
     * Gets the person's age
     * 
     * @return the person's age
     */
    public int getPAge() {
        return this.P_AGE;
    }
    
    /**
     * Gets the person's injury severity
     * 
     * @return the person's injury severity
     */
    public int getPSev() {
        return this.P_ISEV;
    }
    
    // methods
    /**
     * Converts data to a string representation
     * 
     * @return the string representation
     */
    public String toString() {
        return "Year: " + this.getYear() + "\nMonth: " + this.getMonth() + "\nDay: " + this.getDay() + 
        		"\nWeather Condition: " + this.getWthr() + "\nRoad Surface: " + this.getRsur() + 
        		"\nVehicle Type: " + this.getVType() + "\nVehicle Year: " + this.getVYear() +
        		"\nGender: " + this.getPSex() + "\nAge: " + this.getPAge() + "\nSeverity: " +
        		this.getPSev() + "\n";
    }
    
    // Don't use this method. It doesn't select which entry to compare on
    /**
     * Compares two entries - no longer in use
     * 
     * @return Always 0, don't use
     */
    @Override
    public int compareTo(Entry that) {
        System.out.println("Use compareTo(Entry that, String value)");
        System.out.println("Where value is the value to compare, like C_WDAY");
        return 0;
    }
    
    /**
     * Compares two elements based on a field
     * 
     * @param that The collision entry to compare to
     * @param value The field to compare on
     * @return The difference in values
     */
    public int compareTo(Entry that, Field value) {
        // TODO
        return this.get(value) - that.get(value);
    }
}
