
public class BracketsEqualLeftRight {

	public static void main(String[] args) {
		String a= "(())";
		String b= "(())))(";
		String c= "))";
		System.out.println("Expected: 2 ; Returned: "+solution(a));
		System.out.println("Expected: 4 ; Returned: "+solution(b));
		System.out.println("Expected: 2 ; Returned: "+solution(c));

	}
	
	public static int solution(String S) {
        String[] a = S.split("");
        int i=0;
        int j=0;
       
       for (String s: a){
           if (s.equalsIgnoreCase(")"))  {
        	   j++;
           }
       }
       System.out.println(i+","+j);
       for (int k=0;k<=a.length;k++){
           if (i==j)    return k;
           
           if (a[k].equalsIgnoreCase(")"))  j--;
           else if (a[k].equalsIgnoreCase("("))  i++;
       }
        return -1;
    }

}
