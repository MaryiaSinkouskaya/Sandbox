package com.leetcode;

public class SandboxSecond {
    public static void main(String[] args) {
        //task 33
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(deleteMiddle(list));
    }

    public static ListNode deleteMiddle(ListNode head) {
        int length = getLength(head);
        if (length == 1){
            return null;
        }

        int middleIndex = length / 2 ;

        int counter = 0;
        ListNode node = head;
        while (counter < middleIndex -1){
            counter++;
            node = node.next;
        }
        node.next = node.next.next;

        return head;
    }

    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

}
