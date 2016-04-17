import java.util.ArrayList;

/**
 * Created by johnsardo on 2016-04-15.
 */
public class Piece {
    private int square;
    private ArrayList<Piece> attacking;
    private PieceType type;
    private Colour colour;

    public Piece() { }
    public Piece(int square, PieceType t, Colour c)
    {
        this.square = square;
        this.type = t;
        this.colour = c;
    }

    public int getSquare() { return square; }

    public PieceType getPieceType() { return type; }

    public Colour getColour() { return colour; }

    //abstract void setAttacking();
}






