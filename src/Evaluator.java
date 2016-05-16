import java.util.*;

public class Evaluator {
  private static Map<PieceType, Integer> pieceValues = new HashMap<>();
  // will hold entries of the form "xx-yy : n" where xx, yy are starting, ending squares of a piece and n is eval.
  private static SortedSet<Map.Entry<String, Double>> moveValues = new TreeSet<>(
      new Comparator<Map.Entry<String, Double>>() {
        @Override
        public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
          return -o1.getValue().compareTo(o2.getValue());
        }
      });
  private static final int MAXIMUM_MOVES = 5;


  private static int[] knightSquareValues = {
      -1, -1, -1, -1, -1, -1, -1, -1,
      -1,  0,  0,  0,  0,  0,  0, -1,
      -1,  0,  2,  2,  2,  2,  0, -1,
      -1,  0,  2,  4,  4,  2,  0, -1,
      -1,  0,  2,  4,  4,  2,  0, -1,
      -1,  0,  2,  2,  2,  2,  0, -1,
      -1,  0,  0,  0,  0,  0,  0, -1,
      -1, -1, -1, -1, -1, -1, -1, -1,
  };

  public static void init() {
    pieceValues.put(PieceType.BISHOP, 3);
    pieceValues.put(PieceType.EMPTY, 0);
    pieceValues.put(PieceType.KING, 1000);
    pieceValues.put(PieceType.KNIGHT, 3);
    pieceValues.put(PieceType.PAWN, 1);
    pieceValues.put(PieceType.QUEEN, 9);
    pieceValues.put(PieceType.ROOK, 5);
  }

  public static double minimax(Board b, int depth)
  {
    moveValues.clear();
    return minimax_(b, depth, true);
  }

  private static double minimax_(Board b, int depth, boolean firstCall) {
    Board newBoard;
    Piece pieceToMove;
    ArrayList<Piece> pieces = (b.toMove == Colour.WHITE) ? b.whitePieces : b.blackPieces;
    double max = Double.MIN_VALUE, min = Double.MAX_VALUE, value;

    if (depth == 0) {
      return evaluate(b);
    }
    for (Piece p : pieces) {
      for (int sq : p.getPossibleSquares(b)) {
        newBoard = b.copyBoard(b);
        pieceToMove = newBoard.getSquare(p.getSquare());
        newBoard.movePieceToSquare(pieceToMove, sq);
        value = minimax_(newBoard, depth - 1, false);
        if (b.toMove == Colour.WHITE && value > max) {
          max = value;
        } else if (b.toMove == Colour.BLACK && value < min) {
          min = value;
        }
        if (firstCall) {
          Map.Entry<String, Double> newEntry = new AbstractMap.SimpleEntry<String, Double>
              (Board.startAndEndToString(p.getSquare(), sq), value);
          if (moveValues.size() < MAXIMUM_MOVES) {
            moveValues.add(newEntry);
          } else if ((b.toMove == Colour.WHITE && value > moveValues.last().getValue()) ||
              (b.toMove == Colour.BLACK && value < moveValues.last().getValue())) {
            moveValues.add(newEntry);
            moveValues.remove(moveValues.last());
          }
        }
      }
    }
    return (b.toMove == Colour.WHITE) ? max : min;
  }

  // TODO implement
  private static double evaluate(Board b)
  {
    return materialCount(b.whitePieces) - materialCount(b.blackPieces);
  }

  private static int materialCount(ArrayList<Piece> pieces)
  {
    int sum = 0;

    for (Piece p : pieces) {
      sum += pieceValues.get(p.getPieceType());
    }

    return sum;
  }

  public static void testMinimax(Board b, int d)
  {
    System.out.println("minimax is: " + minimax(b, d));
    System.out.println("moveValues is " + moveValues.toString());
  }

  public static void testEvaluate(Board b)
  {
    System.out.println("evaluation is " + evaluate(b));
  }

}
