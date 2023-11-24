package menu.controller;

import java.util.List;
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
        output();
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

    }
}
