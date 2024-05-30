package com.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 리코쳇 로봇
 *
 * bfs 이용
 */
public class RicochetRobot {
    public int solution(String[] board) {
        int answer = 0;
        int rowSize = board.length;
        int colSize = board[0].length();
        boolean [][] visited = new boolean[rowSize][colSize];
        int[] start = new int[2];
        int[] goal = new int[2];
        for(int i=0; i<rowSize; i++){
            for(int j=0; j<colSize; j++){
                char cell = board[i].charAt(j);
                if(cell == 'R'){
                    start = new int[]{i, j};
                }
                if(cell == 'G'){
                    goal = new int[]{i, j};
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){

        }
        return answer;
    }
}
