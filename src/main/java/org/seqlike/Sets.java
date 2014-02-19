package org.seqlike;

import org.seqlike.collections.SetCollectionLike;
import org.seqlike.collections.SetSeqLike;
import org.seqlike.functions.Fn;
import org.seqlike.functions.Fn2;

import java.util.Set;

public abstract class Sets {

  public static <E, R> Set<R> map(final Fn<E, R> function, Set<E> set) {
    return Seqs.<SetCollectionLike<E>, Set, E, R>map(function).apply(Seqs.of(set));
  }

  public static <E> void each(final Fn<E, Void> function, final Set<E> set) {
    Seqs.<SetCollectionLike<E>, Set, E>each(function).apply(Seqs.of(set));
  }

  public static <E, R> R reduce(final Fn2<R, E, R> function, final R initial, Set<E> set) {
    return Seqs.<SetCollectionLike<E>, Set, E, R>reduce(function, initial).apply(Seqs.of(set));
  }

  public static <E> SetSeqLike<E> filter(final Fn<E, Boolean> predicate, final Set<E> set) {
    return (SetSeqLike<E>) Seqs.filter(predicate, Seqs.of(set));
  }
}
