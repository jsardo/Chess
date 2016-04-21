/**
 * Created by johnsardo on 2016-04-15.
 */
import java.util.ArrayList;

public class Knight extends Piece
{
    public Knight(int square, Colour c)
    {
        super(square, PieceType.KNIGHT, c);
    }

    public ArrayList<Integer> getPossibleSquares()
    {
        ArrayList<Integer> squares = new ArrayList<>();
        int[] knightSquareIncrements = {-17, -15, -10, -6, 6, 10, 15, 17};

        int lower = (getSquare()/8)*8, upper = lower + 8, current;
        for (int inc : knightSquareIncrements) {
            current = getSquare() + inc;

        }
        return squares;
    }
}
