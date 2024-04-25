package io.github.samwiz.tictactoe_using_springboot.controllers;
import io.github.samwiz.tictactoe_using_springboot.exceptions.InvalidMoveException;
import io.github.samwiz.tictactoe_using_springboot.models.Game;
import io.github.samwiz.tictactoe_using_springboot.models.GameState;
import io.github.samwiz.tictactoe_using_springboot.models.Player;

import java.util.List;

public class GameController
{
    public Game startGame(int dimension, List<Player> players)
    {
        return new Game(dimension, players);
    }
    public void makeMove(Game game) throws InvalidMoveException
    {
        game.makeMove();
    }
    public GameState checkState(Game game)
    {
        return game.getGameState();
    }
    public Player getWinner(Game game)
    {
        return game.getWinner();
    }
    public void printBoard(Game game)
    {
        game.printBoard();
    }
}
