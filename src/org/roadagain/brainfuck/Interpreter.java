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
     * @throws FileNotFoundException if Interpreter failed to open the source file
     */
    public Interpreter(String fileName, int bufSize) throws FileNotFoundException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //Loading source file to #source
        this.source = new String();
        try {
            String tmpSource = "";
            do {
                this.source += tmpSource;
                tmpSource = bufferedReader.readLine();
            } while (tmpSource != null);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error: exit this program");
            System.exit(-1);
        }

        this.buffer = new byte[bufSize];
    }

    public String getSource(){ return new String(this.source); }
    public byte[] getBuffer(){ return buffer.clone(); }

    /**
     * The String value that is holding source file
     */
    private String source;

    /**
     * The byte array value that gets memory area
     */
    private byte[] buffer;
}
