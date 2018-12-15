/* Sepid Ebrahimi, CS 112, Final Project*/
public class Queen extends ChessPiece{

    private String name;
    protected Queen(int X,int Y) throws OutOfBoardException
    {
        super(X,Y);
        this.name = "Queen";
    }
    public String getName(){
        return name;
    }
    public boolean move(int x, int y, ChessPiece[][] cp) throws PathwayException
    {
        boolean rook = (X==x&&Y!=y)||(Y==y&&X!=x);
        boolean bishop = (Math.abs(X-x)==Math.abs(y-Y));

        if(rook == true){
            checkRookMoves(x,y,cp);
        }

        else if(bishop == true){
            checkBishopMoves(x,y,cp);
        }
        this.X = x;
        this.Y = y;
        return true;
    }

    public void checkRookMoves(int a,int b, ChessPiece[][] cp) throws PathwayException{
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



    public void checkBishopMoves(int a,int b, ChessPiece[][] cp) throws PathwayException{
        int x = a;
        int y = b;

        /*if direction is 0 it means that axis is not changing
         * if direction is 1, it means the piece is moving forward
         * if the direction is -1, it means the piece is moving backwards.*/
        int YDirection = 1;
        int XDirection = 1;
        int distance = Math.abs(x-X);

        if(x < X && y > Y){
            XDirection = -1;
            YDirection = 1;
        }
        if( x < X && y < Y){
            XDirection = -1;
            YDirection = -1;
        }
        if( x > X && y < Y){
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
        return "-Q-";
    }
}