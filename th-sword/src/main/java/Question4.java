import javax.sound.midi.Soundbank;
import java.util.Stack;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/7/2
 * Description:输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Question4 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int size = stack.size();
        int[] target = new int[size];
        for (int i = 0; i < size; i++) {
           target[i] = stack.pop().val;
        }
        return target;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);

        int[] result = reversePrint(listNode);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
