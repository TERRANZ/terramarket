package ru.terramarket.configuration.bean;

/**
 * Date: 26.05.14
 * Time: 15:30
 */
public class MenuPart {
    private String text, shortcut, viewPart;

    public MenuPart() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getViewPart() {
        return viewPart;
    }

    public void setViewPart(String viewPart) {
        this.viewPart = viewPart;
    }
}
