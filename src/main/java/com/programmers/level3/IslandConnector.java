package com.programmers.level3;

import java.util.*;

/**
 * 섬 연결하기
 * 0 : {1/1, 2/2}, 1 : {2/5, 3/1}, 2:{3/8}, 3
 */
public class IslandConnector {
    public static void main(String[] args) {
       IslandConnector islandConnector = new IslandConnector();
        System.out.println(islandConnector.solution(4,	new int[][]{{0, 1, 10}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Map<Integer, List <int[]>> lineMap= new HashMap<>();
        int [] minCostForLine = new int [n];
        Arrays.fill(minCostForLine, Integer.MAX_VALUE);
        boolean [] lineCheck = new boolean [n];

        for(int[] cost: costs){
            lineMap.putIfAbsent(cost[0], new ArrayList<>());
            lineMap.putIfAbsent(cost[1], new ArrayList<>());
            if(cost[0] <= cost[1])
                lineMap.get(cost[0]).add(new int[]{cost[1], cost[2]});
            if(cost[1] <= cost[0])
                lineMap.get(cost[1]).add(new int[]{cost[0], cost[2]});
        }
        for(int i=0; i<n; i++){
            int finalI = i;
            lineMap.get(i).forEach(ints -> {
                System.out.println(finalI + " :"+ Arrays.toString(ints));

                if(minCostForLine[ints[0]] > ints[1]){
                    minCostForLine[ints[0]] = ints[1];
                }
            });
        }
        System.out.println(lineMap);
        System.out.println(Arrays.toString(minCostForLine));
        for(int result: minCostForLine){
            if(result != Integer.MAX_VALUE){
                answer+= result;
            }
        }
        return answer;
    }
}
