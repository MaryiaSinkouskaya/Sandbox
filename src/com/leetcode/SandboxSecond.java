package com.leetcode;

public class SandboxSecond {
    public static void main(String[] args) {
        //task 33
//        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        System.out.println(deleteMiddle(list));

        //task34
        System.out.println(getFinalState(new int[] {2,1,3,5,6}, 5,2));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int index = getMinIndex(nums);
            nums[index] *= multiplier;
        }
        return nums;
    }

    private static int getMinIndex(int[] nums) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                index = i;
                min = nums[i];
            }
        }
        return index;
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
