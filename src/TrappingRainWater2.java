import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWater2 {
	static class Cell{
		int x;
	    int y;
	    int height;
	    public Cell(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}
	}
    public static int trapRainWater(int[][] heightMap) {
        if(heightMap.length == 0){
        	return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(m * n, new Comparator<Cell>(){
        	public int compare(Cell c1, Cell c2){
        		return c1.height - c2.height;
        	}
        });
        for(int j = 0; j < n; j++){
        	visited[0][j] = true;
        	visited[m - 1][j] = true;
        	Cell cell1 = new Cell(0, j, heightMap[0][j]);
        	Cell cell2 = new Cell(m - 1, j, heightMap[m - 1][j]);
        	pq.offer(cell1);
        	pq.offer(cell2);
        }
        for(int i = 1; i < m - 1; i++){
        	visited[i][0] = true;
        	visited[i][n - 1] = true;
        	Cell cell1 = new Cell(i, 0, heightMap[i][0]);
        	Cell cell2 = new Cell(i, n - 1, heightMap[i][n - 1]);
        	pq.offer(cell1);
        	pq.offer(cell2);
        }
        int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int total = 0;
        while(!pq.isEmpty()){
        	Cell cell = pq.poll();
        	for(int[] dis : distance){
        		int x = cell.x + dis[0];
        		int y = cell.y + dis[1];
        		if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]){
        			visited[x][y] = true;
        			total += Math.max(0, cell.height - heightMap[x][y]);
        			pq.offer(new Cell(x, y, Math.max(heightMap[x][y], cell.height)));
        		}
        	}
        }
        return total;
    }
	public static void main(String[] args) {
		int [][] heightMap = {{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
		System.out.println(trapRainWater(heightMap));
	}
}


