package com.example.qd.photocache.utils;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.example.qd.photocache.R;

/**
 * author: wu
 * date: on 2019/4/2.
 * describe:自定义的BitmapUtils,实现三级缓存
 */
public class BitmapUtils {

    private NetCacheUtils mNetCacheUtils;
    private LocalCacheUtils mLocalCacheUtils;
    private MemoryCacheUtils mMemoryCacheUtils;
    private static BitmapUtils bitmapUtils;

    public static BitmapUtils getInstance() {
        if (bitmapUtils == null) {
            bitmapUtils = new BitmapUtils();
        }
        return bitmapUtils;
    }

    public BitmapUtils() {
        mMemoryCacheUtils = new MemoryCacheUtils();
        mLocalCacheUtils = new LocalCacheUtils();
        mNetCacheUtils = new NetCacheUtils(mLocalCacheUtils, mMemoryCacheUtils);
    }

    public void disPlay(ImageView ivPic, String url) {
        ivPic.setImageResource(R.mipmap.ic_launcher);
        Bitmap bitmap;
        //内存缓存
        bitmap = mMemoryCacheUtils.getBitmapFromMemory(url);
        if (bitmap != null) {
            ivPic.setImageBitmap(bitmap);
            Log.e("=====", "从内存获取图片");
            return;
        }

        //本地缓存
        bitmap = mLocalCacheUtils.getBitmapFromLocal(url);
        if (bitmap != null) {
            ivPic.setImageBitmap(bitmap);
            Log.e("=====", "从本地获取图片");
            //从本地获取图片后,保存至内存中
            mMemoryCacheUtils.setBitmapToMemory(url, bitmap);
            return;
        }
        //网络缓存
        mNetCacheUtils.getBitmapFromNet(ivPic, url);
    }
}
