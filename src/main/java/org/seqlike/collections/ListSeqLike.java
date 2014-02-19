package org.seqlike.collections;

import org.seqlike.SeqLike;

import java.util.ArrayList;
import java.util.List;

public class ListSeqLike<E> extends CollectionSeqLike<ListCollectionLike<E>, List, E> {

  private final ListCollectionLike<E> list;

  public ListSeqLike(List<E> list) {
    this(new ListCollectionLike<E>(list));
  }

  public ListSeqLike(ListCollectionLike<E> collectionLike) {
    this.list = collectionLike;
  }

  public SeqLike<ListCollectionLike<E>, List, E> empty() {
    return new ListSeqLike<E>(zero());
  }

  @Override
  protected ListCollectionLike<E> collection() {
    return list;
  }

  @Override
  protected ListCollectionLike<E> zero() {
    return new ListCollectionLike<E>(new ArrayList<E>());
  }

  public SeqLike<ListCollectionLike<E>, List, E> cons(E element) {
    return new ListSeqLike<E>(add(element));
  }
}
