package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String coachName;
    private final List<Menu> cannotEatMenus = new ArrayList<>();
    private final List<Menu> recommendMenus;

    public Coach(String coachName, List<Menu> cannotEatMenus) {
        this.coachName = coachName;
        this.cannotEatMenus.addAll(cannotEatMenus);
        this.recommendMenus = new ArrayList<>();
    }
}
