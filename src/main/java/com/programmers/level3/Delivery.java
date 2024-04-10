package com.programmers.level3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 배달
 *
 * bfs 사용
 */
public class Delivery {
    public static void main(String[] args) {
        Delivery delivery = new Delivery();
        System.out.println(delivery.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        boolean [] roadFlg = new boolean[K];
        int [] roadCnt = new int[K];
        Queue<Map<Integer, Integer>> roadQueue = new LinkedList<>();
        Map<Integer, Map<Integer, Integer>> roadMap = new HashMap<>();
        for(int [] item: road){
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            map1.put(item[1], item[2]);
            if(roadMap.get(item[0]) == null){
                roadMap.put(item[0], map1);
            } else {
                if(roadMap.get(item[0]).get(item[1]) == null){
                    roadMap.get(item[0]).put(item[1],item[2]);
                } else{
                    roadMap.get(item[0]).put(item[1], Math.max(item[2], roadMap.get(item[0]).get(item[1])));
                }
            }
            map2.put(item[0], item[2]);
            if(roadMap.get(item[1]) == null){
                roadMap.put(item[1], map2);
            } else {
                if(roadMap.get(item[1]).get(item[0]) == null){
                    roadMap.get(item[1]).put(item[0],item[2]);
                } else{
                    roadMap.get(item[1]).put(item[0], Math.max(item[2], roadMap.get(item[1]).get(item[0])));
                }
            }
        }
        roadQueue.add(roadMap.get(1));
        roadFlg[0] = true;
        while(roadQueue.peek() != null){
            Map<Integer, Integer> data = roadQueue.poll();
            roadFlg[0] = true;
            for(Integer key: data.keySet()){
                if(!roadFlg[key-1]) {
                    for(Integer key2: roadMap.get(key).keySet()){
                        roadMap.get(key).put(key2, roadMap.get(key).get(key2) + data.get(key));
                    }
                    roadQueue.add(roadMap.get(key));
                }
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(roadMap);

        return answer;
    }
}
