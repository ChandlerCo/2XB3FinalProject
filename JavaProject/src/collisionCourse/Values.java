package collisionCourse;

import collisionCourse.CustomDataTypes.Field;

public class Values {
	private double allPer;
	private double allSev;
	private double[] tsPer;
	private double[] tsSev;
	private Field[] tsType;
	private double[] tpPer;
	private double[] tpSev;
	private Field[] tpType;
	
	/**
	 * Creates a default set of values
	 */
	public Values() {
		allPer = 0.0;
		allSev = 0.0;
		int n = 3;
		tsPer = new double[n];
		tsSev = new double[n];
		tsType = new Field[n];
		tpPer = new double[n];
		tpSev = new double[n];
		tpType = new Field[n];
		for (int i = 0; i < n; i++) {
			tsPer[i] = 0.0;
			tsSev[i] = 0.0;
			tsType[i] = Field.P_Isev;
			tpPer[i] = 0.0;
			tpSev[i] = 0.0;
			tpType[i] = Field.P_Isev;
		}
	}
	
	/**
	 * Gets the percentage for collisions matching all criteria
	 * 
	 * @return allPer, the percentage for all
	 */
	public double allPer() {
		return allPer;
	}
	
	/**
	 * Gets the severity percentage for collisions matching all criteria
	 * 
	 * @return allSev, the severity percentage for all
	 */
	public double allSev() {
		return allSev;
	}
	
	/**
	 * Gets the percentage for most severe factor
	 * 
	 * @param i The ranking of how severe (0 - 2)
	 * @return The pecentage
	 */
	public double tsPer(int i) {
		return tsPer[i];
	}
	
	/**
	 * Gets the severity percentage for most severe factor
	 * 
	 * @param i The ranking of how severe (0 - 2)
	 * @return The pecentage
	 */
	public double tsSev(int i) {
		return tsSev[i];
	}
	
	/**
	 * Gets the field type for most severe factor
	 * 
	 * @param i The ranking of how severe (0 - 2)
	 * @return The field
	 */
	public Field tsType(int i) {
		return tsType[i];
	}
	
	/**
	 * Gets the percentage for most common factor
	 * 
	 * @param i The ranking of how common (0 - 2)
	 * @return The pecentage
	 */
	public double tpPer(int i) {
		return tpPer[i];
	}
	
	/**
	 * Gets the severity percentage for most common factor
	 * 
	 * @param i The ranking of how common (0 - 2)
	 * @return The pecentage
	 */
	public double tpSev(int i) {
		return tpSev[i];
	}
	
	/**
	 * Gets the field type for most common factor
	 * 
	 * @param i The ranking of how common (0 - 2)
	 * @return The field
	 */
	public Field tpType(int i) {
		return tpType[i];
	}
	
	/**
	 * Sets percentage and severity for entries matching all criteria
	 * 
	 * @param per The total percentage
	 * @param sev The severity percentage
	 */
	public void setAll(double per, double sev) {
		allPer = per;
		allSev = sev;
	}
	
	/**
	 * Checks if given values should be in either top common or severe and saves value
	 * 
	 * @param per Total percentage
	 * @param sev Severity percentage
	 * @param type The field type
	 */
	public void setTop(double per, double sev, Field type) {
		// top severe
		if (sev > tsSev[0]) {
			tsPer[0] = per;
			tsSev[0] = sev;
			tsType[0] = type;
			for (int i = 1; i < tsSev.length; i++) {
				if (tsSev[i - 1] > tsSev[i]) {
					double p = tsPer[i];
					double s = tsSev[i];
					Field f = tsType[i];
					
					tsPer[i] = tsPer[i - 1];
					tsSev[i] = tsSev[i - 1];
					tsType[i] = tsType[i - 1];
					
					tsPer[i - 1] = p;
					tsSev[i - 1] = s;
					tsType[i - 1] = f;
				}
			}
		}
		// top percent
		if (per > tpPer[0]) {
			tpPer[0] = per;
			tpSev[0] = sev;
			tpType[0] = type;
			for (int i = 1; i < tsSev.length; i++) {
				if (tpPer[i - 1] > tpPer[i]) {
					double p = tpPer[i];
					double s = tpSev[i];
					Field f = tpType[i];
					
					tpPer[i] = tpPer[i - 1];
					tpSev[i] = tpSev[i - 1];
					tpType[i] = tpType[i - 1];
					
					tpPer[i - 1] = p;
					tpSev[i - 1] = s;
					tpType[i - 1] = f;
				}
			}
		}
	}
}
