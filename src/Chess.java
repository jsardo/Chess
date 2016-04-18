/**
 * Created by johnsardo on 2016-04-15.
 */

// rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR
// default board

public class Chess
{
    public static void main(String[] args)
    {

        twoPlayerGame();
        Board.printBoard();
    }

    public static void initDefaultBoard()
    {
        FEN.initBoardFromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
    }
    public static void twoPlayerGame()
    {
        initDefaultBoard();
    }
}
