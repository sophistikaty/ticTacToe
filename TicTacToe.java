import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    private enum Moves { X, O, EMPTY };
    private Moves[][] board = new Moves[3][3];
    private final List<String> alphaMap = new ArrayList <>(Arrays.asList("A","B","C","D","E","F","G","H","I"));
    private String playerMove = "";
    private Moves currentPlayer = Moves.X;
    Scanner input = new Scanner(System.in);

    TicTacToe (){
        // init with empty board
        for(int row = 0; row < board.length; row++){
            Arrays.fill(board[row],Moves.EMPTY);
        }
        ShowBoard(board);
        TakeTurn();
    }

    private void ShowBoard(Moves[][] board){
        int alphaCounter = 0;
        System.out.printf("%n  TIC-TAC-TOE %n  ------------ %n");
        for(int row = 0; row < board.length; row++){
            for (int cell = 0; cell < board[row].length; cell++) {
                System.out.printf(" | ");
                if(board[row][cell] == Moves.EMPTY){
                    System.out.print(alphaMap.get(alphaCounter));
                } else {
                    System.out.print(board[row][cell]);
                }
            alphaCounter++;
            }
            System.out.printf(" | %n  ------------ %n");
        }
    }

    private void UpdateBoard(String moveBox, Moves player ){
        int [] boardPosition = alphaToBoardPosition(moveBox);
        board[boardPosition[0]][boardPosition[1]] = player;
    }

    private void TakeTurn(){
        currentPlayer = currentPlayer == Moves.X ? Moves.O : Moves.X;
        System.out.printf("%n Player ");
        System.out.println(currentPlayer);
        System.out.println(" enter letter in the box where you'll make your move: ");
        playerMove = input.next();
        if(ValidateMove(playerMove)){
            UpdateBoard(playerMove, currentPlayer);
            ShowBoard(board);
            TakeTurn();
        }
    }

    private int[] alphaToBoardPosition(String alpha){
        int boxInt = alphaMap.indexOf(alpha);
        int rowInt = boxInt / 3;
        System.out.println(rowInt);

        int cellInt = boxInt % 3;
        int [] boardPosition = {rowInt,cellInt};
        return boardPosition;
    }

    private String boardPositionToAlpha(int[] boardPosition){
        return "A";
    }

    private boolean ValidateMove(String moveBox){
        System.out.println(alphaMap.contains(moveBox.toUpperCase()));
        return alphaMap.contains(moveBox.toUpperCase());
    }
}
