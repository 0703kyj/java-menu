package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> cantNotEatMenus;
    private List<String> recommendedMenus;

    public Coach(String name) {
        this.name = name;
        cantNotEatMenus = new ArrayList<>();
        recommendedMenus = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void updateCantNotEatMenus(String cantNotEatMenu) {
        if(cantNotEatMenus.contains(cantNotEatMenu)){
            return;
        }
        cantNotEatMenus.add(cantNotEatMenu);
    }

    public boolean updateRecommendedMenus(String recommendedMenu) {
        if(recommendedMenus.contains(recommendedMenu)){
            return false;
        }
        if (cantNotEatMenus.contains(recommendedMenu)) {
            return false;
        }
        recommendedMenus.add(recommendedMenu);
        return true;
    }

    @Override
    public String toString() {
        return "[ "+name+" | "+String.join(" | ",recommendedMenus)+" ]";
    }

    @Override
    public boolean equals(Object name) {
        String coachName = (String)name;
        return this.name == coachName;
    }
}
