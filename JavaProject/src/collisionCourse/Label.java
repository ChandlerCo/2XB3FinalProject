package collisionCourse;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Label extends JLabel{
	/**
	 * Creates a JLabel and set commonly used paramters
	 * 
	 * @param label The text in the JLabel
	 * @param width The width of the label
	 * @param height The height of the label
	 * @param x The horizontal postion from the left
	 * @param y The vertical position from the top
	 * @param panel The JPanel to be added to
	 */
	public Label(String label, int width, int height, int x, int y, JPanel panel) {
		super(label);
		setSize(width, height);
		setLocation(x, y);
		panel.add(this);
	}
}
