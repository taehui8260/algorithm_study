package com.programmers.level2;

public class Country124
{
    public static void main(String[] args) {
        Country124 country124 = new Country124();
        System.out.print(country124.solution(15));
    }


    /**
     * 3진법과 유사한 진법이라고 생각하면 된다.
     * 다른점이라면 나머지가 없을 시 0으로 끝 자리수를 채우는게 아닌 4로 끝자리를 채우고 몫을 구하기 전 3을 뺸 후 진행한다는 것이다.
     *
     *
     * @param n
     * @return
     */
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int quotient = n;
        int remainder;
        while (quotient!=0){
            remainder = quotient%3;
            if(remainder == 0){
                quotient = quotient - 3;
                answer.insert(0, "4");
            } else {
                answer.insert(0, remainder);
            }
            quotient = quotient / 3;
        }
        return answer.toString();
    }
}
