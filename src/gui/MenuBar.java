package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import main.preferences.UserPreferences;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * Copyright � 2020, Bill Than
 * MenuBar 
 */
public class MenuBar {

	private JMenu file, edit;
	private JMenuItem newMen, filter;
	private JMenuBar mb = new JMenuBar();
	public JFrame j;

	public UserPreferences userPref;
	
	/**
	 * sets menubar in Frame from BigWeatherGUI
	 * sets userPreferences
	 * 
	 * @param frame
	 * @param userPref
	 */
	public MenuBar(JFrame frame, UserPreferences userPref) {
		this.userPref = userPref;
		frame.setJMenuBar(mb);
		initialize();
	}
	
	/**
	 * Build menubar
	 */
	private void initialize() {
		file = new JMenu("File");
		newMen = new JMenuItem("New");
		edit = new JMenu("Edit");
		filter = new JMenuItem("Filters");
		edit.add(filter);

		filter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Filter f = new Filter(userPref);
				f.frame.setVisible(true);
			}
		});

		file.add(newMen);

		newMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigWeatherGUI.main(null);
			}
		});

		mb.add(file);
		mb.add(edit);
	}

}
