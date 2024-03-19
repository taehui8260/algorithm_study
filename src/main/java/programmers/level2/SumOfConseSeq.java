package programmers.level2;


import java.util.Arrays;

public class SumOfConseSeq {
    public static void main(String[] args) {
        SumOfConseSeq sumOfConseSeq = new SumOfConseSeq();
        System.out.println(Arrays.toString(sumOfConseSeq.solution(new int[]{1, 1, 1, 1, 1, 4, 4, 5, 5, 5, 6},12)));
    }

    /**
     * 연속된 부분 수열의 합
     *
     * 합이 k인 수열 중 가장 짧은 수열을 찾아야 함으로 뒤에부터 비교한다.
     * 만약 같은 길이의 수열인 경우 index가 앞에 있는 수열을 찾아야 함으로 각각 앞뒤 경계선에 있는 숫자를 비교해 같을 경우 하나 앞에 수열을 사용한다.
     *
     *
     * @param sequence
     * @param k
     * @return
     */
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        long sum = 0;
        int startIndex = sequence.length-1;
        int endIndex = sequence.length-1;

        sum = sequence[startIndex];

        while(startIndex>0){
            if(sum < k){
                sum += sequence[--startIndex];
            } else if(sum > k){
                sum -= sequence[endIndex--];
                sum += sequence[--startIndex];
            } else{
                if(sequence[startIndex-1] == sequence[endIndex]){
                    startIndex--;
                    endIndex--;
                } else
                    break;
            }
        }
        answer[0] = startIndex;
        answer[1] = endIndex ;
        return answer;
    }
}
