package com.lth.algorithm.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class VisitLength {
    public static void main(String[] args) {
        System.out.println(solution("LRRRRRRRR"));
    }
    static public int solution(String dirs) {
        int answer = 0;
        boolean [][] map = new boolean[11][11];
        int curX = 5;
        int curY = 5;
        //map[curY][curX] = true;
        Set<String> moveHistory = new HashSet<>();
        for(int i=0; i<dirs.length(); i++){
            if(dirs.charAt(i) == 'U'){
                if(curY > 0){
                    moveHistory.add(getMoveKey(curX, curY, curX, curY-1));
                    --curY;
                }
            } else if(dirs.charAt(i) == 'D'){
                if(curY < 10){
                    moveHistory.add(getMoveKey(curX, curY +1, curX, curY));
                    ++curY;
                }
            } else if(dirs.charAt(i) == 'R'){
                if(curX < 10){
                    moveHistory.add(getMoveKey(curX + 1, curY, curX, curY));
                    ++curX;
                }
            } else if(dirs.charAt(i) == 'L'){
                if(curX > 0){
                    moveHistory.add(getMoveKey(curX, curY, curX-1, curY));
                    --curX;
                }
            }
            map[curY][curX] = true;
        }
        System.out.println(moveHistory);
        answer = moveHistory.size();
        return answer;
    }
    static public String getMoveKey(int beforeX, int beforeY, int afterX, int afterY) {
        return Math.max(beforeX, afterX) + "|" + Math.min(beforeX, afterX) + "|" + Math.max(beforeY, afterY) + "|" + Math.min(beforeY, afterY);
    }

}
