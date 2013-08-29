package controller;

import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;



public class ReceptionTabbedPane extends JTabbedPane {

	public ReceptionTabbedPane() {
		super();
		init();
	}
	
	private void init(){
		// ImageIcon icon_map = createImageIcon("images/middle.gif");
		// ImageIcon icon_bookin = createImageIcon("images/middle.gif");
		
		JComponent tab_booking = new Booking_Ctrl();
		this.addTab("Buchungen", null, tab_booking,
		                  "Zeige alle bevorstehenden Buchungen an");
		

		
		JComponent tab_karte = new Map_Ctrl();
		this.addTab("Karte", null, tab_karte,
		                  "Lageplan des Campingplatzes");
		
		
		
		this.setMnemonicAt(0, KeyEvent.VK_B);
		this.setMnemonicAt(1, KeyEvent.VK_K);
		
	}

}
