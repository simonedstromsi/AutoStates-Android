package com.example.autostate;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AutoState {

    public static EditText apply(View ...views){
        for(View view: views) {
            apply(view);
        }
        return null;
    }

    public static void apply(View view) {
        Drawable drawable = view.getBackground();
        if(drawable != null) {
            ViewCompat.setBackground(view, autoState(drawable));
        }

        if(view instanceof TextView) {
            ((TextView) view).setTextColor(autoState(((TextView) view).getTextColors().getDefaultColor()));
        }
    }

    public static ColorStateList autoState(int color) {
        return new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_pressed},
                        new int[]{android.R.attr.state_enabled},
                        new int[]{}
                },
                new int[]{
                        pressed(color),
                        color,
                        disabled(color)}
        );
    }

    public static Drawable autoState(Drawable drawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressed(drawable));
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, drawable);
        stateListDrawable.addState(new int[]{}, disabled(drawable));
        return stateListDrawable;
    }

    /**
     * Pressed states
     */
    private final static int PRESSED_DRAWABLE = Color.argb(50, 0, 0, 0);
    private static Drawable pressed(Drawable source) {
        Drawable drawable = source.getConstantState().newDrawable();
        drawable.setColorFilter(PRESSED_DRAWABLE, PorterDuff.Mode.SRC_OVER);
        return drawable;
    }

    private static int pressed(int source) {
        return source;
    }

    /**
     * Disabled states
     */
    private final static int DISABLED_DRAWABLE = Color.argb(80, 255, 255, 255);
    private static Drawable disabled(Drawable source) {
        Drawable drawable = source.getConstantState().newDrawable();
        drawable.setColorFilter(DISABLED_DRAWABLE, PorterDuff.Mode.SRC_ATOP);
        return drawable;
    }

    private final static int DISABLED_TEXT = Color.argb(150, 150, 150, 150);
    private static int disabled(int color) {
        return ColorUtils.setAlphaComponent(color, 100);
    }

}
