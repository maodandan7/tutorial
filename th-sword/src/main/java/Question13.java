import java.util.Base64;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/8/20
 * Description:实现函数double Power(double base, int exponent)，求base的exponent次方
 */
public class Question13 {
    public static double myPow(double x, int n) {
        double result = 1.;
        if (n > 0) {
            result = power(x, n);
        }
        if (n < 0) {
            if (x == 0.) {
                throw new IllegalArgumentException("参数不合法");
            }
            result = x * power(1 / x, -n - 1);
        }
        return result;
    }

    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = power(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        System.out.println(-a - 1);
        System.out.println(myPow(1.00000, a));
    }
}
