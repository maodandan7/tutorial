package com.naive.tutorial;

import java.util.Stack;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/10/21
 * Description:1.单链表增删改查 2.单链表倒数第k个节点打印 3.单链表的反转 4.从尾到头打印单链表 5.合并两个有序的单链表
 */
public class SingleLinkedListDemo {

    static class HeroNode {
        private Integer no;
        private String name;
        private String nickName;
        private HeroNode next;

        public HeroNode(Integer no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        public String toString() {
            return "[no:" + no + "," + "name:" + name + ", nickName:" + nickName + "]";
        }
    }

    static class SingleLinkedList {
        private HeroNode head = new HeroNode(0, "", "");

        public void add(HeroNode heroNode) {
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = heroNode;
        }

        public void list() {
            HeroNode temp = head.next;
            if (temp == null) {
                System.out.println("链表为空");
                return;
            }
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }

        public void addWithOrder(HeroNode heroNode) {
            HeroNode temp = head;
            boolean flag = true;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no == heroNode.no) {
                    flag = false;
                    break;
                } else if (temp.next.no > heroNode.no) {
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                heroNode.next = temp.next;
                temp.next = heroNode;
            } else {
                System.out.println("插入失败，存在相同no");
            }
        }

        public void update(HeroNode heroNode) {
            HeroNode cur = head.next;
            boolean flag = false;
            while (true) {
                if (cur == null) {
                    break;
                } else if (cur.no == heroNode.no) {
                    flag = true;
                    break;
                }
                cur = cur.next;
            }
            if (flag) {
                cur.name = heroNode.name;
                cur.nickName = heroNode.nickName;
            } else {
                System.out.println("未找到对应no的英雄");
            }
        }

        public void del(int no) {
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no == no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.next = temp.next.next;
            } else {
                System.out.println("未找到对应no的英雄");
            }
        }

        public HeroNode reverseK(int k) {
            if (k < 0) {
                System.out.println("k应为正整数");
                return null;
            }
            HeroNode rear = head.next;
            HeroNode front = rear;
            int count = 0;
            while (true) {
                if(front == null) {
                    break;
                }
                if(count >= k) {
                    rear = rear.next;
                }
                front = front.next;
                count++;
            }
           if(k > count) {
               System.out.println("k大于链表的真实长度了");
               return null;
           }
           return rear;
        }

        public void reversePrint() {
            if(head.next == null) {
                System.out.println("链表为空");
                return;
            }
            Stack<HeroNode> stack = new Stack<>();
            HeroNode temp = head.next;
            while (true) {
                if(temp == null) {
                    break;
                }
                stack.push(temp);
                temp = temp.next;
            }
            while(stack.size() > 0) {
                System.out.println(stack.pop());
            }
        }

        public void reverse() {
            if(head.next == null || head.next.next == null) {
                return;
            }
            HeroNode cur = head.next.next;
            head.next.next = null;
            while (true) {
                if(cur == null) {
                    break;
                }
                HeroNode temp = cur.next;
                cur.next = head.next;
                head.next = cur;
                cur = temp;
            }
        }
    }

    public static void main(String[] args) {
        HeroNode head = new HeroNode(0, "", "");
        HeroNode h1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode h2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode h3 = new HeroNode(3, "吴用", "智多星");
        HeroNode h4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode h5 = new HeroNode(5, "林冲冲", "爆头");
        SingleLinkedList list = new SingleLinkedList();
        list.addWithOrder(h3);
        list.addWithOrder(h1);
        list.addWithOrder(h4);
        list.addWithOrder(h2);
        list.list();
        list.update(h5);
        list.list();
        list.del(5);
        list.list();
        System.out.println(list.reverseK(5));

        list.reversePrint();
        list.reverse();
        list.list();
    }



}
