package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.resource.RecommendDate;
import menu.service.CoachService;
import menu.service.RecommenderService;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {

    private InputView inputView;
    private OutputView outputView;
    private CoachService coachService;
    private RecommenderService recommenderService;

    public RecommendController(InputView inputView, OutputView outputView, CoachService coachService,
                               RecommenderService recommenderService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.coachService = coachService;
        this.recommenderService = recommenderService;
    }

    public void run() {
        outputView.printStartMessage();
        input();
        recommenderService.setRecommendDates();
        for (String dayOfWeek : RecommendDate.getRecommendDates()) {
            recommendByDates(dayOfWeek);
        }
        output();
    }

    private void recommendByDates(String dayOfWeek) {
        for (String coachName : coachService.getCoachNames()) {
            while(!recommendMenuToCoach(coachName, dayOfWeek));
        }
    }

    private boolean recommendMenuToCoach(String coachName, String dayOfWeek) {
        String menu = recommenderService.recommendTodayMenu(dayOfWeek);
        if(!coachService.recommendFood(coachName, menu)){
            return false;
        }
        return true;
    }

    private void input() {
        inputCoaches();
        inputCantEatFood();
    }

    private void inputCantEatFood() {
        List<String> coachNames = coachService.getCoachNames();
        for (String coachName : coachNames) {
            List<String> cantEatMenus = inputView.inputCantEatMenus(coachName);
            coachService.setCantEatMenus(coachName,cantEatMenus);
        }
    }

    private void inputCoaches() {
        List<String> coachNames = inputView.inputCoachNames();
        coachService.setCoaches(coachNames);
    }

    private void output() {
        List<Coach> coaches = coachService.getCoaches();
        outputView.printResult(coaches,recommenderService.getCategories());
    }
}
