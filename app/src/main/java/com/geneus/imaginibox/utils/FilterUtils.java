package com.geneus.imaginibox.utils;

import java.util.Random;

import jp.co.cyberagent.android.gpuimage.filter.GPUImageAlphaBlendFilter;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageBoxBlurFilter;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageCGAColorspaceFilter;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageColorInvertFilter;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter;

public class FilterUtils {

    public static int tapCount = 0;

    public static GPUImageFilter randomizeFilter() {
        /*very simple gpu filter randomizing utils*/
        int random = new Random().nextInt(4);

        switch (random){
            case 0: return new GPUImageBoxBlurFilter();
            case 1: return new GPUImageAlphaBlendFilter();
            case 2: return new GPUImageColorInvertFilter();
            case 3: return new GPUImageCGAColorspaceFilter();
        }
        return new GPUImageBoxBlurFilter();
    }

    public static GPUImageFilter getFilterByType(int type){
        switch (type){
            case 0: return new GPUImageBoxBlurFilter();
            case 1: return new GPUImageAlphaBlendFilter();
            case 2: return new GPUImageCGAColorspaceFilter();
            case 3: return new GPUImageColorInvertFilter();
        }
        return new GPUImageBoxBlurFilter();
    }
}
