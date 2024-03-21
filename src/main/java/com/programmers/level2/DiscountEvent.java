package com.programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class DiscountEvent {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }
    static public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean findDiscountDateFlg = true;
        Map<String, Integer> wantProduct = new HashMap<>();
        setWantProduct(wantProduct, want, number);
        for(int i=0; i<discount.length-9; i++){
            findDiscountDateFlg = true;
            for(int j=i; j < i + 10; j++){
                if(wantProduct.get(discount[j]) != null){
                    wantProduct.put(discount[j], wantProduct.get(discount[j]) -1);
                    if(wantProduct.get(discount[j]) < 0){
                        findDiscountDateFlg = false;
                        break;
                    }
                } else{
                    findDiscountDateFlg = false;
                    break;
                }
            }
            if(findDiscountDateFlg) {
                answer++;
            }
            setWantProduct(wantProduct, want, number);
        }
        return answer;
    }
    static void setWantProduct(Map<String, Integer> wantProduct, String[] want, int[] number){
        for(int i=0; i<want.length; i++){
            wantProduct.put(want[i], number[i]);
        }
    }
}
