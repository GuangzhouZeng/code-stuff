public class Solution {
    public void setZeroes(int[][] matrix) {
        //time O(m*n) space O(1)
        boolean rowHas=false, colHas=false;
        if(matrix[0][0]==0){
            rowHas=true;colHas=true;
        }
        for(int i=0;colHas!=true&&i<matrix.length;i++){
            if(matrix[i][0]==0){
                colHas=true;
            }
        }
        for(int i=0;rowHas!=true&&i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                rowHas=true;
            }
        }
        
        for(int i=matrix.length-1;i>=1;i--){
            for(int j=matrix[i].length-1;j>=1;j--){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[0][j]==0||matrix[i][0]==0) matrix[i][j]=0;
            }
        }
        
        if(rowHas){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
        
        if(colHas){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        
    }
}