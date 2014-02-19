package org.seqlike;

import org.junit.Test;
import org.seqlike.collections.ListSeqLike;
import org.seqlike.functions.Fn;
import org.seqlike.functions.Fn2;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.seqlike.Maps.entry;
import static org.seqlike.Maps.hash;

public class SeqsTest {

  @Test
  public void testOf() throws Exception {
    final List<Integer> mapped = Lists.map(toInteger(), asList("1", "2", "3"));


    final ListSeqLike<Integer> filtered = Lists.filter(new Fn<Integer, Boolean>() {
      public Boolean apply(Integer fst) {
        return fst > 1;
      }
    }, mapped);

    assertThat(Seqs.reduce(withSum(), 0, filtered), is(5));
  }

  @Test
  public void testMap() throws Exception {
    assertThat(Maps.reduce(valueWithSum(), 0, Maps.map(valueToInteger(),
        hash(entry("one", "1"),
            entry("two", "2"),
            entry("three", "3")))), is(6));
  }

  private Fn2<Integer, Map.Entry<String, Integer>, Integer> valueWithSum() {
    return new Fn2<Integer, Map.Entry<String, Integer>, Integer>() {
      public Integer apply(Integer fst, Map.Entry<String, Integer> snd) {
        return fst + snd.getValue();
      }
    };
  }

  private Fn<Map.Entry<String, String>, Map.Entry<String, Integer>> valueToInteger() {
    return new Fn<Map.Entry<String, String>, Map.Entry<String, Integer>>() {
      public Map.Entry<String, Integer> apply(Map.Entry<String, String> fst) {
        return entry(fst.getKey(), Integer.parseInt(fst.getValue()));
      }
    };
  }

  private Fn2<Integer, Integer, Integer> withSum() {
    return new Fn2<Integer, Integer, Integer>() {
      public Integer apply(Integer fst, Integer snd) {
        return fst + snd;
      }
    };
  }

  private Fn<String, Integer> toInteger() {
    return new Fn<String, Integer>() {
      public Integer apply(String fst) {
        return Integer.parseInt(fst);
      }
    };
  }
}
