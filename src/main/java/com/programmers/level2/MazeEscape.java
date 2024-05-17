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
        int answer = -1;
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
        Deque<CoordinateValue> deque = new ArrayDeque<>();
        deque.addLast(new CoordinateValue(startCoordinate[0], startCoordinate[1], 0));
        answer = bfs(mapAry, deque, "L");
        if(answer == -1){
            return answer;
        }

        deque.clear();
        //도착 찾기
        deque.addLast(new CoordinateValue(leverCoordinate[0], leverCoordinate[1], 0));
        answer += bfs(mapAry, deque, "E");

        return answer;
    }

    //길을 찾기 위한 bfs
    private int bfs(String [][] mapAry, Deque<CoordinateValue> deque, String findLocation){
        int result  = -1;
        boolean[][] check = new boolean[mapAry.length][mapAry[0].length];

        while(deque.peek() != null){
            CoordinateValue coordinateValue = deque.pollFirst();
            int row = coordinateValue.row;
            int column = coordinateValue.column;
            int value = coordinateValue.value;
            check[row][column] = true;
            if(mapAry[row][column].equals(findLocation)){
                result = value;
                break;
            }
            if((mapAry[0].length -1 > column) && !check[row][column + 1] && !mapAry[row][column + 1].equals("X")){
                deque.addLast(new CoordinateValue(row, column + 1, value + 1));
            }
            if(0 < column && !check[row][column - 1] && !mapAry[row][column - 1].equals("X")){
                deque.addLast(new CoordinateValue(row, column - 1, value + 1));
            }
            if(mapAry.length -1 > row && !check[row + 1][column] && !mapAry[row + 1][column].equals("X")){
                deque.addLast(new CoordinateValue(row + 1, column, value + 1));
            }
            if( 0 < row && !check[row - 1][column] && !mapAry[row - 1][column].equals("X")){
                deque.addLast(new CoordinateValue(row - 1, column, value + 1));
            }
        }
        return result;
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
