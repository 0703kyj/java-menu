package menu.resource.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Chinese{
    깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토_달걀볶음, 고추잡채;

    private static final String TYPE = "Chinese";

    public static List<Map<String,String>> getMenus(){
        List<Chinese> chineseMenus = new ArrayList<>(Arrays.asList(Chinese.values()));
        List<Map<String, String>> menus = new ArrayList<>();

        for (Chinese menu : chineseMenus) {
            Map<String, String> menuMatchType = new HashMap<>();
            menuMatchType.put(menu.name().replace("_"," "), TYPE);
            menus.add(menuMatchType);
        }

        return menus;
    }
}
