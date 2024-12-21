package com.leetcode;

import java.util.PriorityQueue;

public class SmallestInfiniteSet {

    private PriorityQueue<Integer> priorityQueue;
    private int min;

    public SmallestInfiniteSet() {
        priorityQueue = new PriorityQueue<>();
        min = 1;
    }

    public int popSmallest() {
        if (priorityQueue.isEmpty()) {
            min += 1;
            return min - 1;
        } else {
            return priorityQueue.poll();
        }
    }

    public void addBack(int num) {
        if (min > num && !priorityQueue.contains(num)) {
            priorityQueue.add(num);
        }
    }

}
