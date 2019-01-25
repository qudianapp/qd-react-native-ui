package com.qudian.ui.image;


import com.bumptech.glide.request.RequestListener;

/**
 *
 */
public class QDImageRequestOptions {

    private String url;
    private int width;
    private int height;
    private int placeholder;
    private boolean skipMemoryCache = false;
    private boolean skipDiskCache = false;
    private boolean isCircle = false;
    private int cornerRadius = 0;
    private RequestListener requestListener;

    public QDImageRequestOptions setUrl(String url) {
        this.url = url;
        return this;
    }

    public QDImageRequestOptions setWidth(int width) {
        this.width = width;
        return this;
    }

    public QDImageRequestOptions setHeight(int height) {
        this.height = height;
        return this;
    }

    public QDImageRequestOptions setPlaceholder(int placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    public QDImageRequestOptions setSkipMemoryCache(boolean skipMemoryCache) {
        this.skipMemoryCache = skipMemoryCache;
        return this;
    }

    public QDImageRequestOptions setSkipDiskCache(boolean skipDiskCache) {
        this.skipDiskCache = skipDiskCache;
        return this;
    }

    public QDImageRequestOptions setCircle(boolean circle) {
        isCircle = circle;
        return this;
    }


    public QDImageRequestOptions setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    public QDImageRequestOptions requestListener(RequestListener requestListener) {
        this.requestListener = requestListener;
        return this;
    }

    public boolean isCircle() {
        return isCircle;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPlaceholder() {
        return placeholder;
    }

    public boolean isSkipMemoryCache() {
        return skipMemoryCache;
    }

    public boolean isSkipDiskCache() {
        return skipDiskCache;
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public RequestListener getRequestListener() {
        return requestListener;
    }

    public static boolean isValidDrawableResId(int placeholderResId) {
        return placeholderResId != 0 && placeholderResId != -1;
    }

}
