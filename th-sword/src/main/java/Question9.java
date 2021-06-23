/**
 * User zhongmeng-lizhaohong
 * Date 2020/8/8
 * Description:
 */
public class Question9 {
    static class Solution {
        public int minArray(int[] numbers) {
            if (numbers == null) {
                throw new IllegalArgumentException();
            }
            int min = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] >= min) {
                    continue;
                } else {
                    min = numbers[i];
                    break;
                }
            }
            return min;
        }

        private int minArray1(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                throw new IllegalArgumentException();
            }
            int leftIndex = 0;
            int rightIndex = numbers.length - 1;
            int midIndex = leftIndex;
            while (numbers[leftIndex] >= numbers[rightIndex]) {
                if (rightIndex - leftIndex <= 1) {
                    midIndex = rightIndex;
                    break;
                }
                midIndex = (leftIndex + rightIndex) / 2;
                if(numbers[leftIndex] == numbers[rightIndex] && numbers[midIndex] == numbers[leftIndex]) {
                    return minInOrder(numbers, leftIndex, rightIndex);
                }
                if(numbers[midIndex] >= numbers[leftIndex]) {
                    leftIndex = midIndex;
                }
                if(numbers[midIndex] <= numbers[rightIndex]) {
                    rightIndex = midIndex;
                }
            }
            return numbers[midIndex];
        }

        private int minInOrder(int[] numbers, int leftIndex, int rightIndex) {
            int min = numbers[leftIndex];
            for(int i=leftIndex+1;i<=rightIndex;i++) {
                if(numbers[i] < min) {
                    min = numbers[i];
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[5];
        numbers[0] = 2;
        numbers[1] = 2;
        numbers[2] = 2;
        numbers[3] = 0;
        numbers[4] = 1;
        Solution solution = new Solution();
        System.out.println(solution.minArray1(numbers));
    }
}
