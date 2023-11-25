package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Menu;
import menu.domain.Recommender;
import menu.resource.Categories;
import menu.resource.RecommendDate;

public class RecommenderService {
    private Recommender recommender;

    public RecommenderService(Recommender recommender) {
        this.recommender = recommender;
    }

    public String recommendTodayMenu(String dayOfWeek) {
        Menu menu = Menu.getInstance();
        String category = recommender.getCategory(dayOfWeek);
        String recommendMenu = menu.selectMenuByCategory(category);

        return recommendMenu;
    }

    public void setRecommendDates(){
        for (String recommendDate : RecommendDate.getRecommendDates()) {
            while(!recommendCategory(recommendDate));
        }
    }

    private boolean recommendCategory(String recommendDate) {
        String category = Categories.get(Randoms.pickNumberInRange(1, 5));
        return recommender.setWeekRecommendCategory(recommendDate,category);
    }

    public String getCategories(){
        return recommender.toString();
    }
}
