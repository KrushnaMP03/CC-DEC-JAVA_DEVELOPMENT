

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class TimerGUI extends JFrame{
	
	boolean started = false;

	JTextField textHours = new JTextField(2);
	JTextField textMinutues = new JTextField(2);
	JTextField textSeconds = new JTextField(2);
	JLabel labelHours = new JLabel();
	JLabel labelMinutues = new JLabel();
	JLabel labelSeconds = new JLabel();
	JButton start = new JButton("Start");
	JButton end= new JButton("Reset");
	JButton setTimer = new JButton("Set timer");
	JLabel label = new JLabel();
	TimerClock t = new TimerClock(label);
	
	TimerGUI() {
		
		super("TimerClock By Krushna");
		
		label.setText("Time passed:  "+ t.str_hours + ":" + t.str_minutues + ":" + t.str_seconds);
		setLayout(null);
		setSize(300, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.RED);
		setResizable(false);
		
		
		 
		label.setBounds(65, 40, 150, 30);
		label.setBackground(Color.white);
		label.setEnabled(true);
		label.setOpaque(true);
		
		labelHours.setText("Hours");
		labelHours.setBounds(40, 200, 60, 30);
		labelHours.setEnabled(true);
		labelHours.setOpaque(true);
		labelHours.setBackground(Color.BLUE);

		labelMinutues.setText("Minutues");
		labelMinutues.setBounds(110, 200, 80, 30);
		labelMinutues.setEnabled(true);
		labelMinutues.setOpaque(true);
		labelMinutues.setBackground(Color.BLUE);

		labelSeconds.setText("Seconds");
		labelSeconds.setBounds(190, 200, 80, 30);
		labelSeconds.setEnabled(true);
		labelSeconds.setOpaque(true);
		labelSeconds.setBackground(Color.BLUE);

		textHours.setBounds(70, 205, 20, 20);
		add(textHours);
		
		textMinutues.setBounds(150, 205, 20, 20);
		add(textMinutues);
		
		textSeconds.setBounds(240, 205, 20, 20);
		add(textSeconds);
		
		start.setBounds(35, 100, 100, 30);
		end.setBounds(150, 100, 100, 30);
		setTimer.setBounds(95, 150, 100, 30);
		
		add(start);
		add(end);
		add(setTimer);
	    
		add(labelHours);
		add(labelMinutues);
		add(labelSeconds);
		add(label);
		setVisible(true);
		
		start.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (!started) {
					started = true;
					start.setText("Stop");
					t.start();
				} else {
					started = false;
					start.setText("Start");
					t.stop();
				}
				
			}
			
		});
		
		end.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				t.reset();
				start.setText("Start");
				
			}
			
		});
		
		setTimer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int hours;
				int minutues;
				int seconds;
				
				if (textHours.getText().equals("")) {
					textHours.setText("00");
				}
				hours = Integer.parseInt(textHours.getText());
				textHours.setText(numberToWord(hours));
				
				if (textMinutues.getText().equals("")) {
					textMinutues.setText("00");
				}
				minutues = Integer.parseInt(textMinutues.getText());
				textMinutues.setText(numberToWord(minutues));
				
				if (textSeconds.getText().equals("")) {
					textSeconds.setText("00");
				}
				seconds = Integer.parseInt(textSeconds.getText());
				textSeconds.setText(numberToWord(seconds));
				
				t.setHours(hours);
				t.setMinutues(minutues);
				t.setSeconds(seconds);
				
				String str_hours = String.format("%02d", hours);
				String str_minutues = String.format("%02d", minutues);
				String str_seconds = String.format("%02d", seconds);
				
				label.setText("Tempo rimasto:  "+ str_hours + ":" + str_minutues + ":" + str_seconds);
				System.out.println("  "+ str_hours + ":" + str_minutues + ":" + str_seconds);
				
				if (str_hours == "00" && str_minutues == "00"  && str_seconds == "00") {
					start.setText("Start");
				}
			}

			private String numberToWord(int minutues) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		
	}
	
}
