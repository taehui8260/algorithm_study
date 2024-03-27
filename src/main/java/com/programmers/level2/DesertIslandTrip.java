package com.programmers.level2;

import com.common.Common;

import java.util.ArrayList;
import java.util.List;

public class DesertIslandTrip extends Common {
    public static void main(String[] args) {
        DesertIslandTrip desertIslandTrip = new DesertIslandTrip();
        desertIslandTrip.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1","1XXX1","1XXX1","1XXX1"});
    }

    //배열을 돌면서 숫자가 나오면 해당 숫자의 상하좌우를 보고 그 숫자로 이동 이과정을 반복하면서 이동한 위치의 값은 X로 바꾼 후 해당 위치 수치를 return 한다.
    //받은 수치를 list에 저장한다.
    //정렬 된 값은 출력한다.
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        String [][]mapsAry = new String[maps.length][maps[0].length()];
        for(int i=0; i<mapsAry.length; i++){
            for(int j=0; j<mapsAry[0].length; j++){
                mapsAry[i][j] = String.valueOf(maps[i].charAt(j));
            }
        }

        //showAry(mapsAry);
        for(int i=0; i<mapsAry.length; i++){
            for(int j=0; j<mapsAry[0].length; j++){
                if(!mapsAry[i][j].equals("X")) {
                    answer.add(getIslandValue(mapsAry, i, j));
                    //showAry(mapsAry);
                }
            }
        }
        answer.sort((o1, o2) -> o1-o2);
        if (answer.size() == 0)
            answer.add(-1);
        return  answer.stream().mapToInt(Integer::intValue).toArray();
    }
    private int getIslandValue(String [][]mapsAry, int i, int j){
        int value = Integer.parseInt(mapsAry[i][j]);
        mapsAry[i][j] = "X";

        //상
        if(i>0 && !mapsAry[i-1][j].equals("X")){
            value = value + getIslandValue(mapsAry, i-1, j);
        }
        //하
        if(i<mapsAry.length-1 && !mapsAry[i+1][j].equals("X")){
            value = value + getIslandValue(mapsAry, i+1, j);
        }
        //좌
        if(j>0 && !mapsAry[i][j-1].equals("X")){
            value = value + getIslandValue(mapsAry, i, j-1);
        }
        //우
        if(j<mapsAry[0].length-1 && !mapsAry[i][j+1].equals("X")){
            value = value + getIslandValue(mapsAry, i, j+1);
        }
        return value;
    }
}
