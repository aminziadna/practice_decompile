package ru.tinkoff.acquiring.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.TypedValue;
import java.util.Arrays;
import ru.tinkoff.acquiring.sdk.ax.C2736b;
import ru.tinkoff.acquiring.sdk.views.EditCardView.CardSystemIconsHolder;

/* compiled from: ThemeCardLogoCache */
class be extends C2771k implements CardSystemIconsHolder {
    /* renamed from: a */
    private Context f12887a;

    /* renamed from: a */
    private int m18322a(int r3, int[] r4) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:9:0x0023 in {5, 6, 8} preds:[]
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
        r2 = this;
        r0 = 0;
    L_0x0001:
        r1 = r4.length;
        if (r0 >= r1) goto L_0x000c;
    L_0x0004:
        r1 = r4[r0];
        if (r1 != r3) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x000c:
        r4 = new java.lang.RuntimeException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Failed to find attribute ";
        r0.append(r1);
        r0.append(r3);
        r3 = r0.toString();
        r4.<init>(r3);
        throw r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.acquiring.sdk.be.a(int, int[]):int");
    }

    public be(Context context) {
        this.f12887a = context;
        int[] iArr = new int[]{C2736b.acqMaestroIcon, C2736b.acqMasterCardIcon, C2736b.acqMirIcon, C2736b.acqVisaIcon};
        Arrays.sort(iArr);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C2736b.acqCardIcons, typedValue, true);
        context = context.obtainStyledAttributes(typedValue.resourceId, iArr);
        int resourceId = context.getResourceId(m18322a(C2736b.acqMaestroIcon, iArr), 0);
        int resourceId2 = context.getResourceId(m18322a(C2736b.acqMasterCardIcon, iArr), 0);
        int resourceId3 = context.getResourceId(m18322a(C2736b.acqMirIcon, iArr), 0);
        int resourceId4 = context.getResourceId(m18322a(C2736b.acqVisaIcon, iArr), 0);
        m11404c(resourceId);
        m11402a(resourceId4);
        m11403b(resourceId2);
        m11405d(resourceId3);
        context.recycle();
    }

    public Bitmap getCardSystemBitmap(String str) {
        return m11401a(this.f12887a, str);
    }
}
