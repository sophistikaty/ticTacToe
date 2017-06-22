public class TicTacToe {

    private enum play { X, O, EMPTY };
    private play[][] board = new play[3][3];

    TicTacToe (){

        System.out.println(play.EMPTY);

        for(int row = 0; row < board.length; row++){
            for (int cell = 0; cell < board[row].length; cell++) {
                board[row][cell] = play.EMPTY;
                System.out.println(board[row][cell]);
            }
        }
    }
}