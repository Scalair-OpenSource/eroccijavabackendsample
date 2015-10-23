package org.ow2.erocci;

import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.exceptions.DBusException;

public class Main {

    private DBusConnection dbusConnection;

    private boolean stop = false;

    public void start(DBusInterface impl) {
        try {
            dbusConnection = DBusConnection.getConnection(DBusConnection.SESSION);
            //Service Name can be changed
            dbusConnection.requestBusName("org.occiware.java.test");
            //EROCCI consider that the service is available on / (convention)
            dbusConnection.exportObject("/", impl);
            while (!stop) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            dbusConnection.disconnect();
        } catch (DBusException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().start(new MyBackend());
    }
}
