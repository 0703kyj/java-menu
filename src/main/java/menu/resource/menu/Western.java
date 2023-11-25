package menu.resource.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Western {
    라자냐, 그라탱, 뇨끼, 끼슈, 프렌치_토스트, 바게트, 스파게티, 피자, 파니니;

    private static final String TYPE = "Western";

    public static List<Map<String,String>> getMenus(){
        List<Western> westernMenus = new ArrayList<>(Arrays.asList(Western.values()));
        List<Map<String, String>> menus = new ArrayList<>();

        for (Western menu : westernMenus) {
            Map<String, String> menuMatchType = new HashMap<>();
            menuMatchType.put(menu.name().replace("_"," "), TYPE);
            menus.add(menuMatchType);
        }

        return menus;
    }
}
