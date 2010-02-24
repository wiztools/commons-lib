/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Abstract class providing all the basic functionality of ExpiryCollection
 * like cleaner thread and iterator.
 * @author subwiz
 */
public abstract class AbstractExpiryCollection<T> implements ExpiryCollection<T> {

    // Inner class:
    protected class Encp {
        T t;
        long expiryTime;

        Encp(T t, long expiryTime){
            this.t = t;
            this.expiryTime = expiryTime;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Encp other = (Encp) obj;
            if (this.t != other.t && (this.t == null || !this.t.equals(other.t))) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 71 * hash + (this.t != null ? this.t.hashCode() : 0);
            return hash;
        }
    }

    public abstract Collection<AbstractExpiryCollection.Encp> getData();

    private final Lock lock = new ReentrantLock();

    // Constructor:
    public AbstractExpiryCollection(final long cleanerThreadIntervalInMilliSecond) {
        new Thread() {
            @Override
            public void run() {
                try{
                    Thread.sleep(cleanerThreadIntervalInMilliSecond);
                }
                catch(InterruptedException ex){
                    // do nothing!
                }

                lock.lock();
                final long currentTime = System.currentTimeMillis();
                Set<AbstractExpiryCollection.Encp> toRemove = new HashSet<AbstractExpiryCollection.Encp>();
                for(Encp e: getData()){
                    if(currentTime > e.expiryTime) {
                        toRemove.add(e);
                    }
                }
                getData().removeAll(toRemove);
                lock.unlock();
            }
        }.start();
    }

    @Override
    public boolean add(T t, long expiryTime) {
        return getData().add(new Encp(t, expiryTime));
    }

    @Override
    public void clear() {
        getData().clear();
    }

    @Override
    public boolean contains(T t) {
        return getData().contains(new Encp(t, 0)); // equals() of Encp only checks for equality of data
    }

    @Override
    public boolean isEmpty() {
        return getData().isEmpty();
    }

    @Override
    public int size() {
        return getData().size();
    }

    @Override
    public void acquire() {
        lock.lock();
    }

    @Override
    public void release() {
        lock.unlock();
    }

    @Override
    public Iterator<T> iterator() {
        final Iterator<AbstractExpiryCollection.Encp> itr = getData().iterator();
        return new Iterator<T>() {
            public boolean hasNext() {
                return itr.hasNext();
            }

            public T next() {
                return (T)itr.next().t;
            }

            public void remove() {
                itr.remove();
            }
        };
    }
}
