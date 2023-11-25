package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
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

    public String selectMenuByCategory(String category) {
        List<String> menus = findMenuByCategory(category);
        String menu = Randoms.shuffle(menus).get(0);

        return menu;
    }

    private static List<String> findMenuByCategory(String category) {
        List<String> findMenus = new ArrayList<>();
        for (Map<String, String> menu : menus) {
            List<String> keys = new ArrayList<>(menu.keySet());
            if(menu.get(keys.get(0)).equals(category)){
                findMenus.add(keys.get(0));
            }
        }
        return findMenus;
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
