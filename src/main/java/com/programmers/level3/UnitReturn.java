package com.programmers.level3;

import java.util.*;

/**
 * 부대복귀
 *
 * 각 부대원들을 복귀 시키기 위한 거리를 구하기 위해서는 bfs를 이용한다.
 */
public class UnitReturn {
    public static void main(String[] args) {
        UnitReturn unitReturn = new UnitReturn();
        System.out.println(Arrays.toString(unitReturn.solution(5, new int[][]{{1, 2}, {1,4},{2,4},{2,5}, {4,5}}, new int[]{1,3,5}, 5)));
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        Map<Integer, LinkedHashSet<Integer>> loadMap = new HashMap<>();
        for(int[]road : roads){
            loadMap.putIfAbsent(road[0], new LinkedHashSet<>());
            loadMap.putIfAbsent(road[1], new LinkedHashSet<>());

            loadMap.get(road[0]).add(road[1]);
            loadMap.get(road[1]).add(road[0]);
        }
        for(int i=0; i<answer.length; i++){
            answer[i] = bfs(loadMap, sources[i], destination, n);
        }
        return answer;
    }
    private int bfs(Map<Integer, LinkedHashSet<Integer>> loadMap, int source, int destination, int n){
        boolean [] checkLoad = new boolean[n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{source, 0});
        if(loadMap.get(source) == null){
            return -1;
        }
        while(!queue.isEmpty()){
            int curLocation = queue.peek()[0];
            int curLength = queue.peek()[1];
            if(destination == curLocation){
                return curLength;
            }
            if(!checkLoad[curLocation-1]){
                for(Integer load: loadMap.get(curLocation)){
                    queue.offer(new int[]{load, curLength+1});
                }
                checkLoad[curLocation-1] = true;
            }
            queue.poll();
        }
        return -1;
    }
}
