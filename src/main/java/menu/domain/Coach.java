package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String coachName;
    private final List<Menu> cannotEatMenus = new ArrayList<>();
    private final List<Menu> recommendMenus;

    public Coach(String coachName, List<String> cannotEatMenus) {
        this.coachName = coachName;
        for (String cannotEatMenu : cannotEatMenus) {
            this.cannotEatMenus.add(new Menu(cannotEatMenu));
        }
        this.recommendMenus = new ArrayList<>();
    }

    public List<Menu> getRecommendMenus() {
        return recommendMenus;
    }


    public List<Menu> getCannotEatMenus() {
        return cannotEatMenus;
    }
}
