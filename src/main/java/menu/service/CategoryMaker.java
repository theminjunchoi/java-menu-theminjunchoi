package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.util.randomNumberGenerator.CategoryRandomNumberGenerator;

public class CategoryMaker {
    private final CategoryRandomNumberGenerator categoryRandomNumberGenerator;
    private final int CATEGORY_COUNT = 5;
    private final int CATEGORY_DUPLICATE_LIMIT = 1;

    public CategoryMaker(CategoryRandomNumberGenerator categoryRandomNumberGenerator) {
        this.categoryRandomNumberGenerator = categoryRandomNumberGenerator;
    }

    public List<Category> makeCategories() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < CATEGORY_COUNT; i++) {
            Category category = makeCategory(categories);
            categories.add(category);
        }
        return categories;
    }

    private Category makeCategory(List<Category> categories) {
        try {
            Category category = generateRandomCategory();
            validateCategory(category, categories);
            return category;
        } catch (IllegalStateException e) {
            return makeCategory(categories);
        }
    }

    private Category generateRandomCategory() {
        int randomNumber = categoryRandomNumberGenerator.generate();
        Category category = Category.makeCategory(randomNumber);
        return category;
    }

    private void validateCategory(Category category, List<Category> categories) {

    }
}
