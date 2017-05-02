package com.example.bikramkoju.newdesigncode;

/**
 * Created by Bikramkoju on 5/2/2017.
 */

public class TabMessage {
    public static String get(int menuItemId, boolean isReselection) {
        String message = "Content for ";

        switch (menuItemId) {

            case R.id.tab_favorites:
                message += "favorites";
                break;
            case R.id.tab_nearby:
                message += "nearby";
                break;
            case R.id.tab_friends:
                message += "friends";
                break;
        }

        if (isReselection) {
            message += " WAS RESELECTED! YAY!";
        }

        return message;
    }
}
