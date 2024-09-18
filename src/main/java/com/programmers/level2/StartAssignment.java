package com.programmers.level2;
import java.util.*;
/**
 * 실행시간이 현재시간보다 작을경우 해당 현재시간을 실행시간으로 바꾸고 돟작시간 - (실행시간 - 현재시간) 를 que 에 저장한다
 * 만약 다음 실행 시간이 현재시간보다 작을경우 que에 있는것을 실행하고 다름 실행시간이 되면 다시 que에 넣는다.
 *
 * 과제 진행하기
 */
public class StartAssignment {

    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Deque<String[]> waitPlanQue = new ArrayDeque<>();
        Queue<String[]> planQue = new ArrayDeque<>();

        Arrays.sort(plans, (o1, o2) -> {return o1[1].compareTo(o2[1]);});

        for(String[] plan : plans){
            planQue.offer(plan);
        }
        int curTime = 0;

        while(!planQue.isEmpty()){
            String[] plan = planQue.peek();
            if(waitPlanQue.isEmpty()){
                curTime = changeMinute(plan[1]);
                waitPlanQue.addFirst(new String[]{plan[0], plan[2]});
                planQue.poll();
            } else{
                String[] waitPlan = waitPlanQue.peekFirst();
                if(changeMinute(plan[1]) < curTime + Integer.parseInt(waitPlan[1])){
                    waitPlanQue.pollFirst();
                    waitPlanQue.addFirst(new String[]{waitPlan[0], String.valueOf(curTime + Integer.parseInt(waitPlan[1]) - changeMinute(plan[1]))});
                    waitPlanQue.addFirst(new String[]{plan[0], plan[2]});
                    planQue.poll();
                    curTime = changeMinute(plan[1]);
                } else{
                    while(!waitPlanQue.isEmpty() && changeMinute(plan[1]) >= curTime + Integer.parseInt(waitPlanQue.peekFirst()[1])){
                        curTime = curTime + Integer.parseInt(waitPlanQue.peekFirst()[1]);
                        answer.add(waitPlanQue.peekFirst()[0]);
                        waitPlanQue.pollFirst();
                    }
                }
            }
        }
        while(!waitPlanQue.isEmpty()){
            answer.add(waitPlanQue.pollFirst()[0]);
        }
        return answer.toArray(new String[0]);
    }
    private int changeMinute(String time){
        String[] timeAry = time.split(":");
        return Integer.parseInt(timeAry[0]) * 60 + Integer.parseInt(timeAry[1]);
    }
}
