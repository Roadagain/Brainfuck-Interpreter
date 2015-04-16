package org.roadagain.brainfuck;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * brainfuck interpreter
 * @author Roadagain
 * @version 1.0
 */
public class Interpreter {
    /**
     * Constructor
     * @param fileName source file name
     * @throws FileNotFoundException if {@code file} failed to open the source file
     */
    public Interpreter(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //Loading source file to #source
        this.source = new String();
        try {
            String tmpSource = "";
            do {
                source += tmpSource;
                tmpSource = bufferedReader.readLine();
            } while (tmpSource != null);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error: exit this program");
            System.exit(-1);
        }
    }

    /**
     * The String value that is holding source file
     */
    String source;
}
