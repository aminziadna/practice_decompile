package ru.tinkoff.acquiring.sdk;

import com.google.gson.C1734n;
import com.google.gson.C1735o;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;

/* compiled from: TaxSerializer */
public class bb implements C1735o<ba> {
    public /* synthetic */ JsonElement serialize(Object obj, Type type, C1734n c1734n) {
        return m18320a((ba) obj, type, c1734n);
    }

    /* renamed from: a */
    public JsonElement m18320a(ba baVar, Type type, C1734n c1734n) {
        return new JsonPrimitive(baVar.toString());
    }
}
