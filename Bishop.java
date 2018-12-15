/* Sepid Ebrahimi, CS 112, Final Project*/

public class Bishop extends ChessPiece{

    private String name;


    protected Bishop(int X, int Y) throws OutOfBoardException //changed it from private to protected so I can make a new piece in the driver
    {
        super(X,Y);
        this.name = "Bishop";
    }
    public String getName(){
        return name;
    }

    public boolean move(int x, int y, ChessPiece[][] cp) throws IllegalChessMoveException, PathwayException
    {

        if(Math.abs(x-X) != Math.abs(y-Y)){
            IllegalChessMoveException illegal =  new IllegalChessMoveException("Invalid Board Position!");
            throw(illegal);
        }

        isMoveLegal(x,y,cp);
        this.X = x;
        this.Y = y;
        return true;
    }


    public void isMoveLegal(int a, int b, ChessPiece[][] cp) throws IllegalChessMoveException, PathwayException{
        int x = a;
        int y = b;

        /*if direction is 0 it means that axis is not changing
         * if direction is 1, it means the piece is moving forward
         * if the direction is -1, it means the piece is moving backwards.*/
        int YDirection = 1;
        int XDirection = 1;
        int distance = Math.abs(x-X);

        if(x < X && y > Y){ //moving up-left
            XDirection = -1;
            YDirection = 1;
        }
        if( x < X && y < Y){ //moving down-left
            XDirection = -1;
            YDirection = -1;
        }
        if( x > X && y < Y){ //moving down-right
            XDirection = 1;
            YDirection = -1;
        }

        for(int i = 1 ; i < distance+1 ; i++){ // i should not be zero because then it checks the selected piece
            if(cp[X+i*XDirection][Y+i*YDirection].toString() != "---"){
                PathwayException path = new PathwayException("There is a piece in the way");
                throw(path);
            }
        }
    }


    public String toString(){
        return "-b-";
    }

}