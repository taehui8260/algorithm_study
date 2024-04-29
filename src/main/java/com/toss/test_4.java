package com.toss;

import java.util.*;

public class test_4 {
    public int[][] solution(int servers, boolean sticky, int[] requests) {
        List<Integer> requests_0 = new ArrayList<>();
        List<Integer> requests_1 = new ArrayList<>();
        int serverIndex = 1;
        if(sticky){
            Map<Integer, Integer> server_0 =  new HashMap<>();
            Map<Integer, Integer> server_1 =  new HashMap<>();
            for(int request: requests){
                if(serverIndex == 0){
                    if(server_0.get(request) != null){
                        requests_0.add(request);
                        server_0.put(request, 0);
                    } else{
                        requests_1.add(request);
                        server_1.put(request, 0);
                        serverIndex = 1;
                    }
                } else{
                    if(server_1.get(request) != null){
                        requests_1.add(request);
                        server_1.put(request, 0);
                    } else{
                        requests_0.add(request);
                        server_0.put(request, 0);
                        serverIndex = 0;
                    }
                }
            }

        }
        int [] serverAry_1 = new int [requests_0.size()];
        int [] serverAry_2 = new int [requests_1.size()];
        for(int i=0; i< serverAry_1.length;  i++){
            serverAry_1[i] = requests_0.get(i);
        }
        for(int i=0; i< serverAry_2.length;  i++){
            serverAry_2[i] = requests_1.get(i);
        }
        Object[] test = requests_0.toArray();
        int[][] answer = {serverAry_1,serverAry_2};

        return answer;
    }
}
