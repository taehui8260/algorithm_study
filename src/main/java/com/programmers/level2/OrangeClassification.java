package com.programmers.level2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OrangeClassification {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }
    static public int solution(int k, int[] tangerine) {
        int index = 0;
        int result = 0;
        Map<Integer, Integer> orangeMap = new HashMap<>();
        for (int j : tangerine) {
            orangeMap.merge(j, 1, Integer::sum);
        }
        int[] countForSize = new int[orangeMap.size()];

        for(Integer key : orangeMap.keySet()){
            countForSize[index++] = orangeMap.get(key);
        }
        Arrays.sort(countForSize);

        for(int i=countForSize.length-1; i>=0; i--){
            result++;
            k = k - countForSize[i];
            if(k<=0)
                break;
        }
        return result;
    }

}
