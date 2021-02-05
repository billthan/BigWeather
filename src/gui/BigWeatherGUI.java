package gui;

import java.awt.EventQueue;

import main.preferences.UserPreferences;
//import main.searches.*;
import javax.swing.*;

import gui.menubar.MenuBar;

import java.awt.Font;
import java.util.ArrayList;

/*
 * Copyright © 2021, Bill Than
 * BigWeatherGUI 
 */

public class BigWeatherGUI {
	public static UserPreferences userPref; // stores user information
	private MenuBar mb;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BigWeatherGUI window = new BigWeatherGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Exception
	 */
	public BigWeatherGUI() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 10);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("BigWeather");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 40));
		lblNewLabel.setBounds(10, 11, 262, 45);
		frame.getContentPane().add(lblNewLabel);

		// starts Big Weathers
		initBigWeather();
	}

	/**
	 * Sets default userPref
	 * 
	 * @throws Exception
	 */
	private void initBigWeather() throws Exception {
		BigWeatherGUI.userPref = new UserPreferences();
		System.out.println(userPref);
		this.mb = new MenuBar(frame, userPref);

		//ArrayList<String> trueFields = userPref.ccGetTrue();

	}
}
