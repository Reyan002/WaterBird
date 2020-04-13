package com.practiceandroid.waterbird.Classes;

public class MenuItems {
    private String title,url;
    private boolean hasChild,isGroup;
    private int icons;

    public MenuItems(String title, String url, boolean hasChild, boolean isGroup, int icons) {
        this.title = title;
        this.url = url;
        this.hasChild = hasChild;
        this.isGroup = isGroup;
        this.icons = icons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public int getIcons() {
        return icons;
    }

    public void setIcons(int icons) {
        this.icons = icons;
    }
}
