package menu.config;

import menu.controller.RecommendController;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendConfig {
    public static RecommendController getRecommendController(){

        return new RecommendController(getInputView(), getOutputView());
    }

    private static InputView getInputView(){
        return new InputView();
    }

    private static OutputView getOutputView(){
        return new OutputView();
    }
}
