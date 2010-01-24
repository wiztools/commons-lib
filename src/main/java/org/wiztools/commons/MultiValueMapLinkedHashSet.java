/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author subwiz
 */
public class MultiValueMapLinkedHashSet<K, V> implements MultiValueMap<K, V> {
    private Map<K, Set<V>> map = new HashMap<K, Set<V>>();

    public Collection<V> put(K key, V value){
        Set<V> l = map.get(key);
        if(l == null){
            l = new LinkedHashSet<V>();
        }
        l.add(value);
        return map.put(key, l);
    }

    public Collection<V> get(K key){
        return map.get(key);
    }

    public Set<K> keySet(){
        return map.keySet();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        if(size() == 0)
            return true;
        return false;
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean containsValue(V value) {
        for(K key: map.keySet()){
            Set<V> values = map.get(key);
            if(values.contains(value)){
                return true;
            }
        }
        return false;
    }

    public Collection<V> remove(K key) {
        return map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    public Collection<V> values() {
        List<V> values = new ArrayList<V>();
        for(K key: map.keySet()){
            Set<V> v = map.get(key);
            values.addAll(v);
        }
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
