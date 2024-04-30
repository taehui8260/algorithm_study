package com.toss;

public class test_2 {
    public int solution(String s) {
        int maxValue = 0;
        String StringValue= "";
        for(int i=1; i<s.length()-1; i++) {
            if((s.charAt(i-1) == s.charAt(i)) && (s.charAt(i) == s.charAt(i+1))){
                if(maxValue < Character.getNumericValue(s.charAt(i))){
                    maxValue = Character.getNumericValue(s.charAt(i));

                    StringValue = String.valueOf(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i)));
                }
            }
        }
        if(StringValue.isEmpty()){
            return -1;
        }

        return Integer.parseInt(StringValue);
    }
}
