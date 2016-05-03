import java.util.ArrayList;

public class Test {
    public static void main(String args)
    {
        Bar a = new Bar();
        Bar b = new Bar();

        a.foo.add(2);
        a.a = 3;

    }
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
class Bar
{
    public ArrayList<Integer> foo;
    public int a;
}
