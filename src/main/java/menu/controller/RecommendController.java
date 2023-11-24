package menu.controller;

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

    private void input(){

    }

    private void output(){

    }
}
