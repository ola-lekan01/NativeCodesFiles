package ticTacToe;

import ticTacToe.Exception.TicTacToeIndexOutOfBound;
import ticTacToe.Exception.TicTacToeMarkPositionException;
import java.util.*;

import static ticTacToe.Mark.*;

public class MainPage {
    private Scanner scanner = new Scanner(System.in);
    private Board board = new Board();
    private List<Integer> numberGen = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    private Player player1;
    int size = numberGen.size();
    private Player player2;
    int positionPlayer1;

    public static void main(String[] args) {
        MainPage main = new MainPage();
        main.gameMenu();
    }

    public void gameMenu(){
        displayStatus("Welcome to Tic-Tac-Toe Game");
        displayStatus("Select an Option to Continue ");
        String mainMenu = """
                1.  --> Play Tic-Tac-Toe
                2.  --> Exit
                """;
        switch (returnIntInput(mainMenu)){
            case 1: gameOptions();
            case 2: System.exit(2);
        }
    }

    private void gameOptions() {
        String subMenu = """
                1.  --> Two Player Game
                2.  --> Play with Computer
                3.  --> Go back to previous menu
                4.  --> Exit
                """;
        switch (returnIntInput(subMenu)){
            case 1: playTwoPlayerGame();
            case 2: playWithComputer();
            case 3: gameMenu();
            case 4: System.exit(4);
        }
    }
    private void setUpComputer(){
        String playerName2 = returnStringInput("Enter Player 2 Name: ");
        displayStatus("Your avatar is O");
        player2 = new Player(O, playerName2);
    }

    private void setUpPlayer1(){
        String playerName1 = returnStringInput("Enter Player 1 Name: ");
        displayStatus("Your avatar is X");
        player1 = new Player(X, playerName1);
    }

    private void setUpPlayer2(){
        String playerName2 = returnStringInput("Enter Player 2 Name: ");
        displayStatus("Your avatar is O");
        player2 = new Player(O, playerName2);
    }

    private void playWithComputer(){
        setUpPlayer1();
        setUpComputer();
        computerGameBoard();
    }

    private void playWithComputerGame() {
        System.out.println(player2.getName() + " --> Played!!! ");
        markPosition();
    }

    private void player1Turn(){
        System.out.println();
        System.out.printf("%s Select a Position between 1 and 9 to mark on the Board: --> ", player1.getName());
        positionPlayer1 = scanner.nextInt();
        player1.playGame(positionPlayer1, board);
    }

    private void player2Turn(){
        System.out.println();
        System.out.printf("%s Select a Position between 1 and 9 to mark on the Board: --> ", player2.getName());
        int position = scanner.nextInt();
        player2.playGame(position, board);
    }

    private void markPosition() {
        try {
            int position;
            Collections.shuffle(numberGen);
            int mark = numberGen.remove(0);
            int colMark = mark % 3, rowMark = mark / 3;
            var boardSurface = board.getBoardSurface();
            if(player1.isEmptyPosition(colMark, boardSurface[rowMark])) {
                position = mark;
                player2.playGame(position, board);
            }
        }
        catch (TicTacToeMarkPositionException | TicTacToeIndexOutOfBound exception) {
            System.out.println(exception.getMessage());
            markPosition();
        }
    }
    private void computerGameBoard() {
        try{
            player1Turn();
            board.displaySurface();

            while (!board.isAWinner() || !board.isATie()){
                playWithComputerGame();
                board.displaySurface();
                if(board.isAWinner()) break;

                player1Turn();
                board.displaySurface();
                if (board.isAWinner()) break;
                if(board.isATie()) System.out.println("Game is a Tie!!! Game Session Ended ");
            }
        }
        catch (TicTacToeMarkPositionException | TicTacToeIndexOutOfBound exception){
            System.err.println(exception.getMessage());
            computerGameBoard();
        }
        gameOverOption();
    }

    private void playTwoPlayerGame() {
        setUpPlayer1();
        setUpPlayer2();
        gameBoard();
    }

    private void gameBoard(){
        try{
         player1Turn();
         board.displaySurface();

         while (!board.isAWinner() || !board.isATie()){
             player2Turn();
             board.displaySurface();
             if(board.isAWinner()) break;

             player1Turn();
             board.displaySurface();
             System.out.println();
             if (board.isAWinner()) break;
             if(board.isATie()) System.out.println("Game is a Tie!!! Game Session Ended ");
            }
        }
        catch (TicTacToeMarkPositionException | TicTacToeIndexOutOfBound exception){
            System.err.println(exception.getMessage());
            gameBoard();
        }
        gameOverOption();
    }

    private void gameOverOption() {
        String gameOverOption = """
                Game Over
                1.  --> Play Again;
                2.  --> Back to Game Options
                3.  --> Exit
                """;
        switch (returnIntInput(gameOverOption)){
            case 1: gameBoard();
            case 2: gameOptions();
            default: System.exit(3);
        }
    }

    private String returnStringInput(String message){
        System.out.println();
        System.out.println(message);
        return scanner.next();
    }

    private void displayStatus(String message) {
        System.out.println();
        System.out.println(message);
    }

    private int returnIntInput(String message){
        System.out.println();
        System.out.println(message);
        return scanner.nextInt();
    }
}