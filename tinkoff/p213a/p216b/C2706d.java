package ru.tinkoff.p213a.p216b;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import java.io.IOException;
import ru.tinkoff.acquiring.sdk.views.BankKeyboard;

/* compiled from: Connectivity */
/* renamed from: ru.tinkoff.a.b.d */
public class C2706d {
    /* renamed from: a */
    public static String f8332a = "NfcConnectivity";
    /* renamed from: b */
    private C4282s f8333b = new C4676a();

    /* compiled from: Connectivity */
    /* renamed from: ru.tinkoff.a.b.d$a */
    public static class C4676a implements C4282s {
        /* renamed from: a */
        IsoDep f14128a;

        /* renamed from: a */
        public void mo2391a(Tag tag) {
            this.f14128a = IsoDep.get(tag);
            tag = this.f14128a;
            if (tag != null) {
                tag.setTimeout(BankKeyboard.KEYBOARD_SHOW_DELAY_MILLIS);
                this.f14128a.connect();
                return;
            }
            throw new IOException("tag not supported");
        }

        /* renamed from: a */
        public C2723o mo2390a(C2722n c2722n) {
            return C2723o.m11231a(this.f14128a.transceive(c2722n.m11230a()), c2722n.f8351a);
        }

        public void close() {
            IsoDep isoDep = this.f14128a;
            if (isoDep != null) {
                isoDep.close();
            }
        }
    }

    /* renamed from: a */
    public <T> T m11199a(android.nfc.Tag r2, ru.tinkoff.p213a.p216b.C2709g<T> r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
        /*
        r1 = this;
        r0 = r1.m11200a();
        r0.mo2391a(r2);	 Catch:{ all -> 0x000f }
        r2 = r3.mo1937b(r0);	 Catch:{ all -> 0x000f }
        r0.close();	 Catch:{ IOException -> 0x000e }
    L_0x000e:
        return r2;
    L_0x000f:
        r2 = move-exception;
        r0.close();	 Catch:{ IOException -> 0x0013 }
    L_0x0013:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.a.b.d.a(android.nfc.Tag, ru.tinkoff.a.b.g):T");
    }

    /* renamed from: a */
    public C4282s m11200a() {
        return this.f8333b;
    }
}
