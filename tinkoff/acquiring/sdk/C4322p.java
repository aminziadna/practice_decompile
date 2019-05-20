package ru.tinkoff.acquiring.sdk;

import com.google.gson.C1728f;
import com.google.gson.C1731i;
import com.google.gson.C1732j;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import ru.tinkoff.acquiring.sdk.p221d.C4313g;

/* compiled from: CardsListDeserializer */
/* renamed from: ru.tinkoff.acquiring.sdk.p */
public class C4322p implements C1732j<C4313g> {
    /* renamed from: a */
    private C1728f f12958a = new C1728f();

    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, C1731i c1731i) {
        return m18485a(jsonElement, type, c1731i);
    }

    /* renamed from: a */
    public C4313g m18485a(JsonElement jsonElement, Type type, C1731i c1731i) {
        if (jsonElement.isJsonObject() != null) {
            return (C4313g) this.f12958a.m6442a(jsonElement, C4313g.class);
        }
        return new C4313g((C2766h[]) c1731i.mo1356a(jsonElement, C2766h[].class));
    }
}
