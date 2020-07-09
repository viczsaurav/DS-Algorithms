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

		if	(grid.length==0)  return true;

		/*
			Checking 2 rows a a time moving from left to right
		 */
		for(int i=0; i< grid.length-1; i++){
			for(int j=0; j< grid[0].length-1;j++){
				if (grid[i][j]!=grid[i+1][j+1])  return false;
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

		int[][] grid3 = { {1, 2, 3, 4}};

		System.out.println("Grid1 => expected: [true], actual: "+ isToeplitzMatrix(grid1));
		System.out.println("Grid2 => expected: [false], actual: "+ isToeplitzMatrix(grid2));
		System.out.println("Grid2 => expected: [true], actual: "+ isToeplitzMatrix(grid3));


	}
}
