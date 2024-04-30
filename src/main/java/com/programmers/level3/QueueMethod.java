package com.programmers.level3;

import java.util.ArrayList;
import java.util.List;

/**
 * 줄 서는 방법
 * 1 2 6 24 120
 * k가 어떤 팩토리얼의 합의 +1 집합인지 구한다
 *
 * 1 2 3 4 5 6 : 1
 * 1 2 3 4 6 5 : 2
 * 1 2 3 5 4 6 : 3
 * 1 2 3 5 6 4 : 4
 * 1 2 3 6 4 5 : 5
 * 1 2 3 6 5 4 : 6
 * 1 2 4 3 5 6 : 7
 *
 * 1 2 5 3 4 6 : 13
 *
 * 1 2 6 3 4 5 : 19
 *
 * 1 3 2 4 5 6 : 25
 *
 */
public class QueueMethod {
    public static void main(String[] args) {
        QueueMethod queueMethod = new QueueMethod();

    }
    public int[] solution ( int n, long k){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        List<Integer> resultList = new ArrayList<>();
        int[] result = new int[n];
        k--;

        long factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = (int) (k / factorial);
            resultList.add(numbers.remove(index));
            k %= factorial;
            if (i > 0) {
                factorial /= i;
            }
        }
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
