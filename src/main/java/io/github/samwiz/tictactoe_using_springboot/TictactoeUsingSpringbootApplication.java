package io.github.samwiz.tictactoe_using_springboot;

import io.github.samwiz.tictactoe_using_springboot.controllers.GameController;
import io.github.samwiz.tictactoe_using_springboot.exceptions.InvalidMoveException;
import io.github.samwiz.tictactoe_using_springboot.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

@SpringBootApplication
public class TictactoeUsingSpringbootApplication
{

    public static void main(String[] args) throws InvalidMoveException
    {
        SpringApplication.run(TictactoeUsingSpringbootApplication.class, args);
        System.out.println("Hello to the game of Tic-Tac-Toe!");
        Scanner in = new Scanner(System.in);
        GameController gameController = new GameController();
        System.out.println("Do you want to include bot into the game? Type 1 for yes or 0 for no (Currently single bot is available per game)");
        int chkforbot = in.nextInt();
        System.out.println("Please enter the number of people playing excluding bot");
        int dimension = -1;
        int d = -1;
        if(chkforbot ==  1)
        {
            d = in.nextInt();
            dimension = d + 1;
        }
        else
        {
            d = in.nextInt();
            dimension = d;
        }
        System.out.println("Please enter name and symbol for each player");
        List<Player> players = new ArrayList<>();
        for(int i=0; i < d; i++)
        {
            System.out.println("Enter the name of player "+i+1);
            String name = in.nextLine();
            System.out.println("/n"+"Enter the symbol(any single character) for player "+i+1);
            String symbol = in.nextLine();
            char symb = symbol.charAt(0);
            players.add(new Player(name, new Symbol(symb), PlayerType.HUMAN));
        }
        if(chkforbot == 1)
        {
            System.out.println("Enter the bot difficulty level: 1 for easy, 2 for medium and 3 for difficult");
            int diff = in.nextInt();
            System.out.println("Choose a symbol for bot too !");
            String symbol = in.nextLine();
            char symb = symbol.charAt(0);
            if(diff == 3)
            {
                players.add(new Bot("BOT", new Symbol(symb) , PlayerType.BOT, BotDifficultyLevel.HARD));
            }
            else if (chkforbot == 2)
            {
                players.add(new Bot("BOT", new Symbol(symb) , PlayerType.BOT, BotDifficultyLevel.MEDIUM));
            }
            else
            {
                players.add(new Bot("BOT", new Symbol(symb) , PlayerType.BOT, BotDifficultyLevel.EASY));
            }
        }
        Game game = gameController.startGame(dimension, players);
        while (game.getGameState().equals(GameState.IN_PROGRESS))
        {
            gameController.printBoard(game);
            gameController.makeMove(game);
        }
        if (!gameController.checkState(game).equals(GameState.ENDED))
        {
            game.setGameState(GameState.DRAW);
            System.out.println("Game DRAW");
        }
        else
        {
            gameController.printBoard(game);
            System.out.println("Player " + gameController.getWinner(game).getName() + " is the winner");
        }
    }
}