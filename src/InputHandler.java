import java.util.Scanner;

// wrapper for user input that also handles input validation

public class InputHandler
{
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private char startRank, endRank, startFile, endFile;
    private int startSquare, endSquare;

    public boolean readLine(String msg)
    {
        System.out.println(msg);
        input = scanner.nextLine();

        return inputIsValid();
    }

    private boolean inputIsValid()
    {
        if (input == null) {
            System.out.println("error: null string in inputIsValid()");
            System.exit(0);
        }
        if (input.length() != 4) {
            printErrorMsg();
            return false;
        }
        startFile = Character.toLowerCase(input.charAt(0));
        endFile = Character.toLowerCase(input.charAt(2));
        startRank = input.charAt(1);
        endRank = input.charAt(3);
        startSquare = squareFromChars(startFile, startRank);
        endSquare = squareFromChars(endFile, endRank);

        if (('a' <= startFile && startFile <= 'h') && ('a' <= endFile && endFile <= 'h')
                && ('1' <= startRank && startRank <= '8') && ('1' <= endRank && endRank <= '8')
                && Board.isValid(startSquare) && Board.isValid(endSquare)) {
            return true;
        } else {
            printErrorMsg();
            return false;
        }
    }

    private int squareFromChars(char file, char rank)
    {
        return Character.getNumericValue(file) + 8*(Character.getNumericValue(rank)-1) - 10;
    }

    public Piece getStartPiece(Board board)
    {
        return board.getSquare(startSquare);
    }

    public Piece getEndPiece(Board board)
    {
        return board.getSquare(endSquare);
    }

    private void printErrorMsg()
    {
        System.out.println("invalid input! specify start and end square. eg: a4b5");
    }
}
