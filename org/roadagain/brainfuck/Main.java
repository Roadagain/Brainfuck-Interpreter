package org.roadagain.brainfuck;

public class Main {
    public static void main(String[] args){
        if (args.length == 0){
            throw new IllegalArgumentException("no input files");
        }
    }
}
