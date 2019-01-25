package com.qudian.ui.image;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.qudian.ui.utils.QDDensityUtils;

/**
 *
 */
public class QDImageLoadHelper {
    public static void load(Context context, String imageUrl, ImageView imageView, int placeHolderResId) {
        QDImageRequestOptions imageParam = new QDImageRequestOptions();
        imageParam.setUrl(imageUrl)
                .setPlaceholder(placeHolderResId);
        load(context, imageView, imageParam);
    }

    public static void load(Context context, String imageUrl, final ImageView imageView, final int placeHolderResId,
                            int widthDp, int heightDp) {
        int desireWidth = QDDensityUtils.dp2px(context, widthDp);
        int desireHeight = QDDensityUtils.dp2px(context, heightDp);
        QDImageRequestOptions imageParam = new QDImageRequestOptions();
        imageParam.setUrl(imageUrl);
        imageParam.setPlaceholder(placeHolderResId);
        imageParam.setWidth(desireWidth);
        imageParam.setHeight(desireHeight);
        load(context, imageView, imageParam);
    }

    public static void load(Context context, String imageUrl, ImageView imageView) {
        QDImageRequestOptions imageParam = new QDImageRequestOptions();
        imageParam.setSkipMemoryCache(true);
        imageParam.setUrl(imageUrl);
        load(context, imageView, imageParam);
    }

    public static void load(Context context, int resId, ImageView imageView,
                            boolean isCircle, int cornerRadius) {
        RequestOptions requestOptions = new RequestOptions();
        try {
            if (isCircle) {
                requestOptions.transform(new CircleCrop());
            } else if (cornerRadius > 0) {
                requestOptions.transform(new RoundedCorners(cornerRadius));
            }
            Glide.with(context).load(resId).apply(requestOptions).into(imageView);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static void load(Context context, ImageView target, QDImageRequestOptions imageParam) {
        if (imageParam == null || TextUtils.isEmpty(imageParam.getUrl())) {
            target.setImageBitmap(null);
            if (QDImageRequestOptions.isValidDrawableResId(imageParam.getPlaceholder())) {
                target.setImageResource(imageParam.getPlaceholder());
            }
            return;
        }

        RequestOptions requestOptions = new RequestOptions();
        try {
            if (QDImageRequestOptions.isValidDrawableResId(imageParam.getPlaceholder())) {
//                requestOptions.placeholder(imageParam.getPlaceholder());
            }

            if (imageParam.getWidth() != 0 && imageParam.getHeight() != 0) {
                requestOptions.override(imageParam.getWidth(), imageParam.getHeight());
            }

            if (imageParam.isSkipMemoryCache()) {
                requestOptions.skipMemoryCache(true);
            }
            if (imageParam.isSkipDiskCache()) {
                requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
            }

            if (imageParam.isCircle()) {
                requestOptions.transform(new CircleCrop());
            } else if (imageParam.getCornerRadius() > 0) {
                requestOptions.transform(new RoundedCorners(imageParam.getCornerRadius()));
            }
            Glide.with(context).load(imageParam.getUrl()).apply(requestOptions)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .listener(imageParam.getRequestListener()).into(target);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
