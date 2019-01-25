package com.qudian.ui.image;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;

public class QDImageView extends android.support.v7.widget.AppCompatImageView {
    public QDImageView(Context context) {
        super(context);
    }

    public QDImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public QDImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setSource(String uri) {
        if (!TextUtils.isEmpty(uri)) {
            QDImageLoadHelper.load(getContext(), uri, this);
        }
    }
}
