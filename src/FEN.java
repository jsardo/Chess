/**
 * Created by johnsardo on 2016-04-15.
 */
// rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR
public class FEN
{
    public static void initBoardFromFEN(String fen)
    {
        if (fen == null || fen.length() != 64) {
            System.out.println("error: invalid FEN string");
        }

        int counter = 0;
        char current, lowerCurrent;
        Colour c;

        while (counter < 64) {
            current = fen.charAt(counter);
            lowerCurrent = Character.toLowerCase(current);
            c = (current == lowerCurrent) ? Colour.WHITE : Colour.BLACK;

            switch (lowerCurrent) {
                case 'r':
                    Board.setSquare(current, new Rook(current, c));
                    break;
                case 'n':
                    Board.setSquare(current, new Knight(current, c));
                    break;
                case 'b':
                    Board.setSquare(current, new Bishop(current, c));
                    break;
                case 'q':
                    Board.setSquare(current, new Queen(current, c));
                    break;
                case 'k':
                    Board.setSquare(current, new King(current, c));
                    break;
                default:
                    // do something
            }
            counter++;
        }

    }
}
