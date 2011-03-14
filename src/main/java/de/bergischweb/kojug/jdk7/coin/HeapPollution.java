/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergischweb.kojug.jdk7.coin;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public class HeapPollution {

  public static class G<T> {
  }

  public static void main(String... args) {

    polutionIntroduction();

    String element;

    List<String>[] unpolluted = createNoHeapPollution(Arrays.asList("a", "b", "c"));
    element = unpolluted[0].get(0);

    // String[] polluted = createHeapPollution("a", "b", "c");
    List<String>[] polluted = createHeapPollution(Arrays.asList("a", "b", "c"));
    // java.lang.Integer cannot be cast to java.lang.String
    // element = polluted[0].get(0);

  }

  public static <L> L[] createHeapPollution(L... args) {
    Object[] elements = args;
    elements[0] = Arrays.asList(12, 12);

    return args;
  }

  @SafeVarargs
  public static <L> L[] createNoHeapPollution(L... args) {
    return args;
  }

  public static void polutionIntroduction() {
    List<Integer>[] matrix = new List[23];

    Integer[] vector = new Integer[3];
    Object[] vectorObjects = vector;
    // java.lang.ArrayStoreException
    // vectorObjects[0] = "String";

    List[] nonGenericMatrix = matrix;
    nonGenericMatrix[0] = Arrays.asList("String1", "String1");
    // java.lang.Integer cannot be cast to java.lang.String
    //List<Integer> vectorList = matrix[0];

  }
}