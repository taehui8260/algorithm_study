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
        Map<Integer, Boolean> moveBalloon = new HashMap<>();
        int rightMin = Integer.MAX_VALUE;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int item: a){
            moveBalloon.put(item, false);
            que.add(item);
        }
        for(int i=0; i<a.length-1; i++){
            moveBalloon.put(a[i], true);
            while(moveBalloon.get(que.peek())){
                que.poll();
            }
            if(a[i] < rightMin || a[i] < que.peek()){
                answer++;
            }
            if(a[i] < rightMin){
                rightMin = a[i];
            }
        }
        return answer;
    }
}
