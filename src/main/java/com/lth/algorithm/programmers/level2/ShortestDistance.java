package com.lth.algorithm.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class ShortestDistance {
    public static void main(String[] args) {
        System.out.println(solution(new int [][]{{1},{1}}));
    }
    //최단경로를 구하는 것이기 때문에 BFS 알고리즘 필요
    //현재 방문 위치를 꺼낸다음 다음 방문 경로를 queue(cost+1 필요)에 넣고 해당 위치를 visit 처리
    //최초고 queue 데이터가 ySize, xSize 를 만족하는 위치가 나오면 해당 cost가 결과
    //마지막 queue 데이터까지 위의 조건을 만족하지 않으면 해당 데이터는 ySize, xSize 경로에 도달할 수 없음
    static public int solution(int[][] maps) {
        int answer = 0;
        int ySize = maps.length;
        int xSize = maps[0].length;
        boolean [][]  checkVisited= new boolean[ySize][xSize];

        answer = findDistanceBfs(maps, checkVisited, ySize, xSize);
        return answer;
    }

    static int findDistanceBfs(int[][]maps, boolean[][] checkVisited, int ySize, int xSize){
        Queue<Node> nodes= new LinkedList<>();
        nodes.add(new Node(0, 0, 1));
        checkVisited[0][0] = true;

        while(!nodes.isEmpty()){
            Node curNode = nodes.poll();
            if(curNode.y == ySize-1 && curNode.x == xSize-1){
                return curNode.cost;
            }
            if(curNode.x < xSize-1 && !checkVisited[curNode.y][curNode.x+1] && maps[curNode.y][curNode.x+1] == 1){
                nodes.add(new Node(curNode.y, curNode.x+1, curNode.cost + 1));
                checkVisited[curNode.y][curNode.x+1] = true;
            }
            if(curNode.x != 0 && !checkVisited[curNode.y][curNode.x-1] && maps[curNode.y][curNode.x-1] == 1){
                nodes.add(new Node(curNode.y, curNode.x-1, curNode.cost + 1));
                checkVisited[curNode.y][curNode.x-1] = true;
            }
            if(curNode.y < ySize-1 && !checkVisited[curNode.y+1][curNode.x] && maps[curNode.y+1][curNode.x] == 1){
                nodes.add(new Node(curNode.y + 1, curNode.x, curNode.cost + 1));
                checkVisited[curNode.y+1][curNode.x] = true;
            }
            if(curNode.y != 0 && !checkVisited[curNode.y-1][curNode.x] && maps[curNode.y-1][curNode.x] == 1){
                nodes.add(new Node(curNode.y - 1, curNode.x, curNode.cost + 1));
                checkVisited[curNode.y-1][curNode.x] = true;
            }
        }
        return -1;
    }
    public static class Node {
        int y;
        int x;
        int cost;

        public Node( int y, int x, int cost){
            this.y=y;
            this.x=x;
            this.cost = cost;
        }
    }
    static void findDistanceDfs(int[][]maps, boolean[][] checkDistance, int y, int x, int nowResult, int ySize, int xSize){
        //System.out.println("### y : " + y);
        //System.out.println("### x : " + x);
        //System.out.println("### checkDistance : " + Arrays.deepToString(checkDistance));
        int localResult = 0;
        if(x < xSize-1 && !checkDistance[y][x+1] && maps[y][x+1] == 1){
            checkDistance[y][x+1] = true;
            findDistanceDfs(maps, checkDistance, y, x+1, ++nowResult, ySize, xSize);
            checkDistance[y][x+1] = false;
        }
        if(x != 0 && !checkDistance[y][x-1] && maps[y][x-1] == 1){
            checkDistance[y][x-1] = true;
            findDistanceDfs(maps, checkDistance, y, x-1, ++nowResult, ySize, xSize);
            checkDistance[y][x-1] = false;
        }
        if(y < ySize-1 && !checkDistance[y+1][x] && maps[y+1][x] == 1){
            checkDistance[y+1][x] = true;
            findDistanceDfs(maps, checkDistance, y+1, x, ++nowResult, ySize, xSize);
            checkDistance[y+1][x] = false;
        }
        if(y != 0 && !checkDistance[y-1][x] && maps[y-1][x] == 1){
            checkDistance[y-1][x] = true;
            findDistanceDfs(maps, checkDistance, y-1, x, ++nowResult, ySize, xSize);
            checkDistance[y-1][x] = false;
        }
    }
}
