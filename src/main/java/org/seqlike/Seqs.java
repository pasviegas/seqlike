package org.seqlike;

import org.seqlike.collections.*;
import org.seqlike.functions.Fn;
import org.seqlike.functions.Fn2;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;

public abstract class Seqs {

  public static <E> SeqLike<ListCollectionLike<E>, List, E> of(final E... list) {
    return list == null || list.length == 0 ? new EmptyListSeqLike<E>() : new ListSeqLike<E>(asList(list));
  }

  public static <E> SeqLike<SetCollectionLike<E>, Set, E> of(final Set<E> set) {
    return set == null || set.isEmpty() ? new EmptySetSeqLike<E>() : new SetSeqLike<E>(set);
  }

  public static <E> SeqLike<ListCollectionLike<E>, List, E> of(final List<E> list) {
    return list == null || list.isEmpty() ? new EmptyListSeqLike<E>() : new ListSeqLike<E>(list);
  }

  public static <K, V> SeqLike<MapCollectionLike<K, V>, Map, Map.Entry<K, V>> of(final Map<K, V> map) {
    return map == null || map.isEmpty() ? new EmptyMapSeqLike<K, V>() : new MapSeqLike<K, V>(map);
  }

  public static <K, T, E, R> T map(final Fn<E, R> function, SeqLike<K, T, E> seq) {
    return Seqs.<K, T, E, R>map(function).apply(seq);
  }

  public static <K, T, E> void each(final Fn<E, Void> function, final SeqLike<K, T, E> seq) {
    Seqs.<K, T, E>each(function).apply(seq);
  }

  public static <K, T, E, R> R reduce(final Fn2<R, E, R> function, final R initial, SeqLike<K, T, E> seq) {
    return Seqs.<K, T, E, R>reduce(function, initial).apply(seq);
  }

  public static <K, T, E, R> Fn<SeqLike<K, T, E>, R> reduce(final Fn2<R, E, R> function, final R initial) {
    return Seqs.<K, T, E, R>reduce(function).apply(initial);
  }

  public static <K, T, E> SeqLike<K, T, E> filter(final Fn<E, Boolean> predicate, final SeqLike<K, T, E> seq) {
    return Seqs.<K, T, E>filter(predicate).apply(seq);
  }

  public static <K, T, E> Fn<SeqLike<K, T, E>, Void> each(final Fn<E, Void> function) {
    return new Fn<SeqLike<K, T, E>, Void>() {
      public Void apply(SeqLike<K, T, E> seq) {
        seq.each(function);
        return null;
      }
    };
  }

  public static <K, T, E> Fn<SeqLike<K, T, E>, SeqLike<K, T, E>> filter(final Fn<E, Boolean> predicate) {
    return new Fn<SeqLike<K, T, E>, SeqLike<K, T, E>>() {
      public SeqLike<K, T, E> apply(SeqLike<K, T, E> fst) {
        return reduce(new Fn2<SeqLike<K, T, E>, E, SeqLike<K, T, E>>() {
          public SeqLike<K, T, E> apply(SeqLike<K, T, E> fst, E snd) {
            if (predicate.apply(snd)) {
              return fst.cons(snd);
            }
            return fst;
          }
        }, fst.empty(), fst);
      }
    };
  }

  public static <K, T, E, R> Fn<SeqLike<K, T, E>, T> map(final Fn<E, R> function) {
    return new Fn<SeqLike<K, T, E>, T>() {
      public T apply(SeqLike<K, T, E> seq) {
        return seq.map(function);
      }
    };
  }

  public static <K, T, E, R> Fn<R, Fn<SeqLike<K, T, E>, R>> reduce(final Fn2<R, E, R> function) {
    return new Fn<R, Fn<SeqLike<K, T, E>, R>>() {
      public Fn<SeqLike<K, T, E>, R> apply(final R initial) {
        return new Fn<SeqLike<K, T, E>, R>() {
          public R apply(SeqLike<K, T, E> seq) {
            return seq.reduce(initial, function);
          }
        };
      }
    };
  }
}
