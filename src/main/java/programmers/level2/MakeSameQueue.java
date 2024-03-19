package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class MakeSameQueue {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int limit = queue1.length*3 -3;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        long sumOfQueue1 = 0;
        long sumOfQueue2 = 0;
        for (int i=0; i<queue1.length; i++){
            sumOfQueue1 += queue1[i];
            que1.add(queue1[i]);

            sumOfQueue2 += queue2[i];
            que2.add(queue2[i]);
        }

        while(answer<=limit){
            if(sumOfQueue1 == sumOfQueue2)
                break;

            if(sumOfQueue1<sumOfQueue2){
                sumOfQueue2 -= que2.peek() != null ? que2.peek() : 0;
                sumOfQueue1 += que2.peek() != null ? que2.peek() : 0;
                que1.add(que2.poll());
            } else{
                sumOfQueue2 += que1.peek() != null ? que1.peek() : 0;
                sumOfQueue1 -= que1.peek() != null ? que1.peek() : 0;
                que2.add(que1.poll());
            }
            answer++;
        }
        return answer > limit ? -1 : answer;
    }
}
