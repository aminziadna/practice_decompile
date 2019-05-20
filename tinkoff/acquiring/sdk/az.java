package ru.tinkoff.acquiring.sdk;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import ru.tinkoff.acquiring.sdk.p222e.C2761a;

/* compiled from: StringKeyCreator */
public class az implements aj {
    /* renamed from: a */
    private String f12886a;

    public az(String str) {
        this.f12886a = str;
    }

    /* renamed from: a */
    public PublicKey mo1947a() {
        String str = this.f12886a;
        if (str != null) {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C2761a.m11367a(str, 0)));
            } catch (Throwable e) {
                throw new C2757d(e);
            }
        }
        throw new NullPointerException("StringKeyCreator can't create Key, source String is null, use setSource(String)");
    }
}
