package com.patterns.iterator.impl;

import com.patterns.iterator.CustomIterable;
import com.patterns.iterator.CustomIterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomIteratorImpl implements CustomIterator {

  private List<String> list;
  private int index;

  public CustomIteratorImpl(List<String> list) {
    this.list = list;
    this.index = 0;
  }

  @Override
  public boolean hasNext() {
    return index < list.size();
  }

  @Override
  public Object next() {
    if(!hasNext()){
      throw new NoSuchElementException();
    }
    return list.get(index++);
  }
}
