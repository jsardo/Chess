public class Test {
  public static void main(String[] args) {
    Board board = new Board("r2q1rk1/1bp1bppp/p1n2n2/1p2p3/4P3/1BN2N2/PPP2PPP/R1BQR1K1");
    board.toMove = Colour.WHITE;
    board.printBoard();
    Evaluator.init();
    Evaluator.testMinimax(board, 4);
  }

  static int squareFromChars(char file, char rank) {
    return Character.getNumericValue(file) + 8 * (Character.getNumericValue(rank) - 1) - 10;
  }

  public static void printWhitePieces(Board board) {
    System.out.println("PRINTING WHITE PIECES");
    for (Piece p : board.whitePieces) {
      System.out.println(p.getPieceType().toString() + " at " + p.getSquare());
    }
  }

  public static void printBlackPieces(Board board) {
    System.out.println("PRINTING BLACK PIECES");
    for (Piece p : board.blackPieces) {
      System.out.println(p.getPieceType().toString() + " at " + p.getSquare());
    }
  }
}

