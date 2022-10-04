package cooper.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class NormalCalendar {
    LocalDate starDay;
    LocalDate endDay;
    ArrayList<LocalDate> holidayList;
    ArrayList<LocalDate> cancelHolidayList;

    public NormalCalendar(LocalDate starDay, LocalDate endDay, ArrayList<LocalDate> holidayList, ArrayList<LocalDate> cancelHolidayList) {
        this.starDay = starDay;
        this.endDay = endDay;
        this.holidayList = holidayList;
        this.cancelHolidayList = cancelHolidayList;
    }

    public ArrayList<DayObj> getDayList(){
        ArrayList<DayObj> dayList = new ArrayList<>();
        while (!starDay.isAfter(endDay)){
            DayObj dayObj = new DayObj();
            dayObj.localDate = starDay;

        }


        //預設週六週日為假日

        return dayList;
    }
}
