package menu.controller;

import java.util.List;
import menu.service.CoachService;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {

    private InputView inputView;
    private OutputView outputView;
    private CoachService coachService;

    public RecommendController(InputView inputView, OutputView outputView, CoachService coachService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.coachService = coachService;
    }

    public void run() {
        outputView.printStartMessage();
        input();
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
