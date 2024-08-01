package com.programmers.level3;

import java.util.*;

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
        Map<String, Integer> totalSellerAmount = new LinkedHashMap<>();

        for(int i=0; i<enroll.length; i++){
            sellerChain.put(enroll[i], referral[i]);
            totalSellerAmount.put(enroll[i], 0);
        }

        for(int i=0; i<seller.length; i++){
            dfs(sellerChain, totalSellerAmount, seller[i], amount[i] * 100);
        }

        int index = 0;
        for(String sellerName: totalSellerAmount.keySet()){
            answer[index++] = totalSellerAmount.get(sellerName);
        }
        return answer;
    }
    void dfs(Map<String, String> sellerChain, Map<String, Integer> totalSellerAmount, String seller, int amount){
        int enrollAmount;
        int sellerAmount;
        while(!seller.equals("-") && amount > 0) {
            enrollAmount = amount/10;
            sellerAmount = amount - enrollAmount;
            totalSellerAmount.merge(seller, sellerAmount, Integer::sum);
            seller = sellerChain.get(seller);
            amount = enrollAmount;
        }
    }
}
