/* Sepid Ebrahimi, CS 112, Final Project*/

public class Board {
    private ChessPiece[][] chess_board;

    public Board() {
        chess_board = new ChessPiece[8][8];
    }


    public String toString() {
        String board = "";
        for (int i = 0; i < 8; i++) {
            board = board + "\n";
            board = board + (7-i);
            for (int j = 0; j < 8; j++) {
                board = board + "\t  " + chess_board[7-i][j];
            }
            board = board + "\n";
        }
        board = board + "\n";
        board = board + "*" + "\t  " + " 0" + "\t  " + " 1" + "\t  " + " 2" + "\t  " + " 3" + "\t  " + " 4" + "\t  " + " 5" + "\t  " + " 6" + "\t  " + " 7";
        return board;
    }


    public void addPiece(ChessPiece piece){
        chess_board[piece.X][piece.Y] = piece;
    }


    public ChessPiece getPiece(int y,int x) throws OutOfBoardException{
        if ((x > 7) || (y > 7) || (y < 0) || ( x < 0)){ //the selected piece's origins are out of bound
            OutOfBoardException outOfBound =  new OutOfBoardException("Out Of Bound!");
            throw(outOfBound);
        }
        return chess_board[x][y];
    }

    public boolean transition (int y1, int x1, int y2,int x2) throws IllegalChessMoveException, PathwayException, OutOfBoardException{ // move the piece from A to B

        if ((x2 > 7) || (y2 > 7) || (y2 < 0) || ( x2 < 0)){ // the target spot is out of bound
            OutOfBoardException outOfBound =  new OutOfBoardException("Out Of Bound!");
            throw(outOfBound);
        }

        if (chess_board[x1][y1].toString() == "---") { // if there is no piece in that spot
            System.out.println("Empty Space!");
            IllegalChessMoveException move = new IllegalChessMoveException("You can't move an empty space!!");
            throw(move);

        }

        if (chess_board[x1][y1].move(x2, y2, this.chess_board)) {
            chess_board[x2][y2] = chess_board[x1][y1];
            chess_board[x1][y1] = new FreeSpace(x1,y1);
            return true;
        }

        return false;
    }




}