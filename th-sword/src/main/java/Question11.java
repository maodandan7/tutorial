/**
 * User zhongmeng-lizhaohong
 * Date 2020/8/17
 * Description: 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2
 */
public class Question11 {
    public static class Solution {
        // you need to treat n as an unsigned value
        public static int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count++;
                n &= n - 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.hammingWeight(7));
    }
}
