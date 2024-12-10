package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;

public class OutputView {
    private final static String SERVICE_START = "점심 메뉴 추천을 시작합니다.\n";
    private final static String MENU_RECOMMEND_RESULT = "메뉴 추천 결과입니다.";
    private final static String RECOMMEND_RESULT_DAY_WEEK = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private final static String RECOMMEND_RESULT_CATEGORY = "[ 카테고리 | %s | %s | %s | %s | %s ]\n";
    private final static String RECOMMEND_RESULT_MENU = "[ %s | %s | %s | %s | %s | %s ]\n";
    private final static String SERVICE_END = "추천을 완료했습니다.";

    public void printServiceStart() {
        System.out.println(SERVICE_START);
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e);
    }

    public void printRecommendResult(List<Coach> coaches, List<Category> categories) {
        System.out.println(MENU_RECOMMEND_RESULT);
        System.out.println(RECOMMEND_RESULT_DAY_WEEK);
        printCategories(categories);
        printCoachesMenu(coaches);
        System.out.println();
        System.out.println(SERVICE_END);
    }

    private void printCategories(List<Category> categories) {
        System.out.printf(RECOMMEND_RESULT_CATEGORY,
                categories.get(0).getCategoryName(),
                categories.get(1).getCategoryName(),
                categories.get(2).getCategoryName(),
                categories.get(3).getCategoryName(),
                categories.get(4).getCategoryName()
        );
    }

    private void printCoachesMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            System.out.printf(RECOMMEND_RESULT_MENU,
                    coach.getCoachName(),
                    coach.getRecommendMenus().get(0).getMenuName(),
                    coach.getRecommendMenus().get(1).getMenuName(),
                    coach.getRecommendMenus().get(2).getMenuName(),
                    coach.getRecommendMenus().get(3).getMenuName(),
                    coach.getRecommendMenus().get(4).getMenuName()
            );
        }
    }
}
