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
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int totalTime = 0;
        int currentTime = jobs[0][0];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for(int i=0; i< jobs.length;){
            if(jobs[i][0] <= currentTime){
                priorityQueue.offer(jobs[i]);
                i++;
                continue;
            }
            if(!priorityQueue.isEmpty()){
                int [] job = priorityQueue.poll();
                totalTime += currentTime - job[0] + job[1];
                currentTime += job[1];
            } else{
                priorityQueue.offer(jobs[i]);
                currentTime = jobs[i][0];
                i++;
            }
        }

        while(!priorityQueue.isEmpty()){
            int [] job = priorityQueue.poll();
            totalTime += currentTime - job[0] + job[1];
            currentTime += job[1];
        }
        return (double) totalTime / jobs.length;
    }
}
