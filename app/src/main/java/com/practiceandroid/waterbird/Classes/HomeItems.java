package com.practiceandroid.waterbird.Classes;

public class HomeItems {
    private String name;
    private int pic;
    private String Color;

    public HomeItems(String name, int pic, String color) {
        this.name = name;
        this.pic = pic;
        Color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
