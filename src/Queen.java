import java.util.ArrayList;

public class Queen extends Piece
{
    public Queen(int square, Colour c)
    {
        super(square, PieceType.QUEEN, c);
    }

    public ArrayList<Integer> getPossibleSquares()
    {
        ArrayList<Integer> possibleSquares = new ArrayList<Integer>();

        possibleSquares.addAll((new Rook(getSquare(), getColour())).getPossibleSquares());
        possibleSquares.addAll((new Bishop(getSquare(), getColour())).getPossibleSquares());

        return possibleSquares;
    }
}
