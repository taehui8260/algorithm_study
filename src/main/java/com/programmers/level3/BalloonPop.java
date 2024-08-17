package com.programmers.level3;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 풍선 터트리기
 */
public class BalloonPop {
    public int solution(int[] a) {
        int answer = 1;
        int leftMin = Integer.MAX_VALUE;
        int [] rightMin = new int[a.length];
        rightMin[a.length-1] = a[a.length-1];
        for(int i=a.length-2; i>0; i--){
            rightMin[i] = Math.min(a[i], rightMin[i+1]);
        }

        for(int i=0; i<a.length-1; i++){
            if(a[i] < leftMin || a[i] < rightMin[i+1]){
                answer++;
            }
            if(a[i] < leftMin){
                leftMin = a[i];
            }
        }
        return answer;
    }
}
