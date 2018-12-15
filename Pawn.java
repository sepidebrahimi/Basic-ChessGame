/* Sepid Ebrahimi, CS 112, Final Project*/
public class Pawn extends ChessPiece {
    private String name;
    protected Pawn(int X, int Y) throws OutOfBoardException{ //changed it from private to protected so I can make a new piece in the driver
        super(X,Y);
        this.name = "Pawn";
    }

    public String getName(){
        return name;
    }

    public boolean move(int x, int y, ChessPiece[][] cp) throws IllegalChessMoveException,PathwayException {

        IllegalChessMoveException illegal = new IllegalChessMoveException("Illegal Pawn Move");
        if( X==1 ){ // if pawn is in row 1 ( making the first move)
            if ( ((Math.abs(X-x) == 1 )&&(Math.abs(Y-y) == 0)) || ((Math.abs(X-x) == 2 )&&(Math.abs(Y-y) == 0))) {
                if(((Math.abs(X-x) == 2 )&&(Math.abs(Y-y) == 0))){
                    if(cp[X+1][Y].toString() == "---"){ // check if there is any piece in the way
                        this.X = x;
                        this.Y = y;
                        return true;
                    }
                    else{
                        PathwayException path = new PathwayException("There is a piece in the way");
                        throw(path);
                    }
                }
                this.X = x;
                this.Y = y;
                return true;
            }
            else{
                throw (illegal);
            }
        }

        if ( (Math.abs(X-x) == 1 )&&(Math.abs(Y-y) == 0)) {
            this.X = x;
            this.Y = y;
            return true;
        }

            throw (illegal);

}

    public String toString(){
        return "-p-";
    }
}