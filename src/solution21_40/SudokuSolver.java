package solution21_40;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by yhj on 2017/12/13.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        boolean isSuccess = true;
        HashSet<Character>[][] mayNums =  new HashSet[board.length][board.length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                if(board[i][j] == '.'){
                    isSuccess = false;
                    mayNums[i][j] = new HashSet<Character>(Arrays.asList(new Character[]{'1','2','3','4','5','6','7','8','9'}));
                }
            }
        }

        while (!isSuccess){
            isSuccess = true;
            for(int i = 0;i<board.length;i++){
                for(int j = 0;j<board.length;j++){
                    if(board[i][j] == '.'){
                        int rowIndex = 3*i/3;
                        int colIndex = 3*j/3;
                        for(int k = 0;k<board.length;k++){
                            if(board[k][i] != '.'){
                                mayNums[i][j].remove(board[k][i]);
                            }
                            if(board[i][k] != '.'){
                                mayNums[i][j].remove(board[i][k]);
                            }
                            if(board[rowIndex+k/3][colIndex+k%3] != '.'){
                                mayNums[i][j].remove(board[rowIndex+k/3][colIndex+k%3]);
                            }
                        }
                        if(mayNums[i][j].size() == 1){
                            board[i][j] = mayNums[i][j].iterator().next();
                        }else {
                            isSuccess = false;
                        }
                    }
                }
            }
        }

    }


}
