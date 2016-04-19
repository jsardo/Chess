/**
 * Created by johnsardo on 2016-04-15.
 */
import java.util.ArrayList;

public class Bishop extends Piece
{
    public Bishop(int square, Colour c)
    {
        super(square, PieceType.BISHOP, c);
    }
    public ArrayList<Integer> getPossibleSquares() { return null; } // TODO: implement
}
