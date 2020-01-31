package com.geneus.imaginibox.utils;

import java.util.Random;

import jp.co.cyberagent.android.gpuimage.filter.GPUImage3x3ConvolutionFilter;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageBoxBlurFilter;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageChromaKeyBlendFilter;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageColorBurnBlendFilter;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter;

public class FilterUtils {
    public static GPUImageFilter randomizeFilter() {
        /*very simple gpu filter randomizing utils*/
        int random = new Random().nextInt(4);

        switch (random){
            case 0: return new GPUImageBoxBlurFilter();
            case 1: return new GPUImage3x3ConvolutionFilter();
            case 2: return new GPUImageChromaKeyBlendFilter();
            case 3: return new GPUImageColorBurnBlendFilter();
        }
        return new GPUImageBoxBlurFilter();
    }
}
