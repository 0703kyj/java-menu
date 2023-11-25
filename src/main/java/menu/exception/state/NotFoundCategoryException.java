package menu.exception.state;

public class NotFoundCategoryException extends RecommendStateException {

    public NotFoundCategoryException() {
        super("존재하지 않는 카테고리입니다.");
    }
}
