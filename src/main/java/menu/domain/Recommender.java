package menu.domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.exception.state.NotFoundDateException;
import menu.resource.RecommendDate;

public class Recommender {

    public Map<String,String> categories;

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

    public String getCategory(String dayOfWeek) {
        return categories.get(dayOfWeek);
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

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder("[ 카테고리 | ");
        List<String> categoryTitle = new ArrayList<>();
        for (String recommendDate : RecommendDate.getRecommendDates()) {
            String category = typeChange(categories.get(recommendDate));
            categoryTitle.add(category);
        }
        result.append(String.join(" | ",categoryTitle));
        result.append(" ]");

        return result.toString();
    }

    private String typeChange(String category) {
        if (category.equals("Japanese")) {
            return "일식";
        }
        if (category.equals("Korean")) {
            return "한식";
        }
        if (category.equals("Chinese")) {
            return "중식";
        }
        if (category.equals("Asian")) {
            return "아시안";
        }
        return "양식";
    }
}
