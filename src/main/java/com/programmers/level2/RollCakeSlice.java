package com.programmers.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RollCakeSlice {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 1, 4}));
    }
    //케이크에 올라간 토핑 별 개수를 구한다.
    //나눠지는 부분까지의 토핑 가지수와 남은 토핑 가지수가 같을때에 ++answer 한다.
    //나눠지를 부분의 토핑의 개수가 남은 토핑의 가지수보다 많아질때까지 반복한다.
    static public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> toppingMap = new HashMap<>();
        Set<Integer> brotherCakeTopping = new HashSet<>();

        for(int item: topping){
            toppingMap.merge(item, 1, Integer::sum);
        }
        for(int item: topping){
            brotherCakeTopping.add(item);
            if(toppingMap.get(item) != null){
                toppingMap.put(item, toppingMap.get(item) -1);
                if(toppingMap.get(item) == 0){
                    toppingMap.remove(item);
                }
            }
            if(brotherCakeTopping.size() == toppingMap.size()){
                answer++;
            }
        }
        return answer;
    }
}
