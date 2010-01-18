package org.wiztools.commons;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 *
 * @author subwiz
 */
public final class CollectionsUtil {
    public static final MultiValueMap EMPTY_MULTI_VALUE_MAP = new MultiValueMap() {

        public void clear() {
            throw new UnsupportedOperationException("Not supported yet.");
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
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Collection remove(Object key) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public int size() {
            return 0;
        }

        public Collection values() {
            return Collections.EMPTY_LIST;
        }
    };

    public static final <K, V> MultiValueMap<K, V> unmodifiableMultiValueMap(
            MultiValueMap<K, V> map){
        return null; // TODO
    }
}
