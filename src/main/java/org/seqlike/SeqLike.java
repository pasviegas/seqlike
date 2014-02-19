package org.seqlike;

import org.seqlike.functions.Fn;
import org.seqlike.functions.Fn2;

public interface SeqLike<K, T, E> {

  <R> T map(final Fn<E, R> function);

  <R> R reduce(final R initialValue, final Fn2<R, E, R> function);

  void each(Fn<E, Void> function);

  SeqLike<K, T, E> empty();

  public SeqLike<K, T, E> cons(E element);

}
