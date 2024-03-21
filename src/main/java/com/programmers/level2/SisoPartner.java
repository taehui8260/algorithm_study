package com.programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class SisoPartner {
    public static void main(String[] args) {
        SisoPartner sisoPartner = new SisoPartner();
        System.out.println(sisoPartner.solution(new int[]{400,300}));
    }

    /**
     * 시소 짝궁
     *
     * 여러 사람이 주어지고 이중 2명씩 시소에 앉혀 균형을 이루면 된다.
     * 시소는 중앙으로부터 2, 3, 4 (m) 떨어져 있고 각 거리와 몸무게의 곱이 같다면 균형을 이룬다.
     *
     * map에 모든 수를 넣고 비율을 이용해 값을 찾아 비교한다.

     * @param weights
     * @return
     */
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> weightMap = new HashMap<>();
        int index = 0;
        for(int weight : weights){
            weightMap.merge(weight, 1, Integer::sum);
        }
        int [][] rates = {{1,2}, {2,3}, {3,4}};

        //같은데이터 1:1 일때
        for (int weight : weights) {
            answer += weightMap.get(weight) - 1;
        }
        answer = answer/2;
        for(int[] rate: rates){
            for (int weight : weights) {
                if ((weight * rate[0]) % rate[1] != 0) {
                    continue;
                } else {
                    int comparisonNum = (weight * rate[0]) / rate[1];
                    if (weightMap.get(comparisonNum) != null) {
                        answer += weightMap.get(comparisonNum);
                    }
                }
            }
        }
        return answer;
    }
}
