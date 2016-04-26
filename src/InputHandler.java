import java.util.Scanner;

// wrapper for user input that also handles input validation

public class InputHandler
{
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private int startSquare, endSquare;

    public boolean readLine(String msg)
    {
        System.out.println(msg);
        input = scanner.nextLine();

        return inputIsValid();
    }

    public Piece getPieceFromInput()
    {
        return null;
    }

    private boolean inputIsValid()
    {
        if (input == null) {
            System.out.println("error: null string");
            System.exit(0);
        }
        if (input.length() != 4) {
            printErrorMsg();
            return false;
        }
        char startFile = Character.toLowerCase(input.charAt(0)), endFile = Character.toLowerCase(input.charAt(2)),
                startRank = input.charAt(1), endRank = input.charAt(3);

        if (('a' <= startFile && startFile <= 'h') && ('a' <= endFile && endFile <= 'h')
                && ('1' <= startRank && startRank <= '8') && ('1' <= endRank && endRank <= '8')
                && Board.isValid(startSquare) && Board.isValid(endSquare)) {
            return true;
        } else {
            printErrorMsg();
            return false;
        }
    }

    // TODO: compute startSquare and endSquare based on file and rank

    private void printErrorMsg()
    {
        System.out.println("invalid input! specify start and end square. eg: a4b5");
    }




}
