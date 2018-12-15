public class FreeSpace extends ChessPiece{
    //FreeSpace(){}
    private String name;
    public FreeSpace(int X, int Y) throws OutOfBoardException
    {
        super(X,Y);
        name = "Free Space";
    }
    public String getName(){
        return name;
    }
    public boolean move(int x, int y, ChessPiece[][] p)
    {
        return true;
    }
    public String toString(){
        return "---";
    }
}
