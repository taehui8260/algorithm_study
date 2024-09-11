package com.programmers.level2;
import java.util.*;
/**
 * 실행시간이 현재시간보다 작을경우 해당 현재시간을 실행시간으로 바꾸고 돟작시간 - (실행시간 - 현재시간) 를 que 에 저장한다
 * 만약 다음 실행 시간이 현재시간보다 작을경우 que에 있는것을 실행하고 다름 실행시간이 되면 다시 que에 넣는다.
 * 과제 시작
 */
public class StartAssignment {

    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Deque<String[]> waitPlanQue = new ArrayDeque<>();
        Arrays.sort(plans, (o1, o2) -> {return o1[1].compareTo(o2[1]);});

        String curName = plans[0][0];
        int curPlayTime =  Integer.parseInt(plans[0][2]);
        int curTime = changeMinute(plans[0][1]) + curPlayTime;

        for(int i=1; i<plans.length;){
            if(changeMinute(plans[i][1]) < curTime){
                waitPlanQue.addFirst(new String[]{curName, plans[i][1], String.valueOf(curPlayTime - (changeMinute(plans[i][1]) - curTime))});
                curName = plans[i][0];
                curPlayTime = Integer.parseInt(plans[i][2]);
                curTime = changeMinute(plans[i][1]) + curPlayTime;
            } else {
                answer.add(curName);
                if(!waitPlanQue.isEmpty()){
                    String[] locPlan = waitPlanQue.pollFirst();
                    curName = locPlan[0];
                    curPlayTime =  Integer.parseInt(locPlan[2]);
                    curTime = changeMinute(locPlan[1]) + curPlayTime;
                    continue;
                }
            }
            i++;
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
