package ru.tinkoff.acquiring.sdk;

import com.google.gson.C1731i;
import com.google.gson.C1732j;
import com.google.gson.C1734n;
import com.google.gson.C1735o;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;

/* compiled from: PaymentStatusSerializer */
public class aw implements C1732j<av>, C1735o<av> {
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, C1731i c1731i) {
        return m18318a(jsonElement, type, c1731i);
    }

    public /* synthetic */ JsonElement serialize(Object obj, Type type, C1734n c1734n) {
        return m18317a((av) obj, type, c1734n);
    }

    /* renamed from: a */
    public av m18318a(JsonElement jsonElement, Type type, C1731i c1731i) {
        return jsonElement != null ? av.m11324a(jsonElement.getAsString()) : null;
    }

    /* renamed from: a */
    public JsonElement m18317a(av avVar, Type type, C1734n c1734n) {
        return avVar != null ? new JsonPrimitive(avVar.toString()) : null;
    }
}
