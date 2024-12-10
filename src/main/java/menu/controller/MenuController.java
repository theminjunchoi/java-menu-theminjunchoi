package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printServiceStart();
        List<Coach> coaches = getInputs();
    }

    private List<Coach> getInputs() {
        List<String> coachNames = getCoachNames();
        List<Coach> coaches = getCoachCannotEatMenus(coachNames);
        return coaches;
    }

    private List<String> getCoachNames() {
        try {
            return inputView.getCoachName();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getCoachNames();
        }
    }

    private List<Coach> getCoachCannotEatMenus(List<String> coachNames) {
        try {
            return inputView.getCoachCannotEatMenus(coachNames);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getCoachCannotEatMenus(coachNames);
        }
    }
}
