package solution61_80;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 22:40 2019/2/27
 * @Modified By:
 **/
public class WordSearch {
    private int m,n;
    boolean[][] isWatch;
    public boolean exist(char[][] board, String word) {
        if (board == null){
            return word==null;
        }
        if (board.length == 0 || word.length() == 0){
            return false;
        }
        m = board.length;
        n= board[0].length;
        isWatch = new boolean[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0; j< n;j++){
                isWatch[i][j] = false;
            }
        }
        for (int i = 0;i < m;i++){
            for (int j = 0; j< n;j++){
                if(traceBack(i, j, 0, word, board)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean traceBack(int x, int y, int deep, String word, char[][] board){
        if(deep == word.length()){
            return true;
        }
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return false;
        if(board[x][y] == word.charAt(deep) && !isWatch[x][y]){
            isWatch[x][y] = true;
            boolean tmp = traceBack(x+1, y, deep+1, word, board) || traceBack(x-1, y, deep+1, word, board) || traceBack(x, y+1, deep+1, word, board) || traceBack(x, y-1, deep+1, word, board);
            isWatch[x][y] = false;
            return tmp;
        }else {
            return false;
        }
    }



//    public boolean exist(char[][] board, String word) {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if(exist(board, i, j, word, 0)) return true;
//            }
//        }
//        return false;
//    }

    private boolean exist(char[][] board, int x, int y, String word, int start) {
        if(start >= word.length()) return true;
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (board[x][y] == word.charAt(start++)) {
            char c = board[x][y];
            board[x][y] = '#';
            boolean res = exist(board, x + 1, y, word, start) || exist(board, x - 1, y, word, start) ||
                    exist(board, x, y + 1, word, start) || exist(board, x, y - 1, word, start);
            board[x][y] = c;
            return res;
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] c = new char[2][2];
        c[0][0] ='A';
        c[0][1] ='B';
        c[1][0] ='S';
        c[1][1] ='F';
        System.out.print(new WordSearch().exist(c, "AB"));
    }
}
