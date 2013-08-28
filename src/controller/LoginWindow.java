package controller;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginWindow extends JFrame {

	private JTextField tf_user;
	private JPasswordField tf_password;
	private JButton btn_login;
	private final int fieldLength = 15;

	public static void main(String[] args) {
		new LoginWindow();
	}

	public LoginWindow(){
		super("LogIn Window");
		init();
		// Display the window.
		this.pack();
		this.setVisible(true);
	}

	private void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Use the content pane's default BorderLayout. No need for
		setLayout(new BorderLayout());

		// TODO include image object instead of string
		JLabel logo = new JLabel("Logo");
		logo.setSize(200, 150);

		// Set up the panel for the credentials
		JPanel loginCred = new JPanel();
		loginCred.setLayout(new GridLayout(0, 2));
		JLabel lbl_user = new JLabel("Benutzer:");
		JLabel lbl_password = new JLabel("Passwort:");
		tf_user = new JTextField(fieldLength);
		tf_password = new JPasswordField(fieldLength);
		loginCred.add(lbl_user);
		loginCred.add(tf_user);
		loginCred.add(lbl_password);
		loginCred.add(tf_password);

		btn_login = new JButton("Einloggen");

		// fill the layout of the window
		this.add(logo, BorderLayout.WEST);
		this.add(loginCred, BorderLayout.EAST);
		this.add(btn_login, BorderLayout.SOUTH);

		// set action listener
		btn_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginWindow.this.performLogin();
			}

		});

		tf_password.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginWindow.this.performLogin();
			}

		});

	}

	private void performLogin() {
		// TODO validate password and call next window
		String user = tf_user.getText();
		if(user.equalsIgnoreCase("Empfang")){
			new ReceptionStartWindow();
		} else {
			new TechnicalStartWindow();
		}
		
		this.dispose();

	}

}
