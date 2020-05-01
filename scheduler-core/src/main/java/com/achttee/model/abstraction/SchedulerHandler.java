package com.achttee.model.abstraction;

import org.joda.time.LocalDate;

public interface SchedulerHandler<D ,K , T> {


    void add(D dateType,T value);

    void removeAll(D dateType);

    void removeBy(D dateType,K keyId);

    void update(D dateType,K keyId);




}
