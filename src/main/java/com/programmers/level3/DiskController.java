package com.programmers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 디스크 컨트롤러
 *
 * 해당 시점에 가장 작은 소요  시간이 걸리는 내용을 처리
 * 4, 3
 * 10, 7
 * 12, 17
 *
 */
public class DiskController {
    public double solution(int[][] jobs) {
        // 작업을 시작 시간에 따라 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int totalTime = 0;
        int currentTime = 0;
        int index = 0;
        int count = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (count < jobs.length) {
            // 현재 시간보다 시작 시간이 빠른 모든 작업을 큐에 넣음
            while (index < jobs.length && jobs[index][0] <= currentTime) {
                priorityQueue.offer(jobs[index]);
                index++;
            }

            if (!priorityQueue.isEmpty()) {
                // 우선순위 큐에서 소요 시간이 가장 짧은 작업을 꺼냄
                int[] job = priorityQueue.poll();
                currentTime = Math.max(currentTime, job[0]) + job[1];
                totalTime += currentTime - job[0];
                count++;
            } else if (index < jobs.length) {
                // 큐가 비어있다면 현재 시간을 다음 작업의 시작 시간으로 업데이트
                currentTime = jobs[index][0];
            }
        }
        return (double) totalTime / jobs.length;
    }
}
