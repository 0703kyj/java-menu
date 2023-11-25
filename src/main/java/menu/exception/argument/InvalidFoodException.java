package menu.exception.argument;

public class InvalidFoodException extends RecommendArgumentException {

    public InvalidFoodException() {
        super("존재하지 않는 메뉴를 입력하였습니다.");
    }
}
