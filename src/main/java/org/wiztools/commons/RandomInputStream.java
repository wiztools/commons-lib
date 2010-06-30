/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Originally written by Elliotte Rusty Harold for the book Java I/O 2nd edition.
 * @author subwiz
 */
public class RandomInputStream extends InputStream {

    private Random generator = new Random();
    private boolean closed = false;

    @Override
    public int read() throws IOException {
        checkOpen();
        int result = generator.nextInt() % 256;
        if (result < 0) {
            result = -result;
        }
        return result;
    }

    @Override
    public int read(byte[] data, int offset, int length) throws IOException {
        checkOpen();
        byte[] temp = new byte[length];
        generator.nextBytes(temp);
        System.arraycopy(temp, 0, data, offset, length);
        return length;

    }

    @Override
    public int read(byte[] data) throws IOException {
        checkOpen();
        generator.nextBytes(data);
        return data.length;

    }

    @Override
    public long skip(long bytesToSkip) throws IOException {
        checkOpen();
        // It's all random so skipping has no effect.
        return bytesToSkip;
    }

    @Override
    public void close() {
        this.closed = true;
    }

    private void checkOpen() throws IOException {
        if (closed) {
            throw new IOException("Input stream closed");
        }
    }

    @Override
    public int available() {
        // Limited only by available memory and the size of an array.
        return Integer.MAX_VALUE;
    }
}
