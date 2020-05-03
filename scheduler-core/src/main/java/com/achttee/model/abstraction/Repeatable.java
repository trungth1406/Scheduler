package com.achttee.model.abstraction;

import java.util.InvalidPropertiesFormatException;

public interface Repeatable {

     void repeatFor(int days) throws InvalidPropertiesFormatException;


}
