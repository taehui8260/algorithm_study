package com.programmers.level2;

/**
 * 가장 큰 정사각형 찾기
 */
public class LargestSquareFinder {
    public static void main(String[] args) {
        LargestSquareFinder largestSquareFinder = new LargestSquareFinder();
        System.out.println(largestSquareFinder.solution(new int[][] {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
    }
    public int solution(int [][]board) {
        int answer = 1;
        boolean [][] check = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 1 && !check[i][j]){
                    check[i][j] = true;
                    answer =  Math.max(answer, findSquare(i, j, 2, board, check));
                }
            }
        }
        return answer*answer;
    }
    private int findSquare(int row, int col, int squareSize, int [][]board, boolean [][] check){
        int answer = squareSize;
        if(row+squareSize > board.length || col + squareSize > board[0].length){
            return squareSize-1;
        }
        for(int i=0; i<squareSize-1; i++){
            if(board[row+squareSize-1][col + i]==1 && !check[row+squareSize-1][col + i]){
                check[row+squareSize-1][col + i] = true;
            }
            else {
                return squareSize-1;
            }
            if(board[row+i][col + squareSize-1]==1 && !check[row+i][col + squareSize-1]){
                check[row+i][col + squareSize-1] = true;
            } else {
                return squareSize-1;
            }
        }
        if(board[row+squareSize-1][col +squareSize-1] == 1 && !check[row+squareSize-1][col + squareSize-1]){
            check[row+squareSize-1][col +squareSize-1] = true;
            answer = findSquare(row, col, squareSize +1, board, check);
        }
        return answer;
    }
}
