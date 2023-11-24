package menu.exception.argument;

public class InvalidCoachNameException extends RecommendArgumentException {

    public InvalidCoachNameException() {
        super("코치의 이름은 최소 2글자, 최대 4글자여야 합니다.");
    }
}
