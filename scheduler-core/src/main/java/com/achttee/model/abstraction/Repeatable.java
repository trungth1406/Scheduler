package com.achttee.model.abstraction;

public interface Repeatable<T extends  AbstractNote> {

     void repeat(T type,String typeOfRepeat);

     boolean isRepeated();




}
