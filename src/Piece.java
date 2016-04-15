import java.util.ArrayList;

/**
 * Created by johnsardo on 2016-04-15.
 */
public abstract class Piece {
    private int square;
    private ArrayList<Piece> attacking;
    private PieceType type;

    public Piece() { }
    public Piece(int square) { this.square = square; }

    public int getSquare() { return square; }

    public PieceType getPieceType() { return type; }

    abstract void setAttacking();
}






