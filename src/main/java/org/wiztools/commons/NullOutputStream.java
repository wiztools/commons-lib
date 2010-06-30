/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Originally written by Elliotte Rusty Harold for the book Java I/O 2nd edition.
 * @author subwiz
 */
public class NullOutputStream extends OutputStream {

    private boolean closed = false;

    @Override
    public void write(int b) throws IOException {
        if (closed) throw new IOException("Write to closed stream");
    }

    @Override
    public void write(byte[] data, int offset, int length) throws IOException {
        if (data == null) throw new NullPointerException("data is null");
        if (closed) throw new IOException("Write to closed stream");
    }

    @Override
    public void close() throws IOException {
        closed = true;
    }
}
