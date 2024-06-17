package com.programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 경주로 건설
 * <p>
 * bfs로 구현
 */
public class TrackBuilder {
    public static void main(String[] args) {
        TrackBuilder trackBuilder = new TrackBuilder();
        System.out.println(trackBuilder.solution(new int[][] {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}}));
    }
    public int solution(int[][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;
        int[][][] buildPay = new int[rowSize][colSize][4];
        Queue<int[]> queue = new LinkedList<>();
        for(int[][] item: buildPay){
            for(int[] item_2: item){
                Arrays.fill(item_2, Integer.MAX_VALUE);
            }
        }
        //각 뱡향에서 들어오는 경우에 대한 건설 가격
        buildPay[0][0][0] = 0;
        buildPay[0][0][1] = 0;
        buildPay[0][0][2] = 0;
        buildPay[0][0][3] = 0;

        int[] rowDirection = {0, 1, 0, -1};
        int[] colDirection = {1, 0, -1, 0};
        queue.offer(new int[]{0, 0, 4});
        while (!queue.isEmpty()) {
            int[] curTrack = queue.poll();
            int curRow = curTrack[0];
            int curCol = curTrack[1];
            // 0 오른쪽, 1 아래, 2 왼쪽, 3 위
            int direction = curTrack[2];
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 4; i++) {
                    int expense = buildPay[curRow][curCol][j];

                    if (0 <= curRow + rowDirection[i] && curRow + rowDirection[i] < rowSize && 0 <= curCol + colDirection[i] && curCol + colDirection[i] < colSize && 1 != board[curRow + rowDirection[i]][curCol + colDirection[i]] && curRow + rowDirection[i] + curCol + colDirection[i] != 0) {
                        if (direction == i || direction == 4) {
                            expense += 100;
                        } else {
                            expense += 600;
                        }
                        if (buildPay[curRow + rowDirection[i]][curCol + colDirection[i]][i] > expense) {
                            buildPay[curRow + rowDirection[i]][curCol + colDirection[i]][i] = expense;
                            queue.offer(new int[]{curRow + rowDirection[i], curCol + colDirection[i], i});
                        }
                    }
                }
            }
        }
        for(int[] item: board){
            System.out.println(Arrays.toString(item));

        }
        for(int[][] item: buildPay){
            for(int[] item_2: item){
                System.out.println(Arrays.toString(item_2));
            }
        }
        return Math.min(buildPay[rowSize-1][colSize-1][0], buildPay[rowSize-1][colSize-1][1]);
    }
}
