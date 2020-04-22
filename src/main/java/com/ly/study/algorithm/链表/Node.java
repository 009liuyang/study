package com.ly.study.algorithm.链表;

/**
 * @describe
 * @author yang.liu
 * @date 2020-04-08
 */
public class Node {
    Object data;
    Node next;

    public Node(Object data){
        this.data = data;
    }
}

class reverse{

    /**
     * 单链表反转 - 非递归
     * @param head
     * @return
     */
    public static Node reverse1(Node head){
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null){
            return head;
        }
        //前一个节点指针
        Node pre = null;
        //当前节点指针
        Node cur = head;

        while (cur != null){
            Node next = cur.next;//next 指向下一个节点
            cur.next = pre;//将当前节点next域指向前一个节点
            pre = cur;//preNode 指针向后移动
            cur = next;//curNode指针向后移动
        }
        return pre;
    }


    public static Node reverse2(Node head) {

        if(head == null || head.next == null){
            return head;
        }
        // 遍历到链表尾部
        Node newHead = reverse2(head.next);
        // 反转
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        a.next = b;
        b.next = c;
        c.next = d;

        reverse2(a);
    }
}

/**
 * 删除链表倒数第N个元素 要求只能遍历一遍
 */
class deleteNDesc{
    public static void main(String[] args) {
    }

    void deleteN(Node node, int descN){

        Node n1 = new Node(0);
        Node n2 = new Node(0);

        n1.next = node;
        n2.next = node;

        for (int i=1; i<descN; i++){
            n1 = n1.next;
        }


        while (n1 != null){
            n1 = n1.next;
            n2 = n2.next;
        }

        n2.next = n2.next.next;
    }
}

class marge2list{

   static class InNode{
        int val;
        InNode next;
        public InNode(int val){
            this.val = val;
        }
    }

    static InNode marge2list(InNode n1, InNode n2){

        InNode head = new InNode(0);
        InNode newHead = head;
        while (n1!=null && n2!=null){
            if(n1.val > n2.val){
                InNode node = new InNode(n2.val);
                n2 = n2.next;
                while (head != null && head.next!=null){
                    head = head.next;
                }
                head.next = node;
            }else if(n1.val < n2.val){
                InNode node = new InNode(n1.val);
                n1 = n1.next;
                while (head!=null && head.next!=null){
                    head = head.next;
                }
                head.next = node;
            }
        }


        if (n1 != null){
            while (head!=null && head.next!=null){
                head = head.next;
            }
            head.next = n1;
        }

        if (n2 != null){
            while (head!=null && head.next!=null){
                head = head.next;
            }
            head.next = n2;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        InNode i1 = new InNode(1);
        InNode i3 = new InNode(3);
        i1.next = i3;

        InNode i2 = new InNode(2);

        InNode result = marge2list(i1, i2);
        System.out.println(result);
    }
}
