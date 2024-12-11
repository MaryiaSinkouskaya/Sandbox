package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

  private Queue<Integer> queue;

  public RecentCounter() {
    queue = new LinkedList<>();
  }

  public int ping(int t) {
    queue.add(t);
    return (int) queue.stream().filter(val -> val >= t - 3000).count();
  }
}
