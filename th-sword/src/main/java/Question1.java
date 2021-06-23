/**
 * User zhongmeng-lizhaohong
 * Date 2020/5/19
 * Description:二维数组的查找
 */
public class Question1 {

    public boolean Find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while(row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (target > matrix[row][column]) {
                row++;
            } else if (target < matrix[row][column]) {
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = null;
        System.out.println(array.length);
    }
}
