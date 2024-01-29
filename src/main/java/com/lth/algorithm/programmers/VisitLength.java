package com.lth.algorithm.programmers;

public class VisitLength {
    public static void main(String[] args) {
        System.out.println(solution("LULLLLLLU"));
    }
    static public int solution(String dirs) {
        int answer = 0;
        boolean [][] map = new boolean[11][11];
        int curX = 5;
        int curY = 5;
        //map[curY][curX] = true;

        for(int i=0; i<dirs.length(); i++){
            if(i ==0){
                if(dirs.charAt(i) == 'U'){
                    curX = 4;
                    curY = 5;
                } else if(dirs.charAt(i) == 'D'){
                        ++curY;
                } else if(dirs.charAt(i) == 'R'){
                        ++curX;
                } else if(dirs.charAt(i) == 'L'){
                        --curX;
                }
            }
            if(dirs.charAt(i) == 'U'){
                if(curY > 0){
                    --curY;
                }
            } else if(dirs.charAt(i) == 'D'){
                if(curY < 9){
                    ++curY;
                }
            } else if(dirs.charAt(i) == 'R'){
                if(curX < 9){
                    ++curX;
                }
            } else if(dirs.charAt(i) == 'L'){
                if(curX > 0){
                    --curX;
                }
            }
            map[curY][curX] = true;
        }

        for(int i=0; i<11; i++){
            for(int j=0; j<11; j++){
                System.out.print(map[i][j] + " ");
                if(map[i][j])
                    ++answer;
            }
            System.out.println();
        }
        return answer;
    }
}
