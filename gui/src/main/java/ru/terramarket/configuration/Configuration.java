package ru.terramarket.configuration;

import ru.terramarket.configuration.bean.MenuPart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 26.05.14
 * Time: 15:29
 */
public class Configuration implements Serializable {
    private List<MenuPart> menus = new ArrayList<>();
    private List<MenuPart> viewParts = new ArrayList<>();

    public Configuration() {
    }

    public List<MenuPart> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuPart> menus) {
        this.menus = menus;
    }

    public List<MenuPart> getViewParts() {
        return viewParts;
    }

    public void setViewParts(List<MenuPart> viewParts) {
        this.viewParts = viewParts;
    }
}
