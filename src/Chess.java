/**
 * Created by johnsardo on 2016-04-15.
 */

// rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR
// default board

public class Chess
{
    public static void main(String[] args)
    {
        FEN.initBoardFromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        Board.printBoard();
    }

    public void initalizeDefaultBoard()
    {

    }
    /*
    public void twoPlayerGame()
    {
        intializeDefaultBoard();
    }
    */
}
