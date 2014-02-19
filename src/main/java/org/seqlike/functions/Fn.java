package org.seqlike.functions;

public interface Fn<In, Out> {

  Out apply(In fst);

}
