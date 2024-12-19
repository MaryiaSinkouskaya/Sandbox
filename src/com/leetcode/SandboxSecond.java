package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SandboxSecond {
    public static void main(String[] args) {
        //task 33
//        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        System.out.println(deleteMiddle(list));

        //task34
//        System.out.println(getFinalState(new int[] {2,1,3,5,6}, 5,2));

        //task35
//        ListNode list = new ListNode(2, new ListNode(1,
//            new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
//        System.out.println(oddEvenList(list));

        //task36
//        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        System.out.println(reverseList(list));

        //task37
//        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        System.out.println(pairSum(list));

        //task38
//        TreeNode treeNode1 = new TreeNode(3,
//
//                                new TreeNode(9,
// new TreeNode(15, null, null), new TreeNode(7, null, null)),
//
//                                                                      new TreeNode(20,
//                                       new TreeNode(14, null, null), new TreeNode(17, null, null)));
//
//        TreeNode treeNode2 = new TreeNode(289,
//
//                              new TreeNode(37,
// new TreeNode(15, null, null), new TreeNode(7, null, null)),
//
//                                                        new TreeNode(87,
//                        new TreeNode(14, null, null), new TreeNode(17, null, null)));
//
//
//        System.out.println(leafSimilar(treeNode1, treeNode2));

//task39
//        TreeNode treeNode = new TreeNode(3,
//            new TreeNode(1,
//                new TreeNode(3, null, null), new TreeNode(1, null, null)),
//
//            new TreeNode(4,
//                new TreeNode(1, null, null), new TreeNode(5, null, null)));
//        System.out.println(goodNodes(treeNode));
//
//task40
//        int[] x = finalPrices(new int[] { 10, 1, 1, 6 });
//        System.out.println(x);

    }


    public static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            int j = i + 1;
            while (j < prices.length) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
                j++;
            }
        }
        return prices;
    }

    public static int goodNodes(TreeNode root) {
        return goodNodeCheck(root, 0, Integer.MIN_VALUE);
    }

    private static int goodNodeCheck(TreeNode node, int number, int maxValue) {
        if (node == null) {
            return number;
        }
        if (node.val >= maxValue) {
            maxValue = node.val;
            number++;
        }
        number = goodNodeCheck(node.left, number, maxValue);
        number = goodNodeCheck(node.right, number, maxValue);
        return number;
    }


    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();
        getLeafs(root1, leafs1);
        getLeafs(root2, leafs2);
        return isEqualLists(leafs1, leafs2);
    }

    private static void getLeafs(TreeNode treeNode, List<Integer> leafs){
        if (treeNode.left == null && treeNode.right == null) {
            leafs.add(treeNode.val);
        } else {
            if (treeNode.left != null) {
                getLeafs(treeNode.left, leafs);
            }
            if (treeNode.right != null) {
                getLeafs(treeNode.right, leafs);
            }
        }
    }

    private static boolean isEqualLists(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!Objects.equals(list1.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int pairSum(ListNode head) {
        int length = getLength(head);
        if (length == 2) {
            return head.val + head.next.val;
        }

        int middleIndex = length / 2;

        int counter = 0;
        ListNode node = head;
        while (counter < middleIndex - 1) {
            counter++;
            node = node.next;
        }
        node = reverseList(node.next);

        int sum = 0;
        while (head != null && node != null) {
            int tempSum = head.val + node.val;
            if (tempSum > sum) {
                sum = tempSum;
            }
            head = head.next;
            node = node.next;
        }

        return sum;


    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head.next;
        ListNode previous = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = head;
            head = current;

            previous.next = next;

            current = next;
        }
        return head;
    }


    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;

        ListNode initBuffNode = new ListNode(0);
        ListNode buffNode = initBuffNode;

        while (true) {
            if (current.next != null) {
                buffNode.next = current.next;
                buffNode = buffNode.next;

                current.next = current.next.next;

            }
            if (current.next == null) {
                break;
            }
            current = current.next;

        }
        buffNode.next = null;
        current.next = initBuffNode.next;
        return head;
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
        if (length == 1) {
            return null;
        }

        int middleIndex = length / 2;

        int counter = 0;
        ListNode node = head;
        while (counter < middleIndex - 1) {
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
