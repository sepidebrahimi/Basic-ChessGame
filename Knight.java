/* Sepid Ebrahimi, CS 112, Final Project*/
public class Knight extends ChessPiece {
    private String name;
    protected Knight(int X, int Y) throws OutOfBoardException //changed it from private to protected so I can make a new piece in the driver
    {
        super(X,Y);
        this.name = "Knight";
    }

    public String getName(){
        return name;
    }

    public boolean move(int x, int y, ChessPiece[][] cp) throws IllegalChessMoveException, PathwayException, OutOfBoardException
    {
        //if the total number of moves is not 3 AND if the product of X-difference and Y-difference is not 2
        if(((Math.abs(x-X)+Math.abs(y-Y))!=3)&&((Math.abs(x-X)*Math.abs(y-Y))!=2)){
            IllegalChessMoveException illegal =  new IllegalChessMoveException("Invalid Board Position!");
            throw(illegal);
        }

        this.X = x;
        this.Y = y;
        return true;

    }

    public String toString(){
        return "-h-";
    }
}
