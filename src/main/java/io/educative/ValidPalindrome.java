package io.educative;

import  java.util.*;

public class ValidPalindrome{
    public static boolean isPalindrome(String s) {

        if (s.length()==0)  return false;
        if (s.length()==1)  return true;

        for (int i=0, j=s.length()-1; i<j; i++, j--){
            if (s.charAt(i)==s.charAt(j))    continue;
            else    return false;
        }
        return true;
    }
}
