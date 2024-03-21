package com.programmers.level2;

public class DifferentBits {
    public static void main(String[] args) {
        DifferentBits differentBits = new DifferentBits();

    }
    //마지막 자리수로부터 연속된 1중 가장 큰수를 의미하는 수를 더해주어야 만족하는결과를 얻을 수 있다.
    //1001:1111  이 비트의 경우 문제로부터 만족하는 가장 작은 숫자는
    //1010:1111  이다
    //즉 연속되 1 중에 가장 큰 수인 0001:0000을 더해주는 것이다.
    //왜냐하면 2진법이다 보니 자릿수 올림을 하게 되었을때 가장 큰 자리수가 01 -> 10 으로 변한다.
    //이는 2개 의 차이가 생기게 되고 이를 만족하기 위해서는 나머지 자리수가 모두 동일해야 한다.
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            answer[i] = numbers[i] + findNum(numbers[i]);
        }
        return answer;
    }
    private long findNum(long number){
        long remain = number%2;
        long quotient = number/2;
        long result = remain;
        while(remain==1){
            remain = quotient % 2;
            quotient = quotient / 2;
            if(remain == 0){
                break;
            }
            result = result * 2;
        }
        if(result ==0){
            return 1;
        }
        return result;
    }
}
