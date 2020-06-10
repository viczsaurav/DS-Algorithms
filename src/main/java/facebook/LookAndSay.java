package facebook;

public class LookAndSay {

	/**
	 * 1
	 * 11
	 * 21
	 * 1211
	 * 111221
	 * 312211
	 * 13112221
	 * 1113213211
	 * 31131211131221
	 * 13211311123113112211
	 *
	 *
	 */

	public static void main(String[] args) {
		lookAndSaySeq(5, 6);
	}
	public static void lookAndSaySeq(int length, int val){
		StringBuffer buffer =  new StringBuffer();
		System.out.println(val);
		if (val/10==0){
			buffer.append(1).append(val%10);
			System.out.println(buffer.toString());
		}

		while(length-->1){
			StringBuffer newBuffer =  new StringBuffer();
			char[] valArray = buffer.toString().toCharArray();
			char prev=valArray[0];
			int count=1;
			for(int i=1;i<valArray.length;i++){
				char curr = valArray[i];
				if(curr==prev){
					count++;
				}
				else {
					newBuffer.append(count).append(prev);
					prev=curr;
					count=1;
				}
			}
			newBuffer.append(count).append(prev);
			System.out.println(newBuffer.toString());
			buffer= newBuffer;
		}
	}
}
