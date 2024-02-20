package com.lth.algorithm.programmers.level2;

public class MatrixMultiplication {
    public static void main(String[] args) {
    }
    static public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowCnt = arr1.length;
        int columnCnt = arr2[0].length;
        int[][] answer = new int [rowCnt][columnCnt];
        for(int i=0; i<rowCnt;i++){
            for(int j=0; j<columnCnt; j++){
                answer[i][j] = getMultiplicationArr(getRowValue(i, arr1), getColumnValue(j, arr2));
            }
        }
        return answer;
    }
    static int[] getRowValue(int row, int[][] arr){
        int columnCnt = arr[0].length;
        int[] result = new int[columnCnt];
        for(int i=0; i<columnCnt; i++){
            result[i] = arr[row][i];
        }
        return result;
    }
    static int[] getColumnValue(int column, int[][] arr){
        int rowCnt = arr.length;
        int[] result = new int [rowCnt];
        for(int i=0; i<rowCnt; i++){
            result[i] = arr[i][column];
        }
        return result;
    }
    static int getMultiplicationArr(int[]arr1, int[] arr2){
        int result = 0;
        for(int i=0; i<arr1.length; i++){
            result += arr1[i] * arr2[i];
        }
        return result;
    }
}
