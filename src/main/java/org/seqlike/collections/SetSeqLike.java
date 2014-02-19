package org.seqlike.collections;

import org.seqlike.SeqLike;

import java.util.HashSet;
import java.util.Set;

public class SetSeqLike<E> extends CollectionSeqLike<SetCollectionLike<E>, Set, E> {

  private final SetCollectionLike<E> set;

  public SetSeqLike(Set<E> set) {
    this(new SetCollectionLike<E>(set));
  }

  public SetSeqLike(SetCollectionLike<E> collectionLike) {
    this.set = collectionLike;
  }

  @Override
  protected SetCollectionLike<E> collection() {
    return set;
  }

  @Override
  protected SetCollectionLike<E> zero() {
    return new SetCollectionLike<E>(new HashSet<E>());
  }

  public SeqLike<SetCollectionLike<E>, Set, E> empty() {
    return new SetSeqLike<E>(zero());
  }

  public SeqLike<SetCollectionLike<E>, Set, E> cons(E element) {
    return new SetSeqLike<E>(add(element));
  }
}
