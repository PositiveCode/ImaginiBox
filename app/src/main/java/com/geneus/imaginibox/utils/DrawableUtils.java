package com.geneus.imaginibox.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.geneus.imaginibox.R;

import java.util.Random;

public class DrawableUtils {
    /*
     * When the randomized number generated is these:
     * 0 = china
     * 1 = usa
     * 2 = malaysia
     * 3 = japan
     * */

    public static Drawable randomizeDrawable(Context context) {
        Drawable drawable = context.getDrawable(R.drawable.ic_china);
        int random = new Random().nextInt(4);

        switch (random) {
            case 0:
                drawable = context.getDrawable(R.drawable.ic_china);
                break;
            case 1:
                drawable = context.getDrawable(R.drawable.ic_usa);
                break;
            case 2:
                drawable = context.getDrawable(R.drawable.ic_malaysia);
                break;
            case 3:
                drawable = context.getDrawable(R.drawable.ic_japan);
                break;
        }

        return drawable;
    }

    public static int randomizeDrawableRes() {
        int random = new Random().nextInt(4);

        switch (random) {
            case 0:
                return R.drawable.ic_china;
            case 1:
                return R.drawable.ic_usa;
            case 2:
                return R.drawable.ic_malaysia;
            case 3:
                return R.drawable.ic_japan;
            default:
                return 0;
        }
    }

    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}
