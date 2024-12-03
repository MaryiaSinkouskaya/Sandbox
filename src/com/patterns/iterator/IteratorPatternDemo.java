package com.patterns.iterator;

import com.patterns.iterator.impl.CustomIterableImpl;
import java.util.Arrays;
import java.util.List;

public class IteratorPatternDemo {
  public static void main(String[] args) {

    List<String> list = Arrays.asList("aaa", "sszxcss", "dcnkncd", "dcs", "nscank");
    CustomIterableImpl customIterable = new CustomIterableImpl(list);
    CustomIterator customIterator = customIterable.iterator();

    while (customIterator.hasNext()) {
      System.out.println(customIterator.next());
    }
  }
}
