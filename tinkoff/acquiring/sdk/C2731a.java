package ru.tinkoff.acquiring.sdk;

import com.google.gson.C1728f;
import com.google.gson.C1729g;
import io.card.payment.BuildConfig;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import ru.tinkoff.acquiring.sdk.p220c.C2754a;
import ru.tinkoff.acquiring.sdk.p220c.C4287c;
import ru.tinkoff.acquiring.sdk.p220c.C4289e;
import ru.tinkoff.acquiring.sdk.p220c.C4291g;
import ru.tinkoff.acquiring.sdk.p220c.C4293i;
import ru.tinkoff.acquiring.sdk.p220c.C4295k;
import ru.tinkoff.acquiring.sdk.p220c.C4297m;
import ru.tinkoff.acquiring.sdk.p220c.C4299o;
import ru.tinkoff.acquiring.sdk.p220c.C4301q;
import ru.tinkoff.acquiring.sdk.p220c.C4303s;
import ru.tinkoff.acquiring.sdk.p220c.C4305u;
import ru.tinkoff.acquiring.sdk.p221d.C2756a;
import ru.tinkoff.acquiring.sdk.p221d.C4308b;
import ru.tinkoff.acquiring.sdk.p221d.C4309c;
import ru.tinkoff.acquiring.sdk.p221d.C4310d;
import ru.tinkoff.acquiring.sdk.p221d.C4311e;
import ru.tinkoff.acquiring.sdk.p221d.C4312f;
import ru.tinkoff.acquiring.sdk.p221d.C4313g;
import ru.tinkoff.acquiring.sdk.p221d.C4314h;
import ru.tinkoff.acquiring.sdk.p221d.C4315i;
import ru.tinkoff.acquiring.sdk.p221d.C4316j;
import ru.tinkoff.acquiring.sdk.p221d.C4317k;

/* compiled from: AcquiringApi */
/* renamed from: ru.tinkoff.acquiring.sdk.a */
public class C2731a {
    /* renamed from: a */
    private static final String[] f8362a = new String[]{"Submit3DSAuthorization"};
    /* renamed from: b */
    private static final List<String> f8363b = Arrays.asList(f8362a);
    /* renamed from: c */
    private static final String[] f8364c = new String[]{"0", "104"};
    /* renamed from: d */
    private static final List<String> f8365d = Arrays.asList(f8364c);
    /* renamed from: e */
    private final C1728f f8366e = m11256a();

    /* renamed from: a */
    static String m11258a(String str) {
        if (C2731a.m11264b(str) != null) {
            return ai.m11293b() != null ? "https://rest-api-test.tcsbank.ru/rest" : "https://securepay.tinkoff.ru/rest";
        }
        return ai.m11293b() != null ? "https://rest-api-test.tcsbank.ru/v2" : "https://securepay.tinkoff.ru/v2";
    }

    /* renamed from: b */
    static boolean m11264b(String str) {
        return f8363b.contains(str);
    }

    C2731a() {
    }

    /* renamed from: a */
    C4315i m11273a(C4301q c4301q) {
        return (C4315i) m11261a((C2754a) c4301q, C4315i.class);
    }

    /* renamed from: a */
    C4311e m11269a(C4293i c4293i) {
        return (C4311e) m11261a((C2754a) c4293i, C4311e.class);
    }

    /* renamed from: a */
    C4310d m11268a(C4291g c4291g) {
        return (C4310d) m11261a((C2754a) c4291g, C4310d.class);
    }

    /* renamed from: a */
    C4314h m11272a(C4299o c4299o) {
        return (C4314h) m11261a((C2754a) c4299o, C4314h.class);
    }

    /* renamed from: a */
    C4313g m11271a(C4297m c4297m) {
        return (C4313g) m11261a((C2754a) c4297m, C4313g.class);
    }

    /* renamed from: a */
    C4316j m11274a(C4303s c4303s) {
        return (C4316j) m11261a((C2754a) c4303s, C4316j.class);
    }

    /* renamed from: a */
    C4308b m11266a(C4287c c4287c) {
        return (C4308b) m11261a((C2754a) c4287c, C4308b.class);
    }

    /* renamed from: a */
    C4309c m11267a(C4289e c4289e) {
        return (C4309c) m11261a((C2754a) c4289e, C4309c.class);
    }

    /* renamed from: a */
    C4312f m11270a(C4295k c4295k) {
        return (C4312f) m11261a((C2754a) c4295k, C4312f.class);
    }

    /* renamed from: a */
    C4317k m11275a(C4305u c4305u) {
        return (C4317k) m11261a((C2754a) c4305u, C4317k.class);
    }

    /* renamed from: a */
    private <R extends C2756a> R m11261a(C2754a c2754a, Class<R> cls) {
        OutputStream outputStream;
        StringBuilder stringBuilder;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            URL c = m11265c(c2754a.m11355c());
            String a = m11260a(c2754a.mo1949a(), c2754a.m11355c());
            HttpURLConnection httpURLConnection = (HttpURLConnection) c.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(60000);
            ai.m11290a(String.format("=== Sending %s request to %s", new Object[]{"POST", c.toString()}));
            if (a.isEmpty()) {
                outputStream = null;
            } else {
                ai.m11290a(String.format("===== Parameters: %s", new Object[]{a}));
                byte[] bytes = a.getBytes();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Content-type", C2731a.m11264b(c2754a.m11355c()) ? "application/x-www-form-urlencoded" : "application/json");
                httpURLConnection.setRequestProperty("Content-length", String.valueOf(bytes.length));
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(bytes);
                } catch (IOException e) {
                    cls = e;
                    try {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Unable to execute request ");
                        stringBuilder.append(c2754a.m11355c());
                        throw new ap(stringBuilder.toString(), cls);
                    } catch (Throwable th) {
                        c2754a = th;
                        closeable = closeable2;
                        closeable2 = outputStream;
                        m11262a(closeable2);
                        m11262a(closeable);
                        throw c2754a;
                    }
                }
            }
            closeable = new InputStreamReader(httpURLConnection.getInputStream());
            try {
                String d;
                ai.m11290a(String.format("=== Got server response: %s", new Object[]{m11257a((InputStreamReader) closeable)}));
                C2756a c2756a = (C2756a) this.f8366e.m6447a(d, (Class) cls);
                m11262a((Closeable) outputStream);
                m11262a(closeable);
                if (f8365d.contains(c2756a.m11364b()) != null || c2756a.m11363a() != null) {
                    return c2756a;
                }
                c2754a = c2756a.m11365c();
                d = c2756a.m11366d();
                if (c2754a == null || d == null) {
                    throw new C2751b(c2756a);
                }
                throw new C2751b(c2756a, String.format("%s: %s", new Object[]{c2754a, d}));
            } catch (IOException e2) {
                cls = e2;
                closeable2 = closeable;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to execute request ");
                stringBuilder.append(c2754a.m11355c());
                throw new ap(stringBuilder.toString(), cls);
            } catch (Throwable th2) {
                c2754a = th2;
                closeable2 = outputStream;
                m11262a(closeable2);
                m11262a(closeable);
                throw c2754a;
            }
        } catch (IOException e3) {
            cls = e3;
            outputStream = null;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to execute request ");
            stringBuilder.append(c2754a.m11355c());
            throw new ap(stringBuilder.toString(), cls);
        } catch (Throwable th3) {
            c2754a = th3;
            closeable = null;
            m11262a(closeable2);
            m11262a(closeable);
            throw c2754a;
        }
    }

    /* renamed from: c */
    private URL m11265c(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Cannot prepare URL for request api method is empty or null!");
        }
        StringBuilder stringBuilder = new StringBuilder(C2731a.m11258a(str));
        stringBuilder.append("/");
        stringBuilder.append(str);
        return new URL(stringBuilder.toString());
    }

    /* renamed from: a */
    private String m11260a(Map<String, Object> map, String str) {
        if (map != null) {
            if (!map.isEmpty()) {
                if (C2731a.m11264b(str) != null) {
                    return m11263b((Map) map);
                }
                return m11259a((Map) map);
            }
        }
        return BuildConfig.FLAVOR;
    }

    /* renamed from: a */
    private String m11259a(Map<String, Object> map) {
        return this.f8366e.m6454b((Object) map);
    }

    /* renamed from: b */
    private String m11263b(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            if (entry.getKey() != null) {
                if (entry.getValue() != null) {
                    try {
                        String encode = URLEncoder.encode(entry.getValue().toString(), "UTF-8");
                        stringBuilder.append((String) entry.getKey());
                        stringBuilder.append('=');
                        stringBuilder.append(encode);
                        stringBuilder.append('&');
                    } catch (Throwable e) {
                        ai.m11291a(e);
                    }
                }
            }
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private C1728f m11256a() {
        return new C1729g().m6461a(128).m6460a(C2773m.class, new C4321n()).m6460a(av.class, new aw()).m6460a(C4313g.class, new C4322p()).m6460a(ba.class, new bb()).m6460a(bc.class, new bd()).m6462b();
    }

    /* renamed from: a */
    private String m11257a(InputStreamReader inputStreamReader) {
        char[] cArr = new char[4096];
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int read = inputStreamReader.read(cArr, 0, 4096);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    /* renamed from: a */
    private void m11262a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                ai.m11291a(e);
            }
        }
    }
}
