package amazon;

import java.util.*;

public class SolveMazeDFS {
	/**
	 * {0, 0, 0, 0, 0, 0},
	 * {1, 1, 0, 0, 0, 0},
	 * {0, 1, 1, 0, 1, 1},
	 * {0, 0, 1, 0, 1, 0},
	 * {0, 0, 1, 1, 1, 0},
	 * {0, 0, 0, 0, 0, 0}
	 *
	 * This assumes that the walls of the maze have just 2 openings, 1 Starting point and another exit point
	 * and the starting point is provided.
	 * The exist point is to be searched and the path needs to be found.
	 *
	 * We follow DFS here and mark the visited nodes. After finding the exit point on the wall, we track back and add the
	 * directions[U, D, R, L] which lead to the exist.
	 * At the end we reverse the directions taken to simulate movement from start to end pint.
	 *
	 * E.g, in above example with starting point at x,y = 1,0 , we have just one exit (2,5)
	 * The directions to be followed are Start->End  => [R, D, R, D, D, R, R, U, U, R]
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
	private static int[][] visited;

	public static List<Character> solveMaze(int[][] maze, int x, int y){
		path = new ArrayList<>();
		visited = new int[maze.length][maze[0].length];

		if(maze.length==0)	return path;

		solveDfs(maze, x, y, true);
		Collections.reverse(path);	// Since we backtracked from exit to source
		return path;
	}

	private static boolean solveDfs(int[][] maze, int i, int j, boolean start){
		if (i<0 || i>= maze.length || j<0 || j>=maze[i].length || maze[i][j]==0 || visited[i][j]==1){
			return false;
		}

		if(!start && (i==0 || i==maze.length-1 || j==0 || j==maze[0].length-1) && maze[i][j]==1){
			maze[i][j]=0;		// To ensure single path
			return true;
		}
		visited[i][j]=1;

		if(solveDfs(maze, i-1, j, false)){
			path.add('U');		// If we go up from here we reach exit or path to exit
			return true;
		}
		if(solveDfs(maze, i+1, j, false)){
			path.add('D');	// If we go down from here we reach exit or path to exit
			return true;
		}
		if(solveDfs(maze, i, j-1, false)){
			path.add('L');	// If we go Left from here we reach exit or path to exit
			return true;
		}
		if(solveDfs(maze, i, j+1, false)){
			path.add('R');	// If we go right from here we reach exit or path to exit
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		int maze[][] = {{0, 0, 0, 0, 0, 0},
										{1, 1, 0, 0, 0, 0},
										{0, 1, 1, 0, 1, 1},
										{0, 0, 1, 0, 1, 0},
										{0, 0, 1, 1, 1, 0},
										{0, 0, 0, 0, 0, 0}
									};

		List<Character> finalPath = solveMaze(maze, 1,0);

		System.out.println("Expected: [R, D, R, D, D, R, R, U, U, R] \nresult:   "+finalPath.toString());

		int maze1[][] = {{0, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 0, 0},
						 {0, 1, 0, 0, 1, 1},
						 {0, 1, 0, 0, 1, 0},
						 {0, 1, 1, 1, 1, 0},
						 {0, 0, 0, 0, 0, 0}
		};

		List<Character> finalPath2 = solveMaze(maze1, 1,0);

		System.out.println("Expected: [R, D, D, D, R, R, R, U, U, R] \nresult:   "+finalPath2.toString());

	}
}
