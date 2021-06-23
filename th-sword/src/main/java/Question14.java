/**
 * User zhongmeng-lizhaohong
 * Date 2020/8/21
 * Description:输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999
 */
public class Question14 {
    public int[] printNumbers(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        int maxNum = (int) Math.pow(10, n) - 1;
        int[] result = new int[maxNum];
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = 0;
        }
        for (int i = 0; i < maxNum; i++) {
            result[i] = increment(numbers);
        }
        return result;
    }

    public int increment(int[] numbers) {
        int takeOver = 0;
        int sum = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            sum = takeOver + numbers[i];
            if (i == numbers.length - 1) {
                sum++;
            }
            if (sum >= 10) {
                numbers[i] = sum - 10;
                takeOver = 1;
            } else {
                numbers[i] = sum;
                takeOver = 0;
            }
        }
        boolean isBeginWith0 = true;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0 || !isBeginWith0) {
                isBeginWith0 = false;
            }
            if (!isBeginWith0) {
                str.append(numbers[i]);
            }
        }
        return Integer.parseInt(String.valueOf(str));
    }

}
