package com.programmers.level3;

import java.util.ArrayDeque;

/**
 * 징검다리 건너기
 *
 * 연속된 0의 개수가 k보다 크거나 같은 경우가 생기면 거기까지 한다.
 */
public class SteppingStoneCrossing {
    public static void main(String[] args) {
        SteppingStoneCrossing steppingStoneCrossing = new SteppingStoneCrossing();

        System.out.println(steppingStoneCrossing.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }
    public int solution(int[] stones, int k) {
        int globalMin = Integer.MAX_VALUE;

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for(int i=0; i<stones.length; i++){

            if(!arrayDeque.isEmpty() && arrayDeque.peek() <= i-k ){
                arrayDeque.poll();
            }

            while(!arrayDeque.isEmpty() && stones[arrayDeque.peekLast()] <= stones[i]){
                arrayDeque.pollLast();
            }

            arrayDeque.offer(i);

            if(i >= k - 1 ){
                globalMin = Math.min(globalMin, stones[arrayDeque.peek()]);
            }
        }
        return globalMin;
    }
}
