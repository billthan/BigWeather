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

public class MenuBar {
	private static Object lock = new Object();

	private JMenu file, edit;
	private JMenuItem newMen, filter;
	//private JCheckBoxMenuItem temp, feels_like, dewpoint, humidity, wind_speed, wind_direction, wind_gust,
	//		baro_pressure, precipitation;
	private JMenuBar mb = new JMenuBar();
	JFrame j;

	public UserPreferences userPref;

	public MenuBar(JFrame frame, UserPreferences userPref) {

		this.userPref = userPref;
		file = new JMenu("File");
		newMen = new JMenuItem("New");
		edit = new JMenu("Edit");
		filter = new JMenuItem("Filters");
		edit.add(filter);

		filter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
				Thread t = new Thread(new Filter(userPref));
				t.start();
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
		frame.setJMenuBar(mb);
	}

}
