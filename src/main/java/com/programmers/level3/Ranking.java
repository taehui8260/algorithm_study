package com.programmers.level3;

import java.util.*;

/**
 * 순위
 */
public class Ranking {
    public static void main(String[] args) {
        Ranking ranking = new Ranking();
        System.out.println(ranking.solution(5, new int [][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
    public int solution(int n, int[][] results) {
        int answer = 0;
        int [][] winAndLossCnt = new int[n+1][2];
        Map<Integer, Set<Integer>> winMap = new HashMap<>();
        Map<Integer, Set<Integer>> lossMap = new HashMap<>();
        for(int i=0; i<results.length; i++){
            lossMap.putIfAbsent(results[i][0], new HashSet<>());
            winMap.putIfAbsent(results[i][1], new HashSet<>());
            lossMap.get(results[i][0]).add(results[i][1]);
            winMap.get(results[i][1]).add(results[i][0]);
        }
        for(int i=1; i<=n; i++){
            Queue<Integer> winDfsQueue = new LinkedList<>();
            Queue<Integer> lossDfsQueue = new LinkedList<>();
            winDfsQueue.add(i);
            lossDfsQueue.add(i);
            boolean [] visitedWin = new boolean[n+1];
            visitedWin[i] = true;

            boolean [] visitedLoss = new boolean[n+1];
            visitedLoss[i] = true;

            while(!winDfsQueue.isEmpty()){
                int cur = winDfsQueue.poll();
                if(winMap.get(cur)==null) continue;
                for(Integer win: winMap.get(cur)){
                    if(!visitedWin[win]){
                        visitedWin[win] = true;
                        winDfsQueue.add(win);
                        winAndLossCnt[i][0] += 1;
                    }
                }
            }
            while(!lossDfsQueue.isEmpty()){
                int cur = lossDfsQueue.poll();
                if(lossMap.get(cur)==null) continue;
                for(Integer loss:  lossMap.get(cur)){
                    if(!visitedLoss[loss]){
                        visitedLoss[loss] = true;
                        lossDfsQueue.add(loss);
                        winAndLossCnt[i][1] += 1;
                    }
                }
            }
        }
        for(int [] result: winAndLossCnt){
            if(result[0] + result[1] == n -1)
                answer++;
        }
        return answer;
    }
}
