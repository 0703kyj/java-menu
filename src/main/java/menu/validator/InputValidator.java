package menu.validator;

import java.util.List;
import menu.exception.argument.InvalidCoachNameException;
import menu.exception.argument.InvalidCoachesCountException;

public class InputValidator {

    public static void validateCoaches(List<String> coaches) {
        validateCoachesCount(coaches);
        validateCoachesNameCount(coaches);
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
