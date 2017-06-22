import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    private enum Moves { X, O, EMPTY };
    private Moves[][] board = new Moves[3][3];
    private final List<String> alphaMap = new ArrayList <>(Arrays.asList("A","B","C","D","E","F","G","H","I"));
    private Moves currentPlayer = Moves.X;
    Scanner input = new Scanner(System.in);

    TicTacToe (){
        // init with empty board
        for(int row = 0; row < board.length; row++){
            Arrays.fill(board[row],Moves.EMPTY);
        }
        ShowBoard(board);
        NextTurn();
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

    private void UpdateBoard(int[] boardPosition, Moves player ){
        board[boardPosition[0]][boardPosition[1]] = player;
        ShowBoard(board);
    }

    private void HelpInvalidInput(String playerChoice){
        System.out.printf("%n Player ");
        System.out.print(currentPlayer);
        System.out.printf("%n %s isn't an open box on the board. %n", playerChoice);
        ShowBoard(board);
        System.out.printf("%n Enter a letter A-I that is still open: ");
        MakeMove(input.next());
    }

    private void NextTurn(){
        if (!isGameOver()){
            currentPlayer = currentPlayer == Moves.X ? Moves.O : Moves.X;
            System.out.printf("%n Player ");
            System.out.println(currentPlayer);
            System.out.println(" enter letter in the box where you'll make your move: ");
            MakeMove(input.next());
            return;
        }
        GameOver();
    }
    private void MakeMove(String playerChoice){
        playerChoice = playerChoice.toUpperCase();
        if(isValidBox(playerChoice)){
            int[] boardPosition = alphaToBoardPosition(playerChoice);
            if (isBoxEmpty(boardPosition)){
                UpdateBoard(boardPosition, currentPlayer);
                NextTurn();
            } else {
                HelpInvalidInput(playerChoice);
            }
        } else {
            HelpInvalidInput(playerChoice);
        }
    }

    private int[] alphaToBoardPosition(String alpha){
        int boxInt = alphaMap.indexOf(alpha);
//        System.out.printf("%n alpha %s ", alpha);
//        System.out.printf("%n box %d ", boxInt);
//        System.out.printf("%n row %d ", boxInt / 3);
//        System.out.printf("%n cell %d ", boxInt % 3);
        int[] boardPosition = { boxInt / 3, boxInt % 3 };
        return boardPosition;
    }

    private boolean isValidBox(String playerChoice){
        return alphaMap.contains(playerChoice);
    }

    private boolean isBoxEmpty(int[] boardPosition){
        return board[boardPosition[0]][boardPosition[1]] == Moves.EMPTY;
    }

    private boolean isGameOver(){
        return false;
    }

    private void GameOver(){
        System.out.printf("%n Congratulations Player ");
        System.out.print(currentPlayer);
        System.out.printf("! You win. %n");
    }
}
