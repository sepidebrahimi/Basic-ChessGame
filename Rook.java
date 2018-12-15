/* Sepid Ebrahimi, CS 112, Final Project*/
public class Rook extends ChessPiece{
    private String name;
    protected Rook(int X, int Y) throws OutOfBoardException //changed it from private to protected so I can make a new piece in the driver
    {
        super(X,Y);
        this.name = "Rook";
    }

    public String getName(){
        return name;
    }

    public boolean move(int x, int y, ChessPiece[][] cp) throws IllegalChessMoveException, PathwayException{

        if((X != x && Y == y) || (X == x && Y != y)){
            isMoveLegal(x,y,cp);
            this.X = x;
            this.Y = y;
            return true;

        }

        else{
            IllegalChessMoveException illegal =  new IllegalChessMoveException("Invalid Board Position!");
            throw(illegal);
        }
    }

    public void isMoveLegal(int a, int b, ChessPiece[][] cp) throws PathwayException{
        int x = a;
        int y = b;

        /*if direction is 0 it means that axis is not changing
        * if direction is 1, it means the piece is moving forward
        * if the direction is -1, it means the piece is moving backwards.*/
        int YDirection = 1;
        int XDirection = 1;
        int distance = 0;

        if( x > X ){ // moving forward
            distance = Math.abs(x-X); // absolute value of distance between piece and target
            YDirection = 0;
            XDirection = 1;
        }
        else if( x < X ){ // moving backwards
            distance = Math.abs(X-x);
            YDirection = 0;
            XDirection = -1;
        }
        else if( y > Y ){ // moving left
            distance = Math.abs(y-Y);
            YDirection = 1;
            XDirection = 0;
        }
        else if( y < Y ){ // moving right
            distance = Math.abs(Y-y);
            YDirection = -1;
            XDirection = 0;
        }

        for (int i = 1; i < distance+1 ; i++){
            if (cp[X+i*XDirection][Y+i*YDirection].toString() != "---"){
                PathwayException path =  new PathwayException("There is a piece in your way");
                throw(path);
            }
        }

    }


    public String toString(){
        return "-r-";
    }
}