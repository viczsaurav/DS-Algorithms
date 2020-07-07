package facebook;

public class InterviewToeplitzMatrixFB {
	/**
	 * https://de.wikipedia.org/wiki/Toeplitz-Matrix
	 *
	 * Write a program to determine if a given matrix is a Toeplitz-Matrix
	 * i.e all parallel diagonals to the principal diagonal contains same elements/values
	 *
	 * E.g
	 *
	 * 1 2 3 4
	 * 5 1 2 3
	 * 6 5 1 2
	 * 7 6 5 1
	 *
	 * output:
	 *  true
	 *
	 *  input:
	 * 1 2 3 4
	 * 5 1 2 -1
	 * 6 5 1 2
	 * 7 6 5 1
	 *
	 * output:
	 *  false
	 *
	 */

	public static boolean isToeplitzMatrix(int[][] grid){

		if(grid.length==0)  return true;
		if (grid.length==1 || grid[0].length==1) return true;

		int i=0, j=i;
		while(i<grid.length && j<grid[0].length-1){
			if (grid[i+1][j+1]!=grid[i][j])  return false;
			i++; j++;
		}

		while (j<grid[0].length){
			j=++i;
			while(i<grid.length && j<grid[0].length-1){
				if (grid[i][j+1]!=grid[i][j])  return false;
			}
		}

		j=0;
		i=j;

		while (j<grid[0].length){
			i=++j;
			while(i<grid.length-1 && j<grid[0].length){
				if (grid[i+1][j]!=grid[i][j])  return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		int[][] grid1 = { {1, 2, 3, 4},
											{5, 1, 2, 3},
											{6, 5, 1, 2},
											{7, 6, 5, 1}};

		int[][] grid2 = { {1, 2, 3, 4},
											{5, 1, 2, -1},
											{6, 5, 1, 2},
											{7, 6, 5, 1}};

		System.out.println("Grid1 => expected: [true], actual: "+ isToeplitzMatrix(grid1));
		System.out.println("Grid2 => expected: [false], actual: "+ isToeplitzMatrix(grid2));


	}
}
