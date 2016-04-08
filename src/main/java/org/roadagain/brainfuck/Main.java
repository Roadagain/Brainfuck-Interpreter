package org.roadagain.brainfuck;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * Main class of Brainfuck-interpreter
 * @author Roadagain
 * @version 1.1
 * @since 1.0
 */
public class Main {
    /**
     * Main method
     * @param args source file's name (although call with more than one argument,
     *          this program interprets only the first source file)
     * @since 1.0
     */
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Error: no input files");
            System.exit(-1);
        }

        try {
            Interpreter interpreter = new Interpreter(new BufferedReader(new FileReader(new File(args[0]))));
            interpreter.run();
        } catch (FileNotFoundException e){
            System.out.println("Error: " + args[0] + " was not available");
        }
    }
}