package menu.util.randomNumberGenerator;

import camp.nextstep.edu.missionutils.Randoms;

public class CategoryRandomNumberGenerator implements RandomNumberGenerator{
    private static final int RANDOM_CATEGORY_NUM_MIN = 1;
    private static final int RANDOM_CATEGORY_NUM_MAX = 5;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_CATEGORY_NUM_MIN, RANDOM_CATEGORY_NUM_MAX);
    }
}
