JAR=target/DBUSJavaBackend-0.0.1-SNAPSHOT-jar-with-dependencies.jar

all: $(JAR)

$(JAR):
	mvn assembly:assembly

run: $(JAR)
	java -Djava.library.path=. -cp $< org.ow2.erocci.Main

clean:
	mvn clean

.PHONY: all run clean
