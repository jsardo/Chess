/**
 * Created by johnsardo on 2016-04-15.
 */

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

    public static Piece getSquare(int square)
    {
        if (square >= 0 && square < 64) {
            return board[square];
        }
        else { // TODO: make this legit
            System.out.println("error: trying to access an invalid board location");
            return null;
        }
    }

    public static void printBoard()
    {
        for (int i = 63; i >= 0; ++i) {
            if (i != 63 && (i + 1) % 8 == 0) {
                System.out.println();
            } else {
                System.out.print(getSquare(i).getPieceType().getPieceString());
            }
        }
    }

    public static Piece pieceAtSquare(int s)
    {
        if (isValid(s)) {
            return board[s];
        } else {
            System.out.println("error: accessing invalid board location");
            return null;
        }
    }

    public static void setSquare(int s, Piece p)
    {
        if (isValid(s) && pieceAtSquare(s) == null) {
            board[s] = p;
        } else {
            // do something
        }
    }

    private static boolean isValid(int s) { return (0 <= s && s < 64); }
}
