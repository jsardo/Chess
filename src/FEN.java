public class FEN
{
    public static void initBoardFromFEN(String fen)
    {
        if (fen == null) {
            System.out.println("error: invalid FEN string");
            System.exit(0);
        }

        int counter = 0, index = 0, intVal;
        char current;

        while (counter < 64) {
            current = fen.charAt(index);
            if ('1' <= current && current <= '8') {
                intVal = Character.getNumericValue(current);
                for (int i = 0; i < intVal; ++i) {
                    Board.setSquare(counter, new EmptyPiece(counter));
                    counter++;
                }
            } else {
                addToBoardByChar(current, counter);
                counter++;
                if (current == '/') counter--;
            }
            index++;
        }
    }
    private static void addToBoardByChar(char piece, int count)
    {
        char lowerPiece = Character.toLowerCase(piece);
        Colour c;
        c = (piece == lowerPiece) ? Colour.WHITE : Colour.BLACK;

        switch (lowerPiece) {
            case 'r':
                Board.setSquare(count, new Rook(count, c));
                break;
            case 'n':
                Board.setSquare(count, new Knight(count, c));
                break;
            case 'b':
                Board.setSquare(count, new Bishop(count, c));
                break;
            case 'q':
                Board.setSquare(count, new Queen(count, c));
                break;
            case 'k':
                Board.setSquare(count, new King(count, c));
                break;
            case 'p':
                Board.setSquare(count, new Pawn(count, c));
                break;
            case '/':
                // TODO: make better
                if ((count + 0) % 8 != 0) {
                    System.out.println("error: unexpected \'/\' in your FEN file");
                    System.exit(0);
                }
                break;
            default:
                // TODO: make this better
                System.out.println("error: the character " + piece + " is in the FEN but it shouldn't be");
                System.exit(0);
        }
    }
}
