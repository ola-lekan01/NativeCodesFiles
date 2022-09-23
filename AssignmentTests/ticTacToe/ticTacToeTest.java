package ticTacToe;

import org.junit.jupiter.api.*;
import ticTacToe.Exception.TicTacToeIndexOutOfBound;
import ticTacToe.Exception.TicTacToeMarkPositionException;

import static org.junit.jupiter.api.Assertions.*;
import static ticTacToe.Mark.*;

public class ticTacToeTest {
    private Player player1;
    private Player player2;
    private Board board;

    @BeforeEach
    public void setThisUp(){
        player1 = new Player(X , "Lakes");
        player2 = new Player(O, "James");
        board = new Board();
    }

    @Test
    public void testToGetPlayerMark(){
        assertEquals(X, player1.getMark());
        assertEquals(O, player2.getMark());
    }

    @Test
    public void testThatBoardIsNotNull(){
        assertNotNull(board);
    }

    @Test
    public void testThatPlayer1CanMarkBoard(){
        player1.playGame(1, board);
        player1.playGame(3, board);
        Mark [][] boardSurface = board.getBoardSurface();
        assertEquals(X, boardSurface[0][0]);
        assertEquals(X, boardSurface[0][2]);
    }

    @Test
    public void testThatPlayer2CanMarkBoard(){
        player2.playGame(9, board);
        player2.playGame(8, board);
        Mark [][] boardSurface = board.getBoardSurface();
        assertEquals(O, boardSurface[2][2]);
        assertEquals(O, boardSurface[2][1]);
    }

    @Test
    public void testThatPlayer1AndPlayer2(){
        player1.playGame(4, board);
        player2.playGame(7, board);
        Mark [][] boardSurface = board.getBoardSurface();
        assertEquals(X, boardSurface[1][0]);
        assertEquals(O, boardSurface[2][0]);
    }

    @Test
    public void testThatPlayingInAnOccupiedPositionThrowsException(){
        player1.playGame(5,board);
        assertThrows(TicTacToeMarkPositionException.class, () -> player2.playGame(5, board));
    }

    @Test
    public void testThatPlayingInAnIndexOutOfBoundThrowsAnException(){
        assertThrows(TicTacToeIndexOutOfBound.class, () -> player2.playGame(10, board));
    }

    @Test
    public void testThatThereIsAWinnerOnRowZero(){
        player1.playGame(1,board);
        player2.playGame(5,board);
        player1.playGame(2,board);
        player2.playGame(6,board);
        player1.playGame(3,board);
        assertTrue(board.isAWinner());
    }

    @Test
    public void testThatThereIsAWinnerOnRowTwo(){
        player1.playGame(4,board);
        player2.playGame(8,board);
        player1.playGame(5,board);
        player2.playGame(2,board);
        player1.playGame(6,board);
        assertTrue(board.isAWinner());
    }

    @Test
    public void testThatThereIsAWinnerOnRowThree(){
        player1.playGame(7, board);
        player2.playGame(1, board);
        player1.playGame(8, board);
        player2.playGame(2, board);
        player1.playGame(9, board);
        assertTrue(board.isAWinner());
    }

    @Test
    public void testThatThereIsAWinnerOnColumnZero(){
        player1.playGame(1, board);
        player2.playGame(2, board);
        player1.playGame(4, board);
        player2.playGame(3, board);
        player1.playGame(7, board);
        assertTrue(board.isAWinner());
    }

    @Test
    public void testThatThereIsAWinnerOnColumnOne(){
        player1.playGame(1, board);
        player2.playGame(2, board);
        player1.playGame(4, board);
        player2.playGame(5, board);
        player1.playGame(7, board);
        player2.playGame(8, board);
        assertTrue(board.isAWinner());
    }

    @Test
    public void testThatThereIsAWinnerOnColumnTwo(){
        player1.playGame(1, board);
        player2.playGame(3, board);
        player1.playGame(4, board);
        player2.playGame(6, board);
        player1.playGame(7, board);
        player2.playGame(9, board);
        assertTrue(board.isAWinner());
    }

    @Test
    public void testThatThereIsAWinnerOnDiagonalOne(){
        player1.playGame(1, board);
        player2.playGame(3, board);
        player1.playGame(5, board);
        player2.playGame(6, board);
        player1.playGame(9, board);
        assertTrue(board.isAWinner());
    }

    @Test
    public void testThatThereIsAWinnerOnDiagonalTwo(){
        player1.playGame(3, board);
        player2.playGame(2, board);
        player1.playGame(5, board);
        player2.playGame(6, board);
        player1.playGame(7, board);
        assertTrue(board.isAWinner());
    }

    @Test
    public void testThatGameIsATie(){
        player1.playGame(3, board);
        player2.playGame(2, board);
        player1.playGame(5, board);
        player2.playGame(6, board);
        player1.playGame(7, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void trueIsReturnedWhenThereIsATie() {
        player1.playGame(1, board);
        player2.playGame(2, board);
        player1.playGame(3, board);
        player2.playGame(9, board);
        player1.playGame(5, board);
        player2.playGame(6, board);
        player1.playGame(8, board);
        player2.playGame(7, board);
        player1.playGame(4, board);
        assertFalse(board.isAWinner());
        assertTrue(board.isATie());
    }

}