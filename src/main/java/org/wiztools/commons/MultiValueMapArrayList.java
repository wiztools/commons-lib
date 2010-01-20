package org.wiztools.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class does not implement java.util.Map&lt;K, V&gt; interface.
 * This class encapsulates a HashMap holding a List of values associated with a
 * particular key.
 * @author subwiz
 */
public class MultiValueMapArrayList<K, V> implements MultiValueMap<K, V>{

    private Map<K, List<V>> map = new HashMap<K, List<V>>();

    public Collection<V> put(K key, V value){
        List<V> l = map.get(key);
        if(l == null){
            l = new ArrayList<V>();
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
            List<V> values = map.get(key);
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
            List<V> v = map.get(key);
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
        final Collection thisValues = this.values();
        final Collection otherValues = other.values();
        if (thisValues != otherValues && (thisValues == null || !thisValues.equals(otherValues))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.map != null ? this.map.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return map.toString();
    }

}
