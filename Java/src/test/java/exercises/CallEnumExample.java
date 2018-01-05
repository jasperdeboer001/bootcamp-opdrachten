package exercises;

import org.testng.annotations.Test;

public class CallEnumExample {

    @Test
    public void PrintBootCampDays() {
        System.out.println(EnumExample.checkBootCampDaysInfo(EnumExample.BootCampDay.DAYONE));
        System.out.println(EnumExample.checkBootCampDaysInfo(EnumExample.BootCampDay.DAYTWO));
    }
}
