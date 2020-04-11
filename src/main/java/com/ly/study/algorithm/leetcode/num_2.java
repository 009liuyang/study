package com.ly.study.algorithm.leetcode;

/**
 * @desc
 * @Author liuyang
 * @Date 2020-04-11 10:45
 **/
public class num_2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;


        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        new num_2().addTwoNumbers(l1,l4);

        //String s = "abc";
        //System.out.println(new num_2().reverse(s));

    }


    /**
     * (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1 = "";
        String num2 = "";

        while (l1 != null){
            num1 = num1 + l1.val;
            l1 = l1.next;
        }

        while (l2 != null){
            num2 = num2 + l2.val;
            l2 = l2.next;
        }

        String revNum1 = reverse(num1);
        String revNum2 = reverse(num2);

        Integer num = Integer.valueOf(revNum1) + Integer.valueOf(revNum2);

        ListNode result = new ListNode(0);
        for (Character x : num.toString().toCharArray()){
            result.val = x;

        }

        return null;

    }

    public String reverse(String str){
        if(str.length() <= 1){
            return str;
        }
        String s = reverse(str.substring(1));
        s = s + str.charAt(0);
        return s;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}