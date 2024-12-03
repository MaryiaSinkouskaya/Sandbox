package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

  Queue<Integer> queue;


  public MyStack() {
    queue = new LinkedList<>();

  }

  public void push(int x) {

    queue.add(x);
  }

  public int pop() {
    int size = queue.size();
    Integer val;
    for (int i = 0; i < size - 1; ++i){
      val = queue.poll();
      queue.add(val);
    }
    return queue.poll();
  }

  public int top() {
    int size = queue.size();
    Integer val = 0;
    for (int i = 0; i < size; ++i){
      val = queue.poll();
      queue.add(val);
    }
    return val;

  }

  public boolean empty() {
    return queue.isEmpty();
  }

  /**
   * Your MyStack object will be instantiated and called as such:
   * MyStack obj = new MyStack();
   * obj.push(x);
   * int param_2 = obj.pop();
   * int param_3 = obj.top();
   * boolean param_4 = obj.empty();
   */
}
