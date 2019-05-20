package ru.gg.scooby.settings;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import io.card.payment.BuildConfig;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.util.GsonMapper;
import ru.gg.scooby.util.Log;

/* compiled from: BaseSettings.kt */
public abstract class BaseSettings {

    /* compiled from: BaseSettings.kt */
    protected static final class ListParameterizedType implements ParameterizedType {
        private final Type type;

        public Type getOwnerType() {
            return null;
        }

        public ListParameterizedType(Type type) {
            C0700j.m2715b(type, "type");
            this.type = type;
        }

        public Type[] getActualTypeArguments() {
            return new Type[]{this.type};
        }

        public Type getRawType() {
            return ArrayList.class;
        }
    }

    public abstract SharedPreferences getPrefs();

    public final void clear() {
        getPrefs().edit().clear().apply();
    }

    private final <T extends Enum<T>> T getEnum(String str, T t) {
        str = getPrefs().getString(str, t.name());
        if (str != null) {
            C0700j.m2710a(5, "T");
            str = Enum.valueOf(null, str);
            if (str != null) {
                return str;
            }
        }
        return t;
    }

    public final <T extends Enum<T>> void putEnum(String str, T t) {
        C0700j.m2715b(str, "key");
        getPrefs().edit().putString(str, t != null ? t.name() : null).apply();
    }

    protected final void putObject(String str, Object obj) {
        C0700j.m2715b(str, "key");
        Editor edit = getPrefs().edit();
        if (obj == null) {
            try {
                edit.putString(str, null);
            } catch (String str2) {
                Log.e$default(Log.INSTANCE, (Throwable) str2, false, 2, null);
            }
        } else {
            edit.putString(str2, GsonMapper.INSTANCE.getDefault().m6454b(obj));
        }
        edit.apply();
    }

    protected final <T> T getObject(String str, Class<T> cls) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(cls, "clazz");
        str = getPrefs().getString(str, BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str = GsonMapper.INSTANCE.getDefault().m6447a(str, (Class) cls);
            return str;
        } catch (Class<T> cls2) {
            Log log = Log.INSTANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON: ");
            stringBuilder.append(str);
            Log.e$default(log, stringBuilder.toString(), (Throwable) cls2, false, 4, null);
            return null;
        }
    }

    protected final <T> void putList(String str, List<? extends T> list, Class<T> cls) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(cls, "tClass");
        Editor edit = getPrefs().edit();
        if (list == null) {
            try {
                edit.putString(str, null);
            } catch (String str2) {
                Log.e$default(Log.INSTANCE, (Throwable) str2, false, 2, null);
            }
        } else {
            edit.putString(str2, GsonMapper.INSTANCE.getDefault().m6455b(list, new ListParameterizedType(cls)));
        }
        edit.apply();
    }

    protected final <T> List<T> getList(String str, Class<T> cls) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(cls, "tClass");
        str = getPrefs().getString(str, BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (List) GsonMapper.INSTANCE.getDefault().m6448a(str, (Type) new ListParameterizedType(cls));
        } catch (String str2) {
            Log.e$default(Log.INSTANCE, (Throwable) str2, false, 2, null);
            return null;
        }
    }
}
