import java.util.ArrayList;
import java.util.List;

public class DiagnalTraverse {
	public static int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0){
            return new int[0];
        }
        int n = matrix[0].length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < m + n - 1; i++){
            res.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res.get(i + j).add(matrix[i][j]);
            }
        }
        int[] re = new int[m * n];
        int count = 0;
        for(int i = 0; i < m + n - 1; i++){
            if(i % 2 == 0){
                for(int j = res.get(i).size() - 1; j >= 0; j--){
                    re[count++] = res.get(i).get(j);
                }
            }else{
                for(int j = 0; j < res.get(i).size(); j++){
                    re[count++] = res.get(i).get(j);
                }
            }
        }
        return re;
    }
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[] find = findDiagonalOrder(matrix);
	}
}
