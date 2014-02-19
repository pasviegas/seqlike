package org.seqlike.functions;

public abstract class Fns {

  public static class ValueWrapper<E> {

    public E element;

    public ValueWrapper(E element) {
      this.element = element;
    }
  }
}
