package org.seqlike.collections;

import org.seqlike.CollectionLike;
import org.seqlike.SeqLike;
import org.seqlike.functions.Fn;
import org.seqlike.functions.Fn2;
import org.seqlike.functions.Fns;

public abstract class CollectionSeqLike<K extends CollectionLike, T, E> implements SeqLike<K, T, E> {

  public void each(Fn<E, Void> function) {
    final K collection = collection();
    for (Object e : collection) {
      function.apply((E) e);
    }
  }

  public <R> T map(final Fn<E, R> function) {
    final K mapped = zero();
    each(new Fn<E, Void>() {
      public Void apply(E fst) {
        mapped.add(function.apply(fst));
        return null;
      }
    });
    return (T) mapped.concrete();
  }

  public <R> R reduce(final R initialValue, final Fn2<R, E, R> function) {
    final Fns.ValueWrapper<R> result = new Fns.ValueWrapper<R>(initialValue);
    this.each(new Fn<E, Void>() {
      public Void apply(E elem) {
        result.element = function.apply(result.element, elem);
        return null;
      }
    });
    return result.element;
  }

  protected K add(E element) {
    final K zero = zero();
    zero.addAll(collection());
    zero.add(element);
    return zero;
  }

  protected abstract K collection();

  protected abstract K zero();

}
