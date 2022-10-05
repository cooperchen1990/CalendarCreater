package cooper.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class NormalCalendar {
    LocalDate starDay;
    LocalDate endDay;
    ArrayList<LocalDate> holidayList;
    ArrayList<LocalDate> cancelHolidayList;
    final int WORKTIME= 8;

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
            dayObj.workTime = ;

            starDay.plusDays(1);
        }


        //預設週六週日為假日

        return dayList;
    }
}
