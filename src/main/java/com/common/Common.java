package com.common;

/**
 * 자주쓰는 함수 클래스
 */
public class Common {
    /**
     * String 2차원 배열 출력
     *
     * @param mapsAry
     */
    protected void showAry(String [][]mapsAry){
        System.out.println();
        for (String[] strings : mapsAry) {
            System.out.println();
            for (String string : strings) {
                System.out.print(string + " ");
            }
        }
    }

    /**
     * Integer 2차원 배열 출력
     *
     * @param mapsAry
     */
    protected void showAry(Integer [][]mapsAry){
        System.out.println();
        for (Integer[] strings : mapsAry) {
            System.out.println();
            for (Integer string : strings) {
                System.out.print(string + " ");
            }
        }
    }

    /**
     * 00:00 형식의 시간을 분으로 변환
     *
     * @param time
     * @return
     */
    int changeMinute(String time){
        int minute;

        String [] timeAry = new String[2];
        timeAry = time.split(":");
        minute = Integer.parseInt(timeAry[0]) * 60;
        minute += Integer.parseInt(timeAry[1]);
        return minute;
    }
}
