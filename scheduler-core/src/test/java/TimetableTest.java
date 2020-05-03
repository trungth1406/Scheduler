import com.achttee.model.Activity;
import com.achttee.model.QuickNote;
import com.achttee.model.Scheduler;
import com.achttee.model.SpecialDate;
import com.achttee.model.abstraction.AbstractNote;
import com.achttee.model.abstraction.SchedulerHandler;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.YearMonth;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimePrinter;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sun.jvm.hotspot.utilities.AssertionFailure;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.*;

@FixMethodOrder(MethodSorters.JVM)
public class TimetableTest {


    private static final  Scheduler<LocalDate,Integer,AbstractNote> scheduler = Scheduler.createDefault();

    @Test
    public void testSchedulerInit()  {
        Assert.assertNotNull(scheduler);
    }

    @Test
    public void testSearch(){
        AbstractNote qNote = QuickNote.with("QuickNote", "Testing quick note");
        AbstractNote activity = new Activity("Activity","Testing activity");
        AbstractNote activity1 = new Activity("Activity 1","Testing activity");
        AbstractNote activity2 = new Activity("Activity 2","Testing activity");
        AbstractNote sDate = new SpecialDate("Christmas","Merry Christmas");
        AbstractNote testSDate = new SpecialDate("Christmas","Merry Christmas");
        scheduler.add(LocalDate.now(), qNote);
        scheduler.add(LocalDate.now(),activity);
        scheduler.add(LocalDate.now(),sDate);


        Assert.assertNotNull(scheduler.searchBy(LocalDate.now(),"QuickNote",qNote.getId()));
        Assert.assertEquals(scheduler.searchBy(LocalDate.now(),"QuickNote",1),qNote);
        Assert.assertNotNull(scheduler.searchBy(LocalDate.now(),"Activity",qNote.getId()));
        Assert.assertEquals(scheduler.searchBy(LocalDate.now(),"Activity",2),activity);
        Assert.assertNotEquals(scheduler.searchBy(LocalDate.now(),"SpecialDate",5),testSDate);
        Assert.assertEquals(scheduler.searchBy(LocalDate.now(),"SpecialDate",6),null);

    }


    @Test
    public void testSearchAll(){
        AbstractNote qNote = QuickNote.with("QuickNote", "Testing Search All");
        AbstractNote activity = new Activity("Activity","Testing activity");
        AbstractNote sDate = new SpecialDate("Christmas","Merry Christmas");

        scheduler.add(LocalDate.now(), qNote);
        scheduler.add(LocalDate.now(),activity);
        scheduler.add(LocalDate.now(),sDate);


        Assert.assertEquals(scheduler.searchAll(LocalDate.now(),"QuickNote"), Arrays.asList(qNote));
        Assert.assertEquals(scheduler.searchAll(LocalDate.now(),"Activity"),Arrays.asList(activity));
        Assert.assertEquals(scheduler.searchAll(LocalDate.now(),"SpecialDate"),Arrays.asList(sDate));
    }


    @Test
    public void testUpdate(){
        AbstractNote qNote = QuickNote.with("QuickNote From Test Update", "Testing quick note");
        AbstractNote activity = new Activity("Activity","Testing activity");
        scheduler.add(LocalDate.now(), qNote);
        scheduler.add(LocalDate.now(),activity);
        qNote.setName("QuickNote after update");


//        scheduler.update(LocalDate.parse("2020-05-09"), qNote);

//        Assert.assertSame(scheduler.searchBy(LocalDate.now(), qNote).getId(),6);
//        Assert.assertEquals(scheduler.searchBy(LocalDate.now(),qNote),qNote);
//        Assert.assertEquals(scheduler.searchBy(LocalDate.now(),qNote).getFromTime().toString(),"2020-05-09");

    }


    @Test(expected = InvalidPropertiesFormatException.class)
    public void testRepeat() throws InvalidPropertiesFormatException {
        AbstractNote notes = QuickNote.with("Hello","Testing");
        notes.repeatFor(- 6);
    }



}
