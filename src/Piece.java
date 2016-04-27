import java.util.ArrayList;

/**
 * Created by johnsardo on 2016-04-15.
 */
public abstract class Piece {
    private int square;
    private ArrayList<Piece> attacking;
    private PieceType type;
    private Colour colour;
    private String abbrev;

    public Piece() { }
    public Piece(int square, PieceType t, Colour c)
    {
        this.square = square;
        this.type = t;
        this.colour = c;
        this.abbrev = (c == Colour.WHITE) ? type.getPieceString() : type.getPieceString().toLowerCase();
    }

    public int getSquare() { return square; }
    public String getAbbrev() { return abbrev; }
    public PieceType getPieceType() { return type; }
    public Colour getColour() { return colour; }


    public void setSquare(int square) { this.square = square; }

    public abstract ArrayList<Integer> getPossibleSquares();
}






