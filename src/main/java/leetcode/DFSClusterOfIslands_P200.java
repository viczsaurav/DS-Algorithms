package leetcode;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 */
class DFSClusterOfIslands_P200 {

	public int numIslands(char[][] grid) {

		int count=0;

		for(int i=0; i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if (grid[i][j]=='1'){
					count +=1;
					callDfs(grid, i, j);
				}
			}// end j for
		} // end i for

		return count;

	} // end method

	private void callDfs(char[][] grid, int i, int j){
		if (i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0'){
			return;
		}
		grid[i][j] = '0';

		callDfs(grid, i, j-1); //left
		callDfs(grid, i-1, j); //up
		callDfs(grid, i, j+1); // right
		callDfs(grid, i+1, j); //down

	}
}
