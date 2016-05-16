public enum PieceType {
  PAWN("P"), ROOK("R"), KNIGHT("N"), BISHOP("B"), KING("K"), QUEEN("Q"), EMPTY(" ");

  private String pieceStr;

  PieceType(String pieceStr) {
    this.pieceStr = pieceStr;
  }

  public String getPieceString() {
    return pieceStr;
  }
}