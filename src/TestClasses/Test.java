package TestClasses;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Test {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		myClass[] value = new myClass[3];
		
		value[0] = new myClass("Hallo 1");
		value[1] = new myClass("Hallo 2");
		value[2] = new myClass("Hallo 3");
		
		JFrame frame = new JFrame();
		JComboBox cb = new JComboBox(value);
		frame.add(cb);
		frame.setVisible(true);
		
		Object ob = cb.getSelectedItem();
		myClass it = (myClass) ob;


	}

}
