#Brainfuck-Interpreter Makefile

SRC_DIR = src
PACKAGE = org/roadagain/brainfuck
BUILD_DIR = build
SRC = Main.java Interpreter.java
CLASS = $(BUILD_DIR)/$(PACKAGE)/Main.class $(BUILD_DIR)/$(PACKAGE)/Interpreter.class

COMPILER = javac
CLASSPATH = -classpath $(BUILD_DIR)
BUILD = -d $(BUILD_DIR)

.PHONY: all
all: class

.PHONY: rebuild
rebuild: all clean

.PHONY: class
class: $(CLASS)

$(BUILD_DIR)/$(PACKAGE)/Main.class: $(SRC_DIR)/$(PACKAGE)/Main.java $(BUILD_DIR)/$(PACKAGE)/Interpreter.class
	$(COMPILER) $(CLASSPATH) $(BUILD) $(SRC_DIR)/$(PACKAGE)/Main.java

$(BUILD_DIR)/$(PACKAGE)/Interpreter.class: $(SRC_DIR)/$(PACKAGE)/Interpreter.java
	$(COMPILER) $(CLASSPATH) $(BUILD) $(SRC_DIR)/$(PACKAGE)/Interpreter.java

.PHONY: clean
clean:
	rm -f $(BUILD_DIR)/$(PACKAGE)/*.class
