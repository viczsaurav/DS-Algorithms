package cci;

import java.util.Arrays;

public class EditDistance {

	/**
	 *
	 * Edit matrix will be like
	 *
	 * 	   ""	O R I G S T R
	 * 	"" 0  1 2 3 4 5 6 7
	 * 	F  1
	 * 	I  2
	 * 	N  3
	 * 	A  4
	 * 	L  5
	 * 	S  6
	 * 	T  7
	 * 	R  8
	 *
	 * @param origStr
	 * @param finalStr
	 * @return
	 */
	public static int findMinEditDistance(String origStr, String finalStr){
		int [][] editMatrix = new int[origStr.length()+1][finalStr.length()+1];


		for (int i=0;i<editMatrix.length;i++){				// editMatrix.length gives to length x-axis in editMatrix[X][Y]
			editMatrix[i][0] = i;
		}
		for (int j=0;j<editMatrix[0].length;j++){			// editMatrix[0].length gives to length y-axis in editMatrix[X][Y]
			editMatrix[0][j] = j;
		}

		for (int j=1;j<editMatrix[0].length;j++){
			for(int i=1;i<editMatrix.length;i++){

				// When When char[i] = char[j]

				if (origStr.charAt(i-1)==finalStr.charAt(j-1)){
					editMatrix[i][j] = editMatrix[i-1][j-1];
				}
				else {
					editMatrix[i][j] =  Math.min(editMatrix[i][j-1],
									Math.min(editMatrix[i-1][j-1], editMatrix[i-1][j])) + 1;
				}
			}
		}

		printActualEdits(editMatrix,origStr,finalStr);
		return editMatrix[editMatrix.length-1][editMatrix[0].length-1];
	}

	public static void printActualEdits(int editmatrix[][], String str1, String str2) {
		int i = editmatrix.length - 1;
		int j = editmatrix[0].length - 1;

		while(true) {
			if(i==0 || j==0){
				break;
			}

			if (str1.charAt(i-1) == str2.charAt(j-1)) {
				System.out.println("No change");
				i = i-1;
				j = j-1;
			}
			// 1 more than diagonal
			else if (editmatrix[i][j] == editmatrix[i-1][j-1] + 1){
				System.out.println("Edit {" + str2.charAt(j-1) + "} in ["+ str2 +"] to {" + str1.charAt(i-1) + "} in ["+ str1+ "]");
				i = i-1;
				j = j-1;
			}
			// example converting ab-> a
			else if (editmatrix[i][j] == editmatrix[i-1][j] + 1) {
				System.out.println("Delete in ["+ str1 + "]: {" + str1.charAt(i-1) + "}");
				i = i-1;
			}
			// example converting ab <- abc
			else if (editmatrix[i][j] == editmatrix[i][j-1] + 1){
				System.out.println("Delete in ["+ str2 + "]: {" + str2.charAt(j-1) + "}");
				j = j -1;
			}
			else {
				throw new IllegalArgumentException("Some wrong with given data");
			}

		}
	}

	public static void main(String[] args) {
		System.out.println(findMinEditDistance("originalStr", "FinalStr"));
	}
}
