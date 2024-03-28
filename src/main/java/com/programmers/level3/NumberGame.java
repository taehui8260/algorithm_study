package com.programmers.level3;

import java.util.*;

/**
 * 숫자 게임
 *
 * 정렬 후 큰 수가
 */
public class NumberGame {
    public static void main(String[] args) {
        NumberGame numberGame = new NumberGame();

    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> aQue = new PriorityQueue<>();
        PriorityQueue<Integer> bQue = new PriorityQueue<>();

        for(int a: A)
            aQue.add(a);

        for(int b: B)
            bQue.add(b);

        while(bQue.peek() != null){
            if(aQue.peek() < bQue.peek()){
                aQue.poll();
                bQue.poll();
                answer++;
            }else {
                bQue.poll();
            }
        }
        return answer;
    }
}
