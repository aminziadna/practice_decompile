package ru.gg.scooby.network;

import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import okhttp3.C2638l;

/* compiled from: DummyCookiePersistor.kt */
public final class DummyCookiePersistor implements CookiePersistor {
    public void clear() {
    }

    public void removeAll(Collection<C2638l> collection) {
    }

    public void saveAll(Collection<C2638l> collection) {
    }

    public List<C2638l> loadAll() {
        return new ArrayList();
    }
}
