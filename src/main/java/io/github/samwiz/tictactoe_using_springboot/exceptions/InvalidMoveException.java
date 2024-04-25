package io.github.samwiz.tictactoe_using_springboot.exceptions;

public class InvalidMoveException extends Exception
{
    public InvalidMoveException(String message)
    {
        super(message);
    }
}
