package org.lumijiez.util;

import org.lumijiez.enums.StateType;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class NotificationHandler {
    public static void showNotification(String filename, StateType stateType) {
        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("some-icon.png");

            TrayIcon trayIcon = new TrayIcon(image, "Java AWT Tray Demo");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("File Tracker");
            tray.add(trayIcon);
            trayIcon.displayMessage("File Tracker", filename + " has been " + stateType.getAction(), MessageType.INFO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
