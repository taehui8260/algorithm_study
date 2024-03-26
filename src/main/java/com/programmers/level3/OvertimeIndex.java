package com.programmers.level3;
import java.util.PriorityQueue;

/**
 * 야근지수
 *
 *
 */
public class OvertimeIndex {
    public static void main(String[] args) {
        OvertimeIndex overtimeIndex = new OvertimeIndex();
        System.out.println(overtimeIndex.solution(4, new int[]{4, 3, 3}));
    }
    public long solution(int n, int[] works) {
        long answer = 0;
        long sumNum = 0;
        PriorityQueue<Integer> worksQue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int work: works){
            sumNum += work;
            worksQue.add(work);
        }
        if(sumNum <= n){
            return 0;
        }
        while(n>0){
            worksQue.add(worksQue.poll()-1);
            n--;
        }
        while(worksQue.peek()!= null){
            answer += (long) worksQue.peek() * worksQue.poll();
        }
        return answer;
    }
}
