package com.programmers.level3;

/**
 * 스티커모으기(2)
 *
 * 첫번째 스티커를 때는 경우와 때지 않는 경우를 나누어 생각해야한다.
 *
 */
public class StickerCollectionV2 {
    public static void main(String[] args) {
        StickerCollectionV2 stickerCollectionV2 = new StickerCollectionV2();
        System.out.println(stickerCollectionV2.solution(new int[]{1,1,100,1,100}));
    }
    public int solution(int sticker[]) {
        int n = sticker.length;
        if(n == 1) return sticker[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        //첫번째 스티커를 때는 경우
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];

        for(int i=2; i<n-1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }
        //첫번째 때지 않는 경우
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for(int i=2; i<n; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}
