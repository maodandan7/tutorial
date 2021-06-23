package com.naive.tutorial;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/10/20
 * Description:稀疏数组的使用
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[4][5] = 2;
        //原始二维数组转稀疏数组
        int sum = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }

        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.print(sparseArray[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }

        //稀疏数组转二维数组
        int[][] chessArray2 = new int[11][11];
        for(int i=1;i<sparseArray.length;i++) {
           chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int i = 0; i < chessArray2.length; i++) {
            for (int j = 0; j < chessArray2[i].length; j++) {
                System.out.print(chessArray2[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }

    }
}
