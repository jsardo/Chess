public class Test {
    static int squareFromChars(char file, char rank)
    {
        return Character.getNumericValue(file) + 8*(Character.getNumericValue(rank)-1) - 10;
    }

    public static void printWhitePieces(Board board)
    {
        System.out.println("PRINTING WHITE PIECES");
        for (Piece p : board.whitePieces) {
            System.out.println(p.getPieceType().toString() + " at " + p.getSquare());
        }
    }
    public static void printBlackPieces(Board board)
    {
        System.out.println("PRINTING BLACK PIECES");
        for (Piece p : board.blackPieces) {
            System.out.println(p.getPieceType().toString() + " at " + p.getSquare());
        }
    }

}
