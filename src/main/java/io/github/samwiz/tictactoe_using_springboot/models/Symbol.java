package io.github.samwiz.tictactoe_using_springboot.models;

public class Symbol
{
    private char aChar;
    public char getaChar() {
        return aChar;
    }
    public void setaChar(char aChar) {
        this.aChar = aChar;
    }

    public Symbol(char aChar) {
        this.aChar = aChar;
    }
}
