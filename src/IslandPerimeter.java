import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter {
	public static int islandPerimeter(int[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		int perimeter = 0;
		int[][] distance = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					q.offer(new int[] { i, j });
					grid[i][j] = -1;
					while (!q.isEmpty()) {
						int size = q.size();
						for (int n = 0; n < size; n++) {
							int[] parent = q.poll();
							for (int[] dis : distance) {
								int x = parent[0] + dis[0];
								int y = parent[1] + dis[1];
								if (x < 0 || x >= grid.length) {
									perimeter++;
								}
								if (y < 0 || y >= grid[0].length) {
									perimeter++;
								}
								if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
									if(grid[x][y] == -1){
										continue;
									}
									if (grid[x][y] == 0) {
										perimeter++;
									} else {
										q.offer(new int[] { x, y });
										grid[x][y] = -1;
									}
								}
							}
						}
					}
					return perimeter;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		//int[][] grid = {{1, 1}, {1, 1}};
		System.out.println(islandPerimeter(grid));
	}
}
