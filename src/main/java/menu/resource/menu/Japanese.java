package menu.resource.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Japanese {
    규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼;

    private static final String TYPE = "Japanese";

    public static List<Map<String,String>> getMenus(){
        List<Japanese> japaneseMenus = new ArrayList<>(Arrays.asList(Japanese.values()));
        List<Map<String, String>> menus = new ArrayList<>();

        for (Japanese menu : japaneseMenus) {
            Map<String, String> menuMatchType = new HashMap<>();
            menuMatchType.put(menu.name(), TYPE);
            menus.add(menuMatchType);
        }

        return menus;
    }
}
