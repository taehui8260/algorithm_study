package com.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 자물쇠와 열쇠
 */
public class LockAndKey {
    public static void main(String[] args) {
        LockAndKey lockAndKey = new LockAndKey();
        System.out.println(lockAndKey.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][] {
            {
                1, 1, 1
            },{
                1, 1, 0
            },{
                1, 0, 1
            }
        }));
    }
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int keyOneCnt = 0;
        int lockZeroCnt = 0;
        for(int []item : key){
            for(int item_2: item){
                if(item_2 == 1){
                    keyOneCnt++;
                }
            }
        }
        for(int []item : lock){
            for(int item_2: item){
                if(item_2 == 0){
                    lockZeroCnt++;
                }
            }
        }
        if(lockZeroCnt > keyOneCnt){
            return false;
        }

        int keySize = key.length;
        int lockSize = lock.length;

        int index = 4;
        while(index != 0) {
            int lockStartY = -(keySize -1);
            int lockEndY = 0;

            int lockStartX = -(keySize -1);
            int lockEndX = 0;

            int keyStartY = keySize-1;
            int keyEndY = keySize + lockSize -2;

            int keyStartX = keySize-1;
            int keyEndX = keySize + lockSize -2;

            for (int i = 0; i < keySize + lockSize - 1; i++) {
                lockStartX = -(keySize - 1);
                lockEndX = 0;
                keyStartX = keySize - 1;
                keyEndX = keySize + lockSize - 2;
                for (int j = 0; j < keySize + lockSize - 1; j++) {
                    int result = 0;

                    Queue<Integer> lockQue = new LinkedList<>();
                    Queue<Integer> keyQue = new LinkedList<>();
                    for (int y = Math.max(lockStartY, 0); y <= Math.min(lockEndY, lockSize-1); y++) {
                        for (int x = Math.max(lockStartX, 0); x <= Math.min(lockEndX, lockSize-1); x++) {
                            lockQue.add(lock[y][x]);
                        }
                    }

                    for (int y = Math.max(keyStartY, 0); y <= Math.min(keyEndY, keySize-1); y++) {
                        for (int x = Math.max(keyStartX, 0); x <= Math.min(keyEndX, keySize-1); x++) {
                            keyQue.add(key[y][x]);
                        }
                    }
                    while (!lockQue.isEmpty() && !keyQue.isEmpty()) {
                        int curLock = lockQue.poll();
                        int curKey = keyQue.poll();
                        if (curLock == curKey) {
                            result = -1;
                            break;
                        } else if (curLock == 0 && curKey == 1) {
                            result++;
                        }
                    }
                    if (result == lockZeroCnt) {
                        return true;
                    }

                    lockStartX++;
                    lockEndX++;
                    keyStartX--;
                    keyEndX--;
                }
                lockStartY++;
                lockEndY++;
                keyStartY--;
                keyEndY--;
            }
            key = rotate90(key);
            index--;
        }
        return answer;
    }
    private int[][] rotate90(int[][] key){
        int[][] newKey = new int[key.length][key.length];
        for(int []item : key){
            for(int item_2: item){
                System.out.print(item_2 + " ");
            }
        }
        for(int i=0; i<key.length; i++){
            for(int j=0; j< key.length; j++){
                newKey[j][key.length-1 - i] = key[i][j];
            }
        }
        return newKey;
    }
}
