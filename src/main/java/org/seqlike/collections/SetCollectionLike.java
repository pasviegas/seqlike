package org.seqlike.collections;

import org.seqlike.CollectionLike;

import java.util.Iterator;
import java.util.Set;

public class SetCollectionLike<E> implements CollectionLike<Set, E> {

  private final Set<E> set;

  public SetCollectionLike(Set<E> set) {
    this.set = set;
  }

  public void addAll(CollectionLike<Set, E> collection) {
    set.addAll(collection.concrete());
  }

  public void add(E element) {
    set.add(element);
  }

  public Set concrete() {
    return set;
  }

  public Iterator<E> iterator() {
    return set.iterator();
  }
}
