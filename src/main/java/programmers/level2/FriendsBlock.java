package programmers.level2;


public class FriendsBlock {
    public static void main(String[] args) {
        System.out.println(solution(4,	5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }
    static public int solution(int m, int n, String[] board) {
        boolean[][]deleteFlg = new boolean[m-1][n-1];
        Character[][]block = new Character [m][n];
        int curDeleteCnt = 1;
        int totalDeleteCnt = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                block[i][j] = board[i].charAt(j);
            }
        }
        while (curDeleteCnt!=0){
            curDeleteCnt = 0;
            //2*2 동일 블록 체크
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(checkBlock(block, i, j)){
                        deleteFlg[i][j] = true;
                        curDeleteCnt++;
                    }
                }
            }

            //2*2 동일 블록 삭제
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(deleteFlg[i][j])
                        deleteBlock(block, i, j);
                }
            }

            //하나의 열씩 빈곳 채우기
            for(int i=0; i<n; i++){
                fillBlock(block, i);
            }
            deleteFlg = new boolean[m-1][n-1];
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(block[i][j].equals(' '))
                    totalDeleteCnt++;
            }
        }
        return totalDeleteCnt;
    }

    static public boolean checkBlock(Character[][]block, int y, int x){
        int [][] sumNumAry = {{0,0}, {0,1}, {1,0}, {1,1}};
        String temp = "";
        for(int i=0; i<sumNumAry.length-1; i++){
            if(!block[y + sumNumAry[i][0]][x + sumNumAry[i][1]].equals(' ')){
                if(!block[y + sumNumAry[i][0]][x + sumNumAry[i][1]].equals(block[y + sumNumAry[i + 1][0]][x + sumNumAry[i + 1][1]])){
                    return false;
                }
            } else
                return false;
        }
        return true;
    }

    static public void deleteBlock(Character[][]block, int y, int x){
        int [][] sumNumAry = {{0,0}, {0,1}, {1,0}, {1,1}};
        for (int[] ints : sumNumAry) {
            block[y + ints[0]][x + ints[1]] = ' ';
        }
    }

     static public void fillBlock(Character[][]block, int x){
        for(int i = block.length-1; i>=0; i--){
            if(block[i][x].equals(' ')){
                for(int j=i - 1; j>=0; j--){
                    if(!block[j][x].equals(' ')){
                        block[i][x] = block[j][x];
                        block[j][x] = ' ';
                        if(j == 0){
                            return;
                        }
                        break;
                    }
                }
            }
        }
     }
}
