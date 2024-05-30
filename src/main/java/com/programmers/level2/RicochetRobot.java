package com.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 리코쳇 로봇
 *
 * bfs 이용
 */
public class RicochetRobot {
    public static void main(String[] args) {
        RicochetRobot ricochetRobot = new RicochetRobot();
        System.out.println(ricochetRobot.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    }
    public int solution(String[] board) {
        int answer = -1;
        int rowSize = board.length;
        int colSize = board[0].length();
        boolean [][] visited = new boolean[rowSize][colSize];
        int[] start = new int[2];
        int[] goal = new int[2];
        int[] rowDirection = {0, 0, -1, 1};
        int[] colDirection = {-1, 1, 0, 0};
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
            int[] current = queue.poll();
            int count = current[2];

            if(board[current[0]].charAt(current[1]) == 'G'){
                return count;
            }
            for(int i=0; i<4; i++){
                int row = current[0];
                int col = current[1];
                while(true) {
                    if (0 <= row + rowDirection[i] && row + rowDirection[i] < rowSize && 0 <= col + colDirection[i] && col + colDirection[i] < colSize && board[row + rowDirection[i]].charAt(col + colDirection[i]) != 'D') {
                        row = row + rowDirection[i];
                        col = col + colDirection[i];
                    } else{
                       if(!visited[row][col]){
                           visited[row][col] = true;
                           queue.offer(new int[]{row, col, count+1});
                       }
                       break;
                    }
                }
            }
        }
        return answer;
    }
}
