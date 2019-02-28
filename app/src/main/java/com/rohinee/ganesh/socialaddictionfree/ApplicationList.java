package com.rohinee.ganesh.socialaddictionfree;

import android.graphics.drawable.Drawable;

public class ApplicationList {
    private String name;
    Drawable icon;

    public ApplicationList(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }
}
