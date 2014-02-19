package org.seqlike.functions;

public interface Fn2<In, In2, Out> {

  Out apply(In fst, In2 snd);
}
