package menu.util.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.util.exception.InputException;

public class CoachNameValidator {
    public static void validateCoachName(String input) {
        validateCoachNameCount(input);
        validateDuplicateCoachName(input);
        validateCoachNameLength(input);
    }

    private static void validateCoachNameCount(String input) {
        List<String> coachNames = List.of(input.replace(" ", "").split(","));
        if (coachNames.size() < 2) {
            throw new IllegalArgumentException(InputException.OUT_OF_COACH_NAME_COUNT_MIN.getExceptionMessage());
        }
        if (coachNames.size() > 5) {
            throw new IllegalArgumentException(InputException.OUT_OF_COACH_NAME_COUNT_MAX.getExceptionMessage());
        }
    }

    private static void validateDuplicateCoachName(String input) {
        List<String> coachNames = List.of(input.replace(" ", "").split(","));
        Set<String> uniqueCoachNames = new HashSet<>(coachNames);
        if(uniqueCoachNames.size() != coachNames.size()) {
            throw new IllegalArgumentException(InputException.DUPLICATE_COACH_NAME.getExceptionMessage());
        }
    }

    private static void validateCoachNameLength(String input) {
        List<String> coachNames = List.of(input.replace(" ", "").split(","));
        for (String coachName : coachNames) {
            if (coachName.length() < 2) {
                throw new IllegalArgumentException(InputException.OUT_OF_COACH_NAME_LENGTH_MIN.getExceptionMessage());
            }
            if (coachName.length() > 4) {
                throw new IllegalArgumentException(InputException.OUT_OF_COACH_NAME_LENGTH_MAX.getExceptionMessage());
            }
        }
    }
}
