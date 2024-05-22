package com.programmers.level2;

import java.util.Arrays;

/**
 * 거리두기 확인하기
 *
 * 강의실 마다 P를 찾고 해당 P에 맨해튼 거리가 2이하인 지점의 P를 찾고 해당 지점까지의 파티션이 있는지 확인하는 절차를 구한다.
 */
public class DistanceMonitor {
    public static void main(String[] args) {
        DistanceMonitor distanceMonitor = new DistanceMonitor();
        System.out.println(Arrays.toString(distanceMonitor.solution(new String[][]{
                {
                    "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"
                },
                {
                    "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"
                },
                {
                    "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"
                },
                {
                        "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"
                },
                {
                        "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"
                }})));
    }
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
                if(place[row][column].equals("P")) {
                    for (int i = 0; i < 4; i++) {
                        if (validation(place, row + check_1[0][i], column + check_1[1][i])) {
                            return 0;
                        }
                        if (validation(place, row + check_2[0][i], column + check_2[1][i])) {
                            if (!place[row + check_2[0][i]][column].equals("X") || !place[row][column + check_2[1][i]].equals("X")) {
                                return 0;
                            }
                        }
                        if (validation(place, row + check_3[0][i], column + check_3[1][i])) {
                            if (!place[row + check_3[0][i] - check_1[0][i]][column + check_3[1][i] - check_1[1][i]].equals("X")) {
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
            return place[row][column].equals("P");
        }
        return false;
    }
}
