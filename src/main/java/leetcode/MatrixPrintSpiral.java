package leetcode;

class MatrixPrintSpiral {
	// Function print matrix in spiral form
	static void spiralPrintIterative(int m, int n, int arr[][])
	{
		int i, k=0,l=0;
		/**
		 * k = row lower bound, m = natural upper bound
		 * l= column lower bound, n = natural upper bound
		 */

		while(k<m && l< n ){

			// Print row left to right(iterate column wise) => row fixed
			for(i=l;i<n; i++){
				System.out.print(arr[k][i] + " ");
			}
			k++;	// increment row

			// Print column top to bottom(iterate row wise) => column fixed
			for(i=k; i<m;i++){
				System.out.print(arr[i][n-1] + " ");
			}
			n--;

			// Print row right to left(iterate column wise) => row fixed
			if(k<m){
				for(i=n; i>l;i--){
					System.out.print(arr[m-1][i-1] + " ");
				}
				m--;
			}

			// Print column bottom to top(iterate row wise) => column fixed
			if(l<n){
				for (i=m;i>k;i--){
					System.out.print(arr[i-1][l] + " ");
				}
				l++;
			}
		}
	}

	// driver program
	public static void main(String[] args)
	{
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 2, 3, 4, 5, 6 },
						{ 7, 8, 9, 10, 11, 12 },
						{ 13, 14, 15, 16, 17, 18 } };

		System.out.println("Expected: \n1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11");
		System.out.println("Result  :");
		spiralPrintIterative(R, C, a);
	}
}

// Contributed by Pramod Kumar

