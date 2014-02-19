package org.seqlike;

import org.seqlike.collections.ListCollectionLike;
import org.seqlike.collections.ListSeqLike;
import org.seqlike.functions.Fn;
import org.seqlike.functions.Fn2;

import java.util.List;

public abstract class Lists {

  public static <E, R> List<R> map(final Fn<E, R> function, List<E> list) {
    return Seqs.<ListCollectionLike<E>, List, E, R>map(function).apply(Seqs.of(list));
  }

  public static <E> void each(final Fn<E, Void> function, final List<E> list) {
    Seqs.<ListCollectionLike<E>, List, E>each(function).apply(Seqs.of(list));
  }

  public static <E, R> R reduce(final Fn2<R, E, R> function, final R initial, List<E> list) {
    return Seqs.<ListCollectionLike<E>, List, E, R>reduce(function, initial).apply(Seqs.of(list));
  }

  public static <E> ListSeqLike<E> filter(final Fn<E, Boolean> predicate, final List<E> list) {
    return (ListSeqLike<E>) Seqs.filter(predicate, Seqs.of(list));
  }
}
