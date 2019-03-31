package collisionCourse;

import java.awt.*;
import javax.swing.*;

public class UserInterface {
	// properties
	
	private JFrame theFrame;
	private JPanel thePanel;
	
	// input fields
	public JComboBox cMonth;
	public JComboBox cDay;
	public JSpinner cHour;
	public JComboBox cWthr;
	public JComboBox cRsur;
	
	public JComboBox vType;
	public JSpinner vYear;
	
	public JComboBox pSex;
	public JSpinner pAge;
	
	// Constructor
	public UserInterface(String strHeader, int intL, int intW) {
		this.theFrame = new JFrame(strHeader);
		this.theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.thePanel = new JPanel();
		this.thePanel.setPreferredSize(new Dimension(intW, intL));
		this.thePanel.setLayout(null);
		
		// month
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		this.cMonth = new JComboBox(months);
		this.cMonth.setLocation(100, 100);
		this.thePanel.add(this.cMonth);
		// day
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		this.cDay = new JComboBox(days);
		this.cDay.setLocation(100, 100);
		this.thePanel.add(this.cDay);
		// hour
		this.cHour = new JSpinner(new SpinnerNumberModel(1, 1, 24, 1));
		this.cHour.setLocation(100, 100);
		this.thePanel.add(this.cHour);
		// weather
		this.cWthr = new JTextField("Enter the weather", 10);
		this.cWthr.setLocation(100, 100);
		cWthr.setEnabled(true);
		this.thePanel.add(this.cWthr);
		// road surface
		this.cRsur = new JTextField("Enter the road surface", 10);
		this.cRsur.setLocation(100, 100);
		cMonth.setEnabled(true);
		this.thePanel.add(this.cMonth);
	}
}
