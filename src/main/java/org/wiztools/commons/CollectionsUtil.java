package org.wiztools.commons;

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

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean containsKey(Object key) {
            return false;
        }

        public boolean containsValue(Object value) {
            return false;
        }

        public Collection get(Object key) {
            return null;
        }

        public boolean isEmpty() {
            return true;
        }

        public Set keySet() {
            return Collections.EMPTY_SET;
        }

        public Collection put(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        public Collection remove(Object key) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return 0;
        }

        public Collection values() {
            return Collections.EMPTY_LIST;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null){return false;}
            if(!(obj instanceof MultiValueMap)){return false;}
            MultiValueMap other = (MultiValueMap) obj;
            if(other.size()!=0){return false;}
            return true;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    };

    public static final <K, V> MultiValueMap<K, V> unmodifiableMultiValueMap(
            final MultiValueMap<K, V> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new MultiValueMap<K, V>() {

            public void clear() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public boolean containsKey(K key) {
                return map.containsKey(key);
            }

            public boolean containsValue(V value) {
                return map.containsValue(value);
            }

            public Collection<V> get(K key) {
                return Collections.unmodifiableCollection(map.get(key));
            }

            public boolean isEmpty() {
                return map.isEmpty();
            }

            public Set<K> keySet() {
                return Collections.unmodifiableSet(map.keySet());
            }

            public Collection<V> put(K key, V value) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Collection<V> remove(K key) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public int size() {
                return map.size();
            }

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
}
