import java.util.ArrayList;

public class Knight extends Piece
{
    public Knight(int square, Colour c)
    {
        super(square, PieceType.KNIGHT, c);
    }

    public ArrayList<Integer> getPossibleSquares(Board board)
    {
        ArrayList<Integer> squares = new ArrayList<>();
        ArrayList<Integer> potential = new ArrayList<>();

        if (getSquare() % 8 >= 2) {
            potential.add(getSquare() + 6);
            potential.add(getSquare() - 10);
        }
        if (getSquare() % 8 >= 1) {
            potential.add(getSquare() + 15);
            potential.add(getSquare() - 17);
        }
        if (getSquare() % 8 <= 5) {
            potential.add(getSquare() + 10);
            potential.add(getSquare() - 6);
        }
        if (getSquare() % 8 <= 6) {
            potential.add(getSquare() + 17);
            potential.add(getSquare() - 15);
        }

        for (int sq : potential) {
            if (board.pieceCanMove(sq, getColour())) {
                squares.add(sq);
            }
        }

        return squares;
    }
}
