package com.programmers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 이중우선순위큐
 * 오름차순/내림차순 각각 2개의 큐를 만든다.
 *
 * 값이 들어오면 두 큐에 데이터를 다 넣고 명령어에 따라 queue 에서 값을 뺀다(D 1 일때는 내림차순 poll/ D -1 일때는 오름차순 poll).
 *
 * 만약 넣는 명령어와 빼는 명령어의 수가 같을때 모든 큐를 초기와 하고 index도 초기화 한다.
 *
 * A
 */
public class DualPriorityQueue {
    public static void main(String[] args) {
        DualPriorityQueue queue = new DualPriorityQueue();
        System.out.println(Arrays.toString(queue.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
    public int[] solution(String[] operations) {
        int[] answer = new int[]{0,0};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>((o1, o2) -> o2-o1);

        int addIndex = 0;

        for(String operation: operations){
            String [] operationAry = operation.split(" ");
            if(addIndex!=0 && operationAry[0].equals("D")){
                if(operationAry[1].equals("-1")){
                    queue.poll();
                } else{
                    reverseQueue.poll();
                }
                addIndex--;
            } else if(operationAry[0].equals("I")){
                queue.add(Integer.valueOf(operationAry[1]));
                reverseQueue.add(Integer.valueOf(operationAry[1]));
                addIndex++;
            }

            if(addIndex == 0){
                queue.clear();
                reverseQueue.clear();
            }
        }
        if(addIndex != 0){
            answer[0] = reverseQueue.poll();
            answer[1] = queue.poll();
        }
        return answer;
    }
}
