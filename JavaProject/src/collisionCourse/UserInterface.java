package collisionCourse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Class for the project's user interface
 * Implements ActionListener
 * 
 * @author Chandler Co
 *
 */
public class UserInterface implements ActionListener{
	// properties

	private JFrame theFrame;
	private JPanel thePanel;

	// input fields
	private Label Cmonth;
	private Label Cday;
	private Label Chour;
	private Label Cwthr;
	private Label Crsur;
	
	private Label Vtype;
	private Label Vyear;
	
	private Label Psex;
	private Label Page;
	
	private ComboBox cMonth;
	private ComboBox cDay;
	private JSpinner cHour;
	private ComboBox cWthr;
	private ComboBox cRsur;

	private ComboBox vType;
	private JSpinner vYear;

	private ComboBox pSex;
	private JSpinner pAge;

	private JButton go;
	
	private Label headings;
	private Label headings2;
	
	private Label total;
	private Label headPer;
	private Label headSev;
	private Label topPer[];
	private Label topSev[];
	
	private Values output;
	private static ArrayList<Entry> data;
	// Constructor
	/**
	 * Creates a user interface
	 * 
	 * @param strHeader The window header
	 * @param intL The default height of the window
	 * @param intW The default width of the window
	 */
	public UserInterface(String strHeader, int intL, int intW) {
		theFrame = new JFrame(strHeader);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		thePanel = new JPanel();
		thePanel.setPreferredSize(new Dimension(intW, intL));
		thePanel.setLayout(null);

		// month
		Cmonth = new Label("Month", 150, 30, 15, 10, thePanel);
		String[] months = { "Select one", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		cMonth = new ComboBox(months, 150, 30, 10, 40, 0, thePanel);
		cMonth.addActionListener(this);
		// day
		Cday = new Label("Day of the week", 150, 30, 175, 10, thePanel);
		String[] days = { "Select one", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		cDay = new ComboBox(days, 150, 30, 170, 40, 0, thePanel);
		// hour
		Chour = new Label("Hour (-1 for no answer)", 150, 30, 335, 10, thePanel);
		cHour = new JSpinner(new SpinnerNumberModel(0, -1, 23, 1));
		cHour.setSize(150, 30);
		cHour.setLocation(330, 40);
		thePanel.add(cHour);
		// weather
		Cwthr = new Label("Weather conditions", 250, 30, 495, 10, thePanel);
		String[] wthr = { "Select one", "Clear and sunny", "Overcast, cloudy but no precipitation", "Raining",
				"Snowing", "Freezing rain, sleet, hail", "Visibility limitation", "Strong wind" };
		cWthr = new ComboBox(wthr, 250, 30, 490, 40, 0, thePanel);
		// road surface
		Crsur = new Label("Road surface conditions", 150, 30, 755, 10, thePanel);
		String[] rsur = { "Select one", "Dry, normal", "Wet", "Snow", "Slush, wet snow", "Icy", "Sandy/dirty", "Muddy",
				"Oil", "Flooded" };
		cRsur = new ComboBox(rsur, 150, 30, 750, 40, 0, thePanel);
		// vehicle type
		Vtype = new Label("Vehicle type", 250, 30, 15, 70, thePanel);
		String[] vtype = { "Select one", "Passenger car/van, light utility vehicle", "Cargo van", "Other trucks/vans",
				"Unit trucks >4536 KG", "Road tractor", "School bus", "City Bus", "Motorcycle, moped",
				"Off road vehicle", "Bicycle", "Motorhome", "Farm equipment", "Construction equipment", "Fire engine",
				"Snowmobile", "Street car" };
		vType = new ComboBox(vtype, 250, 30, 10, 100, 0, thePanel);
		// vehicle year
		Vyear = new Label("Vehicle year(1900 for no answer)", 250, 30, 275, 70, thePanel);
		vYear = new JSpinner(new SpinnerNumberModel(2000, 1900, 2017, 1));
		vYear.setSize(150, 30);
		vYear.setLocation(270, 100);
		thePanel.add(vYear);
		// sex
		Psex = new Label("Sex", 150, 30, 15, 130, thePanel);
		String[] sex = { "Prefer not to say", "Female", "Male" };
		pSex = new ComboBox(sex, 150, 30, 10, 160, 0, thePanel);
		// age
		Page = new Label("Age (100 for prefer not to answer)", 250, 30, 175, 130, thePanel);
		pAge = new JSpinner(new SpinnerNumberModel(25, 16, 100, 1));
		pAge.setSize(150, 30);
		pAge.setLocation(170, 160);
		thePanel.add(pAge);
		
		// go
		go = new JButton("Go");
		go.setSize(150, 30);
		go.setLocation(650, 160);
		go.addActionListener(this);
		thePanel.add(go);
		
		headings = new Label("% of all collisions   % of collisions involving factor which", 600, 25, 35, 200, thePanel);
		headings2 = new Label("involving factor      resulted in serious injury or fatality", 600, 25, 35, 220, thePanel);
		// total
		total = new Label("", 300, 25, 25, 250, thePanel);

		headPer = new Label("Top 3 factors with highest occurence percentage", 300, 25, 25, 275, thePanel);
		headPer = new Label("Top 3 factors with highest severity percentage", 300, 25, 25, 390, thePanel);
		topPer = new Label[3];
		
		topSev = new Label[3];
		//tsSev = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			topPer[i] = new Label("", 300, 25, 25, 300 + i * 30, thePanel);
			topSev[i] = new Label("", 300, 25, 25, 415 + i * 30, thePanel);
		}
		
		
		theFrame.setContentPane(thePanel);
	    theFrame.pack();
	    theFrame.setVisible(true);
	}
	
	/**
	 * The main function - creates the UI window
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		data = ReadData.Read("data\\NCDB_2016.csv");
		UserInterface ui = new UserInterface("Collision Course", 550, 910);
	}

	/**
	 * To react when Jave UI elements are triggered.
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if (evt.getSource() == go) {
			int month = cMonth.getSelectedIndex();
			if (month == 0) month = -1;
			int day = cDay.getSelectedIndex();
			if (month == 0) month = -1;
			int hour = (Integer) cHour.getValue();
			int weather = (Integer) cWthr.getSelectedIndex();
			if (weather == 0) weather = -1;
			int rdsur = (Integer) cRsur.getSelectedIndex();
			if (rdsur == 0) rdsur = -1;
			int type = (Integer) vType.getSelectedIndex();
			if (type == 0) type = -1;
			int year = (Integer) vYear.getValue();
			if (year == 1900) year = -1;
			int sex = (Integer) pSex.getSelectedIndex();
			if (sex == 0) sex = -1;
			int age = (Integer) pAge.getValue();
			if (age == 100) age = -1;
			//System.out.println(month + " " + day + " " + hour + " " + weather + " " + rdsur + " " + type + " " + year + " " + sex + " " + age);
			output = Calculations.danger(new Entry(-1, month, day, hour, weather, rdsur, type, year, sex, age, -1), 3, data);
			
			total.setText("All: " + String.format("%.2f", output.allPer()*100) + "%                      " + String.format("%.2f",output.allSev()*100) + "%");
			
			for (int i = 0; i < 3; i++) {
				topPer[i].setText(output.tpType(2 - i) + ": " + String.format("%.2f", output.tpPer(2 - i)*100) + "%                      " + String.format("%.2f", output.tpSev(2 - i)*100) + "%");
				topSev[i].setText(output.tsType(2 - i) + ": " + String.format("%.2f", output.tsPer(2 - i)*100) + "%                      " + String.format("%.2f", output.tsSev(2 - i)*100) + "%");
			}
		}
	}
}
