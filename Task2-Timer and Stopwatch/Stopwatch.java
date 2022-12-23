

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{
 
 JFrame window = new JFrame("StopWatch");
 JButton start = new JButton("StartTime!");
 JButton end = new JButton("ResetTime!");
 JLabel label = new JLabel();
 Font font = new Font("Verdana", Font.PLAIN, 15);

 int Timepassed = 0;
 int Seconds     = 0;
 int Minutues     = 0;
 int Hours      = 0;
 boolean started = false;
 String string_seconds = String.format("%02d", Seconds);
 String string_minutues = String.format("%02d", Minutues);
 String string_hours= String.format("%02d", Hours);
 
 Timer timer = new Timer(1000, new ActionListener() {
  
  public void actionPerformed(ActionEvent e) {
   
    Timepassed=Timepassed+1000;
   Hours = (Timepassed/3600000);
   Minutues = (Timepassed/60000) % 60;
   Seconds = (Timepassed/1000) % 60;

   string_seconds = String.format("%02d", Seconds);
   string_minutues  = String.format("%02d", Minutues);
   string_hours    = String.format("%02d", Hours);
   label.setText("  "+string_hours + ":" +string_minutues + ":" + string_seconds);
   
  }
  
 });

 
 
 Stopwatch(){
  
      label = new JLabel("  "+string_hours + ":" +string_minutues + ":" + string_seconds);
      label.setBounds(93, 60, 100, 30);
      label.setFont(new Font("Verdana", Font.PLAIN, 15));
      label.setEnabled(true);
      label.setVisible(true);
      label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      label.setOpaque(true);
  
        start.setBounds(35, 150, 100, 30);
        start.setFont(font);
        start.setFocusable(false);
        start.addActionListener(this);
        
        end.setBounds(150, 150, 100, 30);
        end.setFont(font);
        end.setFocusable(false);
        end.addActionListener(this);
        
        window.add(start);
        window.add(end);
        window.add(label);

        window.getContentPane().setBackground(Color.GREEN);
        window.setLayout(null);  
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setSize(300,300);
        window.setResizable(false);
        window.setVisible(true);

 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  
  if(e.getSource()==start) {
   
   if(started==false) {
    started=true;
    start.setText("Stop!");
    start();
   }
   else {
    started=false;
    start.setText("Start!");
    stop();
   }
   
  }
  if(e.getSource()==end) {
   started=false;
   start.setText("Start!");
   reset();
  }
  
 }
 
 void start() {
  timer.start();
 }
 
 void stop() {
  timer.stop();
 }
 
 void reset() {
  timer.stop();
  Timepassed=0;
  Seconds=0;
  Minutues=0;
  Hours=0;
  string_seconds= String.format("%02d", Seconds);
  string_minutues = String.format("%02d", Minutues);
  string_hours = String.format("%02d", Hours);       
  label.setText("  "+string_hours + ":" +string_minutues + ":" + string_seconds);
 }

}

