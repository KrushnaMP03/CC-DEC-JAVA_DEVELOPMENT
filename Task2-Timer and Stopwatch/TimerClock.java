import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JFrame;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerClock {
	TrayIconDemo notification = new TrayIconDemo(); 
	JLabel labelTimer = new JLabel();
	JFrame frame = new JFrame("Timer");
	public boolean fine = false;
	private int hours;
	private int minutues;
	private int seconds;
	String str_hours;
	String str_minutues;
	String str_seconds;
	Timer timer;
	
	TimerClock(JLabel label) {
		
		labelTimer = label;
		this.hours = 0;
		this.minutues= 0;
		this.seconds = 0;
		str_hours = String.format("%02d", getHours());
		str_minutues = String.format("%02d", getMinutues());
		str_seconds = String.format("%02d", getSeconds());
		
		timer = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					
					if (getSeconds() > 0) {
						setSeconds(getSeconds()-1);
					} else if (getMinutues() > 0) {
						setMinutues(getMinutues()-1);
						setSeconds(59);
					} else if (getHours() > 0) {
						setHours(getHours()-1);
						setMinutues(59);
						setSeconds(59);
					} else {

						timer.stop();
						try {
							notification.displayTray();
						} catch (AWTException Eccezione) {
							Eccezione.printStackTrace();
						}
					}
					
					str_hours = String.format("%02d", getHours());
					str_minutues = String.format("%02d", getMinutues());
					str_seconds = String.format("%02d", getSeconds());
					
					labelTimer.setText("Time Passed:  "+ str_hours + ":" + str_minutues + ":" + str_seconds);
					System.out.println("  "+ str_hours + ":" + str_minutues + ":" + str_seconds);
				
				
			}	
		});
		
	}
	
	public void start() {
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	public void reset() {
		timer.stop();
		setHours(0);
		setMinutues(0);
		setSeconds(0);
		str_hours = String.format("%02d", getHours());
		str_minutues = String.format("%02d", getMinutues());
		str_seconds = String.format("%02d", getSeconds());
		labelTimer.setText("Time Passed:  "+ str_hours  + ":" + str_minutues + ":" + str_seconds);
		System.out.println("  "+ str_hours  + ":" + str_minutues + ":" + str_seconds);
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public int getHours() {
		return hours;
	}
	
	public void setMinutues(int minutues) {
		this.minutues = minutues;
	}
	
	public int getMinutues() {
		return minutues;
	}
	
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public int getSeconds() {
		return seconds;
	}
	
}

