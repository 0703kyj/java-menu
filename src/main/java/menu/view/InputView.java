package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.util.Console;
import menu.validator.InputValidator;

public class InputView {
    private static final String INPUT_DELIMITER = ",";
    private static final String INPUT_COACH_NAME
            = "코치의 이름을 입력해 주세요. ("+INPUT_DELIMITER+" 로 구분)";
    private static final String INPUT_CANT_EAT_FOOD
            = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public List<String> inputCoachNames(){
        List<String> coaches = repeat(this::makeCoaches);

        return coaches;
    }

    public List<String> inputCantEatMenus(String coachName) {
        List<String> cantEatMenus = repeat(()->makeCantEatMenus(coachName));
        return cantEatMenus;
    }

    private List<String> makeCantEatMenus(String coachName) {
        System.out.println(coachName+INPUT_CANT_EAT_FOOD);

        String cantEatFoodNames = Console.readLine();
        List<String> cantEatFoods = splitToDelimiter(cantEatFoodNames);

        InputValidator.validateCantEatFoods(cantEatFoods);
        return cantEatFoods;
    }

    private List<String> makeCoaches() {
        System.out.println(INPUT_COACH_NAME);

        String coachNames = Console.readLine();
        List<String> coaches = splitToDelimiter(coachNames);

        InputValidator.validateCoaches(coaches);
        return coaches;
    }

    private List<String> splitToDelimiter(String input) {
        return Arrays.stream(input.split(INPUT_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private <T> T repeat(Supplier<T> supplier) {
        while (true) {
            try {
                T result = supplier.get();
                return result;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception);
            }
        }
    }
}
