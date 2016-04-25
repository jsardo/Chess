import java.util.ArrayList;

public class Bishop extends Piece
{
    public Bishop(int square, Colour c)
    {
        super(square, PieceType.BISHOP, c);
    }

    public ArrayList<Integer> getPossibleSquares()
    {
        ArrayList<Integer> possibleSquares = new ArrayList<>();
        int currentSquare = getSquare();
        Colour c = getColour();

        // up-right diagonal
        while (currentSquare % 8 < 7 && Board.pieceCanMove(currentSquare + 9, c)) {
            if (Board.isEmptySquare(currentSquare + 9)) {
                possibleSquares.add(currentSquare+9);
            } else {
                possibleSquares.add(currentSquare+9);
                break;
            }
            currentSquare += 9;
        }

        // up-left diagonal
        currentSquare = getSquare();
        while (currentSquare % 8 > 0 && Board.pieceCanMove(currentSquare + 7, c)) {
            if (Board.isEmptySquare(currentSquare + 7)) {
                possibleSquares.add(currentSquare + 7);
            } else {
                possibleSquares.add(currentSquare+7);
                break;
            }
            currentSquare += 7;
        }

        // down-left diagonal
        currentSquare = getSquare();
        while (currentSquare % 8 > 0 && Board.pieceCanMove(currentSquare - 9, c)) {
            if (Board.isEmptySquare(currentSquare - 9)) {
                possibleSquares.add(currentSquare - 9);
            } else {
                possibleSquares.add(currentSquare-9);
                break;
            }
            currentSquare -= 9;
        }

        // down-right diagonal
        currentSquare = getSquare();
        while (currentSquare % 8 < 7 && Board.pieceCanMove(currentSquare - 7, c)) {
            if (Board.isEmptySquare(currentSquare - 7)) {
                possibleSquares.add(currentSquare - 7);
            } else {
                possibleSquares.add(currentSquare-7);
                break;
            }
            currentSquare -= 7;
        }

        return possibleSquares;
    }
}
