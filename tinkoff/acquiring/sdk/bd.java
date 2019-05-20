package ru.tinkoff.acquiring.sdk;

import com.google.gson.C1734n;
import com.google.gson.C1735o;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;

/* compiled from: TaxationSerializer */
public class bd implements C1735o<bc> {
    public /* synthetic */ JsonElement serialize(Object obj, Type type, C1734n c1734n) {
        return m18321a((bc) obj, type, c1734n);
    }

    /* renamed from: a */
    public JsonElement m18321a(bc bcVar, Type type, C1734n c1734n) {
        return new JsonPrimitive(bcVar.toString());
    }
}
