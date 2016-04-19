/**
 * Created by johnsardo on 2016-04-17.
 */
import java.util.ArrayList;

public class EmptyPiece extends Piece
{
    public EmptyPiece(int square)
    {
        super(square, PieceType.EMPTY, null);
    }

    public ArrayList<Integer> getPossibleSquares() { return null; }
}
