package com.achttee.model;

import com.achttee.model.abstraction.AbstractNote;
import com.achttee.model.abstraction.Adjustable;
import com.achttee.model.abstraction.Repeatable;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.Temporal;
import java.util.*;

/**
 * @author trungtran
 * @version 1.0.0
 * @since  April 20, 2020

 * Timetable contains list of {@docRoot Activity} and {@docRoot QuickNote}. Each timetable has a Calendar with Notes
 * and Activities on it.
 *
 */
public final class Timetable implements Adjustable<String,AbstractNote>, Repeatable {

    private Map<Date, Map<LocalDate, List<? extends AbstractNote>>> dayNoteMapping;

    private Timetable(Date fromDate,Date toDate){
        dayNoteMapping = new LinkedHashMap<>();
    }

    private Timetable(Date fromDate){
        dayNoteMapping = new LinkedHashMap<>();
        dayNoteMapping.put(fromDate,new HashMap<>());
    }

    private static Timetable from(Date startDate,Date endDate){
        return new Timetable(startDate,endDate);
    }

    public static Timetable startWith(Date startDate){
        return new Timetable(startDate);
    }

    @Override
    public void add(AbstractNote content) {
        dayNoteMapping.put(new Date(),getDailyTasks(new Date()));
    }

    private  Map<LocalDate, List<? extends AbstractNote>> getDailyTasks(Date date){
        return null;
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public AbstractNote getBy(String key) {
        return null;
    }

    @Override
    public List<AbstractNote> getBy(String... keys) {
        return null;
    }

    @Override
    public void repeat(AbstractNote type, String typeOfRepeat) {

    }

    @Override
    public boolean isRepeated() {
        return false;
    }
}
