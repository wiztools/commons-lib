/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 *
 * @author subwiz
 */
public final class CollectionsUtil {

    public static final MultiValueMap EMPTY_MULTI_VALUE_MAP = new MultiValueMap() {

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Collection get(Object key) {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public Set keySet() {
            return Collections.EMPTY_SET;
        }

        @Override
        public Collection put(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Collection remove(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Collection values() {
            return Collections.EMPTY_LIST;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null){return false;}
            if(!(obj instanceof MultiValueMap)){return false;}
            MultiValueMap other = (MultiValueMap) obj;
            return other.isEmpty();
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    };
    
    /**
     * Returns a empty MultiValueMap. Example usage:
     * <pre>
     * {@code
     * MultiValueMap<String, String> map = CollectionsUtil.<String, String>emptyMultiValueMap();
     * }
     * </pre>
     * @param <K>
     * @param <V>
     * @return Returns a empty MultiValueMap.
     */
    public static final <K, V> MultiValueMap<K, V> emptyMultiValueMap() {
        return (MultiValueMap<K, V>) EMPTY_MULTI_VALUE_MAP;
    }

    /**
     * Returns an unmodifiable version of the MultiValueMap.
     * @param <K>
     * @param <V>
     * @param map
     * @return Returns an unmodifiable version of the MultiValueMap.
     */
    public static final <K, V> MultiValueMap<K, V> unmodifiableMultiValueMap(
            final MultiValueMap<K, V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new MultiValueMap<K, V>() {

            @Override
            public void clear() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public boolean containsKey(K key) {
                return map.containsKey(key);
            }

            @Override
            public boolean containsValue(V value) {
                return map.containsValue(value);
            }

            @Override
            public Collection<V> get(K key) {
                return Collections.unmodifiableCollection(map.get(key));
            }

            @Override
            public boolean isEmpty() {
                return map.isEmpty();
            }

            @Override
            public Set<K> keySet() {
                return Collections.unmodifiableSet(map.keySet());
            }

            @Override
            public Collection<V> put(K key, V value) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public Collection<V> remove(K key) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public int size() {
                return map.size();
            }

            @Override
            public Collection<V> values() {
                Collection<V> values = map.values();
                if(values == null){
                    return null;
                }
                if(values instanceof List){
                    return Collections.unmodifiableList((List)values);
                }
                if(values instanceof Set){
                    return Collections.unmodifiableSet((Set)values);
                }
                // This does not override equals() and hashCode():
                return Collections.unmodifiableCollection(values);
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null) {
                    return false;
                }
                if (!(obj instanceof MultiValueMap)) {
                    return false;
                }
                final MultiValueMap<K, V> other = (MultiValueMap<K, V>) obj;
                final Set mapKeySet = map.keySet();
                final Set otherKeySet = other.keySet();
                if (mapKeySet != otherKeySet && (mapKeySet == null || !mapKeySet.equals(otherKeySet))) {
                    return false;
                }
                final Collection mapValues = map.values();
                final Collection otherValues = other.values();
                if (mapValues != otherValues && (mapValues == null || !mapValues.equals(otherValues))) {
                    return false;
                }
                return true;
            }

            @Override
            public int hashCode() {
                int hash = 7;
                hash = 47 * hash + (map != null ? map.hashCode() : 0);
                return hash;
            }

            @Override
            public String toString() {
                return map.toString();
            }
        };
    }

    /**
     * Accepts a varargs argument of type T, and returns a java.util.List representation of them.
     * @param <T>
     * @param objs
     * @return A List representation of all the varargs.
     */
    public static <T> List<T> asList(T ... objs){
        List<T> l = new ArrayList<>();
        l.addAll(Arrays.asList(objs));
        return l;
    }
}
