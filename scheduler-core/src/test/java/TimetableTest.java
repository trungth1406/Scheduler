import com.achttee.model.Activity;
import com.achttee.model.QuickNote;
import com.achttee.model.Scheduler;
import com.achttee.model.SpecialDate;
import com.achttee.model.abstraction.AbstractNote;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.YearMonth;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class TimetableTest {


    /**
     * Test for singleton Timetable
     */
    @Test
    public void testTimetable(){
        YearMonth ym  = org.joda.time.YearMonth.now();
    }

    @Test
    public void testRepeat(){
//        AbstractNote notes = QuickNote.with("Hello","Testing");
//        notes.repeatFor(5);
//        System.out.println(notes);
    }

    @Test
    public void testScheduler() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Scheduler<AbstractNote> scheduler = Scheduler.createDefault();
        scheduler.add(LocalDate.parse("2020-12-31"), QuickNote.with("QuickNote","Content"));
        scheduler.add(LocalDate.parse("2020-12-31"), new Activity("1","2"));
        scheduler.add(LocalDate.parse("2020-12-31"), new SpecialDate());
        scheduler.add(LocalDate.parse("2020-12-31"), new Activity("3","4"));
        scheduler.add(LocalDate.parse("2020-12-31"), new SpecialDate());

        System.out.println(scheduler.toString());


    }



}
