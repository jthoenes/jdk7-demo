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

        String element;
        
        List<String>[] unpolluted = createNoHeapPollution(Arrays.asList("a", "b", "c"));
        element = unpolluted[0].get(0);
        
        // String[] polluted = createHeapPollution("a", "b", "c");
        List<String>[] polluted = createHeapPollution(Arrays.asList("a", "b", "c"));
        element = polluted[0].get(0);

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
}