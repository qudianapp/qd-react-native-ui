package com.qudian.ui.utils;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

import org.json.JSONObject;

/**
 * 容错类，防闪退
 */

public class QDReadableMapUtils {

    public static final String NATIVEMAP = "NativeMap";

    /**
     * ReadableMap转JSON字符串
     *
     * @param readableMap
     * @return
     */
    public static String toJsonStr(ReadableMap readableMap) {
        if (readableMap == null) {
            return "";
        }
        try {
            JSONObject jsonObject = new JSONObject(readableMap.toString());
            return jsonObject.optString(NATIVEMAP);
        } catch (Exception e) {
            //ignore
        }
        return "";
    }

    public static String tryGetString(ReadableMap readableMap, String name) {
        if (readableMap == null) {
            return "";
        }
        try {
            return readableMap.getString(name);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return "";
    }

    public static boolean tryGetBoolean(ReadableMap readableMap, String name) {
        if (readableMap == null) {
            return false;
        }
        try {
            return readableMap.getBoolean(name);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return false;
    }

    public static ReadableArray tryGetArray(ReadableMap readableMap, String name) {
        if (readableMap == null) {
            return null;
        }
        try {
            return readableMap.getArray(name);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }

    public static double tryGetDouble(ReadableMap readableMap, String name) {
        if (readableMap == null) {
            return 0;
        }
        try {
            return readableMap.getDouble(name);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return 0;
    }

    public static double tryGetInt(ReadableMap readableMap, String name) {
        if (readableMap == null) {
            return 0;
        }
        try {
            return readableMap.getInt(name);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return 0;
    }

    public static ReadableMap tryGetMap(ReadableMap readableMap, String name) {
        if (readableMap == null) {
            return null;
        }
        try {
            return readableMap.getMap(name);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }

    public static ReadableType tryGetType(ReadableMap readableMap, String name) {
        if (readableMap == null) {
            return null;
        }
        try {
            return readableMap.getType(name);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }

    public static Dynamic tryGetDynamic(ReadableMap readableMap, String name) {
        if (readableMap == null) {
            return null;
        }
        try {
            return readableMap.getDynamic(name);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }
}
