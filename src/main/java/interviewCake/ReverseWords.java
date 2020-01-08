package interviewCake;

/**
 * You're working on a secret team solving coded transmissions.
 *
 * Your team is scrambling to decipher a recent message, worried it's a plot to break into a major European National Cake Vault. The message has been mostly deciphered, but all the words are backward! Your colleagues have handed off the last step to you.
 *
 * Write a method reverseWords() that takes a message as an array of characters and reverses the order of the words in place. ↴
 *
 * Why an array of characters instead of a string?
 *
 * The goal of this question is to practice manipulating strings in place. Since we're modifying the message, we need a mutable ↴ type like an array, instead of Java's immutable strings.
 *
 * For example:
 *
 *   char[] message = { 'c', 'a', 'k', 'e', ' ',
 *                    'p', 'o', 'u', 'n', 'd', ' ',
 *                    's', 't', 'e', 'a', 'l' };
 *
 * reverseWords(message);
 *
 * System.out.println(message);
 * // prints: "steal pound cake"
 *
 * When writing your method, assume the message contains only letters and spaces, and all words are separated by one space.
 *
 */
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
