package com.programmers.level2;

import java.util.*;

/**
 * 광물 캐기
 *
 * 광물을 순서대로 5개씩 나눈 후 각 가중치를 설정한다.
 *
 * 다이아몬드 곡괭이 가중치: 다이아몬드광석 * 25 + 철광석 * 5 + 돌광석 * 1
 */
public class MineralMining {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int maxCnt = picks[0] + picks[1] + picks[2];
        PriorityQueue<Map<String, Object>> resultQue = new PriorityQueue<>((o1, o2) ->
                (Integer)o2.get("weight") - (Integer)o1.get("weight")
        );
        for(int i=0; i< minerals.length; ){
            if(maxCnt * 5 <= i){
                break;
            }
            List<String> mineral = new ArrayList<>();
            int weight = 0;

            for (int j = i; i + 5 < minerals.length ? j < i + 5 : j < minerals.length; j++){
                mineral.add(minerals[j]);
                weight += getWeight(minerals[j]);
            }

            Map<String, Object> mineralInfo = new HashMap<>();
            mineralInfo.put("mineral", mineral);
            mineralInfo.put("weight", weight);
            resultQue.offer(mineralInfo);
            i = i+5;
        }
        for (int i=0; i<picks.length; i++) {
            for (int j = 0; j < picks[i]; j++) {
                if(resultQue.peek() == null){
                    break;
                }
                answer += getFatigue((List<String>) resultQue.poll().get("mineral"), i);
            }
        }
        return answer;
    }
    //가중치 구하기
    private int getWeight(String mineral){
        switch (mineral) {
            case "stone":{
                return 1;
            }
            case "iron": {
                return 5;
            }
            case "diamond": {
                return 25;
            }
        }
        return 0;
    }
    //피로도 구하기
    private int getFatigue(List<String> minerals, int pick){
        int result = 0;
        for(String mineral: minerals){
            if(pick == 0){
                result += 1;
            } else if(pick == 1){
                if (mineral.equals("diamond")) {
                    result += 5;
                } else {
                    result += 1;
                }
            } else{
                if (mineral.equals("diamond")) {
                    result += 25;
                } else if (mineral.equals("iron")){
                    result += 5;
                } else {
                    result += 1;
                }
            }
        }
        return result;
    }
}
