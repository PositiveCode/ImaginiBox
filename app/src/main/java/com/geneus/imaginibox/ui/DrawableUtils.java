package com.geneus.imaginibox.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;

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

    public static Drawable randomizeDrawable(Context context){
        Drawable drawable = context.getDrawable(R.drawable.ic_china);
        int random = new Random().nextInt(4);

        switch(random){
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
}
