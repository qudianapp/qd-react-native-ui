package com.qudian.ui.image;

import android.widget.ImageView;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.qudian.ui.utils.QDReadableMapUtils;

import javax.annotation.Nullable;

public class QDReactImageManager extends SimpleViewManager<QDImageView> {
    private static final String REACT_CLASS = "QDImageView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected QDImageView createViewInstance(ThemedReactContext reactContext) {
        return new QDImageView(reactContext);
    }

    @ReactProp(name = "source")
    public void setSource(QDImageView imageView, @Nullable ReadableMap source) {
        String uri = QDReadableMapUtils.tryGetString(source, "uri");
        imageView.setSource(uri);
    }

    @ReactProp(name = ViewProps.RESIZE_MODE)
    public void setResizeMode(QDImageView view, @Nullable String resizeMode) {
        view.setScaleType(ImageResizeMode.toScaleType(resizeMode));
    }

    public static class ImageResizeMode {
        /**
         * Converts JS resize modes into {@code ScalingUtils.ScaleType}.
         * See {@code ImageResizeMode.js}.
         */
        public static ImageView.ScaleType toScaleType(@Nullable String resizeModeValue) {
            if ("contain".equals(resizeModeValue)) {
                return ImageView.ScaleType.FIT_CENTER;
            }
            if ("cover".equals(resizeModeValue)) {
                return ImageView.ScaleType.CENTER_CROP;
            }
            if ("stretch".equals(resizeModeValue)) {
                return ImageView.ScaleType.FIT_XY;
            }
            if ("center".equals(resizeModeValue)) {
                return ImageView.ScaleType.CENTER_INSIDE;
            }
            if (resizeModeValue == null) {
                // Use the default. Never use null.
                return defaultValue();
            }
            throw new JSApplicationIllegalArgumentException(
                    "Invalid resize mode: '" + resizeModeValue + "'");
        }

        /**
         * This is the default as per web and iOS.
         * We want to be consistent across platforms.
         */
        public static ImageView.ScaleType defaultValue() {
            return ImageView.ScaleType.CENTER_CROP;
        }
    }
}
