/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author subwiz
 */
public class MultiValueMapLinkedHashSet<K, V> implements MultiValueMap<K, V> {
    private final Map<K, Set<V>> map = new LinkedHashMap<>();

    @Override
    public Collection<V> put(K key, V value){
        Set<V> l = map.get(key);
        if(l == null){
            l = new LinkedHashSet<>();
        }
        l.add(value);
        return map.put(key, l);
    }

    @Override
    public Collection<V> get(K key){
        return map.get(key);
    }

    @Override
    public Set<K> keySet(){
        return map.keySet();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(V value) {
        if (map.keySet().stream().map((key) -> map.get(key)).anyMatch((values) -> (values.contains(value)))) {
            return true;
        }
        return false;
    }

    @Override
    public Collection<V> remove(K key) {
        return map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        map.keySet().stream().map((key) -> map.get(key)).forEach((v) -> {
            values.addAll(v);
        });
        return values;
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
        if (this.keySet() != other.keySet() && (this.keySet() == null || !this.keySet().equals(other.keySet()))) {
            return false;
        }
        if (this.values() != other.values() && (this.values() == null || !this.values().equals(other.values()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.map != null ? this.map.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
