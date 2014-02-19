package org.seqlike.collections;

import java.util.HashMap;

public class EmptyMapSeqLike<K, V> extends MapSeqLike<K, V> {

  public EmptyMapSeqLike() {
    super(new HashMap<K, V>());
  }
}
