package com.programmers.level3;

import java.util.*;

/**
 * 배달
 *
 * bfs 사용
 */
public class Delivery {
    public static void main(String[] args) {
        Delivery delivery = new Delivery();
        System.out.println(delivery.solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }
    public int solution(int N, int[][] road, int K) {
        Map<Integer, List<int[]>> roadMap = new HashMap<>();
        for (int[] r : road) {
            roadMap.putIfAbsent(r[0], new ArrayList<>());
            roadMap.putIfAbsent(r[1], new ArrayList<>());
            roadMap.get(r[0]).add(new int[]{r[1], r[2]});
            roadMap.get(r[1]).add(new int[]{r[0], r[2]});
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentTown = current[0];
            int currentDist = current[1];

            if (!roadMap.containsKey(currentTown)) continue;

            for (int[] next : roadMap.get(currentTown)) {
                int nextTown = next[0];
                int nextDist = next[1];

                if (dist[nextTown] > currentDist + nextDist) {
                    dist[nextTown] = currentDist + nextDist;
                    queue.offer(new int[]{nextTown, dist[nextTown]});
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
   /* public int solution(int N, int[][] road, int K) {
        int answer = 0;
        boolean [] roadFlg = new boolean[N];
        int [] roadCnt = new int[N];
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
                    roadMap.get(item[0]).put(item[1], Math.min(item[2], roadMap.get(item[0]).get(item[1])));
                }
            }
            map2.put(item[0], item[2]);
            if(roadMap.get(item[1]) == null){
                roadMap.put(item[1], map2);
            } else {
                if(roadMap.get(item[1]).get(item[0]) == null){
                    roadMap.get(item[1]).put(item[0],item[2]);
                } else{
                    roadMap.get(item[1]).put(item[0], Math.min(item[2], roadMap.get(item[1]).get(item[0])));
                }
            }
        }
        roadFlg[0] = true;

        for(Integer key : roadMap.get(1).keySet()){
            Map<Integer, Integer> map = new HashMap<>();
            map.put(key, roadMap.get(1).get(key));
            roadCnt[key-1] = roadMap.get(1).get(key);
            roadFlg[key-1] = true;
            roadQueue.add(map);
        }

        while(roadQueue.peek() != null){
            Map<Integer, Integer> data = roadQueue.poll();

            for(Integer key: data.keySet()){
                for(Integer key2: roadMap.get(key).keySet()){
                    if(!roadFlg[key2-1]){
                        Map<Integer, Integer> map = new HashMap<>();
                        map.put(key2, data.get(key) + roadMap.get(key).get(key2));
                        roadQueue.add(roadMap.get(key));
                        roadCnt[key2-1] = map.get(key2);
                        roadFlg[key2-1] = true;
                    }
                }
            }
            System.out.println(roadMap);

        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(roadMap);
        System.out.println(roadQueue);
        System.out.println(Arrays.toString(roadCnt));
        for(int cnt : roadCnt){
            if(cnt <= K) answer++;
        }
        return answer;
    }*/
}
