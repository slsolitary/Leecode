package hot100;

import java.util.Arrays;

/**
 * @author heyao
 * @date 2023-08-02 11:27
 * 73.矩阵置零
 * 利用首行和首列来记录行、列的置零情况
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //记录首行&首列是否需要被置零
        boolean r = false, c = false;
        for(int i = 0;i < m;i++){
            if(matrix[i][0] == 0){
                r = true;
                break;
            }
        }
        for(int j = 0;j < n;j++){
            if(matrix[0][j] == 0){
                c = true;
                break;
            }
        }
        //将置零信息存在首行首列
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //置零
        for(int i = 1;i < m;i++){
            if(matrix[i][0] == 0){
                Arrays.fill(matrix[i],0);
            }
        }
        for(int j = 1;j < n;j++){
            if(matrix[0][j] == 0){
                for(int i = 1;i < m;i++){
                    matrix[i][j]=0;
                }
            }
        }
        if(r){
            for(int i = 0;i < m;i++){
                matrix[i][0]=0;
            }
        }
        if(c){
            Arrays.fill(matrix[0],0);
        }
    }

}
