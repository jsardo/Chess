import java.util.ArrayList;

public class EmptyPiece extends Piece
{
    public EmptyPiece(int square)
    {
        super(square, PieceType.EMPTY, null);
    }

    public ArrayList<Integer> getPossibleSquares(Board board) { return null; }
}
