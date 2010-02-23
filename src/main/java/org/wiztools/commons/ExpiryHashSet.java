/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author subwiz
 */
public class ExpiryHashSet<T> implements ExpiryCollection<T> {

    // Inner class:
    private class Encp {
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

    private final Set<ExpiryHashSet.Encp> data = new HashSet<ExpiryHashSet.Encp>();

    private final Lock lock = new ReentrantLock();

    // Constructor:
    public ExpiryHashSet(final long cleanerThreadIntervalInMilliSecond) {
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
                Set<ExpiryHashSet.Encp> toRemove = new HashSet<ExpiryHashSet.Encp>();
                for(Encp e: data){
                    if(currentTime > e.expiryTime) {
                        toRemove.add(e);
                    }
                }
                data.removeAll(toRemove);
                lock.unlock();
            }
        }.start();
    }

    @Override
    public boolean add(T t, long expiryTime) {
        return data.add(new Encp(t, expiryTime));
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public boolean contains(T t) {
        return data.contains(new Encp(t, 0)); // equals() of Encp only checks for equality of data
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void lock() {
        lock.lock();
    }

    @Override
    public void unlock() {
        lock.unlock();
    }

    @Override
    public Iterator<T> iterator() {
        final Iterator<ExpiryHashSet.Encp> itr = data.iterator();
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
