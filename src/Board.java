import java.util.ArrayList;
import java.util.Collection;

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
public class Board
{
    private static Piece[] board = new Piece[64];

    public static ArrayList<Piece> whitePieces = new ArrayList<>();
    public static ArrayList<Piece> blackPieces = new ArrayList<>();

    public static Piece getSquare(int square)
    {
        if (square >= 0 && square < 64) {
            return board[square];
        }
        else { // TODO: make this legit
            System.out.println("error: trying to access an invalid board location");
            System.exit(0);
            return null;
        }
    }

    public static boolean isEmptySquare(int square)
    {
        return (isValid(square) && (getSquare(square).getPieceType() == PieceType.EMPTY));
    }


    public static void setSquare(int s, Piece p)
    {
        Piece pieceAtSquare;
        if (isValid(s)) {
            pieceAtSquare = getSquare(s);
            if (pieceAtSquare != null && !isEmptySquare(s)) {
                if (pieceAtSquare.getColour() == Colour.WHITE) {
                    whitePieces.remove(pieceAtSquare);
                } else if (pieceAtSquare.getColour() == Colour.BLACK) {
                    blackPieces.remove(pieceAtSquare);
                }
            }
            board[s] = p;
            if (p.getColour() == Colour.WHITE) {
                whitePieces.add(p);
            } else if (p.getColour() == Colour.BLACK) {
                blackPieces.add(p);
            }
        } else {
            System.out.println("error: in setSquare(): invalid square");
            System.exit(0);
        }
    }

    /*
    return true if the square is nonempty or occupied by a piece of the opposite colour; false otherwise
     */
    public static boolean pieceCanMove(int square, Colour c)
    {
        return isValid(square) && (isEmptySquare(square) || getSquare(square).getColour() != c);
    }

    public static boolean positionIsInCheck(Colour c)
    {
        return (c == Colour.WHITE) ? kingIsAttackedBy(blackPieces) : kingIsAttackedBy(whitePieces);
    }

    private static boolean kingIsAttackedBy(Collection<Piece> pieces)
    {
        for (Piece p : pieces) {
            for (int square : p.getPossibleSquares()) {
                if (getSquare(square).getPieceType() == PieceType.KING) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValid(int s) { return (0 <= s && s < 64); }

    public static void printBoard()
    {
        System.out.println("  |-------------------------------|");
        for (int i = 7; i >= 0; --i) {
            System.out.print(i+1);
            System.out.print(" |");
            for (int j = 0; j < 8; ++j) {
                System.out.print(" " + getSquare(i*8 + j).getAbbrev());
                System.out.print(" |");
            }
            System.out.println();
            System.out.println("  |-------------------------------|");
        }
        System.out.println("    a   b   c   d   e   f   g   h");
    }
}
