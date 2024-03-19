package programmers.level2;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        System.out.println(solution(new int []{3,4}));
    }
    static public int solution(int[] citations) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(citations);
        for(int i=citations[citations.length-1]; i>=0; i--){
            sum = 0;
            for(int j=citations.length-1; j>=0; j--){
                if(i<=citations[j]){
                    ++sum;
                }
                if(i>citations[j]) {
                    break;
                }
            }
            System.out.println("### sum:" + sum);
            if(sum >= i){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
