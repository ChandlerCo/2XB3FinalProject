package collisionCourse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class UserInterface implements ActionListener{
	// properties

	private JFrame theFrame;
	private JPanel thePanel;

	// input fields
	public Label Cmonth;
	public Label Cday;
	public Label Chour;
	public Label Cwthr;
	public Label Crsur;
	
	public Label Vtype;
	public Label Vyear;
	
	public Label Psex;
	public Label Page;
	
	public ComboBox cMonth;
	public ComboBox cDay;
	public JSpinner cHour;
	public ComboBox cWthr;
	public ComboBox cRsur;

	public ComboBox vType;
	public JSpinner vYear;

	public ComboBox pSex;
	public JSpinner pAge;

	public JButton go;
	
	public JLabel totPer;
	public JLabel totSev;
	
	public JLabel tpPer[];
	//public JLabel tpSev[];
	public JLabel tsPer[];
	//public JLabel tsSev[];
	
	public Values output;
	private static ArrayList<Entry> data;
	// Constructor
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
		Cwthr = new Label("Weather conditions", 150, 30, 495, 10, thePanel);
		String[] wthr = { "Select one", "Clear and sunny", "Overcast, cloudy but no precipitation", "Raining",
				"Snowing", "Freezing rain, sleet, hail", "Visibility limitation", "Strong wind" };
		cWthr = new ComboBox(wthr, 150, 30, 490, 40, 0, thePanel);
		// road surface
		Crsur = new Label("Road surface conditions", 150, 30, 655, 10, thePanel);
		String[] rsur = { "Select one", "Dry, normal", "Wet", "Snow", "Slush, wet snow", "Icy", "Sandy/dirty", "Muddy",
				"Oil", "Flooded" };
		cRsur = new ComboBox(rsur, 150, 30, 650, 40, 0, thePanel);
		// vehicle type
		Vtype = new Label("Vehicle type", 150, 30, 15, 70, thePanel);
		String[] vtype = { "Select one", "Passenger car/van, light utility vehicle", "Cargo van", "Other trucks/vans",
				"Unit trucks >4536 KG", "Road tractor", "School bus", "City Bus", "Motorcycle, moped",
				"Off road vehicle", "Bicycle", "Motorhome", "Farm equipment", "Construction equipment", "Fire engine",
				"Snowmobile", "Street car" };
		vType = new ComboBox(vtype, 150, 30, 10, 100, 0, thePanel);
		// vehicle year
		Vyear = new Label("Vehicle year(1900 for no answer)", 150, 30, 175, 70, thePanel);
		vYear = new JSpinner(new SpinnerNumberModel(2000, 1900, 2017, 1));
		vYear.setSize(150, 30);
		vYear.setLocation(170, 100);
		thePanel.add(vYear);
		// sex
		Psex = new Label("Sex", 150, 30, 15, 130, thePanel);
		String[] sex = { "Prefer not to say", "Female", "Male" };
		pSex = new ComboBox(sex, 150, 30, 10, 160, 0, thePanel);
		// age
		Page = new Label("Age (100 for prefer not to answer)", 150, 30, 175, 130, thePanel);
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
		
		// total
		totPer = new JLabel("Total Percent");
		totPer.setSize(100,25);
		totPer.setLocation(25, 200);
		thePanel.add(totPer);
		
		totSev = new JLabel("Total severe");
		totSev.setSize(100,25);
		totSev.setLocation(150, 200);
		thePanel.add(totSev);
		
		tpPer = new JLabel[3];
		//tpSev = new JLabel[3];
		
		tsPer = new JLabel[3];
		//tsSev = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			tpPer[i] = new JLabel("Top Percent");
			tpPer[i].setSize(300,25);
			tpPer[i].setLocation(25, 240 + i * 40);
			thePanel.add(tpPer[i]);
			/*
			tpSev[i] = new JLabel("Top Severe");
			tpSev[i].setSize(100,25);
			tpSev[i].setLocation(150, 240 + i * 40);
			thePanel.add(tpSev[i]);
			*/
			tsPer[i] = new JLabel("Top Percent");
			tsPer[i].setSize(300,25);
			tsPer[i].setLocation(25, 400 + i * 40);
			thePanel.add(tsPer[i]);
			/*
			tsSev[i] = new JLabel("Top Severe");
			tsSev[i].setSize(100,25);
			tsSev[i].setLocation(150, 400 + i * 40);
			thePanel.add(tsSev[i]);
			*/
		}
		
		
		theFrame.setContentPane(thePanel);
	    theFrame.pack();
	    theFrame.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		data = ReadData.Read("data\\NCDB_2016.csv");
		UserInterface ui = new UserInterface("Collision Course", 600, 810);
	}

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
			System.out.println(month + " " + day + " " + hour + " " + weather + " " + rdsur + " " + type + " " + year + " " + sex + " " + age);
			output = Calculations.danger(new Entry(-1, month, day, hour, weather, rdsur, type, year, sex, age, -1), 3, data);
			
			totPer.setText("" + output.allPer());
			totSev.setText("" + output.allSev());
			
			for (int i = 0; i < 3; i++) {
				tpPer[i].setText(output.tpType(2 - i) + ": " + output.tpPer(2 - i)*100 + " " + output.tpSev(2 - i)*100);
				//tpSev[i].setText("" + output.tpSev(2 - i));
				tsPer[i].setText(output.tsType(2 - i) + ": " + output.tsPer(2 - i)*100 + " " + output.tsSev(2 - i)*100);
				//tsSev[i].setText("" + output.tsSev(2 - i));
			}
		}
	}
}
