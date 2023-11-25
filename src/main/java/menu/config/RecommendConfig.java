package menu.config;

import menu.controller.RecommendController;
import menu.domain.Recommender;
import menu.service.CoachService;
import menu.service.RecommenderService;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendConfig {
    public static RecommendController getRecommendController(){
        return new RecommendController(
                getInputView(),
                getOutputView(),
                getCoachService(),
                getRecommenderService());
    }

    private static Recommender getRecommender(){
        return new Recommender();
    }

    private static RecommenderService getRecommenderService(){
        return new RecommenderService(getRecommender());
    }

    private static CoachService getCoachService(){
        return new CoachService();
    }

    private static InputView getInputView(){
        return new InputView();
    }

    private static OutputView getOutputView(){
        return new OutputView();
    }
}
