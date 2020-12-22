package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class GUIMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain window = new GUIMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 182);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JPanel centerPanel = new JPanel();
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);

		JLabel title = new JLabel("BigWeather");
		title.setBounds(120, 11, 185, 42);
		title.setFont(new Font("Tw Cen MT", Font.PLAIN, 38));
		centerPanel.add(title);

		JLabel prompt = new JLabel("Allow BigWeather to access your location?");
		prompt.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		prompt.setBounds(99, 62, 253, 14);
		centerPanel.add(prompt);
		
		// Consent for location access

		JButton yesBtn = new JButton("Yes");
		yesBtn.setBounds(107, 95, 89, 23);
		centerPanel.add(yesBtn);

		JButton noBtn = new JButton("No");
		noBtn.setBounds(216, 95, 89, 23);
		centerPanel.add(noBtn);


		yesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BigWeatherGUI.main(null);
				frame.setVisible(false); 
				frame.dispose(); 
			}
		});
		

		// if user does not consent.
		noBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "BigWeather needs access to your location!");
				System.exit(0);
			}
		});

	}

}
