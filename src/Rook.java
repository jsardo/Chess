/**
 * Created by johnsardo on 2016-04-15.
 */

import java.util.ArrayList;

public class Rook extends Piece
{
    public Rook(int square, Colour c)
    {
        super(square, PieceType.ROOK, c);
    }

    public ArrayList<Integer> getPossibleSquares()
    {
        ArrayList<Integer> possibleSquares = new ArrayList<>();
        int currentSquare = getSquare() + 8;

        while (currentSquare < 64) {
            if (Board.isEmptySquare(currentSquare)) {
                possibleSquares.add(currentSquare);
            } else {
                break; // can break because if one square is blocked then all others above are blocked.
            }
            currentSquare += 8; // adding 8 moves up one row in this board representation.
        }
        currentSquare = getSquare() - 8;
        while (currentSquare >= 0) {
            if (Board.isEmptySquare(currentSquare)) {
                possibleSquares.add(currentSquare);
            } else {
                break;
            }
            currentSquare -= 8;
        }
        int lower = (currentSquare/8)*8, upper = lower + 8;
        currentSquare = getSquare() + 1;
        while (currentSquare < upper) {
            if (Board.isEmptySquare(currentSquare)) {
                possibleSquares.add(currentSquare);
            } else {
                break;
            }
            currentSquare++;
        }
        currentSquare =




        return possibleSquares;
    }

}
