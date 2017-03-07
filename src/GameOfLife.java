
public class GameOfLife {
	public static void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                update(i, j, board);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] >>= 1;
            }
        }
    }
	public static void update(int i, int j, int[][] board){
		int left = Math.max(j - 1, 0);
        int right = Math.min(j + 1, board[0].length - 1);
        int up = Math.max(i - 1, 0);
        int down = Math.min(i + 1, board.length - 1);
        int lives = 0;
        for(int r = up; r <= down; r++){
            for(int c = left; c <= right; c++){
                if((board[r][c] & 1) == 1){
                    lives++;
                }
            }
        }
        if((board[i][j] & 1) == 1){
            lives--;
            if(lives < 2 || lives > 3){
                board[i][j] = 1;
            }else{
                board[i][j] = 3;
            }
        }else{
            if(lives == 3){
                board[i][j] = 2;
            }
        }
    }
	public static void main(String[] args) {
		int[][] board = {{1, 1}, {1, 0}};
		gameOfLife(board);
		System.out.println(board);
	}
}
/*
 * 1. fogot to use &, just directly judged with board[i][j] == 1
 * fogot to notice the number has been changed, only the first bit remained unchanged
 * */
