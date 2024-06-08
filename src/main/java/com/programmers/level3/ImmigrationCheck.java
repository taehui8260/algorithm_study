package com.programmers.level3;

/**
 * 입국심사
 * left와 right를 초기화하고, 가능한 최대 시간을 right로 설정합니다.
 * 이진 탐색을 수행하면서 mid를 계산합니다.
 * getPeopleProcessed 메서드를 통해 mid 시간 동안 처리할 수 있는 사람 수를 계산합니다.
 * 처리할 수 있는 사람 수가 n명 이상이면 right를 줄여서 더 작은 시간을 탐색하고, 그렇지 않으면 left를 늘려서 더 큰 시간을 탐색합니다.
 * 최종적으로 모든 사람이 심사를 받을 수 있는 최소 시간을 반환합니다.
 */
public class ImmigrationCheck {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) n * getMaxTime(times);
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long peopleProcessed = getPeopleProcessed(mid, times);

            if (peopleProcessed >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private long getMaxTime(int[] times) {
        long max = times[0];
        for (int time : times) {
            if (time > max) {
                max = time;
            }
        }
        return max;
    }

    private long getPeopleProcessed(long mid, int[] times) {
        long total = 0;
        for (int time : times) {
            total += mid / time;
        }
        return total;
    }
}
