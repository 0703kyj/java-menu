package menu.resource.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Korean {
    김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음;

    private static final String TYPE = "Korean";

    public static List<Map<String,String>> getMenus(){
        List<Korean> koreanMenus = new ArrayList<>(Arrays.asList(Korean.values()));
        List<Map<String, String>> menus = new ArrayList<>();

        for (Korean menu : koreanMenus) {
            Map<String, String> menuMatchType = new HashMap<>();
            menuMatchType.put(menu.name(), TYPE);
            menus.add(menuMatchType);
        }

        return menus;
    }
}
