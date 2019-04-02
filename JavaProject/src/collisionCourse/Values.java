package collisionCourse;

import collisionCourse.CustomDataTypes.Field;

public class Values {
	private double allPer;
	private double allSev;
	private double[] topPer;
	private double[] topSev;
	private Field[] types;
	
	public Values() {
		allPer = 0.0;
		allSev = 0.0;
		topPer = new double[1];
		topSev = new double[1];
		types = new Field[1];
		for (int i = 0; i < topPer.length; i++) {
			topPer[i] = 0.0;
			topSev[i] = 0.0;
			types[i] = Field.P_Isev;
		}
	}
	
	public double allPer() {
		return allPer;
	}
	public double allSev() {
		return allSev;
	}
	public double topPer(int i) {
		return topPer[i];
	}
	public double topSev(int i) {
		return topSev[i];
	}
	public Field topType(int i) {
		return types[i];
	}
	
	public void setAll(double per, double sev) {
		allPer = per;
		allSev = sev;
	}
	
	public void setTop(double per, double sev, Field type) {
		if (sev > topSev[0]) {
			topPer[0] = per;
			topSev[0] = sev;
			types[0] = type;
		}
		for (int i = 1; i < topSev.length; i++) {
			if (topSev[i - 1] > topSev[i]) {
				double p = topPer[i];
				double s = topSev[i];
				Field f = types[i];
				
				topPer[i] = topPer[i - 1];
				topSev[i] = topSev[i - 1];
				types[i] = types[i - 1];
				
				topPer[i - 1] = p;
				topSev[i - 1] = s;
				types[i - 1] = f;
			}
		}
	}
}
