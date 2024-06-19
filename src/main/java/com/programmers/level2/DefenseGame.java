package com.programmers.level2;

import java.util.PriorityQueue;

/**
 * 디펜스 게임
 *
 * 스킬을 쓰지 않고 넘길 수 있는 모든 라운드를 정렬된 que에 넣는다.
 * 더이상 라운드를 넘길 수 없다고 스킬이 있다면 다음 라운드의 값을 que에 넣고 가장 큰 값을 poll한 후 병사에 해당 값만큼 추가한다.
 * 위에 과정을 반복하고 라운드가 끝나거나 스킬이 없을떄까지 반복한다.
 * 여기서 스킬이 있다면 다음 라운드에 값을 넣
 */
public class DefenseGame {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int N = n;
        int K = k;
        //내림차순 정렬
        PriorityQueue<Integer> enemyQue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i=0; i<enemy.length; i++){
            N -= enemy[i];
            if(N >= 0){
                enemyQue.offer(enemy[i]);
            } else{
                if(K != 0){
                    enemyQue.offer(enemy[i]);
                    N += enemyQue.poll();
                    K--;
                } else{
                    return i;
                }
            }
        }
        return enemy.length;
    }
}
