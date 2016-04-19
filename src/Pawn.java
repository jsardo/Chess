/**
 * Created by johnsardo on 2016-04-15.
 */
import java.util.ArrayList;

public class Pawn extends Piece
{
    public Pawn(int square, Colour c)
    {
        super(square, PieceType.PAWN, c);
    }

    public ArrayList<Integer> getPossibleSquares() { return null; } // TODO: implement
}
