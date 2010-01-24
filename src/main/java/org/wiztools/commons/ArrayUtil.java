/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author subwiz
 */
public final class ArrayUtil {
    private ArrayUtil(){}

    /**
     * Concatenates all the passed parameters.
     * @param <T>
     * @param objs
     * @return
     */
    public static <T> T[] concat(T[] ... objs){
        List<T> out = new ArrayList<T>();

        int i = 0;
        T[] pass = null;
        for(T[] o: objs){
            for(int j=0; j<o.length; j++){
                out.add(o[j]);
                i++;
            }
            pass = o;
        }
        
        return out.toArray(pass);
    }

    // Primitive types for quicker copy:

    public static short[] concat(short[] ... objs){
        int count = 0;
        for(short[] o: objs){
            count += o.length;
        }

        final short[] out = new short[count];

        int i = 0;
        for(short[] o: objs){
            for(int j=0; j<o.length; j++){
                out[i] = o[j];
                i++;
            }
        }

        return out;
    }

    public static int[] concat(int[] ... objs){
        int count = 0;
        for(int[] o: objs){
            count += o.length;
        }

        final int[] out = new int[count];

        int i = 0;
        for(int[] o: objs){
            for(int j=0; j<o.length; j++){
                out[i] = o[j];
                i++;
            }
        }

        return out;
    }

    public static long[] concat(long[] ... objs){
        int count = 0;
        for(long[] o: objs){
            count += o.length;
        }

        final long[] out = new long[count];

        int i = 0;
        for(long[] o: objs){
            for(int j=0; j<o.length; j++){
                out[i] = o[j];
                i++;
            }
        }

        return out;
    }

    public static byte[] concat(byte[] ... objs){
        int count = 0;
        for(byte[] o: objs){
            count += o.length;
        }

        final byte[] out = new byte[count];

        int i = 0;
        for(byte[] o: objs){
            for(int j=0; j<o.length; j++){
                out[i] = o[j];
                i++;
            }
        }

        return out;
    }

    public static char[] concat(char[] ... objs){
        int count = 0;
        for(char[] o: objs){
            count += o.length;
        }

        final char[] out = new char[count];

        int i = 0;
        for(char[] o: objs){
            for(int j=0; j<o.length; j++){
                out[i] = o[j];
                i++;
            }
        }

        return out;
    }

    public static float[] concat(float[] ... objs){
        int count = 0;
        for(float[] o: objs){
            count += o.length;
        }

        final float[] out = new float[count];

        int i = 0;
        for(float[] o: objs){
            for(int j=0; j<o.length; j++){
                out[i] = o[j];
                i++;
            }
        }

        return out;
    }

    public static double[] concat(double[] ... objs){
        int count = 0;
        for(double[] o: objs){
            count += o.length;
        }

        final double[] out = new double[count];

        int i = 0;
        for(double[] o: objs){
            for(int j=0; j<o.length; j++){
                out[i] = o[j];
                i++;
            }
        }

        return out;
    }

    public static boolean[] concat(boolean[] ... objs){
        int count = 0;
        for(boolean[] o: objs){
            count += o.length;
        }

        final boolean[] out = new boolean[count];

        int i = 0;
        for(boolean[] o: objs){
            for(int j=0; j<o.length; j++){
                out[i] = o[j];
                i++;
            }
        }

        return out;
    }
}
