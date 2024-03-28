package com.programmers.level3;

/**
 * 모든 경로를 찾는다.
 * 이동할 곳이 없을 경우
 */
public class SchoolRouteFinder {
    public static void main(String[] args) {
        SchoolRouteFinder schoolRouteFinder = new SchoolRouteFinder();
        System.out.println(schoolRouteFinder.solution(4,	3, new int[][]{{2, 2}}));
    }
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for(int[] puddle : puddles){
            map[puddle[1]-1][puddle[0]-1] = -1;
        }
        map[0][0] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //시작점
                if(i==0 && j==0 )
                    continue;
                //물에잠긴땅
                if(map[i][j] == -1)
                    continue;

                //위에 값
                if(i>0 && map[i-1][j] != -1){
                    map[i][j] +=  map[i-1][j]%1000000007;
                }
                //왼쪽값
                if(j>0 && map[i][j-1] != -1){
                    map[i][j] +=  map[i][j-1]%1000000007;
                }
            }
        }
        return map[n-1][m-1]%1000000007;
    }
}
