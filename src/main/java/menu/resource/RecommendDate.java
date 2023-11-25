package menu.resource;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum RecommendDate {
    MONDAY(DayOfWeek.MONDAY.name()),
    TUESDAY(DayOfWeek.TUESDAY.name()),
    WEDNESDAY(DayOfWeek.WEDNESDAY.name()),
    THURSDAY(DayOfWeek.THURSDAY.name()),
    FRIDAY(DayOfWeek.FRIDAY.name());

    private String dayOfWeek;
    RecommendDate(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public static List<String> getRecommendDates(){
        List<RecommendDate> Dates = Arrays.asList(RecommendDate.values());
        List<String> recommendDates = new ArrayList<>();
        for (RecommendDate recommendDate : Dates) {
            recommendDates.add(recommendDate.dayOfWeek);
        }

        return recommendDates;
    }
}
