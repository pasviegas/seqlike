package org.seqlike;

import org.seqlike.collections.MapCollectionLike;
import org.seqlike.collections.MapSeqLike;
import org.seqlike.functions.Fn;
import org.seqlike.functions.Fn2;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public abstract class Maps {

  public static <K, V, K2, V2> Map<K2, V2> map(final Fn<Map.Entry<K, V>, Map.Entry<K2, V2>> function, Map<K, V> map) {
    return Seqs.<MapCollectionLike<K, V>, Map, Map.Entry<K, V>, Map.Entry<K2, V2>>map(function).apply(Seqs.of(map));
  }

  public static <K, V> void each(final Fn<Map.Entry<K, V>, Void> function, final Map<K, V> map) {
    Seqs.<MapCollectionLike<K, V>, Map, Map.Entry<K, V>>each(function).apply(Seqs.of(map));
  }

  public static <K, V, R> R reduce(final Fn2<R, Map.Entry<K, V>, R> function, final R initial, Map<K, V> map) {
    return Seqs.<MapCollectionLike<K, V>, Map, Map.Entry<K, V>, R>reduce(function, initial).apply(Seqs.of(map));
  }

  public static <K, V> MapSeqLike<K, V> filter(final Fn<Map.Entry<K, V>, Boolean> predicate, final Map<K, V> map) {
    return (MapSeqLike<K, V>) Seqs.filter(predicate, Seqs.of(map));
  }

  public static <K, V> Map<K, V> hash(Map.Entry<K, V>... entries) {
    return Seqs.reduce(new Fn2<Map<K, V>, Map.Entry<K, V>, Map<K, V>>() {
      public Map<K, V> apply(Map<K, V> fst, Map.Entry<K, V> snd) {
        fst.put(snd.getKey(), snd.getValue());
        return fst;
      }
    }, new HashMap<K, V>(), Seqs.of(asList(entries)));
  }

  public static <K, V> Map.Entry<K, V> entry(K key, V value) {
    return new Entry<K, V>(key, value);
  }

  private static class Entry<K, V> implements Map.Entry<K, V> {

    private final K key;
    private V value;

    private Entry(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }

    public V setValue(V object) {
      value = object;
      return value;
    }
  }
}
