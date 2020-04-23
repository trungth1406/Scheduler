package com.achttee.model;

import com.achttee.model.abstraction.AbstractNote;
import com.achttee.model.abstraction.Changeable;

import java.time.Month;
import java.util.Date;
import java.util.List;

/**
 * @author trungtran
 * @version  1.0.0
 * @since April 20, 2020
 * QuickNote is a part of a {@inheritDoc Timetable}
 */
public class QuickNote extends AbstractNote {

    private QuickNote(String header,String content){
       super(header,content);
    }

    public static QuickNote with(String header,String content){
        return new QuickNote(header,content);
    }


}
