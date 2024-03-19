package programmers.level2;

import java.util.Arrays;

public class PrimeNum {
    public static void main(String[] args) {
        System.out.println(solution(124156,	10));
    }
    static public int solution(int n, int k) {
        int answer = 0;
        String data = changeDecimalToK(n, k);
        String[] numAry = data.split("0");

        long num = 0;
        for (String s : numAry) {
            num = Long.parseLong((s.isEmpty() ?"0":s));
            if (checkPrimeNum(num)) {
                answer++;
            }
        }
        return answer;
    }
    //10진수를 k 진수로 변환
    static String changeDecimalToK(int n, int k){
        int remainder = 0;
        String result = "";
        while(n!=0){
            remainder = n % k;
            n = n / k;
            result = String.valueOf(remainder) + result;
        }
        return result;
    }
    static boolean checkPrimeNum(long num){
        if(num < 2){
            return false;
        } else{
            for(long i = 2;i * i<=num; i++){
                if(num%i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
