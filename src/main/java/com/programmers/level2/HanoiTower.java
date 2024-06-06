package com.programmers.level2;

import java.util.LinkedList;
import java.util.List;

/**
 * 하노이의 탑
 * 1번 기둥에 있는 모든 원판을 3번으로 보내기 위해서는  원판의 개수 -1개를 2번으로 보낸 이후 제일 큰 원판은 3번으로 보내고 나머지 원판을 2에서 3으로 보내야한다.
 *
 * 1 2
 * 1 3
 * 2 3
 *
 */
public class HanoiTower {
    public int[][] solution(int n) {
        List<int[]> answerList = move(n, 1, 3);
        int[][] answer = new int[answerList.size()][2];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    private List<int[]> move(int towerSize, int startPoint, int endPoint){
        List<int[]> answer = new LinkedList<>();
        if(towerSize == 1){
            answer.add(new int[]{startPoint, endPoint});
            return answer;
        }
        answer = move(towerSize - 1, startPoint, 6 - (startPoint + endPoint));
        answer.add(new int[]{startPoint, endPoint});
        answer.addAll(move(towerSize - 1, 6 - (startPoint + endPoint), endPoint));
        return answer;
    }
}
