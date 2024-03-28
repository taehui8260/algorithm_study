package com.programmers.level3;

import java.util.Arrays;

/**
 * 최고의 집합
 */
public class BestSet {
    public static void main(String[] args) {
        BestSet bestSet = new BestSet();
    }
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int standardNum = 0;
        int remainder = 0;
        int index = 0;
        if(n>s){
            return new int[]{-1};
        }
        standardNum = s/n;
        remainder = s%n;
        while (index<n){
            if(remainder>0) {
                answer[index] = standardNum + 1;
                index++;
                remainder--;
            }
            else{
                answer[index] = standardNum;
                index++;
            }
        }
        Arrays.sort(answer);

        return answer;
    }
}
