package com.lth.algorithm.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingFee {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
    }
    //당일 출차 내역이 없으면 23:59 출차 처리
    //누적 이용시간 기본시간 이하라면 기본요금 청구
    //입차이면 time에 현재시간 넣기
    //출차이면 time에 현재시간 넣고 totalTime에 출차 - 입차 값 넣기
    //마지막까지 입차로 되어있는 값이 있으면 time에 23:59넣고 totalTime에 출차 - 입차 넣기 출차
    public static int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];


        Map<String, CarParkingInfo> ParkingFee = new HashMap<>();
        String [] recordsDetail;

        //자동차 주차 정보 현행화
        for (String record : records) {
            recordsDetail = record.split(" ");
            ParkingFee.merge(recordsDetail[1], new CarParkingInfo(recordsDetail[2], changeStringToTime(recordsDetail[0])), (carParkingInfo, carParkingInfo2) -> {
                int totalTime = carParkingInfo2.carStatus.equals("IN") ? carParkingInfo.totalTime : carParkingInfo2.time - carParkingInfo.time + carParkingInfo.totalTime;
                return new CarParkingInfo(carParkingInfo2.carStatus, carParkingInfo2.time, totalTime);
            });
        }
        //출차 안한 자동차 출차 처리
        for(String key : ParkingFee.keySet()){
            int totalTime = ParkingFee.get(key).totalTime + (changeStringToTime("23:59") - ParkingFee.get(key).time);
            if(ParkingFee.get(key).carStatus.equals("IN")){
                ParkingFee.put(key, new CarParkingInfo("OUT", changeStringToTime("23:59"), totalTime));
            }
        }

        String [] carNumAry = ParkingFee.keySet().toArray(new String[0]);
        Arrays.sort(carNumAry);
        int[] answer =  new int[carNumAry.length];
        //주차 비용 계산
        for(int i=0; i<answer.length; i++){
            CarParkingInfo car = ParkingFee.get(carNumAry[i]);
            answer[i] = getParkingFee(defaultTime, defaultFee, unitTime, unitFee, car.totalTime);

        }
        return answer;
    }
    //문자열 시간 int로 변환
    static int changeStringToTime(String time){
        String [] timeDetail = time.split(":");

        return Integer.parseInt(timeDetail[0])*60 + Integer.parseInt(timeDetail[1]);
    }
    //주차요금 계산
    static int getParkingFee(int defaultTime, int defaultFee ,int unitTime, int unitFee, int parkingTime){
        if(parkingTime <= defaultTime)
            return defaultFee;
        else{
            int remain = (parkingTime-defaultTime) % unitTime == 0 ? 0 : unitFee;
            return defaultFee + unitFee*((parkingTime-defaultTime)/unitTime) + remain;
        }
    }
    //자동차 주차 정보
    public static class CarParkingInfo {
        String carStatus;
        int time;
        int totalTime;
        CarParkingInfo(String carStatus, int time){
            this.carStatus = carStatus;
            this.time = time;
        }
        CarParkingInfo(String carStatus, int time, int totalTime){
            this.carStatus = carStatus;
            this.time = time;
            this.totalTime = totalTime;

        }
    }
}
