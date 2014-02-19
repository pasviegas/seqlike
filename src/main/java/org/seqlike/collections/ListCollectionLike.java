package org.seqlike.collections;

import org.seqlike.CollectionLike;

import java.util.Iterator;
import java.util.List;

public class ListCollectionLike<E> implements CollectionLike<List, E> {

  private final List<E> list;

  public ListCollectionLike(List<E> list) {
    this.list = list;
  }

  public void addAll(CollectionLike<List, E> collection) {
    list.addAll(collection.concrete());
  }

  public void add(E element) {
    list.add(element);
  }

  public Iterator<E> iterator() {
    return list.iterator();
  }

  public List concrete() {
    return list;
  }
}
