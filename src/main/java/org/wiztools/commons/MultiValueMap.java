package org.wiztools.commons;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 *
 * @author subwiz
 */
public interface MultiValueMap<K, V> {

    void clear();

    boolean containsKey(K key);

    boolean containsValue(V value);

    List<V> get(K key);

    boolean isEmpty();

    Set<K> keySet();

    List<V> put(K key, V value);

    List<V> remove(K key);

    int size();

    Collection<V> values();

}
