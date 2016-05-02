import java.util.ArrayList;

public class Queen extends Piece
{
    public Queen(int square, Colour c)
    {
        super(square, PieceType.QUEEN, c);
    }

    public ArrayList<Integer> getPossibleSquares(Board board)
    {
        ArrayList<Integer> possibleSquares = new ArrayList<Integer>();

        possibleSquares.addAll((new Rook(getSquare(), getColour())).getPossibleSquares(board));
        possibleSquares.addAll((new Bishop(getSquare(), getColour())).getPossibleSquares(board));

        return possibleSquares;
    }
}