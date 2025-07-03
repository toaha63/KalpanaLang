JAVAC = javac
MAIN_CLASS = Main
JAR_NAME = kalpanaKey.jar

.PHONY: all clean jar run

all: jar

jar: $(MAIN_CLASS).class
	jar cfe $(JAR_NAME) $(MAIN_CLASS) *.class
	@echo "JAR built successfully, cleaning class files..."
	rm -f *.class

$(MAIN_CLASS).class: $(MAIN_CLASS).java
	$(JAVAC) $(MAIN_CLASS).java

clean:
	rm -f *.class $(JAR_NAME)

run: jar
	java -jar $(JAR_NAME) $(FILE)
