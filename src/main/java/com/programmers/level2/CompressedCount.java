package com.programmers.level2;

/**
 * 쿼드압축 후 개수 세기
 */
public class CompressedCount {
    public int[] solution(int[][] arr) {
        return dfs(arr, 0, 0, arr.length);
    }
    private int[] dfs(int[][] arr, int startY, int startX, int size){
        if(checkUnique(arr, startY, startX, size)){
            if(arr[startY][startX] == 0){
                return new int[] {1, 0};
            } else{
                return new int[] {0, 1};
            }
        }
        int newSize = size/2;
        int [] leftTop = dfs(arr, startY, startX, newSize);
        int [] rightTop = dfs(arr, startY, startX + newSize, newSize);
        int [] leftBottom = dfs(arr, startY + newSize, startX, newSize);
        int [] rightBottom = dfs(arr, startY + newSize, startX + newSize, newSize);

        return new int[] {
            leftTop[0]+rightTop[0]+leftBottom[0]+rightBottom[0],
            leftTop[1]+rightTop[1]+leftBottom[1]+rightBottom[1]
        };
    }
    private boolean checkUnique(int[][] arr, int startY, int startX, int size){
        int value = arr[startY][startX];
        for(int i=startY; i<startY + size; i++){
           for(int j=startX; j<startX + size; j++){
               if(value != arr[i][j]){
                   return false;
               }
           }
        }
        return true;
    }

}
