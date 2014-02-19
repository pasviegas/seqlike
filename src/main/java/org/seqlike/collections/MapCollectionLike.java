package org.seqlike.collections;

import org.seqlike.CollectionLike;

import java.util.Iterator;
import java.util.Map;

public class MapCollectionLike<K, V> implements CollectionLike<Map, Map.Entry<K, V>> {

  private final Map<K, V> map;

  public MapCollectionLike(Map<K, V> map) {
    this.map = map;
  }

  @Override
  public void addAll(CollectionLike<Map, Map.Entry<K, V>> collection) {
    map.putAll(collection.concrete());
  }

  @Override
  public void add(Map.Entry<K, V> element) {
    map.put(element.getKey(), element.getValue());
  }

  @Override
  public Iterator<Map.Entry<K, V>> iterator() {
    return map.entrySet().iterator();
  }

  @Override
  public Map concrete() {
    return map;
  }
}
