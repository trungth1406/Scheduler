package com.achttee.model.abstraction;

import com.achttee.model.Timetable;

import java.util.List;

/**
 * @author trungtran
 * @implNote
 *      AbstractNote belongs to a timetable or multiple timetable at once .
 *      These notes can be repeated over a period of time
 */
public abstract class AbstractNote  {

    protected String name;
    protected String content;
    private Timetable timetable;

    protected AbstractNote(){}

    protected AbstractNote(String name,String content){
        this.name = name;
        this.content = content;
    }

    protected void setTimetable(Timetable timetable){
        this.timetable = timetable;
    }

    protected Timetable getTimetable(){
        if(timetable == null){
            throw new NullPointerException("Must belong to a time table");
        }
        return timetable;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getContent() {
        return content;
    }

    protected void setContent(String content) {
        this.content = content;
    }

}
