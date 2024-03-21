package com.programmers.level2;

import static java.lang.Integer.parseInt;

public class MinMax {
    public static void main(String[] args) {
        System.out.print(solution("-1 -5 -6 28 4"));
    }
    public static String solution(String s){
        String[] answerArray = s.split(" ");
        String maxValue = "";
        String minValue = "";
        for(String item: answerArray){
            int value = parseInt(item);
            if(maxValue.isEmpty()){
                maxValue = item;
            }
            else if(parseInt(maxValue) <= value)
                maxValue = item;
            if(minValue.isEmpty()){
                minValue = item;
            }
            else if(parseInt(minValue) >= value)
                minValue = item;
        }

        return minValue + " " + maxValue;
    }
}
