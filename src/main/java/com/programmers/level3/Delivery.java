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
}
