package com.programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 미로탈출
 *
 * 레버를 먼저 찾고 이후 출구로 간다.
 * 벽과 맵 밖으로의 이동은 불가능
 *
 * bfs 사용
 */
public class MazeEscape {
    public int solution(String[] maps) {
        int [] startCoordinate = new int[2];
        int [] leverCoordinate = new int[2];
        String [][] mapAry = new String [maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    startCoordinate[0] = i;
                    startCoordinate[1] = j;
                }
                if(maps[i].charAt(j) == 'L'){
                    leverCoordinate[0] = i;
                    leverCoordinate[1] = j;
                }
                mapAry[i][j] = String.valueOf(maps[i].charAt(j));
            }
        }
        //레버 찾기

        int answer = bfs(mapAry, startCoordinate, "L");
        if(answer == -1){
            return answer;
        }
        int answer2 = bfs(mapAry, leverCoordinate, "E");
        if(answer2 == -1){
            return answer2;
        }
        return answer + answer2;
    }

    //길을 찾기 위한 bfs
    private int bfs(String [][] mapAry, int [] coordinate, String findLocation){
        int result  = -1;
        boolean[][] check = new boolean[mapAry.length][mapAry[0].length];
        Deque<CoordinateValue> deque = new ArrayDeque<>();
        deque.addLast(new CoordinateValue(coordinate[0], coordinate[1], 0));
        check[coordinate[0]][coordinate[1]] = true;
        int []rowMove = {0, 0, 1, -1};
        int []colMove = {1, -1, 0, 0};

        while(!deque.isEmpty()){
            CoordinateValue coordinateValue = deque.pollFirst();
            int row = coordinateValue.row;
            int column = coordinateValue.column;
            int value = coordinateValue.value;
            if(mapAry[row][column].equals(findLocation)){
                return value;
            }
            for(int i=0; i<4; i++){
                int newRow = row + rowMove[i];
                int newCol = column + colMove[i];
                if(validation(newRow, newCol, mapAry, check)){
                    deque.addLast(new CoordinateValue(newRow, newCol, value + 1));
                    check[newRow][newCol] = true;
                }
            }
        }
        return result;
    }
    private boolean validation(int row, int col, String [][] mapAry, boolean[][] check){
        return row >= 0 && row < mapAry.length && col >= 0 && col < mapAry[0].length && !check[row][col] && !mapAry[row][col].equals("X");
    }
    class CoordinateValue {
        int row;
        int column;
        int value;
        public CoordinateValue(int row, int column, int value){
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
}
