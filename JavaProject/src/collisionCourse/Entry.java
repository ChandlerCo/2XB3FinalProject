package collisionCourse;

public class Entry implements Comparable<Entry> {
    // variables
    private final int C_YEAR;
    private final int C_MONTH;
    private final int C_WDAY;
    // cont.
    
    // constructors
    public Entry(String strLine) {
        this.C_YEAR = 2016;
        this.C_MONTH = 1;
        this.C_WDAY = 1;
    }
    
    // accessors
    public int getDAY() {
        return this.C_WDAY;
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
            return this.getDAY() - that.getDAY();
        }
        
        return 0;
    }
}
