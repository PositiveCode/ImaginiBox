package com.geneus.imaginibox.async;

import android.content.Context;
import android.os.AsyncTask;

import com.geneus.imaginibox.R;
import com.geneus.imaginibox.utils.DrawableUtils;
import com.geneus.imaginibox.utils.FilterUtils;

import jp.co.cyberagent.android.gpuimage.GPUImageView;

public class SetImageAsync extends AsyncTask<String, Void, Void> {
    /*
    filter type:
    0 - blurred.
    1 - blurred.
     */

    private int filterType;
    private GPUImageView gpuImageView;
    private Context context;

    public SetImageAsync(GPUImageView gpuImageView, Context context, int filterType) {
        this.gpuImageView = gpuImageView;
        this.context = context;
        this.filterType = filterType;
    }


    protected Void doInBackground(String... urls) {
        return null;
    }

    protected void onPostExecute(Void result) {
        gpuImageView.setImage(DrawableUtils.getBitmapFromVectorDrawable(context, R.drawable.ic_usa));
        gpuImageView.setFilter(FilterUtils.getFilterByType(filterType));
    }
}
