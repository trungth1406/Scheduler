package com.achttee.model;

import com.achttee.model.abstraction.AbstractNote;
import com.achttee.model.constant.MonthName;
import org.joda.time.LocalDate;


import java.util.*;

/**
 * A Scheduler holds instances of any type that extends AbstractNote
 *
 */
public final class Scheduler<T extends AbstractNote>  {

    private Map<LocalDate, Map<String, List<T>>> dateMap;

    private Scheduler(){
        this.dateMap = new LinkedHashMap<>();
    }

    public Scheduler(List<T>  notes){
        this.dateMap = new LinkedHashMap<>();
    }


    public static Scheduler createDefault(){
        return new Scheduler();
    }


    public LocalDate getCurrentDate(){
        return LocalDate.now();
    }


    /**
     * Get list of notes for date
     * @param date
     * @return
     */
    public List<T> getFor(LocalDate date){
        return null;
    }


    /**
     * Get list of notes for selected month
     * @param month
     * @return
     */
    public List<T> getFor(MonthName month){
        return null;
    }


    /**
     * Add any type that inherit from {@link AbstractNote}
     * @param key
     * @param content
     */
    public void add(LocalDate key, T content)  {
        if(isExisted(key)){
            if(isTypeExisted(key,content)){
                List<T> type = dateMap.get(key).get(content.getClass().getSimpleName());
                type.add(content);
            } else {
                List<T> notes = new ArrayList<>(Arrays.asList(content));
                dateMap.get(key).put(content.getClass().getSimpleName(),notes);
            }
        }else{
            Map<String, List<T>> notesMap = new LinkedHashMap<>();
            List<T> notes = new ArrayList<>(Arrays.asList(content));
            notesMap.put(content.getClass().getSimpleName(),notes);
            dateMap.put(key,notesMap);
        }
    }

    private boolean isExisted(LocalDate date){
        return dateMap.containsKey(date);
    }

    private boolean isTypeExisted(LocalDate key,T note){
        return dateMap.get(key).containsKey(note.getClass().getSimpleName());
    }

    /**
     * Update content of selected Note with id;
     * @param date
     * @param key
     */
    public void update(LocalDate date, Integer key){

    }


    /**
     * Delete all notes base on a date
     * @param date
     */
    public void delete(LocalDate date) {
        if(!dateMap.containsKey(date)){
            throw new NoSuchElementException("Such date does not contain any notes" + date);
        }else{
            dateMap.remove(date);
        }
    }

}
