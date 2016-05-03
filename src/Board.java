import java.util.ArrayList;
import java.util.Collection;

/*
56 57 58 59 60 61 62 63
48 49 50 51 52 53 54 55
40 41 42 43 44 45 46 47
32 33 34 35 36 37 38 39
24 25 26 27 28 29 30 31
16 17 18 19 20 21 22 23
 8  9 10 11 12 13 14 15
 0  1  2  3  4  5  6  7
 */

public class Board
{
    private Piece[] board = new Piece[64];

    public ArrayList<Piece> whitePieces = new ArrayList<>();
    public ArrayList<Piece> blackPieces = new ArrayList<>();

    public Board(String fenString)
    {
        initBoardFromFEN(fenString);
    }

    public Board() { }

    public Piece getSquare(int square)
    {
        if (square >= 0 && square < 64) {
            return board[square];
        }
        else { // TODO: make this legit
            System.out.println("error: trying to access an invalid board location");
            System.exit(0);
            return null;
        }
    }

    public boolean isEmptySquare(int square)
    {
        return (isValid(square) && (getSquare(square).getPieceType() == PieceType.EMPTY));
    }


    public void setSquare(int s, Piece p)
    {
        Piece pieceAtSquare;
        if (isValid(s)) {
            pieceAtSquare = getSquare(s);
            if (pieceAtSquare != null && !isEmptySquare(s)) {
                if (pieceAtSquare.getColour() == Colour.WHITE) {
                    whitePieces.remove(pieceAtSquare);
                } else if (pieceAtSquare.getColour() == Colour.BLACK) {
                    blackPieces.remove(pieceAtSquare);
                }
            }
            board[s] = p;
            if (p.getColour() == Colour.WHITE) {
                whitePieces.add(p);
            } else if (p.getColour() == Colour.BLACK) {
                blackPieces.add(p);
            }
        } else {
            System.out.println("error: in setSquare(): invalid square");
            System.exit(0);
        }
    }

    /*
    move piece p to square s. remove p from its list white/black pieces. remove piece at endsquare from white/black
    piece list.
     */
    public void movePieceToSquare(Piece p, int s)
    {
        Piece pieceAtSquare;

        if (isValid(s)) {
            pieceAtSquare = getSquare(s);
            if (pieceAtSquare != null && !isEmptySquare(s)) {
                if (pieceAtSquare.getColour() == Colour.WHITE) {
                    whitePieces.remove(pieceAtSquare);
                } else if (pieceAtSquare.getColour() == Colour.BLACK) {
                    blackPieces.remove(pieceAtSquare);
                }
            }
            board[s] = p;
            board[p.getSquare()] = new EmptyPiece(p.getSquare());
            p.setSquare(s);
        } else {
            System.out.println("error: in addPiece(): invalid square");
            System.exit(0);
        }
    }

    /*
    return true if the square is nonempty or occupied by a piece of the opposite colour; false otherwise
     */
    public boolean pieceCanMove(int square, Colour c)
    {
        return isValid(square) && (isEmptySquare(square) || getSquare(square).getColour() != c);
    }

    public boolean positionIsInCheck(Colour c)
    {
        return (c == Colour.WHITE) ? kingIsAttackedBy(blackPieces) : kingIsAttackedBy(whitePieces);
    }

    private boolean kingIsAttackedBy(Collection<Piece> pieces)
    {
        for (Piece p : pieces) {
            for (int square : p.getPossibleSquares(this)) {
                if (getSquare(square).getPieceType() == PieceType.KING) {
                    return true;
                }
            }
        }
        return false;
    }

    // true if c is in checkmate; false otherwise
    public boolean inCheckmate(Colour c)
    {
        Piece king = getKing(c), newKing;
        ArrayList<Integer> squares = king.getPossibleSquares(this);
        Board newBoard;

        for (int sq : squares) {
            newBoard = copyBoard(this);
            newBoard.movePieceToSquare(newBoard.getKing(c), sq);
            newBoard.printBoard();
            if (!newBoard.positionIsInCheck(c))
                return false;
        }
        return true;
    }

    private Piece getKing(Colour c)
    {
        ArrayList<Piece> pieces = c == Colour.WHITE ? whitePieces : blackPieces;

        for (Piece p : pieces) {
            if (p.getPieceType() == PieceType.KING)
                return p;
        }
        System.out.println("error: no king in the list of pieces.");
        return null;
    }

    public Board copyBoard(Board board)
    {
        Board newBoard = new Board();
        Piece p;

        for (int i = 0; i < 64; ++i) {
            p = board.getSquare(i);
            newBoard.setSquare(i, p.copyPiece());
            if (p.getColour() == Colour.WHITE) {
                newBoard.whitePieces.add(p.copyPiece());
            } else if (p.getColour() == Colour.BLACK) {
                newBoard.blackPieces.add(p.copyPiece());
            }
        }
        return newBoard;
    }

    public static boolean isValid(int s) { return (0 <= s && s < 64); }

    public void printBoard()
    {
        System.out.println("    a   b   c   d   e   f   g   h");
        System.out.println("  |-------------------------------|");
        for (int i = 7; i >= 0; --i) {
            System.out.print(i+1);
            System.out.print(" |");
            for (int j = 0; j < 8; ++j) {
                System.out.print(" " + getSquare(i*8 + j).getAbbrev());
                System.out.print(" |");
            }
            System.out.println();
            System.out.println("  |-------------------------------|");
        }
        System.out.println("    a   b   c   d   e   f   g   h");
    }

    private void initBoardFromFEN(String fen)
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
                    setSquare(counter, new EmptyPiece(counter));
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
    private void addToBoardByChar(char piece, int count)
    {
        char lowerPiece = Character.toLowerCase(piece);
        Colour c;
        c = (piece == lowerPiece) ? Colour.WHITE : Colour.BLACK;

        switch (lowerPiece) {
            case 'r':
                setSquare(count, new Rook(count, c));
                break;
            case 'n':
                setSquare(count, new Knight(count, c));
                break;
            case 'b':
                setSquare(count, new Bishop(count, c));
                break;
            case 'q':
                setSquare(count, new Queen(count, c));
                break;
            case 'k':
                setSquare(count, new King(count, c));
                break;
            case 'p':
                setSquare(count, new Pawn(count, c));
                break;
            case '/':
                // TODO: make better
                if ((count) % 8 != 0) {
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
