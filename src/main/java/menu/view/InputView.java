package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.util.validation.CoachNameValidator;
import menu.util.validation.MenuNameValidator;

public class InputView {
    private final static String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final static String INPUT_COACH_CANNOT_EAT_MENUS = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public List<String> getCoachName() {
        System.out.println(INPUT_COACH_NAME);
        String coachNameInput = Console.readLine();
        CoachNameValidator.validateCoachName(coachNameInput);
        List<String> coachNames = List.of(coachNameInput.replace(" ","").split(","));
        return coachNames;
    }

    public List<Coach> getCoachCannotEatMenus(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            System.out.println(coachName + INPUT_COACH_CANNOT_EAT_MENUS);
            String menuNameInput = Console.readLine();
            MenuNameValidator.validateMenuName(menuNameInput);
        }
    }
}
