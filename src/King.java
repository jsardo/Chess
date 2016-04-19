/**
 * Created by johnsardo on 2016-04-15.
 */
import java.util.ArrayList;

public class King extends Piece
{
    public King(int square, Colour c)
    {
        super(square, PieceType.KING, c);
    }

    public ArrayList<Integer> getPossibleSquares() { return null; } // TODO: implement
}
