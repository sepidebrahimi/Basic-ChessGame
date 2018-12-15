/* Sepid Ebrahimi, CS 112, Final Project*/
import java.util.*;
import java.io.*;
public class ChessGame{
public static void main(String[] args) throws Exception {
    System.out.println("Reading a file");
    Scanner scan = new Scanner(new File("C:/Users/Sepi/Desktop/GitHub/Basic-ChessGame/input.txt")); //ENTER YOUR OWN PATH
    String line;
    String[] lineSegment;

    System.out.println("Welcome to my chess game :)");
    Board board = new Board();

    for (int i = 0; i < 8; i++) { // adding free spaces to the board
        for (int j = 0; j < 8; j++) {
            board.addPiece(new FreeSpace(i,j));
        }
    }
    System.out.println(board);
    while (scan.hasNextLine()) {
        line = scan.nextLine();
        lineSegment = line.split(" ");

        // adding all the pieces to the board
        if (lineSegment[0].contains("knight")){board.addPiece(new Knight(Integer.parseInt(lineSegment[1]),Integer.parseInt(lineSegment[2])));}
        if (lineSegment[0].contains("pawn")){board.addPiece(new Pawn(Integer.parseInt(lineSegment[1]),Integer.parseInt(lineSegment[2]))); }
        if (lineSegment[0].contains("rook")){board.addPiece(new Rook(Integer.parseInt(lineSegment[1]),Integer.parseInt(lineSegment[2]))); }
        if (lineSegment[0].contains("bishop")){board.addPiece(new Bishop(Integer.parseInt(lineSegment[1]),Integer.parseInt(lineSegment[2]))); }
        if (lineSegment[0].contains("king")){board.addPiece(new King(Integer.parseInt(lineSegment[1]),Integer.parseInt(lineSegment[2]))); }
        if (lineSegment[0].contains("queen")){board.addPiece(new Queen(Integer.parseInt(lineSegment[1]),Integer.parseInt(lineSegment[2]))); }
    }

    System.out.println(board);
    Scanner scanTwo = new Scanner(new File("C:/Users/Sepi/Desktop/GitHub/Basic-ChessGame/input.txt")); //ENTER YOUR OWN PATH

    //read the file for moves
    while (scanTwo.hasNextLine()) {
        line = scanTwo.nextLine();
        lineSegment = line.split(" ");
        if (lineSegment[0].contains("move")) {
            System.out.print(board.getPiece(Integer.parseInt(lineSegment[1]),Integer.parseInt(lineSegment[2])).getName() + ": (" + Integer.parseInt(lineSegment[1]) + "," + Integer.parseInt(lineSegment[2]) + ")");
            System.out.println(" (" + Integer.parseInt(lineSegment[3]) + "," + Integer.parseInt(lineSegment[4]) + ")");
            try {
                if (board.getPiece(Integer.parseInt(lineSegment[3]), Integer.parseInt(lineSegment[4])).toString() != "---")
                {
                    System.out.print("Targeted spot is occupied!");
                    System.out.print("(" + Integer.parseInt(lineSegment[1]) + "," + Integer.parseInt(lineSegment[2]) + ")");
                    System.out.println(" (" + Integer.parseInt(lineSegment[3]) + "," + Integer.parseInt(lineSegment[4]) + ")");
                } else {
                    try {
                        board.transition(Integer.parseInt(lineSegment[1]), Integer.parseInt(lineSegment[2]), Integer.parseInt(lineSegment[3]), Integer.parseInt(lineSegment[4]));
                        System.out.print("moved! " + "(" + Integer.parseInt(lineSegment[1]) + "," + Integer.parseInt(lineSegment[2]) + ")");
                        System.out.println(" (" + Integer.parseInt(lineSegment[3]) + "," + Integer.parseInt(lineSegment[4]) + ")");
                    } catch (IllegalChessMoveException illegal) {
                        System.out.println("Invalid Board Position!" + "(" + lineSegment[1] + "," + lineSegment[2] + ") " + "(" + lineSegment[3] + "," + lineSegment[4] + ")");
                    } catch (PathwayException path) {
                        System.out.println("There is another chess piece in your way!");
                    }
                }
            } catch (OutOfBoardException outOfBound) {
                System.out.println("! Out Of Board !");
            }
            System.out.println(board);
        }
    }
    scan.close();
    }
}


