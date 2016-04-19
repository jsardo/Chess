/**
 * Created by johnsardo on 2016-04-15.
 */
import java.util.ArrayList;

public class Queen extends Piece
{
    public Queen(int square, Colour c)
    {
        super(square, PieceType.QUEEN, c);
    }
    public ArrayList<Integer> getPossibleSquares() { return null; } // TODO: implement
}
