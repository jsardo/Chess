import java.util.ArrayList;

public class Rook extends Piece
{
    public Rook(int square, Colour c)
    {
        super(square, PieceType.ROOK, c);
    }

    public ArrayList<Integer> getPossibleSquares(Board board)
    {
        ArrayList<Integer> possibleSquares = new ArrayList<>();
        int currentSquare = getSquare();
        Colour c = getColour();

        // TODO: make those loops like those Bishop.java because i'm stupid
        currentSquare += 8;
        while (currentSquare < 64) {
            if (board.pieceCanMove(currentSquare, c)) {
                if (board.isEmptySquare(currentSquare)) {
                    possibleSquares.add(currentSquare);
                } else {
                    possibleSquares.add(currentSquare);
                    break;
                }
            } else {
                break;
            }
            currentSquare += 8; // adding 8 moves up one row in this board representation.
        }

        currentSquare = getSquare() - 8;
        while (currentSquare >= 0) {
            if (board.pieceCanMove(currentSquare, c)) {
                if (board.isEmptySquare(currentSquare)) {
                    possibleSquares.add(currentSquare);
                } else {
                    possibleSquares.add(currentSquare);
                    break;
                }
            } else {
                break;
            }
            currentSquare -= 8;
        }
        int lower = (getSquare()/8)*8, upper = lower + 8;
        currentSquare = getSquare()+1;
        while (currentSquare < upper) {
            if (board.pieceCanMove(currentSquare, c)) {
                if (board.isEmptySquare(currentSquare)) {
                    possibleSquares.add(currentSquare);
                } else {
                    possibleSquares.add(currentSquare);
                    break;
                }
            } else {
                break;
            }
            currentSquare++;
        }
        currentSquare = getSquare()-1;
        while (currentSquare >= lower) {
            if (board.pieceCanMove(currentSquare, c)) {
                if (board.isEmptySquare(currentSquare)) {
                    possibleSquares.add(currentSquare);
                } else {
                    possibleSquares.add(currentSquare);
                    break;
                }
            } else {
                break;
            }
            currentSquare--;
        }
        return possibleSquares;
    }
}