package com.lth.algorithm.programmers.level2;

public class Fatigue {
    static int result = 0;
    public static void main(String[] args) {
        System.out.print(solution(80, new int[][]{{80, 10}, {40, 30}, {60, 10}, {80,10}}));
    }
    static public int solution(int k, int[][] dungeons) {
        //어차피 최대 8개 이므로 다 해봐야 할듯 즉 DFS
        int answer = -1;
        boolean[] adventureDungeonFlg = new boolean[dungeons.length];
        adventure(k, dungeons, adventureDungeonFlg);
        answer = result;
        return answer;
    }
    static void adventure(int k, int[][] dungeons, boolean[] adventureDungeonFlg){

        boolean[] localAdventureDungeonFlg = new boolean[adventureDungeonFlg.length];
        for(int i=0; i<adventureDungeonFlg.length; i++){
            localAdventureDungeonFlg[i] = adventureDungeonFlg[i];
        }
        int adventureDungeonCnt = 0;
        for(int i=0; i<localAdventureDungeonFlg.length; i++){
            if(!localAdventureDungeonFlg[i]){
                if(k >= dungeons[i][0]){
                    //System.out.println("before K: " +   k);
                    k = k-dungeons[i][1];
                    //System.out.println("after K: " +   k);
                    localAdventureDungeonFlg[i] = true;
                    adventure(k, dungeons, localAdventureDungeonFlg);
                    for(boolean flg:localAdventureDungeonFlg){
                        if(flg) {
                            adventureDungeonCnt++;
                        }
                        result = Math.max(result, adventureDungeonCnt);
                    }
                    adventureDungeonCnt = 0;
                    //System.out.println("result: " +   result);
                    if(result == localAdventureDungeonFlg.length)
                        break;
                    localAdventureDungeonFlg[i] = false;
                    k =  k+dungeons[i][1];
                }
            }
        }
    }
}
