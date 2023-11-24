package menu.domain;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;
import menu.exception.state.NotFoundDateException;

public class Recommender {

    private Map<String,String> categories;

    public Recommender() {
        this.categories = new HashMap<>();
        this.categories.put(DayOfWeek.MONDAY.name(),"");
        this.categories.put(DayOfWeek.TUESDAY.name(),"");
        this.categories.put(DayOfWeek.WEDNESDAY.name(),"");
        this.categories.put(DayOfWeek.THURSDAY.name(),"");
        this.categories.put(DayOfWeek.FRIDAY.name(),"");
    }

    public boolean setWeekRecommendCategory(String dayOfWeek, String category) {
        if(!validateDuplicate(category)){
            return false;
        }

        String replace = categories.replace(dayOfWeek, category);
        if (replace == null) {
            throw new NotFoundDateException();
        }
        return true;
    }

    public void recommendTodayMenu() {

    }

    private boolean validateDuplicate(String category) {
        long count = categories.values().stream()
                .filter(savedCategory -> savedCategory.equals(category))
                .count();

        if (count >= 2) {
            return false;
        }
        return true;
    }
}
