package com.programmers.level2;

/**
 * 멀쩡한 사각형
 * 8 1 0
 * 8 2 (16 - 8) 8
 * 8 3 (24 -10) 14
 * 8 4 (32 - 8) 24
 * 8 5 (40 - 12) 28
 * 8 6 (48 - 12) 36
 * 8 7 ()
 * 가로 세로가 짝수일때
 */
public class NormalSquare {
    public long solution(int W, int H) {
        // 전체 정사각형의 개수
        long totalSquares = (long) W * H;
        // 대각선이 지나가는 정사각형의 개수
        long unusableSquares = W + H - gcd(W, H);
        // 사용할 수 있는 정사각형의 개수
        return totalSquares - unusableSquares;
    }

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
