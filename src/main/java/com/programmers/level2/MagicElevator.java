package com.programmers.level2;

public class MagicElevator {
    public static void main(String[] args) {
        MagicElevator magicElevator = new MagicElevator();
        System.out.println(magicElevator.solution(2554));
    }
    //가장 작은 자리수 부터 시작한다.
    //해당 자리수의 값이 5보다 작거나 큰 경우 그에 맞게 반올림 해주는 값을 answer에 더해준다.
    //만약 5일 경우 그 다음 자리수를 보고 판단한다.
    //다음 자리수가 5보다 크거나 같으면 반올림
    //다음 자리수가 4보다 작거나 같으면 반내림 해준다.
    //이를 끝까지 해준다.
    public int solution(int storey) {
        int answer = 0;
        int remainder;
        while(storey != 0){
            remainder = storey % 10;
            storey = storey / 10;
            if(storey != 0 && remainder == 5){
                if(storey % 10>= 5){
                    storey += 1;
                }
                answer += 5;
            } else if(remainder > 5){
                answer += 10 - remainder;
                storey += 1;
            } else{
                answer += remainder;
            }
        }
        return answer;
    }
}
