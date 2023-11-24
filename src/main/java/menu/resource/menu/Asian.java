package menu.resource.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Asian {
    팟타이, 카오, 팟, 나시고렝, 파인애플, 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜;

    private static final String TYPE = "Asian";

    public static List<Map<String,String>> getMenus(){
        List<Asian> asianMenus = new ArrayList<>(Arrays.asList(Asian.values()));
        List<Map<String, String>> menus = new ArrayList<>();

        for (Asian menu : asianMenus) {
            Map<String, String> menuMatchType = new HashMap<>();
            menuMatchType.put(menu.name(), TYPE);
            menus.add(menuMatchType);
        }

        return menus;
    }
}
