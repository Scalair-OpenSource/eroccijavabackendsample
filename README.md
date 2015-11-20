#Initial example to create a backend in Java

compile and package Erocci-DBus backend :

$ mvn assembly:assembly

to run it :

$ java -Djava.library.path=. -cp target/DBUSJavaBackend-0.0.1-SNAPSHOT-jar-with-dependencies.jar org.ow2.erocci.Main

You can launch erocci with the configuration file dbus.config
