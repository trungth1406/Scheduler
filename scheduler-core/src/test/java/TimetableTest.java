import com.achttee.model.Timetable;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TimetableTest {


    /**
     * Test for singleton Timetable
     */
    @Test
    public void testTimetable(){
        Timetable tbl =Timetable.startWith(new Date());
        Timetable tbl2 = Timetable.startWith(new Date());
        Assert.assertNotEquals(tbl,tbl2);
    }
}
