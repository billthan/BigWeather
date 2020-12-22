package gui;

import javax.swing.*;

import main.preferences.UserPreferences;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Filter implements Runnable{

	JFrame frame;
	public JPanel panel;
	public UserPreferences userPref;
	private JCheckBox[] boxes;
	private String[] retStr;

	/**
	 * Create the application.
	 */
	public Filter(UserPreferences userPref) {
		this.userPref = userPref;
		run();
	}
	
	@Override
	public void run() {
		frame = new JFrame();
		frame.setBounds(100, 100, 315, 345);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);

		panel = new JPanel();
		panel.setLayout(null);
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel txt = new JLabel("Select the filters you want to request.");
		txt.setBounds(38, 11, 239, 14);
		panel.add(txt);

		JButton okBtn = new JButton("Okay");
		okBtn.setBounds(106, 261, 89, 23);
		panel.add(okBtn);

		String[] opt = { "Temp", "Feels like", "Dew Point", "Humidity", "Wind Speed", "Wind Direction", "Wind Gust",
				"Barometer Pressure", "Precipitation" };

		boxes = new JCheckBox[opt.length];
		ArrayList<String> c = this.userPref.ccGetTrue();
		for (int i = 0; i < boxes.length; i++) {

			if (c.contains(getInternalName(opt[i])))
				boxes[i] = new JCheckBox(opt[i], true);
			else
				boxes[i] = new JCheckBox(opt[i]);

			boxes[i].setBounds(30, 35 + i * 25, 198, 14);
			this.panel.add(boxes[i]);
		}

		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				retStr = arrayList2Array(update());
			}
		});
		
	}


	private String[] arrayList2Array(ArrayList<String> str) {
		String[] arr = new String[str.size()];
		arr = str.toArray(arr);

		return arr;
	}

	private ArrayList<String> update() {
		ArrayList<String> str = new ArrayList<String>();

		for (JCheckBox x : boxes) {
			if (!x.isSelected()) {
				str.add(getInternalName(x.getText()));
			}
		}
		return str;
	}

	/**
	 * returns internal name
	 * 
	 * @param s
	 * @return
	 */
	private String getInternalName(String s) {
		switch (s) {
		case "Temp":
			return "temp";
		case "Feels like":
			return "feels_like";
		case "Dew Point":
			return "dewpoint";
		case "Humidity":
			return "humidity";
		case "Wind Speed":
			return "wind_speed";
		case "Wind Direction":
			return "wind_direction";
		case "Wind Gust":
			return "wind_gust";
		case "Barometer Pressure":
			return "baro_pressure";
		case "Precipitation":
			return "precipitation";
		}
		return "";
	}


}
