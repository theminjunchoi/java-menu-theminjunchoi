package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.util.exception.MenuException;

public class MenuMaker {
    private final List<Coach> coaches;
    private final Category category;

    public MenuMaker(List<Coach> coaches, Category category) {
        this.coaches = coaches;
        this.category = category;
    }

    public void makeRandomMenus() {
        List<String> menus = category.getMenuList()
                .stream()
                .map(Menu::getMenuName)
                .toList();
        for (Coach coach : coaches) {
            Menu menu = makeRandomMenu(menus, coach);
            coach.getRecommendMenus().add(menu);
        }
    }

    private Menu makeRandomMenu(List<String> menus, Coach coach) {
        try {
            Menu menu = generateRandomMenu(menus);
            validateMenu(menu, coach);
            return menu;
        } catch (IllegalStateException e) {
            return makeRandomMenu(menus, coach);
        }
    }

    private Menu generateRandomMenu(List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);
        return new Menu(menu);
    }

    private void validateMenu(Menu menu, Coach coach) {
        validateDuplicateRandomMenu(menu, coach);
        validateCannotEatRandomMenu(menu, coach);
    }

    private void validateDuplicateRandomMenu(Menu menu, Coach coach) {
        List<Menu> menus = coach.getRecommendMenus();
        if (menus.contains(menu)) {
            throw new IllegalStateException(MenuException.DUPLICATE_MENU.getExceptionMessage());
        }
    }

    private void validateCannotEatRandomMenu(Menu menu, Coach coach) {
        List<Menu> cannotEatMenus = coach.getCannotEatMenus();
        if (cannotEatMenus.contains(menu)) {
            throw new IllegalStateException(MenuException.CANNOT_EAT_MENU.getExceptionMessage());
        }
    }
}
