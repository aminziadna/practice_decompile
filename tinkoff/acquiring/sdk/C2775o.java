package ru.tinkoff.acquiring.sdk;

import android.os.Bundle;

/* compiled from: CardsArrayBundlePacker */
/* renamed from: ru.tinkoff.acquiring.sdk.o */
public class C2775o {
    /* renamed from: a */
    private void m11412a(ru.tinkoff.acquiring.sdk.C2766h[] r7, byte[] r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:28:0x0048 in {8, 9, 11, 13, 14, 15, 17, 19, 20, 23, 25, 27} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
        /*
        r6 = this;
        r0 = new java.io.ByteArrayInputStream;
        r0.<init>(r8);
        r8 = 2;
        r1 = 1;
        r2 = 0;
        r3 = 0;
        r4 = new java.io.ObjectInputStream;	 Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x002e }
        r4.<init>(r0);	 Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x002e }
        r3 = 0;
    L_0x000f:
        r5 = r7.length;	 Catch:{ IOException -> 0x0028, ClassNotFoundException -> 0x0026, all -> 0x0024 }
        if (r3 >= r5) goto L_0x001d;	 Catch:{ IOException -> 0x0028, ClassNotFoundException -> 0x0026, all -> 0x0024 }
    L_0x0012:
        r5 = r4.readObject();	 Catch:{ IOException -> 0x0028, ClassNotFoundException -> 0x0026, all -> 0x0024 }
        r5 = (ru.tinkoff.acquiring.sdk.C2766h) r5;	 Catch:{ IOException -> 0x0028, ClassNotFoundException -> 0x0026, all -> 0x0024 }
        r7[r3] = r5;	 Catch:{ IOException -> 0x0028, ClassNotFoundException -> 0x0026, all -> 0x0024 }
        r3 = r3 + 1;
        goto L_0x000f;
    L_0x001d:
        r7 = new java.lang.Object[r8];
        r7[r2] = r0;
        r7[r1] = r4;
        goto L_0x003a;
    L_0x0024:
        r7 = move-exception;
        goto L_0x003e;
    L_0x0026:
        r7 = move-exception;
        goto L_0x0029;
    L_0x0028:
        r7 = move-exception;
    L_0x0029:
        r3 = r4;
        goto L_0x0031;
    L_0x002b:
        r7 = move-exception;
        r4 = r3;
        goto L_0x003e;
    L_0x002e:
        r7 = move-exception;
        goto L_0x0031;
    L_0x0030:
        r7 = move-exception;
    L_0x0031:
        ru.tinkoff.acquiring.sdk.ai.m11291a(r7);	 Catch:{ all -> 0x002b }
        r7 = new java.lang.Object[r8];
        r7[r2] = r0;
        r7[r1] = r3;
    L_0x003a:
        ru.tinkoff.acquiring.sdk.bi.m11349a(r7);
        return;
    L_0x003e:
        r8 = new java.lang.Object[r8];
        r8[r2] = r0;
        r8[r1] = r4;
        ru.tinkoff.acquiring.sdk.bi.m11349a(r8);
        throw r7;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.acquiring.sdk.o.a(ru.tinkoff.acquiring.sdk.h[], byte[]):void");
    }

    /* renamed from: b */
    private byte[] m11413b(ru.tinkoff.acquiring.sdk.C2766h[] r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:23:0x0047 in {6, 9, 11, 13, 15, 19, 20, 22} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
        /*
        r9 = this;
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = 0;
        r2 = 2;
        r3 = 1;
        r4 = 0;
        r5 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x002d, all -> 0x002a }
        r5.<init>(r0);	 Catch:{ IOException -> 0x002d, all -> 0x002a }
        r6 = r10.length;	 Catch:{ IOException -> 0x0028 }
        r7 = 0;	 Catch:{ IOException -> 0x0028 }
    L_0x0010:
        if (r7 >= r6) goto L_0x001a;	 Catch:{ IOException -> 0x0028 }
    L_0x0012:
        r8 = r10[r7];	 Catch:{ IOException -> 0x0028 }
        r5.writeObject(r8);	 Catch:{ IOException -> 0x0028 }
        r7 = r7 + 1;	 Catch:{ IOException -> 0x0028 }
        goto L_0x0010;	 Catch:{ IOException -> 0x0028 }
    L_0x001a:
        r10 = r0.toByteArray();	 Catch:{ IOException -> 0x0028 }
        r1 = new java.lang.Object[r2];
        r1[r4] = r0;
        r1[r3] = r5;
        ru.tinkoff.acquiring.sdk.bi.m11349a(r1);
        return r10;
    L_0x0028:
        r10 = move-exception;
        goto L_0x002f;
    L_0x002a:
        r10 = move-exception;
        r5 = r1;
        goto L_0x003d;
    L_0x002d:
        r10 = move-exception;
        r5 = r1;
    L_0x002f:
        ru.tinkoff.acquiring.sdk.ai.m11291a(r10);	 Catch:{ all -> 0x003c }
        r10 = new java.lang.Object[r2];
        r10[r4] = r0;
        r10[r3] = r5;
        ru.tinkoff.acquiring.sdk.bi.m11349a(r10);
        return r1;
    L_0x003c:
        r10 = move-exception;
    L_0x003d:
        r1 = new java.lang.Object[r2];
        r1[r4] = r0;
        r1[r3] = r5;
        ru.tinkoff.acquiring.sdk.bi.m11349a(r1);
        throw r10;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.acquiring.sdk.o.b(ru.tinkoff.acquiring.sdk.h[]):byte[]");
    }

    /* renamed from: a */
    public C2766h[] m11415a(Bundle bundle) {
        if (bundle == null) {
            return new C2766h[0];
        }
        int i = bundle.getInt("count", 0);
        if (i == 0) {
            return new C2766h[0];
        }
        C2766h[] c2766hArr = new C2766h[i];
        m11412a(c2766hArr, bundle.getByteArray("data"));
        return c2766hArr;
    }

    /* renamed from: a */
    public Bundle m11414a(C2766h[] c2766hArr) {
        if (c2766hArr == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        int length = c2766hArr.length;
        bundle.putInt("count", length);
        if (length > 0) {
            bundle.putByteArray("data", m11413b(c2766hArr));
        }
        return bundle;
    }
}
