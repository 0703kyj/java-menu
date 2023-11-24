package menu;

import menu.config.RecommendConfig;
import menu.controller.RecommendController;

public class Application {
    public static void main(String[] args) {

        RecommendController recommendController = RecommendConfig.getRecommendController();
        recommendController.run();
    }
}
