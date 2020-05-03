package com.achttee.model;

import com.achttee.exception.ClassException;
import com.achttee.model.abstraction.AbstractNote;
import com.achttee.model.abstraction.SchedulerHandler;
import com.achttee.model.abstraction.Searchable;
import org.joda.time.LocalDate;
import org.joda.time.base.AbstractPartial;


import java.util.*;

/**
 * A Scheduler holds instances of any type that extends AbstractNote
 *
 */
public final class Scheduler<D extends AbstractPartial,K extends Object,V extends  AbstractNote>
        implements SchedulerHandler<D, K, V>, Searchable<D, K, V> {

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


    @Override
    public void add(D dateType, V value) {
        if(isExisted(dateType)){
            if(isTypeExisted(dateType,value.getClass().getSimpleName())){
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

    @Override
    public void update(V newVal) {
       //TODO: Search by Id
    }

    @Override
    public void removeBy(D dateType, K key, Class<V> className) {
        List<V> notes = getNotesBy(dateType,className.getSimpleName());
        ListIterator<V> iterator = notes.listIterator();
        while(iterator.hasNext()){
            if(iterator.next().getId().equals(key)){
                iterator.remove();
            }
        }
    }

    @Override
    public void removeAll(D dateType) {
        if(isExisted(dateType)){
            dateMap.get(dateType).clear();
        }else{
            throw new NoSuchElementException("There were no notes on such day: " + dateType);
        }
    }

    private boolean isExisted(D date){
        return dateMap.containsKey(date);
    }

    private boolean isTypeExisted(D key,String className){
        return dateMap.get(key).containsKey(className);
    }


    /**
     * Get every Notes with date
     * @param dateType
     * @param className
     * @return
     */
    @Override
    public List<V> searchAll(D dateType, String className)  {
        return getNotesBy(dateType,className);
    }

    @Override
    public V searchBy(D time, String className,K key){
        List<V> notes = getNotesBy(time,className);
        ListIterator<V> iterator = notes.listIterator();
        while(iterator.hasNext()){
            V val = iterator.next();
            if(val.getId().equals(key)){
                return val;
            }
        }
        return null;
    }

    private List<V> getNotesBy(D date, String className) throws ClassException{
        try{
            Class<?> clazz = Class.forName("com.achttee.model." + className);
            if(isExisted(date) && isTypeExisted(date,clazz.getSimpleName())){
                return dateMap.get(date).get(className);
            }else{
                throw new NoSuchElementException("No such type of note: " + className);
            }
        }catch (ClassNotFoundException e){
            throw new ClassException("No such class: " + className);
        }
    }


    private V getNotesBy(D date, K id,V clazz){
        //TODO: Seach by id
        if(isExisted(date) && isTypeExisted(date,null)){

        }
        return null;
    }


    @Override
    public String toString() {
        return "Scheduler{" +
                "dateMap=" + dateMap +
                '}';
    }
}
