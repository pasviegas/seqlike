package org.seqlike;

import java.util.Collection;

public interface CollectionLike<T extends Collection, E> extends Iterable<E> {

  public void addAll(CollectionLike<T, E> collection);

  public void add(E element);

  public T concrete();
}
