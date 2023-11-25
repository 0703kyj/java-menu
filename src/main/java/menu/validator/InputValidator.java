package menu.validator;

import java.util.List;
import menu.domain.Menu;
import menu.exception.argument.InvalidCantEatFoodCountException;
import menu.exception.argument.InvalidCoachNameException;
import menu.exception.argument.InvalidCoachesCountException;
import menu.exception.argument.InvalidFoodException;

public class InputValidator {

    public static void validateCoaches(List<String> coaches) {
        validateCoachesCount(coaches);
        validateCoachesNameCount(coaches);
    }

    public static void validateCantEatFoods(List<String> cantEatFoods){
        validateCantEatFoodsCount(cantEatFoods);
        validateValidCantEatFoods(cantEatFoods);
    }

    private static void validateValidCantEatFoods(List<String> cantEatFoods) {
        for (String cantEatFood : cantEatFoods) {
            Menu menu = Menu.getInstance();

            if(!menu.contains(cantEatFood)){
                throw new InvalidFoodException();
            }
        }
    }

    private static void validateCantEatFoodsCount(List<String> cantEatFoods) {
        int cantEatFoodsCount = cantEatFoods.size();

        if (cantEatFoodsCount < 0 || cantEatFoodsCount > 2) {
            throw new InvalidCantEatFoodCountException();
        }
    }

    private static void validateCoachesCount(List<String> coaches) {
        int coachesCount = coaches.size();

        if (coachesCount < 2 || coachesCount > 5) {
            throw new InvalidCoachesCountException();
        }
    }

    private static void validateCoachesNameCount(List<String> coaches) {
        for (String coach : coaches) {
            if (coach.length() < 2 || coach.length() > 4) {
                throw new InvalidCoachNameException();
            }
        }
    }
}
