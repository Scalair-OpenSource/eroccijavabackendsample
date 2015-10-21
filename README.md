#Initial example to create a backend in Java

#Initial configuration. 
You must clone the following [repo](https://github.com/diega/libmatthew-java)


edit the pom.xml of the following subproject. 

libmatthew-libcgi/pom.xml and 
libmatthew-libunix/pom.xml

to change the variable
   <jdkIncludePath>/usr/lib/jvm/java-6-sun-1.6.0.22/include/</jdkIncludePath>
   
   with your jvm install directory. 
   
   Next 
   
   ```bash
   mvn install 
   ```
   
   Next clone the [following project](https://github.com/diega/dbus-java/)
   
   ```bash
   mvn install 
   ```

Next import this project, you can play with it. 
It currently only contains the OCCI mandatory interface, an example of an implementation for this interface and a Main app to start your backend.

We will provide an extension with other (otpional) interfaces . 

Next start erocci in changing the following file with your backend
https://github.com/erocci/erocci/blob/master/apps/erocci/priv/configs/dbus.config

Have fun


