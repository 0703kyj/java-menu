package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.exception.state.NotFoundCoachException;
import menu.domain.Menu;

public class CoachService {
    private List<Coach> coaches;

    public CoachService() {
        coaches = new ArrayList<>();
    }

    public void setCoaches(List<String> coachNames) {
        coaches.clear();

        for (String coachName : coachNames) {
            coaches.add(new Coach(coachName));
        }
    }

    public List<String> getCoachNames(){
        List<String> coachNames = new ArrayList<>();

        for (Coach coach : coaches) {
            coachNames.add(coach.getName());
        }

        return coachNames;
    }

    public void setCantEatMenus(String coachName, List<String> cantEatMenus) {
        Coach coach = findCoach(coachName);

        for (String cantEatMenu : cantEatMenus) {
            coach.updateCantNotEatMenus(cantEatMenu);
        }
    }

    private Coach findCoach(String coachName) {
        for (Coach coach : coaches) {
            if (coach.equals(coachName)) {
                return coach;
            }
        }
        throw new NotFoundCoachException();
    }

    public boolean recommendFood(Menu menu){

        return false;
    }
}
