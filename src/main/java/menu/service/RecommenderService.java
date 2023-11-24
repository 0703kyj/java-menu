package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.time.DayOfWeek;
import java.util.List;
import menu.domain.Recommender;
import menu.resource.Categories;

public class RecommenderService {
    private Recommender recommender;

    private List<String> recommendDates = List.of(
            DayOfWeek.MONDAY.name(),
            DayOfWeek.TUESDAY.name(),
            DayOfWeek.WEDNESDAY.name(),
            DayOfWeek.THURSDAY.name(),
            DayOfWeek.FRIDAY.name()
    );

    public RecommenderService(Recommender recommender) {
        this.recommender = recommender;
    }

    public void setRecommendDates(){
        for (String recommendDate : recommendDates) {
            while(!recommendCategory(recommendDate));
        }
    }

    private boolean recommendCategory(String recommendDate) {
        String category = Categories.get(Randoms.pickNumberInRange(1, 5));
        System.out.println("category = " + category+"/"+ recommendDate);
        return recommender.setWeekRecommendCategory(recommendDate,category);
    }
}
