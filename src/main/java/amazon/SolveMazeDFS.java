package amazon;

import java.util.*;

public class SolveMazeDFS {
	/**
	 * {1, 0, 0, 0}
	 * {1, 1, 0, 0}
	 * {0, 1, 0, 0}
	 * {0, 1, 1, 1}
	 *
	 */

	/**
	 *
	 * @param maze
	 * @param x = starting position row index
	 * @param y= starting position column index
	 * @return
	 */

	private static List<Character> path;

	public static List<Character> solveMaze(int[][] maze, int x, int y){
		path = new ArrayList<>();

		if(maze.length==0)	return path;

		solveDfs(maze, x, y, true);
		Collections.reverse(path);	// Since we backtracked from exit to source
		return path;
	}

	private static boolean solveDfs(int[][] maze, int i, int j, boolean start){
		if (i<0 || i>= maze.length || j<0 || j>=maze[0].length || maze[i][j]==0){
			return false;
		}
		else if(!start && (i==0 || i==maze.length-1 || j==0 || j==maze[0].length-1) && maze[i][j]==1){
			maze[i][j]=0;		// To ensure single path
			return true;
	}
		maze[i][j] =0;
		if(solveDfs(maze, i-1, j, false)){
			path.add('U');		// If we go up from here we reach exit or path to exit
		}
		if(solveDfs(maze, i+1, j, false)){
			path.add('D');	// If we go down from here we reach exit or path to exit
		}
		if(solveDfs(maze, i, j-1, false)){
			path.add('L');	// If we go up from here we reach exit or path to exit
		}
		if(solveDfs(maze, i, j+1, false)){
			path.add('R');	// If we go up from here we reach exit or path to exit
		}
		return false;
	}

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 },
						{ 1, 1, 0, 1 },
						{ 0, 1, 0, 0 },
						{ 1, 1, 1, 1 } };

		List<Character> finalPath = solveMaze(maze, 0,0);

		System.out.println(finalPath.toString());

	}
}
