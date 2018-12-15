/* Sepid Ebrahimi, CS 112, Final Project*/
abstract public class ChessPiece {
    int X;
    int Y;

    ChessPiece(int Y, int X) throws OutOfBoardException {
        this.X = X;
        this.Y = Y;
    }

    abstract public boolean move(int x, int y, ChessPiece[][] p) throws IllegalChessMoveException, PathwayException, OutOfBoardException;
    abstract public String getName();


}