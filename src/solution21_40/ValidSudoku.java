package solution21_40;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yhj on 2017/12/13.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i<board.length;i++){
            if(!isValid(board[i])){
                return false;
            }
        }
        for(int i = 0;i<board.length;i++){
            char[] cells = new char[board.length];
            for(int  j = 0;j<board.length;j++){
                cells[j] = board[j][i];
            }
            if(!isValid(cells)){
                return false;
            }
        }
        for(int i = 0;i<board.length;i+=3){
            for(int j = 0;j<board.length;j+=3){
                char[] cells = new char[board.length];
                for(int a = 0;a<3;a++){
                    for(int b = 0;b<3;b++){
                        cells[a*3+b] = board[i+a][j+b];
                    }
                }
                if(!isValid(cells)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[] cells){
        HashSet<Character> set = new HashSet<>();
        for(int i =0;i<cells.length;i++){
            if(cells[i] != '.'){
                if(set.contains(cells[i])){
                    return false;
                }else {
                    set.add(cells[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.print(validSudoku.isValidSudoku(new char[][]{
                {'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}}));
    }
}
