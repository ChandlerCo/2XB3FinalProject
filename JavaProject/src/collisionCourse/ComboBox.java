package collisionCourse;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboBox extends JComboBox{
	public ComboBox(String[] items, int width, int height, int x, int y, int defI, JPanel panel) {
		super(items);
		setSize(width, height);
		setLocation(x, y);
		setSelectedIndex(defI);
		panel.add(this);
	}
}
