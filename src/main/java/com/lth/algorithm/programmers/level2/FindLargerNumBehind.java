package com.lth.algorithm.programmers.level2;

import java.util.*;

public class FindLargerNumBehind {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 5, 5, 5, 6})));
    }
    //주어진 배열에서 자신의 숫자보다 큰 바로위의 수를  구하는 문제
    //만약 자기보다 큰 수가 없을경우 -1
    static public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Map<Integer, Integer> numMap = new HashMap<>();
        int maxData = 0;

        for(int i=numbers.length-1; i >= 0; i--){
            answer[i] = -1;

            if(maxData < numbers[i]){
                maxData = numbers[i];
            }
            if(numbers[i] < maxData){
                for(int j=i+1; j<numbers.length; j++){
                    if(numbers[i] < numbers[j]){
                        answer[i] = numbers[j];
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
