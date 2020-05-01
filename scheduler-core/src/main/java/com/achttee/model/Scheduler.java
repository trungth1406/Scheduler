package com.achttee.model;

import com.achttee.model.abstraction.AbstractNote;
import com.achttee.model.abstraction.SchedulerHandler;
import com.achttee.model.abstraction.Searchable;
import com.achttee.model.constant.MonthName;
import org.joda.time.LocalDate;


import java.io.Serializable;
import java.util.*;

/**
 * A Scheduler holds instances of any type that extends AbstractNote
 *
 */
public final class Scheduler<D extends Serializable,K extends Object,V extends  AbstractNote>
        implements SchedulerHandler<D , K, V>, Searchable<D,K,V> {

    private Map<D, Map<K, List<V>>> dateMap;

    private Scheduler(){
        this.dateMap = new LinkedHashMap<>();
    }

    public Scheduler(List<? extends  AbstractNote>  notes){
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
    public List<? extends  AbstractNote> getFor(LocalDate date){
        return null;
    }


    /**
     * Get list of notes for selected month
     * @param month
     * @return
     */
    public List<? extends AbstractNote> getFor(MonthName month){
        return null;
    }


    @Override
    public void add(D dateType, V value) {
        if(isExisted(dateType)){
            if(isTypeExisted(dateType,value)){
                List<V> type = dateMap.get(dateType).get(value.getClass().getSimpleName());
                type.add(value);
            } else {
                List<V> notes = new ArrayList<>(Arrays.asList(value));
                dateMap.get(dateType).put((K)value.getClass().getSimpleName(), notes);
            }
        }else{
            Map<K, List<V>> notesMap = new LinkedHashMap<>();
            List<V> notes = new ArrayList<>(Arrays.asList(value));
            notesMap.put((K) value.getClass().getSimpleName(),notes);
            dateMap.put(dateType,notesMap);
        }
    }

    private boolean isExisted(D date){
        return dateMap.containsKey(date);
    }

    private boolean isTypeExisted(D key,V note){
        return dateMap.get(key).containsKey(note.getClass().getSimpleName());
    }

    @Override
    public void removeAll(D dateType) {
        if(isExisted(dateType)){
            dateMap.get(dateType).clear();
        }else{
            throw new NoSuchElementException("There were no notes on such day: " + dateType);
        }
    }

    @Override
    public void removeBy(D dateType, K keyId) {
        //TODO: Change API
    }

    @Override
    public void update(D dateType, K keyId) {

    }


    @Override
    public List<V> searchBy(D key, V clazz) throws Exception {
        if(isExisted(key)){
            if(clazz instanceof AbstractNote && isTypeExisted(key,clazz)){
                return dateMap.get(key).get(clazz.getClass().getSimpleName());
            }else{
                throw new Exception("No such type");
            }
        }
        return new ArrayList<>();
    }

    @Override
    public V searchBy(D time, K key,V clazz) {
        //TODO: Search by id
        return null;
    }

    @Override
    public String toString() {
        return "Scheduler{" +
                "dateMap=" + dateMap +
                '}';
    }
}
