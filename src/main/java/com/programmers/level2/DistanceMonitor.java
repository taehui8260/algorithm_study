package com.programmers.level2;

import java.util.Arrays;

/**
 * 거리두기 확인하기
 *
 * 강의실 마다 P를 찾고 해당 P에 맨해튼 거리가 2이하인 지점의 P를 찾고 해당 지점까지의 파티션이 있는지 확인하는 절차를 구한다.
 */
public class DistanceMonitor {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        int index = 0;
        for(String[] item: places){
            String [][] place = new String[5][5];
            for(int i=0; i<item.length; i++){
                for(int j=0; j<item[i].length(); j++){
                    place[i][j] = String.valueOf(item[i].charAt(j));
                }
            }
            answer[index] = checkDistance(place);
            index++;
        }

        return answer;
    }
    private int checkDistance(String [][] place){
        int [][] check_1 = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
        int [][] check_2 = {{-1, 1, -1, 1}, {-1, 1, 1, -1}};
        int [][] check_3 = {{-2, 2, 0, 0}, {0, 0, -2, 2}};
        for(int row=0; row<place.length; row++){
            for(int column=0; column<place[row].length; column++){
                for(int i=0; i<4; i++){
                    if(!validation(place, row + check_1[0][i], column + check_1[1][i])){
                        return 0;
                    }
                    if(!validation(place, row + check_2[0][i], column + check_2[1][i])){
                        if(!place[row + check_2[0][i]][column].equals("X") || !place[row][column + check_2[1][i]].equals("X"))
                            return 0;
                    }
                    if(!validation(place, row + check_3[0][i], column + check_3[1][i])){
                        if(i == 0){
                            if(!place[row -1][column].equals("X")){
                                return 0;
                            }
                        } else if (i==1) {
                            if(!place[row +1][column].equals("X")){
                                return 0;
                            }
                        } else if(i==2){
                            if(!place[row][column -1].equals("X")){
                                return 0;
                            }
                        } else {
                            if(!place[row][column +1].equals("X")){
                                return 0;
                            }
                        }
                    }

                }
            }
        }
        return 1;
    }
    private boolean validation(String [][] place, int row, int column){
        if(row >= 0 && column >=0 && row < 5 && column < 5){
            return !place[row][column].equals("P");
        }
        return true;
    }
}
