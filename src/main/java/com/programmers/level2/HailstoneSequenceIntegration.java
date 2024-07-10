package com.programmers.level2;

import java.util.LinkedList;
import java.util.List;

/**
 * 우박수열 정적분
 *
 * 1이 될때까지 계속 진행하면서 List에 저장한다.
 *
 * n = List의 길이 -1
 *
 * a < n-b 일때에는 -1
 *
 * Math.Min(x, y) +
 *
 */
public class HailstoneSequenceIntegration {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> HailstoneSequenceList = new LinkedList<>();
        int n;
        while(true){
            HailstoneSequenceList.add(k);
            if(k==1){
                break;
            }
            if(k%2 == 0){
                k = k/2;
            } else{
                k = k*3 + 1;
            }
        }

        n = HailstoneSequenceList.size() - 1;
        int index = 0;
        for(int [] range: ranges){
            int a = range[0];
            int b = n + range[1];
            if(a>b){
                answer[index] = -1;
            } else if(a == b){
                answer[index] = 0;
            } else{
                for(int i=a; i<b; i++){
                    answer[index] += getIntegration(HailstoneSequenceList.get(i), HailstoneSequenceList.get(i+1));
                    System.out.println("index: " + answer[index]);
                }
            }
            index++;
        }

        return answer;
    }
    private double getIntegration(int a, int b){
        int integration = 0;

         return Math.min(a, b) +  Math.abs(a - b) /(double)2;
    }
}
