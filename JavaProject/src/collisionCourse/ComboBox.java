package collisionCourse;

import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * Extends JComboBox, with a constructor with more inputs
 * 
 * @author Chandler Co
 *
 */
public class ComboBox extends JComboBox{
	/**
	 * Creates  JComboBox, and also sets other commonly set parameters
	 * 
	 * @param items The options for the JComboBox
	 * @param width The width of the element
	 * @param height The height of the element
	 * @param x The horizontal position from the left in pixels
	 * @param y The vertical position from the top in pixels
	 * @param defI The index of the default position
	 * @param panel The JPanel to be added to
	 */
	public ComboBox(String[] items, int width, int height, int x, int y, int defI, JPanel panel) {
		super(items);
		setSize(width, height);
		setLocation(x, y);
		setSelectedIndex(defI);
		panel.add(this);
	}
}
