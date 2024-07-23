package com.programmers.level3;

import java.util.PriorityQueue;

/**
 * [1차] 셔틀버스
 *
 * timetable을 분으로 변경한 후 priorityQueue에 오름차순으로 넣는다.
 *
 * 9시부터 해당 시간보다 일찍 오거나 같게 온 사람을 m만큼 뺀다.
 * 이후 t를 더한 후 위애 방법을 n-1 만큼 한다.
 *
 * n번째에는 하나씩 pop하면서 시간을 체크한다. 만약 n번째에 pop한 개수가 m보다 작다면 answer = 9 + n * t 아니면 pop의 마지막 보다 1이 작은 것이 된다.
 *
 *
 */
public class ShuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> timeQue = new PriorityQueue<>();

        for(String time: timetable){
            timeQue.offer(changeTime(time));
        }
        int minute = 9 * 60;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                //모든 사람이 셔틀을 이미 탔을경우
                if (timeQue.isEmpty()) {
                    return changeTime(minute + (n-1) * t);
                }

                //셔틀을 타고 떠난 사람들
                if (minute + i * t >=timeQue.peek()){

                    //마지막 셔틀까지 사람이 남아있을경우
                    if(i==n-1){
                        if(j == m-1){
                            return changeTime(timeQue.peek() - 1);
                        }
                    }
                    timeQue.poll();
                }
            }
        }
        return changeTime(minute + (n-1) * t);
    }
    // HH:mm -> mm
    private int changeTime(String time){
        int hour;
        int minute;
        String [] timeAry = time.split(":");
        hour = Integer.parseInt(timeAry[0]);
        minute = Integer.parseInt(timeAry[1]);

        return minute + hour*60;
    }
    //mm -> HH:mm
    private String changeTime(int time){
        int hour = time/60;
        int minute = time%60;
        return String.format("%02d", hour) + ":" + String.format("%02d", minute);
    }
}
