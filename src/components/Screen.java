package components;

import helper.Helper;

public abstract class Screen {
    public Screen() {}

    public Screen(String notification) {
        System.out.println(notification);
    }

    /** Show the screen */
    public abstract void showScreen();
}