package com.programmers.level3;

import java.util.*;

/**
 * 보석 쇼핑
 *
 * 보석의 개수를 찾는다.
 *
 * 진열대를 앞부터 확인하면서 시작 index에 해당하는 보석이 내부에 2개 이상 있다면 index를 +1 하고 내부 보석의 개수를 하나 줄인다.
 * 이렇게 해 모든 보석이 있다면 실행을 종료하고 시작 index와 현재 index를 return 한다.
 */
public class GemShopping {
    public static void main(String[] args) {
        GemShopping gemShopping = new GemShopping();
        System.out.println(Arrays.toString(gemShopping.solution(new String[]{
                "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
        })));
    }
    public int[] solution(String[] gems) {
        int[] answer = {};
        Map<String, Integer> gemCntMap = new HashMap<>();

        Set<String> gemSet = new HashSet<>();

        Map<Integer, List<Integer>> resultMap = new HashMap<>();

        for(String gem: gems ){
            gemCntMap.put(gem, 0);
        }

        int endIndex = gems.length-1;
        gemCntMap.put(gems[endIndex], 1);
        gemSet.add(gems[endIndex]);
        for(int i=endIndex-1; i>=0; i--){
            gemCntMap.put(gems[i], gemCntMap.get(gems[i]) + 1);
            gemSet.add(gems[i]);

            if(gems[i].equals(gems[endIndex])){
                //endIndex--;

                endIndex = checkEndIndex( gems, gemCntMap, endIndex);
            }

            if(gemSet.size() == gemCntMap.size()){
                resultMap.put(endIndex - i, List.of(i +1, endIndex+1));
            }
        }
        int minCnt = 10000000;
        for(Integer key: resultMap.keySet()){
            if(minCnt > key){
                minCnt = key;
            }
        }

        return resultMap.get(minCnt).stream() // 스트림 생성
                .mapToInt(Integer::intValue) // Integer를 int로 언박싱
                .toArray();
    }
    private int checkEndIndex(String[] gems, Map<String, Integer> gemCntMap, int endIndex){
        int index = endIndex;
        if(gemCntMap.get(gems[index])>1){
            gemCntMap.put(gems[index],  gemCntMap.get(gems[index])-1);
            index = checkEndIndex(gems,  gemCntMap, index - 1);
        }
        return index;
    }
}
