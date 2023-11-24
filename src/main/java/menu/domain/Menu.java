package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.resource.menu.Asian;
import menu.resource.menu.Chinese;
import menu.resource.menu.Japanese;
import menu.resource.menu.Korean;
import menu.resource.menu.Western;

public class Menu {
    private static List<Map<String,String>> menus;
    private static Menu instance;

    private Menu() {
        menus = new ArrayList<>();
        setMenus();
    }

    private void setMenus() {
        menus.addAll(Japanese.getMenus());
        menus.addAll(Korean.getMenus());
        menus.addAll(Chinese.getMenus());
        menus.addAll(Asian.getMenus());
        menus.addAll(Western.getMenus());
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public static boolean contains(String menuName) {
        if (menuName.isBlank()) {
            return true;
        }

        for (Map<String, String> menu : menus) {
            if(findMenu(menu,menuName)){
                return true;
            }
        }
        return false;
    }

    private static boolean findMenu(Map<String, String> menu, String menuName) {
        for (String findMenu : menu.keySet()) {
            if (findMenu.equals(menuName)) {
                return true;
            }
        }
        return false;
    }
}
