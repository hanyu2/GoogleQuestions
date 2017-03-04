
public class NumOfIsland {
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int num = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    num++;
                    traverse(grid, i, j);
                }
            }
        }
        return num;
    }
	public void traverse(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        traverse(grid, i + 1, j);
        traverse(grid, i - 1, j);
        traverse(grid, i, j + 1);
        traverse(grid, i, j - 1);
    }
	public int numIslands2(char[][] grid) {
		if(grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(m, n, grid);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    int p = i * n + j;
                    if(i > 0 && grid[i - 1][j] == '1'){
                        uf.union(p, p - n);
                    }
                    if(i < m - 1 && grid[i + 1][j] == '1'){
                        uf.union(p, p + n);
                    }
                    if(j > 0 && grid[i][j - 1] == '1'){
                        uf.union(p, p - 1);
                    }
                    if(j < n - 1 && grid[i][j + 1] == '1'){
                        uf.union(p, p + 1);
                    }
                }
            }
        }
        return uf.count;
    }
}

class UF{
    int count;
    int[] id = null;
    public UF(int m, int n, char[][] grid){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                }
            }
        }
        id = new int[m * n];
        for(int i = 0; i < m * n; i++){
            id[i] = i;
        }
    }
    public int find(int p){
        while(p != id[p]){
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }else{
            id[p] = qRoot;
            count--;
        }
    }
}
