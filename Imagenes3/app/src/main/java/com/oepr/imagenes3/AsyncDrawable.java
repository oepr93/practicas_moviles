package com.oepr.imagenes3;

import java.lang.ref.WeakReference;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

// Solve problem using ListView and GridView
class AsyncDrawable extends BitmapDrawable {
    private final WeakReference<BitmapWorkerTask> bitmapWorkerTaskReference;

    AsyncDrawable(Resources resources, Bitmap bitmap, BitmapWorkerTask bitmapWorkerTask) {
        super(resources, bitmap);
        bitmapWorkerTaskReference = new WeakReference<>(bitmapWorkerTask);
    }

    BitmapWorkerTask getBitmapWorkerTask() {
        return bitmapWorkerTaskReference.get();
    }
}