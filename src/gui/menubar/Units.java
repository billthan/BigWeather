package gui.menubar;

import javax.swing.*;

import main.preferences.UserPreferences;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * Copyright © 2021, Bill Than
 * Filter 
 */
public class Units {

	JFrame frame;
	public JPanel panel;
	public UserPreferences userPref;

	@SuppressWarnings("rawtypes")
	private JComboBox cb;
	private String[] opt = { "Standard Units", "United States" };

	private String[] optINT = { "unit_system=si", "unit_system=us" };

	/**
	 * Create the application.
	 */
	public Units(UserPreferences userPref) {
		this.userPref = userPref;
		initialize();
	}

	/**
	 * Builds Filter menu popup
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 315, 170);
		this.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.frame.setResizable(false);

		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.frame.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel txt = new JLabel("Select units you want to use.");
		txt.setBounds(70, 11, 239, 20);
		this.panel.add(txt);

		JButton okBtn = new JButton("Okay");
		okBtn.setBounds(106, 95, 89, 23);

		this.cb = new JComboBox(opt);	
		this.cb.setBounds(50, 50, 198, 20);

		this.panel.add(cb);
		this.panel.add(okBtn);

		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					update();
					System.out.println(userPref);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}

	private void update() throws Exception {
		if (this.cb.getItemAt(cb.getSelectedIndex()).equals(opt[0])) {
			this.userPref.changeUnits(optINT[0]);
		} else {
			this.userPref.changeUnits(optINT[1]);
		}
	}

}
