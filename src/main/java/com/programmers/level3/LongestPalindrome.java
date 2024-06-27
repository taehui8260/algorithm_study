package com.programmers.level3;

/**
 * 가장 긴 팰린드룸
 */
public class LongestPalindrome {
    public int solution(String s) {
        int size = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=1; j<=size + 1; j++){
                if(i-j > 0 && i+j < s.length()){
                    if(s.charAt(i-j) != s.charAt(i-j)){
                        break;
                    }
                    if(j == size + 1){
                        size++;
                    }
                } else{
                    break;
                }
            }
        }
        return size * 2 + 1;
    }
}
