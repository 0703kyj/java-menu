package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.validator.InputValidator;

public class InputView {
    private static final String INPUT_DELIMITER = ",";
    private static final String INPUT_COACH_NAME
            = "코치의 이름을 입력해 주세요. ("+INPUT_DELIMITER+" 로 구분)";

    public List<String> inputCoachNames(){
        List<String> coaches = repeat(this::makeCoaches);

        return coaches;
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
