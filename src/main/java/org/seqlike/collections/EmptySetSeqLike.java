package org.seqlike.collections;

import java.util.HashSet;

public class EmptySetSeqLike<E> extends SetSeqLike<E> {

  public EmptySetSeqLike() {
    super(new HashSet<E>());
  }
}
