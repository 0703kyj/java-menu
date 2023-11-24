package menu.exception.state;

public class NotFoundCoachException extends RecommendStateException{
    public NotFoundCoachException() {
        super("해당 코치를 찾을 수 없습니다.");
    }
}
