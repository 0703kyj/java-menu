package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> cantNotEatMenus;

    public Coach(String name) {
        this.name = name;
        cantNotEatMenus = new ArrayList<>();
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

    @Override
    public boolean equals(Object name) {
        String coachName = (String)name;
        return this.name == coachName;
    }
}
