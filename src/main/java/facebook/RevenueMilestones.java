package facebook;

class RevenueMilestones {

 /**
  Time : KLog(N) Space :  [N]


	https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=192049171861831

	Revenue Milestones
	We keep track of the revenue Facebook makes every day, and we want to know on what days Facebook hits certain revenue milestones. Given an array of the revenue on each day, and an array of milestones Facebook wants to reach, return an array containing the days on which Facebook reached every milestone.
	Signature : int[] getMilestoneDays(int[] revenues, int[] milestones)
	Input : revenues is a length-N array representing how much revenue FB made on each day (from day 1 to day N).
					milestones is a length-K array of total revenue milestones.
	Output: Return a length-K array where K_i is the day on which FB first had milestones[i] total revenue.
 */


	int binarySearchRevenue(int[] revenue, int milestone){
		int i=0, j= revenue.length-1;
		int mid=0;
		while(i<=j){
			mid = (i+j)/2;
			if (revenue[mid]== milestone)	return mid+1;
			else if ((revenue[mid]< milestone) && (milestone<revenue[mid+1])){
				return mid+1+1;
			}
			else if (revenue[mid]> milestone) j=mid-1;
			else i=mid+1;
		}
		return mid+1;
	}


	int[] getMilestoneDays(int[] revenues, int[] milestones) {
		int[] rollingRevenue = new int[revenues.length];
		int[] output = new int[milestones.length];

		rollingRevenue[0] = revenues[0];
		for(int i=1; i<rollingRevenue.length;i++){
			rollingRevenue[i]= rollingRevenue[i-1]+ revenues[i];
		}

		for (int i=0; i<milestones.length;i++){
			output[i] = binarySearchRevenue(rollingRevenue, milestones[i]);
		}

		return output;
	}


	int test_case_number = 1;
	void check(int[] expected, int[] output) {
		int expected_size = expected.length;
		int output_size = output.length;
		boolean result = true;
		if (expected_size != output_size) {
			result = false;
		}
		for (int i = 0; i < Math.min(expected_size, output_size); i++) {
			result &= (output[i] == expected[i]);
		}
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		}
		else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printIntegerArray(expected);
			System.out.print(" Your output: ");
			printIntegerArray(output);
			System.out.println();
		}
		test_case_number++;
	}
	void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for(int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}
	public void run() {
		int revenues_1[] = {100, 200, 300, 400, 500};
		int milestones_1[] = {300, 800, 1000, 1400};
		int expected_1[] = {2, 4, 4, 5};
		int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
		check(expected_1, output_1);

		int revenues_2[] = {700, 800, 600, 400, 600, 700};
		int milestones_2[] = {3100, 2200, 800, 2100, 1000};
		int expected_2[] = {5, 4, 2, 3, 2};
		int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new RevenueMilestones().run();
	}
}