package menu.exception.argument;

public class InvalidCoachesCountException extends RecommendArgumentException{
    public InvalidCoachesCountException() {
        super("코치는 최소 2명 이상, 최대 5명 이하로 입력해야 합니다.");
    }
}
