package collisionCourse;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Label extends JLabel{
	public Label(String label, int width, int height, int x, int y, JPanel panel) {
		super(label);
		setSize(width, height);
		setLocation(x, y);
		panel.add(this);
	}
}
