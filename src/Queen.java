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
    public ArrayList<Integer> getPossibleSquares()
    {
        // oop is pretty nice sometimes
        (new Rook(getSquare(), null)).getPossibleSquares();
        (new Bishop(getSquare(), null)).getPossibleSquares();
        return null;
    } // TODO: implement
}
