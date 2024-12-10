package menu.view;

public class OutputView {
    private final static String SERVICE_START = "점심 메뉴 추천을 시작합니다.\n";
    private final static String MENU_RECOMMEND_RESULT = "메뉴 추천 결과입니다.";
    private final static String RECOMMEND_RESULT_DAY_WEEK = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private final static String RECOMMEND_RESULT_CATEGORY = "[ 카테고리 | ";
    private final static String RECOMMEND_RESULT_PARTITION = " | ";
    private final static String RECOMMEND_RESULT_START = "[ ";
    private final static String RECOMMEND_RESULT_END = " ]";
    private final static String SERVICE_END = "추천을 완료했습니다.";

    public void printServiceStart() {
        System.out.println(SERVICE_START);
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e);
    }
}
