import java.util.ArrayList;

public class Pawn extends Piece
{
    public Pawn(int square, Colour c)
    {
        super(square, PieceType.PAWN, c);
    }

    public ArrayList<Integer> getPossibleSquares()
    {
        ArrayList<Integer> possibleSquares = new ArrayList<>();
        int factor = (getColour() == Colour.WHITE) ? 1 : -1; // move forward if white, backward if black
        int currentSquare = getSquare(), potentialSquare, secondRank = (getColour() == Colour.WHITE ? 8 : 48);
        int[] diagonals = {7, 9};


        if (Board.isEmptySquare(currentSquare + factor*8)) {
            possibleSquares.add(currentSquare + factor*8);
            // jump ahead two if on the second rank
            if (Board.isEmptySquare(currentSquare + 2*factor*8) && (currentSquare / 8 * 8 == secondRank)) {
                possibleSquares.add(currentSquare + 2*factor*8);
            }
        }

        for (int inc : diagonals)  {
            potentialSquare = currentSquare + factor*inc;
            if (Board.isValid(potentialSquare) && !Board.isEmptySquare(potentialSquare) &&
                    Board.getSquare(potentialSquare).getColour() != getColour()) {
                possibleSquares.add(potentialSquare);
            }
        }
        return possibleSquares;
    }
}
