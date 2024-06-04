package com.programmers.level2;

/**
 * 가장 큰 정사각형 찾기
 */
public class LargestSquareFinder {
    public static void main(String[] args) {
        LargestSquareFinder largestSquareFinder = new LargestSquareFinder();
        System.out.println(largestSquareFinder.solution(new int[][] {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
    }
    public int solution(int[][] board) {
        int maxSquareSize = 0;
        int[][] dp = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = board[i][j];
                } else if (board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                maxSquareSize = Math.max(maxSquareSize, dp[i][j]);
            }
        }
        return maxSquareSize * maxSquareSize;
    }
}
