package com.programmers.level3;

import java.util.*;

/**
 * 여행경로
 */
public class TripRoute {
    public static void main(String[] args) {
        TripRoute tripRoute = new TripRoute();
        System.out.println(Arrays.toString(tripRoute.solution(new String[][]{{"ICN", "JFK"}, {
                "HND", "IAD"
        }, {
                "JFK", "HND"
        }})));
    }
    public String[] solution(String[][] tickets) {
        List<String> answerList = new ArrayList<>();
        Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();

        for(String[] ticket : tickets){
            ticketMap.putIfAbsent(ticket[0], new PriorityQueue<>());
            ticketMap.get(ticket[0]).add(ticket[1]);
        }
        String nation = "ICN";
        while(true){
            answerList.add(nation);
            if(ticketMap.get(nation)==null || ticketMap.get(nation).peek() == null){
                break;
            }
            nation = ticketMap.get(nation).poll();
        }
        return answerList.toArray(new String[0]);
    }
}
