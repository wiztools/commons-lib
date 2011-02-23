/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author subWiz
 */
public final class Statistics {
    private Statistics() {}

    private static final String LOG_ARRAY_LENGTH_0 = "Length of array cannot be 0!";

    /* MEAN */

    public static int mean(final int[] list) throws IllegalArgumentException {
        if(list.length == 0) {
            throw new IllegalArgumentException(LOG_ARRAY_LENGTH_0);
        }
        int sum = 0;
        for(int n: list) {
            sum += n;
        }
        return sum / list.length;
    }

    public static long mean(final long[] list) throws IllegalArgumentException {
        if(list.length == 0) {
            throw new IllegalArgumentException(LOG_ARRAY_LENGTH_0);
        }
        long sum = 0;
        for(long n: list) {
            sum += n;
        }
        return sum / list.length;
    }

    public static float mean(final float[] list) throws IllegalArgumentException {
        if(list.length == 0) {
            throw new IllegalArgumentException(LOG_ARRAY_LENGTH_0);
        }
        float sum = 0;
        for(float n: list) {
            sum += n;
        }
        return sum / list.length;
    }

    public static double mean(final double[] list) throws IllegalArgumentException {
        if(list.length == 0) {
            throw new IllegalArgumentException(LOG_ARRAY_LENGTH_0);
        }
        float sum = 0;
        for(double n: list) {
            sum += n;
        }
        return sum / list.length;
    }

    /* MEDIAN */

    public static int median(final int[] list) throws IllegalArgumentException {
        if(list.length < 1) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(list);
        if((list.length % 2) == 0) { // is even
            final int idx = list.length / 2;
            return (list[idx] + list[idx-1]) / 2;
        }
        else { // is odd
            final int idx = list.length / 2;
            return list[idx];
        }
    }

    /* MODE */

    private static class ModeCompute <T extends Number> {
        private Map<T, Integer> map = new HashMap<T, Integer>();
        private int maxFrequency = 0;

        void add(T t) {
            final int count = (map.get(t) == null)? 1: (map.get(t) + 1);

            // Update map:
            map.put(t, count);

            // Update maxFrequency:
            if(count > maxFrequency)
                maxFrequency = count;
        }

        List<T> getMode() {
            List<T> out = new ArrayList<T>();

            for(Map.Entry<T, Integer> entry: map.entrySet()) {
                if(entry.getValue() == maxFrequency) {
                    out.add(entry.getKey());
                }
            }

            return out;
        }
    }

    public static int[] mode(final int[] list) throws IllegalArgumentException {
        if(list.length == 0) {
            throw new IllegalArgumentException(LOG_ARRAY_LENGTH_0);
        }

        final ModeCompute<Integer> modeComp = new ModeCompute<Integer>();
        for(int i=0; i<list.length; i++) {
            modeComp.add(list[i]);
        }

        final List<Integer> l = modeComp.getMode();

        // Prepare the output array:
        final int[] out = new int[l.size()];
        Iterator<Integer> itr = l.iterator();
        for(int i=0; i<out.length; i++) {
            out[i] = itr.next();
        }

        return out;
    }
}
