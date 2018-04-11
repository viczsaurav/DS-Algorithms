
public class MinNumHandPlayed {

	public static void main(String[] args) {
		System.out.println("Expected: 7, "+ solution(8, 0));
		System.out.println("Expected: 6, "+solution(18, 2));
		System.out.println("Expected: 4, "+solution(10, 10));
		System.out.println("Expected: 5, "+solution(14, 2));
		System.out.println("Expected: 2, "+solution(4, 2));
		System.out.println("Expected: 4, "+solution(7, 2));

	}
	
	public static int solution(int N, int K) {
		
		int numHands=0;
		
		if (N==1)	return 0;
		if (K==0)	return N-1;
		
		while (N>1) {
			if (N%2==0 && K>0) {
				N=N/2;
				numHands++;
				K--;
			}
			else if	(K==0){
				numHands+= (N-1);
				break;
			}
			else {
				N--;
				numHands++;
			}
		}
		return numHands;
    }
	
}
