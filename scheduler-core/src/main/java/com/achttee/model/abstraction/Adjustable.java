package com.achttee.model.abstraction;

import java.time.Month;
import java.util.Date;
import java.util.List;

public interface Adjustable<K extends  Object,V extends  Object> {

    void add(V content);

    void delete(K key);

    V getBy(K key);

    List<V> getBy(K... keys);
}
