package com.achttee.model.abstraction;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.util.Date;

/**
 * @author trungtran
 * @implNote
 *      AbstractNote belongs to a timetable or multiple timetable at once .
 *      These notes can be repeated over a period of time
 */
public abstract class AbstractNote implements Repeatable {

    private static Integer id = 0;
    private String name;
    private String content;
    private LocalDate fromTime;
    private LocalDate toTime;

    protected AbstractNote(){}

    protected AbstractNote(String name,String content){
        this.name = name;
        this.content = content;
        this.fromTime = LocalDate.now();
        this.toTime = LocalDate.now();
        id++;
    }

    protected LocalDate getFromTime() {
        return fromTime;
    }
    protected int getTotalDays(){
        if(fromTime == null && toTime == null){
            return -1;
        }
        return Days.daysBetween(fromTime,toTime).getDays();
    }

    protected Integer getId(){
        return id;
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

    protected void setFromTime(LocalDate fromTime) {
        this.fromTime = fromTime;
    }

    protected LocalDate getToTime() {
        return toTime;
    }

    protected void setToTime(LocalDate toTime) {
        this.toTime = toTime;
    }



    @Override
    public void repeatFor(int days) {
        if(fromTime == null && toTime == null){
            throw new NullPointerException("No start and end date for such Note");
        }
        toTime = toTime.plusDays(days);
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + "{" + "name='" + name + '\'' + ", content='" + content + '\'' +
                ", fromTime=" + fromTime + ", toTime=" + toTime + '}';
    }
}
