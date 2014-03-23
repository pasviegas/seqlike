package org.seqlike;

public interface CollectionLike<T, E> extends Iterable<E> {

  public void addAll(CollectionLike<T, E> collection);

  public void add(E element);

  public T concrete();
}
