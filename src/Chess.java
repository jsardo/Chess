public class Chess
{
    public static void main(String[] args)
    {
        twoPlayerGame();
    }

    public static void twoPlayerGame()
    {
        Board board = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        Colour turn = Colour.WHITE;
        InputHandler handler = new InputHandler();
        Piece startPiece, endPiece;

        board.printBoard();
        while (!board.inCheckmate(turn) && !board.isStalemate(turn)) {
            handler.readLine("Enter a move for " + turn.toString());
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
            /*
            Test.printWhitePieces(board);
            Test.printBlackPieces(board);
            */
            board.printBoard();
            turn = (turn == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
        }

        if (board.isStalemate(turn)) {
            System.out.println("Stalemate!");
        } else {
            if (turn == Colour.WHITE) {
                System.out.println("Black wins by checkmate!");
            } else {
                System.out.println("White wins by checkmate!");
            }
        }
    }
}