package ru.tinkoff.acquiring.sdk;

import com.google.gson.C1731i;
import com.google.gson.C1732j;
import com.google.gson.C1733m;
import com.google.gson.C1734n;
import com.google.gson.C1735o;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;

/* compiled from: CardStatusSerializer */
/* renamed from: ru.tinkoff.acquiring.sdk.n */
public class C4321n implements C1732j<C2773m>, C1735o<C2773m> {
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, C1731i c1731i) {
        return m18484a(jsonElement, type, c1731i);
    }

    public /* synthetic */ JsonElement serialize(Object obj, Type type, C1734n c1734n) {
        return m18483a((C2773m) obj, type, c1734n);
    }

    /* renamed from: a */
    public C2773m m18484a(JsonElement jsonElement, Type type, C1731i c1731i) {
        if (jsonElement == null) {
            return null;
        }
        jsonElement = jsonElement.getAsString();
        if (jsonElement.length() == 1) {
            return C2773m.m11411a(jsonElement.charAt(null));
        }
        c1731i = new StringBuilder();
        c1731i.append("Card Status has wrong format: ");
        c1731i.append(jsonElement);
        throw new C1733m(c1731i.toString());
    }

    /* renamed from: a */
    public JsonElement m18483a(C2773m c2773m, Type type, C1734n c1734n) {
        return c2773m != null ? new JsonPrimitive(c2773m.toString()) : null;
    }
}
