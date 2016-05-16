import java.util.ArrayList;

public abstract class Piece {
  private int square;
  private ArrayList<Piece> attacking;
  private PieceType type;
  private Colour colour;
  private String abbrev;

  public Piece() {
  }

  public Piece(int square, PieceType t, Colour c) {
    this.square = square;
    this.type = t;
    this.colour = c;
    this.abbrev = (c == Colour.WHITE) ? type.getPieceString() : type.getPieceString().toLowerCase();
  }

  public int getSquare() {
    return square;
  }

  public String getAbbrev() {
    return abbrev;
  }

  public PieceType getPieceType() {
    return type;
  }

  public Colour getColour() {
    return colour;
  }

  public Piece copyPiece() {
    switch (type) {
      case BISHOP:
        return new Bishop(square, colour);
      case KNIGHT:
        return new Knight(square, colour);
      case ROOK:
        return new Rook(square, colour);
      case KING:
        return new King(square, colour);
      case QUEEN:
        return new Queen(square, colour);
      case PAWN:
        return new Pawn(square, colour);
      case EMPTY:
        return new EmptyPiece(square);
    }
    System.out.println("error: bad piece in copyPiece");
    return null;
  }

  public void setSquare(int square) {
    this.square = square;
  }

  public abstract ArrayList<Integer> getPossibleSquares(Board board);

  public void printPieceInfo() {
    System.out.println("Type: " + type.toString() + " colour: " + colour.toString() + " square: " + square);
  }
}