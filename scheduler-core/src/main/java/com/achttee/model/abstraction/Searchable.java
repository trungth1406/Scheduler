package com.achttee.model.abstraction;

import org.joda.time.LocalDate;

import java.util.List;

public interface Searchable<D ,K ,V extends  AbstractNote> {

    List<V> searchBy(D key,V clazz) throws Exception;

    V searchBy(D time,K key,V clazz);

}
