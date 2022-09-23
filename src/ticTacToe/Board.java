package ticTacToe;

import static ticTacToe.Mark.*;

public class Board {

    private final Mark [][] boardSurface = {{E,E,E},{E,E,E},{E,E,E}};
    private boolean isX, isO;

    public boolean  isAWinner() {
        if(isWinnerOnRowZero()) return true;
        else if(isWinnerOnRowTwo()) return true;
        else if(isWinnerOnRowThree()) return true;
        else if(isWinnerOnColumnZero()) return true;
        else if(isWinnerOnColumnOne()) return true;
        else if(isWinnerOnColumnTwo()) return true;
        else if (isWinnerOnDiagonalOne()) return true;
        else return isWinnerOnDiagonalZero();
    }

    private boolean isWinnerOnRowZero(){
        isX = boardSurface[0][0] == X && boardSurface[0][1] == X && boardSurface[0][2] == X;
        isO = boardSurface[0][0] == O && boardSurface[0][1] == O && boardSurface[0][2] == O;
        winnerDisplay(isX, isO);
        return isX || isO;
    }

    private boolean isWinnerOnRowTwo(){
        isX = boardSurface[1][0] == X && boardSurface[1][1] == X && boardSurface[1][2] == X;
        isO = boardSurface[1][0] == O && boardSurface[1][1] == O && boardSurface[1][2] == O;
        winnerDisplay(isX, isO);
        return isX || isO;
    }

    private boolean isWinnerOnRowThree(){
        isX = boardSurface[2][0] == X && boardSurface[2][1] == X && boardSurface[2][2] == X;
        isO = boardSurface[2][0] == O && boardSurface[2][1] == O && boardSurface[2][2] == O;
        winnerDisplay(isX, isO);
        return isX || isO;
    }

    private boolean isWinnerOnColumnZero(){
        isX = boardSurface[0][0] == X && boardSurface[1][0] == X && boardSurface[2][0] == X;
        isO = boardSurface[0][0] == O && boardSurface[1][0] == O && boardSurface[2][0] == O;
        winnerDisplay(isX, isO);
        return isX || isO;
    }

    private boolean isWinnerOnColumnOne(){
        isX = boardSurface[0][1] == X && boardSurface[1][1] == X && boardSurface[2][1] == X;
        isO = boardSurface[0][1] == O && boardSurface[1][1] == O && boardSurface[2][1] == O;
        winnerDisplay(isX, isO);
        return isX || isO;
    }

    private boolean isWinnerOnColumnTwo(){
        isX = boardSurface[0][2] == X && boardSurface[1][2] == X && boardSurface[2][2] == X;
        isO = boardSurface[0][2] == O && boardSurface[1][2] == O && boardSurface[2][2] == O;
        winnerDisplay(isX, isO);
        return isX || isO;
    }

    private boolean isWinnerOnDiagonalZero(){
        isX = boardSurface[0][0] == X && boardSurface[1][1] == X && boardSurface[2][2] == X;
        isO = boardSurface[0][0] == O && boardSurface[1][1] == O && boardSurface[2][2] == O;
        winnerDisplay(isX, isO);
        return isX || isO;
    }

    private boolean isWinnerOnDiagonalOne(){
        isX = boardSurface[0][2] == X && boardSurface[1][1] == X && boardSurface[2][0] == X;
        isO = boardSurface[0][2] == O && boardSurface[1][1] == O && boardSurface[2][0] == O;
        winnerDisplay(isX, isO);
        return isX || isO;
    }

    public boolean isATie(){
        return !isAWinner() && !checkEmptyBoard();
    }

    private boolean checkEmptyBoard() {
        for(Mark[] marks : boardSurface){
            for (int i = 0; i < boardSurface.length; i++) {
             if(marks[i] == E) return true;
            }
        }
        return false;
    }

    private void winnerDisplay(boolean isX, boolean isO) {
        if(isO) System.out.println("Player 2 Won the Game");
        if(isX) System.out.println("Player 1 Won the Game");
    }


    public void displaySurface() {
        for (Mark[] marks : boardSurface){
            System.out.print(" | ");
            for (int i = 0; i < boardSurface.length; i++) {
                System.out.print(marks[i]);
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public Mark[][] getBoardSurface() {
        return boardSurface;
    }
}
