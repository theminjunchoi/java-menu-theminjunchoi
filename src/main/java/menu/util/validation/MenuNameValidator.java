package menu.util.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.domain.Category;
import menu.util.exception.InputException;

public class MenuNameValidator {
    private final static int CANNOT_EAT_MENUS_COUNT_LIMIT = 2;

    public static void validateMenuName(String input) {
        validateDuplicateMenus(input);
        validateMenuLength(input);
        validateMenuInCategory(input);
    }

    private static void validateDuplicateMenus(String input) {
        List<String> cannotEatMenus = List.of(input.replace(" ","").split(","));
        Set<String> uniqueCannotEatMenus = new HashSet<>(cannotEatMenus);
        if (cannotEatMenus.size() != uniqueCannotEatMenus.size()) {
            throw new IllegalArgumentException(InputException.DUPLICATE_COACH_MENUS.getExceptionMessage());
        }
    }

    private static void validateMenuLength(String input) {
        List<String> cannotEatMenus = List.of(input.replace(" ","").split(","));
        if(cannotEatMenus.size() > CANNOT_EAT_MENUS_COUNT_LIMIT) {
            throw new IllegalArgumentException(InputException.OUT_OF_RANGE_MENU_COUNT.getExceptionMessage());
        }
    }

    private static void validateMenuInCategory(String input) {
        if(input.isEmpty()) {
            return;
        }
        List<String> cannotEatMenus = List.of(input.replace(" ","").split(","));
        for(String cannotEatMenu : cannotEatMenus) {
            Category menuCategory = Category.of(cannotEatMenu);
            if(menuCategory == Category.INVALID_CATEGORY) {
                throw new IllegalArgumentException(InputException.INVALID_MENU.getExceptionMessage());
            }
        }
    }
}
