package com.geneus.imaginibox.ui.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class ViewUtils {
    public static float dipToPixels(final Context _context, final float _dipValue) {
        final DisplayMetrics metrics = _context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _dipValue, metrics);
    }
}
