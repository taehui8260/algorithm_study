package com.programmers.level3;

import java.util.*;

/**
 * 가장 먼 노드
 *
 * 1번 노드로 부터 연결되어있는 모든 노드들의 최단 거리를 bfs를 이용해 구하고 최장거리에 있는 노드의 개수르 구한다.
 *
 */
public class DistantNode {
    public static void main(String[] args) {
        DistantNode distantNode = new DistantNode();
        System.out.println(distantNode.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        int maxDistant = 0;
        boolean[] nodeCheck = new boolean[n];
        int [] distant = new int[n];

        Queue<Integer> nodeQueue = new LinkedList<>();

        for(int [] item : edge){
            nodeMap.putIfAbsent(item[0], new ArrayList<>());
            nodeMap.putIfAbsent(item[1], new ArrayList<>());

            nodeMap.get(item[0]).add(item[1]);
            nodeMap.get(item[1]).add(item[0]);
        }

        nodeQueue.add(1);
        nodeCheck[0] = true;

        while(!nodeQueue.isEmpty()){
            int node = nodeQueue.poll();
            int nodeDistant = distant[node-1];
            for(int item: nodeMap.get(node)){
                if(!nodeCheck[item-1]) {
                    nodeQueue.add(item);
                    distant[item - 1] = 1 + nodeDistant;
                    nodeCheck[item - 1] = true;
                    maxDistant = distant[item - 1];
                }
            }
        }
        for(int result: distant){
            if(result == maxDistant){
                answer++;
            }
        }
        return answer;
    }

}
