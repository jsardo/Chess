import java.util.ArrayList;

public class King extends Piece
{
    public King(int square, Colour c)
    {
        super(square, PieceType.KING, c);
    }

    public ArrayList<Integer> getPossibleSquares()
    {
        ArrayList<Integer> possibleSquares = new ArrayList<>();
        int[] increments = {-9, -8, -7, -1, 1, 7, 8, 9};

        for (int inc : increments) {
            if (Board.pieceCanMove(getSquare() + inc, getColour())) {
                possibleSquares.add(getSquare() + inc);
            }
        }
        return possibleSquares;
    }
}
