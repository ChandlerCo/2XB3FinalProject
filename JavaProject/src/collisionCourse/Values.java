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
	
	public double allPer() {
		return allPer;
	}
	public double allSev() {
		return allSev;
	}
	public double tsPer(int i) {
		return tsPer[i];
	}
	public double tsSev(int i) {
		return tsSev[i];
	}
	public Field tsType(int i) {
		return tsType[i];
	}
	public double tpPer(int i) {
		return tpPer[i];
	}
	public double tpSev(int i) {
		return tpSev[i];
	}
	public Field tpType(int i) {
		return tpType[i];
	}
	
	public void setAll(double per, double sev) {
		allPer = per;
		allSev = sev;
	}
	
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
