import java.util.Scanner;

public class TicTacToe {

    private enum moves { X, O, EMPTY };
    private moves[][] board = new moves[3][3];
    private final String[] alphaMap = {"A","B","C","D","E","F","G","H","I"};
    private String playerMove = "";
    Scanner input = new Scanner(System.in);

    TicTacToe (){
        // init with empty board
        for(int row = 0; row < board.length; row++){
            for (int cell = 0; cell < board[row].length; cell++) {
                board[row][cell] = moves.EMPTY;
            }
        }
        ShowBoard(board);
        System.out.print("Player X enter letter in the box where you'll make your move: ");
        playerMove = input.next();
        System.out.print("You chose ");
        System.out.println(playerMove);
    }

    public void ShowBoard(moves[][] board){
        int alphaCounter = 0;
        System.out.println("");
        System.out.println("  TIC-TAC-TOE");
        for(int row = 0; row < board.length; row++){
            System.out.println("  ------------");
            for (int cell = 0; cell < board[row].length; cell++) {
                System.out.printf(" | ");
                if(board[row][cell] == moves.EMPTY){
                    System.out.print(alphaMap[ alphaCounter ]);
                } else {
                    System.out.print(board[row][cell]);
                }
            alphaCounter++;
            }
            System.out.println(" |");
        }
        System.out.println("  ------------");
    }
}