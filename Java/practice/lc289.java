public class Solution {
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                genNextState(board,i,j);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]>>=1;
            }
        }
    }
    
    private void genNextState(int[][] board, int p, int q){
        int count=0;
        for(int i=Math.max(0,p-1);i<=Math.min(board.length-1,p+1);i++){
            for(int j=Math.max(0,q-1);j<=Math.min(board[i].length-1,q+1);j++){
                if(i==p&&j==q) continue;
                if((board[i][j]&1)==1){ //load
                    count++;
                }
            }
        }
        //System.out.println("count("+p+" "+q+"): "+count);
        if(board[p][q]==1&&(count==2||count==3)) board[p][q]|=(1<<1); //save
        if(board[p][q]==0&&count==3) board[p][q]|=(1<<1);
    }
}