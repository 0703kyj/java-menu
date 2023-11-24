package menu.exception.argument;

public class InvalidCantEatFoodCountException extends RecommendArgumentException{
    public InvalidCantEatFoodCountException() {
        super("못 먹는 메뉴는 최소 0개, 최대 2개여야 합니다.");
    }
}
