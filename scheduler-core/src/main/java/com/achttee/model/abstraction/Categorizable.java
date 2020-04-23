package com.achttee.model.abstraction;

import com.achttee.model.Category;

public interface Categorizable<T extends AbstractNote> {

    Category get(T anyNote);

    void add(T anyNote, Category toCategory);

    void remove(T anyNote);

}
