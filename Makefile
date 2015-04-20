#Brainfuck-Interpreter Makefile

SRC_DIR = src
PACKAGE = org/roadagain/brainfuck
BUILD_DIR = build
DOC_DIR = docs
SRC = $(SRC_DIR)/$(PACKAGE)/Main.java $(SRC_DIR)/$(PACKAGE)/Interpreter.java
CLASS = $(BUILD_DIR)/$(PACKAGE)/Main.class $(BUILD_DIR)/$(PACKAGE)/Interpreter.class

COMPILER = javac
DOC = javadoc
CLASSPATH = -classpath $(BUILD_DIR)
BUILD = -d $(BUILD_DIR)
DOCPATH = -d $(DOC_DIR)

.PHONY: all
all: class docs

.PHONY: rebuild
rebuild: clean all

.PHONY: class
class: $(CLASS)

$(BUILD_DIR)/$(PACKAGE)/Main.class: $(SRC_DIR)/$(PACKAGE)/Main.java $(BUILD_DIR)/$(PACKAGE)/Interpreter.class
	$(COMPILER) $(CLASSPATH) $(BUILD) $(SRC_DIR)/$(PACKAGE)/Main.java

$(BUILD_DIR)/$(PACKAGE)/Interpreter.class: $(SRC_DIR)/$(PACKAGE)/Interpreter.java
	$(COMPILER) $(CLASSPATH) $(BUILD) $(SRC_DIR)/$(PACKAGE)/Interpreter.java

.PHONY: docs
docs: $(SRC)
	$(DOC) -version $(DOCPATH) $(SRC)

.PHONY: clean
clean:
	rm -rf $(BUILD_DIR)/*
	rm -rf $(DOC_DIR)/*
