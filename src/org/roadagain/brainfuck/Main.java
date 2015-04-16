package org.roadagain.brainfuck;

/**
 * Main class of Brainfuck-interpreter
 * @author Roadagain
 * @version 1.0
 */
public class Main {
    /**
     * Main method
     * @param args source file's name (although call with more than one argument,
     *          this program interprets only the first source file)
     */
    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("Error: no input files");
            System.exit(-1);
        }
    }
}
