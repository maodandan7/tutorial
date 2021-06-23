import java.util.Stack;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/8/4
 * Description:两个栈实现一个队列
 */
public class Question6 {
    class CQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
            stack1 = s1;
            stack2 = s2;
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.empty() && stack1.empty()) {
                return -1;
            }
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        System.out.println(s.empty());
    }
}
