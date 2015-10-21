package org.ow2.erocci.DBUSJavaInterface;

import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.exceptions.DBusException;

public class Main {

	 private DBusConnection dbusConnection;
	  public boolean isRemote()
	  {
	    return false;
	  }
	  private boolean stop=false;
	  
	  public void start(DBusInterface impl)
	  {
	    try
	    {
	      dbusConnection = DBusConnection.getConnection(DBusConnection.SESSION);
	      //Service Name can be changed
	      dbusConnection.requestBusName("org.occiware.java.test");
	      //EROCCI consider that the service is available on / (convention)
	      dbusConnection.exportObject("/", impl);
	      while (!stop)
	      {
	         try {
	         Thread.sleep(1000);
	         } catch (Exception e) {}
	      }
	      dbusConnection.disconnect();
	    }
	    catch (DBusException e)
	    {
	      e.printStackTrace();
	    }
	  }
	  public static void main(String[] args)
	  {
		 BeckEndImpl servimpl = new BeckEndImpl();
		 new Main().start(servimpl);
	  }
}
