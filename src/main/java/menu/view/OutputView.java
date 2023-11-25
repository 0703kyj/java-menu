package menu.view;

import java.util.List;
import menu.domain.Coach;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String RESULT_TITLE_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

    public void printStartMessage(){
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    public void printResult(List<Coach>coaches, String categories){
        System.out.println(RESULT_MESSAGE);
        System.out.println(RESULT_TITLE_MESSAGE);
        System.out.println(categories);
        for (Coach coach : coaches) {
            System.out.println(coach);
        }
        System.out.println("추천을 완료했습니다.");
    }
}
