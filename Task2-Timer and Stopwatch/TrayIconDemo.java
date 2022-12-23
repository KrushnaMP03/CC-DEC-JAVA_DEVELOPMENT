import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class TrayIconDemo {


    public void displayTray() throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

      
      Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("img/watch.png"));

        TrayIcon trayIcon = new TrayIcon(image,null);
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("TIME");
        tray.add(trayIcon);
        trayIcon.displayMessage("Timer arrival time terminated!", " ", MessageType.WARNING);
    }
}