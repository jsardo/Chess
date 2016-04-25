// rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR
// default board

/*
56 57 58 59 60 61 62 63
48 49 50 51 52 53 54 55
40 41 42 43 44 45 46 47
32 33 34 35 36 37 38 39
24 25 26 27 28 29 30 31
16 17 18 19 20 21 22 23
 8  9 10 11 12 13 14 15
 0  1  2  3  4  5  6  7
 */
public class Chess
{
    public static void main(String[] args)
    {

        /*
        twoPlayerGame();
        Board.printBoard();
        */
        //FEN.initBoardFromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        FEN.initBoardFromFEN("8/8/8/8/8/8/8/8");
        Board.setSquare(36, new King(36, Colour.WHITE));

        Board.setSquare(44, new Pawn(44, Colour.WHITE));
        Board.setSquare(45, new Pawn(45, Colour.BLACK));
        Board.setSquare(43, new Pawn(43, Colour.WHITE));
        Board.setSquare(35, new Pawn(35, Colour.WHITE));
        Board.setSquare(27, new Pawn(27, Colour.WHITE));
        Board.setSquare(28, new Pawn(28, Colour.WHITE));
        Board.setSquare(29, new Pawn(29, Colour.WHITE));
        Board.setSquare(29, new Queen(29, Colour.BLACK));
        /*
        /*
        for (int i = 0; i < 64; ++i) {
            if (!Board.isEmptySquare(i)) {
                System.out.println(i);
                System.out.println(Board.getSquare(i).getPossibleSquares().toString());
            }
        }
        */
        Board.printBoard();
        //System.out.println(Board.getSquare(36).getPossibleSquares().toString());
        System.out.println("White pieces: ");
        for (Piece p : Board.whitePieces) {
            System.out.println(p.getPieceType().toString() + " at " + p.getSquare());
        }
        System.out.println("Black pieces:");
        for (Piece p : Board.blackPieces) {
            System.out.println(p.getPieceType().toString() + " at " + p.getSquare());
        }
        //System.out.println(Board.getSquare(52).getPossibleSquares().toString());
        /*
        System.out.println(Board.pieceCanMove(25, Board.getSquare(24).getColour()));
        System.out.println(Board.getSquare(24).getColour());
        System.out.println(Board.getSquare(25).getColour());
        */


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
