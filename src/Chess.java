// TODO: pawn promotion, castling,
public class Chess {
  public static void main(String[] args) {
    Evaluator.init();
    twoPlayerGame();
  }

  public static void twoPlayerGame() {
    Board board = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
    board.toMove = Colour.WHITE;
    InputHandler handler = new InputHandler();
    Piece startPiece, endPiece;

    board.printBoard();
    while (!board.inCheckmate(board.toMove) && !board.isStalemate(board.toMove)) {
      handler.readLine("Enter a move for " + board.toMove.toString());
      startPiece = handler.getStartPiece(board);
      endPiece = handler.getEndPiece(board);
      if (startPiece.getPieceType() == PieceType.EMPTY) {
        System.out.println("starting square is empty");
        continue;
      }
      if (!startPiece.getPossibleSquares(board).contains(endPiece.getSquare())) {
        System.out.println("trying to move to an invalid square");
        continue;
      }
      if (startPiece.getColour() == endPiece.getColour()) {
        System.out.println("can't move a piece to a square occupied by a piece of the same colour");
        continue;
      }

      board.movePieceToSquare(startPiece, endPiece.getSquare());
      board.printBoard();
      board.toMove = (board.toMove == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
    }

    if (board.isStalemate(board.toMove)) {
      System.out.println("Stalemate!");
    } else {
      if (board.toMove == Colour.WHITE) {
        System.out.println("Black wins by checkmate!");
      } else {
        System.out.println("White wins by checkmate!");
      }
    }
  }
}