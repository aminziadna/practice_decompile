package ru.gg.scooby.util;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;
import p042b.p047e.p049b.C0700j;

/* compiled from: MapEx.kt */
public final class MapExKt {
    public static /* synthetic */ Bundle toBundle$default(Map map, Bundle bundle, int i, Object obj) {
        if ((i & 1) != 0) {
            bundle = new Bundle();
        }
        return toBundle(map, bundle);
    }

    public static /* synthetic */ JSONObject toJsonObject$default(Map map, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = new JSONObject();
        }
        return toJsonObject(map, jSONObject);
    }

    public static final <V> Bundle toBundle(Map<String, ? extends V> map, Bundle bundle) {
        C0700j.m2715b(map, "receiver$0");
        C0700j.m2715b(bundle, "bundle");
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof IBinder) {
                bundle.putBinder(str, (IBinder) value);
            } else if (value instanceof Bundle) {
                bundle.putBundle(str, (Bundle) value);
            } else if (value instanceof Byte) {
                bundle.putByte(str, ((Number) value).byteValue());
            } else if (value instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) value);
            } else if (value instanceof Character) {
                bundle.putChar(str, ((Character) value).charValue());
            } else if (value instanceof char[]) {
                bundle.putCharArray(str, (char[]) value);
            } else if (value instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) value);
            } else if (value instanceof Float) {
                bundle.putFloat(str, ((Number) value).floatValue());
            } else if (value instanceof float[]) {
                bundle.putFloatArray(str, (float[]) value);
            } else if (value instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) value);
            } else if (value instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) value);
            } else if (value instanceof Short) {
                bundle.putShort(str, ((Number) value).shortValue());
            } else if (value instanceof short[]) {
                bundle.putShortArray(str, (short[]) value);
            } else if (value != null) {
                bundle = new StringBuilder();
                bundle.append(value);
                bundle.append(" is of a type that is not currently supported");
                throw ((Throwable) new IllegalArgumentException(bundle.toString()));
            }
        }
        return bundle;
    }

    public static final <V> JSONObject toJsonObject(Map<String, ? extends V> map, JSONObject jSONObject) {
        C0700j.m2715b(map, "receiver$0");
        C0700j.m2715b(jSONObject, "jsonObject");
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }
}
