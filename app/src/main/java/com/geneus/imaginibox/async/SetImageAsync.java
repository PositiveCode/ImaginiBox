package com.geneus.imaginibox.async;

import android.content.Context;
import android.os.AsyncTask;

import com.geneus.imaginibox.utils.DrawableUtils;
import com.geneus.imaginibox.utils.FilterUtils;

import jp.co.cyberagent.android.gpuimage.GPUImageView;

public class SetImageAsync extends AsyncTask<String, Void, Void> {
    private GPUImageView gpuImageView;
    private Context context;

    public SetImageAsync(GPUImageView gpuImageView, Context context) {
        this.gpuImageView = gpuImageView;
        this.context = context;
    }


    protected Void doInBackground(String... urls) {
        return null;
    }

    protected void onPostExecute(Void result) {
        gpuImageView.setImage(DrawableUtils.getBitmapFromVectorDrawable(context, DrawableUtils.randomizeDrawableRes()));
        gpuImageView.setFilter(FilterUtils.randomizeFilter());
    }
}
