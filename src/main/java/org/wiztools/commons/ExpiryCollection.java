/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.util.Iterator;

/**
 * When adding elements to this collection type, we need to specify when the element
 * will be expired and removed from the collection.
 * @author subwiz
 */
public interface ExpiryCollection<T> extends Iterable<T> {

    boolean add(T t, long expiryTime);

    void clear();

    boolean contains(T t);

    boolean isEmpty();

    Iterator<T> iterator();

    int size();

    /**
     * Before running sequence of operations on the collection (like iterating, adding element, etc.),
     * it is recommended to acquire the lock so that the cleaner thread does not
     * run in-between the operation.
     */
    void acquire();

    /**
     * Whenever lock is acquired, make sure to release it (preferably in finally
     * block).
     */
    void release();

    /**
     * Call to this method will send a interrupt signal to the cleaner thread and
     * make it quit. Call this method when you are done with the this collection.
     */
    void shutdown();
}
