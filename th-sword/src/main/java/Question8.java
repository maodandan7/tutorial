import sun.jvm.hotspot.runtime.ResultTypeFinder;

import java.util.HashMap;
import java.util.Map;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/8/6
 * Description:青蛙跳台阶问题
 */
public class Question8 {

    private static Map<Integer, Integer> map = new HashMap<>();

    static class Solution {
        public int numWays(int n) {
            if (n <= 1) {
                return 1;
            }
            return (numWays(n - 1) + numWays(n - 2)) % 1000000007;
        }

        public int numWays1(int n) {
            if (n <= 1) {
                return 1;
            }
            int result = 0;
            if (map.get(n) != null) {
                result = map.get(n);
            } else {
                result = numWays1(n - 1) + numWays1(n - 2);
                map.put(n, result);
            }
            return result % 1000000007;
        }

        public int numWays2(int n) {
            if (n <= 1) {
                return 1;
            }
            int pre = 1, cur = 1;
            for (int i = 0; i < n - 1; i++) {
                int sum = pre + cur;
                pre = cur;
                cur = sum % 1000000007;
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 100;
        int w1 = solution.numWays(n);
        int w2 = solution.numWays1(n);
        int w3 = solution.numWays2(n);
        System.out.println(w1 + "," + w2 + "," +w3);
    }
}
