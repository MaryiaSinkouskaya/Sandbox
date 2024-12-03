package com.patterns.iterator.impl;

import com.patterns.iterator.CustomIterable;
import com.patterns.iterator.CustomIterator;
import java.util.List;

public class CustomIterableImpl implements CustomIterable {

  private List<String> list;

  public CustomIterableImpl(List<String> list) {
    this.list = list;
  }

  public String get(int index) {
    return list.get(index);
  }

  public void add(String element) {
    list.add(element);
  }

  @Override
  public CustomIterator iterator() {
    return new CustomIteratorImpl(list);
  }
}
