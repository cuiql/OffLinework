package com.wabao.android.app.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.Volley;

public class AppUtils {

    private static RequestQueue mRequestQueue;

    private static ImageLoader mImageLoader;

    private static SharedPreferencesManager mSharePreferencesManager;

    public static void init(Context ctx) {
        mRequestQueue = Volley.newRequestQueue(ctx);
        mImageLoader = new ImageLoader(mRequestQueue, new BitmapCache());
        mSharePreferencesManager = new SharedPreferencesManager(ctx);
    }

    public static RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            throw new RuntimeException("RequestQueue is not init");
        }
        return mRequestQueue;
    }

    public static SharedPreferencesManager getSharedPreferencesManager() {
        if (mSharePreferencesManager == null) {
            throw new RuntimeException("mSharePreferencesManager is not init");
        }
        return mSharePreferencesManager;
    }

    public static ImageLoader getImageLoader() {
        if (mImageLoader == null) {
            throw new RuntimeException("ImageLoader is not init");
        }
        return mImageLoader;
    }

    private static class BitmapCache implements ImageCache {
        private LruCache<String, Bitmap> mCache;

        public BitmapCache() {
            int maxSize = 4 * 1024 * 1024;// 4M
            mCache = new LruCache<String, Bitmap>(maxSize) {

                @Override
                protected int sizeOf(String key, Bitmap bitmap) {

                    return bitmap.getByteCount();
                }

            };

        }

        @Override
        public Bitmap getBitmap(String url) {
            return mCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            if (bitmap != null) {
                mCache.put(url, bitmap);
            }
        }

    }

}
