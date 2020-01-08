package interviewCake;

public class ReverseWords {

	public static void reverseWords(char[] message) {

		//Step1: full in-place reverse (Only if multiple words present)
		reverseCharacters(message,0,message.length-1);
		//Step 2: Reverse only the individual words:

		int leftIndex=0;

		for(int i=0;i<=message.length;i++){
			if(i== message.length|| message[i]==' '){
				reverseCharacters(message,leftIndex, i-1);
				leftIndex=i+1;
			}
		}
	}

	public static void reverseCharacters(
					char[] message,
					int leftIndex,
					int rightIndex){

		while(leftIndex<rightIndex){
			char temp = message[leftIndex];
			message[leftIndex] =message[rightIndex];
			message[rightIndex]= temp;
			leftIndex++;rightIndex--;
		}
	}



}
