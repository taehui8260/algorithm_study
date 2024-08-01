package com.programmers.level3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 다단계 칫솔 판매
 *
 * Map<판매원, 추천인>
 * Map<판매원, 이익금>
 */
public class MultilevelToothbrushSales {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> sellerChain = new HashMap<>();
        Map<String, List<Integer>> sellerAmount = new HashMap<>();
        Map<String, Integer> totalSellerAmount = new LinkedHashMap<>();

        for(int i=0; i<enroll.length; i++){
            sellerChain.put(enroll[i], referral[i]);
            totalSellerAmount.put(enroll[i], 0);
        }
        for(int i=0; i<seller.length; i++){
            sellerAmount.putIfAbsent(seller[i], new ArrayList<>());
            sellerAmount.get(seller[i]).add(amount[i] * 100);
        }
        for(String sellerName: sellerAmount.keySet()){
            dfs(sellerChain, totalSellerAmount, sellerName, sellerAmount.get(sellerName));
        }

        int index = 0;
        for(String sellerName: totalSellerAmount.keySet()){
            answer[index++] = totalSellerAmount.get(sellerName);
        }
        return answer;
    }
    void dfs(Map<String, String> sellerChain, Map<String, Integer> totalSellerAmount, String seller, List<Integer> amountList){
        List<Integer> enrollAmount = amountList.stream().map(n -> n/10).collect(Collectors.toList());
        int sellerAmount = 0;
        for(Integer amount: amountList){
            sellerAmount += (amount/10) * 9 + (amount%10);
        }
        totalSellerAmount.merge(seller, sellerAmount, Integer::sum);
        if(!sellerChain.get(seller).equals("-")){
            dfs(sellerChain, totalSellerAmount, sellerChain.get(seller), enrollAmount);
        }
    }
}
