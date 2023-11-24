package menu.controller;

import java.util.List;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {

    private InputView inputView;
    private OutputView outputView;


    public RecommendController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        input();
        output();
    }

    private void input() {
        List<String> coachNames = inputView.inputCoachNames();
        System.out.println(coachNames);
    }

    private void output() {

    }
}
