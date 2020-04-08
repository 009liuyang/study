package com.ly.study.algorithm.链表;

/**
 * @describe 查找单链表的中间节点，要求只能遍历一次链表
 * @author yang.liu
 * @date 2020-03-25
 */
public class LinkedMiddleIndexFind {

    static int findMiddle(Node first){
        Node fast = first;
        Node slow = first;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    static class Node{
        int data;
        Node next;
    }


    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        n1.data = 1;
        n2.data = 2;
        n3.data = 3;
        n4.data = 4;
        n5.data = 5;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(findMiddle(n1));
    }

}
