import com.achttee.model.Activity;
import com.achttee.model.QuickNote;
import com.achttee.model.Scheduler;
import com.achttee.model.SpecialDate;
import com.achttee.model.abstraction.AbstractNote;
import com.achttee.model.abstraction.SchedulerHandler;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.YearMonth;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.*;


public class TimetableTest {


    /**
     * Test for singleton Timetable
     */
    @Test
    public void testTimetable(){
        YearMonth ym  = org.joda.time.YearMonth.now();
    }

    @Test
    public void testRepeat() throws NoSuchMethodException {
        AbstractNote notes = QuickNote.with("Hello","Testing");
        notes.repeatFor(5);
//        Assert.assertEquals(((QuickNote) notes.getClass().getMethod("getToTime").invoke());
    }

    @Test
    public void testScheduler()  {
        SchedulerHandler<LocalDate,String,AbstractNote> scheduler = Scheduler.createDefault();
        scheduler.add(LocalDate.parse("2020-12-31"), QuickNote.with("QuickNote","Content"));
        scheduler.add(LocalDate.parse("2020-12-31"), new Activity("1","2"));
        scheduler.add(LocalDate.parse("2020-12-31"), new SpecialDate());
        scheduler.add(LocalDate.parse("2020-12-31"), new Activity("3","4"));
        scheduler.add(LocalDate.parse("2020-12-31"), new SpecialDate());

        SchedulerHandler<Date,String,AbstractNote> scheduler2 = Scheduler.createDefault();
        scheduler2.add(new Date(), QuickNote.with("QuickNote","Content"));
        scheduler2.add(new Date(), new Activity("1","2"));
        scheduler2.add(new Date(), new SpecialDate());
        scheduler2.add(new Date(), new Activity("3","4"));
        scheduler2.add(new Date(), new SpecialDate());



        System.out.println(scheduler.toString());
        System.out.println(scheduler2.toString());
    }

    @Test
    public void testSearch(){

    }



}
