package com.lth.algorithm.programmers.level2;

import static java.lang.Integer.parseInt;

public class MakeBigNum {
    static public String solution(String number, int k) {
        String answer = "";
        answer = findBiggerNum(number, k, number.length()-k);
        return answer;
    }
    static public String findBiggerNum(String number, int outCnt, int digit){
        int temp = 0;
        int tempIndex = 0;
        String result;

        if(outCnt == 0){
            return number;
        }
        if(digit == 0){
            return "";
        }
        for(int i=0; i<=number.length() - digit; i++){
            if(temp < parseInt(String.valueOf(number.charAt(i)))){
                tempIndex = i;
                temp = parseInt(String.valueOf(number.charAt(i)));
            }
            if(temp == 9)
                break;
        }

        result = temp + findBiggerNum(number.substring(tempIndex + 1), outCnt - tempIndex, --digit);
        return result;
    }
}