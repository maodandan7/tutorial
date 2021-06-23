import java.util.HashMap;
import java.util.Map;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/8/5
 * Description:斐波那契数列
 */
public class Question7 {
    static class Solution {
        private final Integer mod = 1000000007;
        private Map<Integer, Integer> map = new HashMap<>();

        public int fib(int n) {
            int result = 0;
            if (n <= 1) {
                result = n;
            } else if (map.get(n) != null) {
                result = map.get(n);
            } else {
                result = fib(n - 1) + fib(n - 2);
                map.put(n, result);
            }
            return result % mod;
        }

        public int fib1(int n) {
            if (n < 2) {
                return n;
            }
            int pre = 0, cur = 1;
            for (int i = 0; i < n - 1; i++) {
                int sum = pre + cur;
                pre = cur;
                cur = sum % mod;
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(48));
        System.out.println(solution.fib1(48));
    }
}
