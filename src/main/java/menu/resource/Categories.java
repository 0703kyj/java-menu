package menu.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.exception.state.NotFoundCategoryException;

public enum Categories {
    Japanese(1),
    Korean(2),
    Chinese(3),
    Asian(4),
    Western(5);

    private int value;
    Categories(int value) {
        this.value = value;
    }

    public static String get(int value) {
        List<Categories> categories = new ArrayList<>(Arrays.asList(Categories.values()));

        for (Categories category : Categories.values()) {
            if (category.value == value) {
                return category.name();
            }
        }
        throw new NotFoundCategoryException();
    }
}
