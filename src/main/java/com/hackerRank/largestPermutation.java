package com.hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Largest Permutation
 */
public class largestPermutation {
    public static List<Integer> largestPermutation(int k, List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>(arr);
        int[] numMap = new int[result.size() + 1];
        int maxNum;
        for(int i=0; i<result.size(); i++){
            numMap[result.get(i)] = i;
        }
        int mapTemp = 0;
        int valueTemp = 0;
        for(int i=0; i<Math.min(k, result.size()); i++){
            maxNum = result.size() - i;

            if(result.get(i) == maxNum){
                k++;
                continue;
            }else {
                mapTemp = numMap[maxNum];
                numMap[maxNum] = i;
                valueTemp = result.get(i);
                numMap[valueTemp] = mapTemp;

                result.set(i, maxNum);
                result.set(mapTemp, valueTemp);
            }
        }
        return result;
    }
}
