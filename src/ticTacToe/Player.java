package ticTacToe;

import ticTacToe.Exception.TicTacToeIndexOutOfBound;
import ticTacToe.Exception.TicTacToeMarkPositionException;

import static ticTacToe.Mark.E;

public class Player {
    private Mark mark;
    private String name;

    public Player(Mark mark, String name) {
        this.mark = mark;
        this.name = name;
    }

    public Mark getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public void playGame(int markPosition, Board board) {
        boolean isValidPosition = markPosition < 1 || markPosition > 9;
        if (isValidPosition) throw new TicTacToeIndexOutOfBound("You can only play between position 1 and 9");
        int position = markPosition - 1;
        int row = position / 3;
        int col = position % 3;

        var boardSurface = board.getBoardSurface();
        if(isEmptyPosition(col, boardSurface[row])) boardSurface[row][col] = mark;
    }

    public boolean isEmptyPosition(int col, Mark [] boardSurface){
        if(boardSurface[col] == E) return true;
        else throw new TicTacToeMarkPositionException("You can Only Mark an Empty Position");
    }
}