package com.programmers.level2;

import java.util.*;

/**
 * 행열 테두리 회전하기
 */
public class MatrixBorderRotator {
    public static void main(String[] args) {
        MatrixBorderRotator matrixBorderRotator = new MatrixBorderRotator();
        System.out.println(Arrays.toString(matrixBorderRotator.solution(6, 6, new int[][]{{2, 2, 5, 3}})));

    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        Deque<Integer> deque = new ArrayDeque<>();
        int [][] matrix = new int[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] = (j+1)  + (columns * i);
            }
        }
        int index = 0;
        for(int [] item: queries){
            int minNum = Integer.MAX_VALUE;
            int x = item[0] -1;
            int y = item[1] -1;
            int a = item[2] -1;
            int b = item[3] -1;
            for(int i=y; i<b; i++){
                if(minNum > matrix[x][i])
                    minNum = matrix[x][i];
                deque.addLast(matrix[x][i]);
            }
            for(int i=x; i<a; i++){
                if(minNum > matrix[i][b])
                    minNum = matrix[i][b];
                deque.addLast(matrix[i][b]);
            }
            for(int i=b; i>y; i--){
                if(minNum > matrix[a][i])
                    minNum = matrix[a][i];
                deque.addLast(matrix[a][i]);
            }
            for(int i=a; i>x; i--){
                if(minNum > matrix[i][y])
                    minNum = matrix[i][y];
                deque.addLast(matrix[i][y]);
            }
            deque.addFirst(deque.pollLast());

            for(int i=y; i<b; i++){
                matrix[x][i] = deque.pop();
            }
            for(int i=x; i<a; i++){
                matrix[i][b] = deque.pop();
            }
            for(int i=b; i>y; i--){
                matrix[a][i] = deque.pop();
            }
            for(int i=a; i>x; i--){
                matrix[i][y] = deque.pop();
            }

            deque.clear();
            answer[index] = minNum;
            index++;
        }

        return answer;
    }
}
