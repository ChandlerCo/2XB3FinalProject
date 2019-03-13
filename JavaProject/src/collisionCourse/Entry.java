package collisionCourse;

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
    // cont.
    
    // constructors
    public Entry(String strLine) {
        this.C_YEAR = 2016;
        this.C_MONTH = 1;
        this.C_WDAY = 1;
        this.C_HOUR = 2016;
        this.C_WTHR = 1;
        this.C_RSUR = 1;
        
        this.V_TYPE = 2016;
        this.V_YEAR = 1;
        
        this.P_SEX = 1;
        this.P_AGE = 2016;
        this.P_ISEV = 1;
        
    }
    
    // accessors
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
        return "";
    }
    
    // Don't use this method. It doesn't select which entry to compare on
    @Override
    public int compareTo(Entry that) {
        System.out.println("Use compareTo(Entry that, String value)");
        System.out.println("Where value is the value to compare, like C_WDAY");
        return 0;
    }
    
    
    public int compareTo(Entry that, String value) {
        // TODO
        if (value.contentEquals("C_WDAY")) {
            return this.getDay() - that.getDay();
        }
        
        return 0;
    }
}
