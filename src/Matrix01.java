import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    res[i][j] = 0;
                }else{
                    res[i][j] = search(i, j, matrix);
                }
            }
        }
        return res;
    }
    
    public int search(int i, int j, int[][] matrix){
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{i, j});
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            step++;
            for(int n = 0; n < size; n++){
                int[] node = q.poll();
                for(int[] dis : distance){
                    int x = node[0] + dis[0];
                    int y = node[1] + dis[1];
                    if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length){
                        continue;
                    }
                    q.offer(new int[]{x, y});
                    if(matrix[x][y] == 0){
                        return step;
                    }
                }  
            }
        }
        return step;
    }
    
}
