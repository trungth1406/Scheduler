package com.achttee.model.abstraction;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.util.Date;
import java.util.InvalidPropertiesFormatException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author trungtran
 * @implNote
 *      AbstractNote belongs to a timetable or multiple timetable at once .
 *      These notes can be repeated over a period of time
 */
public abstract class AbstractNote implements Repeatable {

    private  static  AtomicInteger idIncrement = new AtomicInteger(1);
    private Integer id;
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
        this.id = handleId();
    }

    private static synchronized  int handleId(){
        return idIncrement.getAndIncrement();
    }


    protected int getTotalDays(){
        if(fromTime == null && toTime == null){
            return -1;
        }
        return Days.daysBetween(fromTime,toTime).getDays();
    }

    public Integer getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFromTime(LocalDate fromTime) {
        this.fromTime = fromTime;
    }

    public LocalDate getFromTime() {
        return fromTime;
    }

    public LocalDate getToTime() {
        return toTime;
    }

    public void setToTime(LocalDate toTime) {
        this.toTime = toTime;
    }



    @Override
    public void repeatFor(int days) throws InvalidPropertiesFormatException {
        if(fromTime == null && toTime == null){
            throw new NullPointerException("No start and end date for such Note");
        }
        if (days < 0){
            throw new InvalidPropertiesFormatException("Days of reapeat must greater than 0");
        }
        toTime = toTime.plusDays(days);
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName() + "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", fromTime=" + fromTime +
                ", toTime=" + toTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractNote that = (AbstractNote) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(content, that.content) &&
                Objects.equals(fromTime, that.fromTime) &&
                Objects.equals(toTime, that.toTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content, fromTime, toTime);
    }
}
