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
     * @param bufSize size of buffer
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
    /**
     * Second constructor
     * @param fileName source file name
     * @throws FileNotFoundException if Interpreter failed to open the source file
     * @see #Interpreter(String, int)
     */
    public Interpreter(String fileName) throws FileNotFoundEception {
        this(fileName, 1024);
    }

    public String getSource(){ return new String(this.source); }
    public byte[] getBuffer(){ return buffer.clone(); }

    public void run(){
        int current = 0;
        int loop = 0;

        for (int i = 0; i < source.length(); i++){
            char c = source.charAt(i);
        }
    }

    /**
     * The String value that is holding source file
     */
    private String source;

    /**
     * The byte array value that gets memory area
     */
    private byte[] buffer;
}
