package com.achttee.model.abstraction;

import org.joda.time.LocalDate;

public interface SchedulerHandler<D ,K , V> {


    void add(D dateType,V value);

    void removeAll(D dateType);

    void removeBy(D date, K id, Class<V> className);

    void update(V newVal);




}
