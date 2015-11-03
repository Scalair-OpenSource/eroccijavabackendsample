package org.ow2.erocci;

import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.exceptions.DBusException;

public class Main {

    private DBusConnection dbusConnection;

    public void start(DBusInterface impl) {
        try {
            dbusConnection = DBusConnection.getConnection(DBusConnection.SESSION);
            //Service Name can be changed
            dbusConnection.requestBusName("org.occiware.java");
            //EROCCI consider that the service is available on / (convention)
            dbusConnection.exportObject("/", impl);

            System.out.println(dbusConnection.getUniqueName());


        } catch (DBusException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().start(new MyBackend());
    }
}
