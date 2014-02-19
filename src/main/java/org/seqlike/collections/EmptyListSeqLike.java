package org.seqlike.collections;

import java.util.ArrayList;

public class EmptyListSeqLike<E> extends ListSeqLike<E> {

  public EmptyListSeqLike() {
    super(new ArrayList<E>());
  }
}
