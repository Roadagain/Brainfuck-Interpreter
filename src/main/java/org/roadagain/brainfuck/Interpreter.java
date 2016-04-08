package org.roadagain.brainfuck;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * brainfuck interpreter
 * @author Roadagain
 * @version 1.1
 * @since 1.0
 */
public class Interpreter {
    /**
     * The constructor which is called with a BufferedReader argument
     * @param bufferedReader The BufferedReader of the source program
     * @since 1.1
     */
    public Interpreter(BufferedReader bufferedReader) {
        //Loading source file to #source
        try {
            StringBuffer stringBuffer = new StringBuffer("");
            String tmpSource = "";

            do {
                stringBuffer.append(tmpSource);
                tmpSource = bufferedReader.readLine();
            } while (tmpSource != null);
            this.source = stringBuffer.toString();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error: exit this program");
            System.exit(-1);
        }

        this.buffer = new byte[BUF_SIZE];
    }
    /**
     * The constructor which is called with a String argument
     * @param source The String value which holds the source program
     * @since 1.1
     */
    public Interpreter(String source) {
        this.source = source;
        this.buffer = new byte[BUF_SIZE];
    }

    /**
     * Get source code
     * @return source code
     * @since 1.0
     * @see #source
     */
    public String getSource() { return new String(this.source); }
    /**
     * Get buffer
     * @return buffer
     * @since 1.0
     * @see #buffer
     */
    public byte[] getBuffer() { return buffer.clone(); }

    /**
     * Run brainfuck interpreter
     * @since 1.0
     */
    public void run() {
        int current = 0;
        int loop = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < source.length(); i++){
            char c = source.charAt(i);

            switch (c){
                case '>':
                    current++;
                    break;
                case '<':
                    current--;
                    break;
                case '+':
                    buffer[current]++;
                    break;
                case '-':
                    buffer[current]--;
                    break;
                case ',':
                    try {
                        buffer[current] = (byte)bufferedReader.read();
                    } catch (IOException e){
                        ;//do nothing
                    }
                    break;
                case '.':
                    System.out.print((char)buffer[current]);
                    break;
                case '[':
                    if (buffer[current] == 0){
                        i++;
                        try {
                            while (loop > 0 || this.source.charAt(i) != ']'){
                                char tmp = this.source.charAt(i);

                                if (tmp == '['){
                                    loop++;
                                }
                                else if (tmp == ']'){
                                    loop--;
                                }
                                i++;
                            }
                        } catch (IndexOutOfBoundsException e){
                            e.printStackTrace();
                            System.out.println("Error: not closed loop");
                            System.exit(-1);
                        }
                    }
                    break;
                case ']':
                    i--;
                    try {
                        while (loop > 0 || this.source.charAt(i) != '['){
                            char tmp = this.source.charAt(i);

                            if (tmp == ']'){
                                loop++;
                            }
                            else if (tmp == '['){
                                loop--;
                            }
                            i--;
                        }
                    } catch (IndexOutOfBoundsException e){
                        e.printStackTrace();
                        System.out.println("Error: not opened loop");
                        System.exit(-1);
                    }
                    i--;
                    break;
            }
        }
    }

    /**
     * The constant int value that has the size of the buffer
     * @since 1.1
     */
    public static final int BUF_SIZE = 1024;

    /**
     * The String value that holds source file
     * @since 1.0
     */
    private String source;

    /**
     * The byte array value that gets memory area
     * @since 1.0
     */
    private byte[] buffer;
}
