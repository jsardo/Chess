/**
 * Created by johnsardo on 2016-04-15.
 */
public class Board
{
    private static Piece[] board = new Piece[64];

    public static Piece getSquare(int square)
    {
        if (square >= 0 && square < 64) {
            return board[square];
        }
        else { // TODO: make this legit
            System.out.println("error: trying to access an invalid board location");
            return null;
        }
    }

    public static void setSquare(int square, Piece p)
    {

    }

}
