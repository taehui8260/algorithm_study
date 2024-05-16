package com.programmers.level3;

import java.util.*;

/**
 * 섬 연결하기
 * cost를 기준으로 정렬 후 파인트 유니온 알고리즘을 통해 전체 노드를 연결하는 cost의 합을 구한다
 */
public class IslandConnector {
    public static void main(String[] args) {
       IslandConnector islandConnector = new IslandConnector();
        System.out.println(islandConnector.solution(4,	new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (a, b) ->{
           return a[2] - b[2];
        });
        int [] parents = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        for(int[] cost : costs){
            System.out.println(Arrays.toString(cost));
            if(find(parents, cost[0]) != find(parents, cost[1])){
                answer += cost[2];
                union(parents, cost[0], cost[1]);
            }
            System.out.println(Arrays.toString(parents));
        }
        return answer;
    }
    private int find(int[] parents, int n){
        if(parents[n] == n){
            return n;
        } else{
            return parents[n] = find(parents, parents[n]);
        }
    }
    private void union(int[] parents, int x, int y){
        int xParents = find(parents, x);
        int yParents = find(parents, y);
        if(xParents != yParents)
            parents[xParents] = yParents;
    }
}
