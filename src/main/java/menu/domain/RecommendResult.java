package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.service.CategoryMaker;
import menu.service.MenuMaker;
import menu.util.randomNumberGenerator.CategoryRandomNumberGenerator;

public class RecommendResult {
    private final List<Coach> coaches;
    private List<Category> categories;
    private final CategoryRandomNumberGenerator categoryRandomNumberGenerator;

    public RecommendResult(List<Coach> coaches) {
        this.coaches = coaches;
        this.categories = new ArrayList<>();
        this.categoryRandomNumberGenerator  = new CategoryRandomNumberGenerator();
    }

    public void makeRecommendResult() {
        generateRandomCategories();
        generateRandomMenus();
    }

    private void generateRandomCategories() {
        CategoryMaker categoryMaker = new CategoryMaker(categoryRandomNumberGenerator);
        this.categories = categoryMaker.makeCategories();
    }

    private void generateRandomMenus() {
        for (Category category : categories) {
            MenuMaker menuMaker = new MenuMaker(coaches, category);
            menuMaker.makeRandomMenus();
        }
    }
}
