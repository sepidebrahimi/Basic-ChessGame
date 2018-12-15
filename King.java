/* Sepid Ebrahimi, CS 112, Final Project*/
public class King extends ChessPiece {

    private String name;
    protected King(int X, int Y) throws OutOfBoardException
    {
        super(X,Y);
        this.name = "King";
    }
    public String getName(){
        return name;
    }

    public boolean move(int x, int y, ChessPiece[][] cp) throws IllegalChessMoveException {

        //if the king is moving vertically, horizontally or diagonally
        if(((Math.abs(x-X)==1&&Y==y)||(Math.abs(y-Y)==1&&X==x)||(Math.abs(y-Y)==1&&Math.abs(x-X)==1))){
            this.X = x;
            this.Y = y;
            return true;
        }

        IllegalChessMoveException illegal =  new IllegalChessMoveException("Invalid Board Position!");
        throw(illegal);
    }
    public String toString(){
        return "-K-";
    }

}
