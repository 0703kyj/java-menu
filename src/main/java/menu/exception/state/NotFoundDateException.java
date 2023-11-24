package menu.exception.state;

public class NotFoundDateException extends RecommendStateException{
    public NotFoundDateException() {
        super("존재하지 않는 요일입니다.");
    }
}
