package gui.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.preferences.UserPreferences;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.*;

/*
 * Copyright � 2020, Bill Than
 * MenuBar 
 */
public class MenuBar {

	private JMenu file, edit;
	private JMenuItem newMen, filter, units;
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
		units = new JMenuItem("Units");

		edit.add(units);
		edit.add(filter);
		
		filter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filter f = new Filter(userPref);
				f.frame.setVisible(true);
			}
		});
		
		
		units.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Units u = new Units(userPref);
				u.frame.setVisible(true);
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
