package com.programmers.level3;

import java.util.*;

/**
 * 섬 연결하기
 * cost를 기준으로 정렬 후 파인트 유니온 알고리즘을 통해 전체 노드를 연결하는 cost의 합을 구한다
 */
public class IslandConnector {
    public static void main(String[] args) {
       IslandConnector islandConnector = new IslandConnector();
        System.out.println(islandConnector.solution(4,	new int[][]{{0, 1, 10}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (a, b) ->{
           return a[2] - b[2];
        });
        for(int[] cost : costs){
            System.out.println(Arrays.toString(cost));
        }
        boolean [] checkVisit = new boolean[n];

        for(int[] cost : costs){
            if(!checkVisit[cost[0]] || !checkVisit[cost[1]]){
                answer += cost[2];
                checkVisit[cost[0]] = true;
                checkVisit[cost[1]] = true;
            }
        }
        return answer;
    }
}
