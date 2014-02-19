package org.seqlike.collections;

import org.seqlike.SeqLike;

import java.util.HashMap;
import java.util.Map;

public class MapSeqLike<K, V> extends CollectionSeqLike<MapCollectionLike<K, V>, Map, Map.Entry<K, V>> {

  private final MapCollectionLike<K, V> map;

  public MapSeqLike(Map<K, V> map) {
    this(new MapCollectionLike<K, V>(map));
  }

  public MapSeqLike(MapCollectionLike<K, V> collectionLike) {
    this.map = collectionLike;
  }

  @Override
  protected MapCollectionLike<K, V> collection() {
    return map;
  }

  @Override
  protected MapCollectionLike<K, V> zero() {
    return new MapCollectionLike<K, V>(new HashMap<K, V>());
  }

  public SeqLike<MapCollectionLike<K, V>, Map, Map.Entry<K, V>> empty() {
    return new MapSeqLike<K, V>(zero());
  }

  public SeqLike<MapCollectionLike<K, V>, Map, Map.Entry<K, V>> cons(Map.Entry<K, V> element) {
    return new MapSeqLike<K, V>(add(element));
  }

}
