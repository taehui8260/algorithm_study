package com.lth.algorithm.programmers;

public class Carpet {
    public static void main(String[] args) {
        solution(10, 2);
    }
    static public int[] solution(int brown, int yellow) {
        int[] answer = {};
        //yellow의 약수에 각 각 +2를 한 후 곱한게 brown과 같다면 그 값이 각각 가로 세로이다.
        int x = 0;
        for(int i = 1; i < yellow + 3; i++){
            if(yellow % i == 0){
                x = yellow / i;
                if((x+2) * (i +2) == yellow + brown){
                    System.out.println("3");
                    answer = new int[]{x + 2, i + 2};
                    break;
                }
            }
        }
        return answer;
    }
}
