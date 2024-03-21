package com.programmers.level2;

import java.util.Arrays;

public class LifeBoat {
    public static void main(String[] args) {
        solution(new int[]{10, 5, 4, 888, 2, 15}, 20);
    }
    static public int solution(int[] people, int limit) {
        int answer = 0;
        int j = 0;
        people = Arrays.stream(people).sorted().toArray();
        System.out.println(people[1] + " " +  people[5]);
        for(int i=people.length-1; i>=j; i--){
            if(people[i] + people[j] <= limit){
                j++;
            }
            answer++;
        }
        return answer;
    }
}
