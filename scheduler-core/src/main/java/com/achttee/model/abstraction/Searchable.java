package com.achttee.model.abstraction;

import org.joda.time.LocalDate;

import java.util.List;

public interface Searchable<D ,K ,V> {

    List<V> searchAll(D key,String className) throws Exception;

    V searchBy(D time, String className , K id) throws NoSuchMethodException;


}
