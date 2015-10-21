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
   
   '''bash
   mvn install 
   '''
   
   Next clone the [following project](https://github.com/diega/dbus-java/)
   '''bash
   mvn install 
   '''

Next import this project, you can play with it. 
It currently only contains the OCCI mandatory interface. 

We will provide an extension with other interfaces. 

Have fun


