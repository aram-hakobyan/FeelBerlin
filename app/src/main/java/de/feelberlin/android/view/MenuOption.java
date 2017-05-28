package de.feelberlin.android.view;

/**
 * Created by Apple on 5/27/17.
 */

public class MenuOption {

    private int drawable;
    private String text;

    public MenuOption(int drawable, String text) {
        this.drawable = drawable;
        this.text = text;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
