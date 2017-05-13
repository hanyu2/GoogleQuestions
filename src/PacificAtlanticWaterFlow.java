import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
	public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<int[]>();
        if(matrix.length == 0){
            return res;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[][] p = new boolean[r][c];
        boolean[][] a = new boolean[r][c];
        Queue<int[]> q = new LinkedList<int[]>();
        int[][] distance = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int j = 0; j < c; j++){
            p[0][j]  = true;
            int[] temp = {0, j};
            q.offer(temp);
        }
        for(int i = 1; i < r; i++){
            p[i][0]  = true;
            int[] temp = {i, 0};
            q.offer(temp);
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] parent = q.poll();
                for(int[] dis : distance){
                    int[] kid = {parent[0] + dis[0], parent[1] + dis[1]};
                    if(kid[0] >= 0 && kid[0] < r && kid[1] >= 0 && kid[1] < c){
                        if(!p[kid[0]][kid[1]] && matrix[kid[0]][kid[1]] >= matrix[parent[0]][parent[1]]){
                             q.offer(kid);
                             p[kid[0]][kid[1]] = true;
                        }
                    }
                }
            }
        }
        
        for(int j = 0; j < c; j++){
            a[r - 1][j]  = true;
            int[] temp = {r - 1, j};
            q.offer(temp);
        }
        for(int i = 0; i < r; i++){
            a[i][c - 1]  = true;
            int[] temp = {i, c - 1};
            q.offer(temp);
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] parent = q.poll();
                for(int[] dis : distance){
                    int[] kid = {parent[0] + dis[0], parent[1] + dis[1]};
                    if(kid[0] >= 0 && kid[0] < r && kid[1] >= 0 && kid[1] < c){
                        if(!a[kid[0]][kid[1]] && matrix[kid[0]][kid[1]] >= matrix[parent[0]][parent[1]]){
                             q.offer(kid);
                             a[kid[0]][kid[1]] = true;
                        }
                    }
                }
            }
        }
       
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(p[i][j] && a[i][j]){
                    int[] temp = {i, j};
                    res.add(temp);
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		//int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		int[][] matrix = {{1, 1}, {1, 1}, {1, 1}};
		pacificAtlantic(matrix);
	}

}
