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
        twoPlayerGame();
        Board.printBoard();
    }


    public static void initDefaultBoard()
    {
        FEN.initBoardFromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
    }
    public static void twoPlayerGame()
    {
        Colour turn = Colour.WHITE;
        InputHandler handler = new InputHandler();
        Piece startPiece, endPiece;

        initDefaultBoard();

        Board.printBoard();
        while (!Board.positionIsInCheck(turn)) {
            handler.readLine("Enter a move for " + turn.toString());
            startPiece = handler.getStartPiece();
            endPiece = handler.getEndPiece();
            if (startPiece.getPieceType() == PieceType.EMPTY) {
                System.out.println("starting square is empty");
                continue;
            }
            if (!startPiece.getPossibleSquares().contains(endPiece.getSquare())) {
                System.out.println("trying to move to an invalid square");
                continue;
            }
            if (startPiece.getColour() == endPiece.getColour()) {
                System.out.println("can't move a piece to a square occupied by a piece of the same colour");
                continue;
            }

            Board.movePieceToSquare(startPiece, endPiece.getSquare());
            Test.printWhitePieces();
            Test.printBlackPieces();
            Board.printBoard();
            turn = (turn == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
        }
    }
}
