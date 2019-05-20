package ru.gg.scooby.util;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;

/* compiled from: BundleBuilder.kt */
public final class BundleBuilder {
    private final Bundle bundle;

    public BundleBuilder() {
        this(null, 1, null);
    }

    public BundleBuilder(Bundle bundle) {
        C0700j.m2715b(bundle, "bundle");
        this.bundle = bundle;
    }

    public /* synthetic */ BundleBuilder(Bundle bundle, int i, C0697g c0697g) {
        if ((i & 1) != 0) {
            bundle = new Bundle();
        }
        this(bundle);
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final BundleBuilder putAll(Bundle bundle) {
        C0700j.m2715b(bundle, "bundle");
        this.bundle.putAll(bundle);
        return this;
    }

    public final BundleBuilder putBoolean(String str, boolean z) {
        C0700j.m2715b(str, "key");
        this.bundle.putBoolean(str, z);
        return this;
    }

    public final BundleBuilder putBooleanArray(String str, boolean[] zArr) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(zArr, "value");
        this.bundle.putBooleanArray(str, zArr);
        return this;
    }

    public final BundleBuilder putDouble(String str, double d) {
        C0700j.m2715b(str, "key");
        this.bundle.putDouble(str, d);
        return this;
    }

    public final BundleBuilder putDoubleArray(String str, double[] dArr) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(dArr, "value");
        this.bundle.putDoubleArray(str, dArr);
        return this;
    }

    public final BundleBuilder putLong(String str, long j) {
        C0700j.m2715b(str, "key");
        this.bundle.putLong(str, j);
        return this;
    }

    public final BundleBuilder putLongArray(String str, long[] jArr) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(jArr, "value");
        this.bundle.putLongArray(str, jArr);
        return this;
    }

    public final BundleBuilder putString(String str, String str2) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(str2, "value");
        this.bundle.putString(str, str2);
        return this;
    }

    public final BundleBuilder putStringArray(String str, String[] strArr) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(strArr, "value");
        this.bundle.putStringArray(str, strArr);
        return this;
    }

    public final BundleBuilder putBundle(String str, Bundle bundle) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(bundle, "value");
        this.bundle.putBundle(str, bundle);
        return this;
    }

    public final BundleBuilder putByte(String str, byte b) {
        C0700j.m2715b(str, "key");
        this.bundle.putByte(str, b);
        return this;
    }

    public final BundleBuilder putByteArray(String str, byte[] bArr) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(bArr, "value");
        this.bundle.putByteArray(str, bArr);
        return this;
    }

    public final BundleBuilder putChar(String str, char c) {
        C0700j.m2715b(str, "key");
        this.bundle.putChar(str, c);
        return this;
    }

    public final BundleBuilder putCharArray(String str, char[] cArr) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(cArr, "value");
        this.bundle.putCharArray(str, cArr);
        return this;
    }

    public final BundleBuilder putCharSequence(String str, CharSequence charSequence) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(charSequence, "value");
        this.bundle.putCharSequence(str, charSequence);
        return this;
    }

    public final BundleBuilder putCharSequenceArray(String str, CharSequence[] charSequenceArr) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(charSequenceArr, "value");
        this.bundle.putCharSequenceArray(str, charSequenceArr);
        return this;
    }

    public final BundleBuilder putCharSequenceArrayList(String str, ArrayList<CharSequence> arrayList) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(arrayList, "value");
        this.bundle.putCharSequenceArrayList(str, arrayList);
        return this;
    }

    public final BundleBuilder putInt(String str, int i) {
        C0700j.m2715b(str, "key");
        this.bundle.putInt(str, i);
        return this;
    }

    public final BundleBuilder putIntArray(String str, int[] iArr) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(iArr, "value");
        this.bundle.putIntArray(str, iArr);
        return this;
    }

    public final BundleBuilder putFloat(String str, float f) {
        C0700j.m2715b(str, "key");
        this.bundle.putFloat(str, f);
        return this;
    }

    public final BundleBuilder putFloatArray(String str, float[] fArr) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(fArr, "value");
        this.bundle.putFloatArray(str, fArr);
        return this;
    }

    public final BundleBuilder putIntegerArrayList(String str, ArrayList<Integer> arrayList) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(arrayList, "value");
        this.bundle.putIntegerArrayList(str, arrayList);
        return this;
    }

    public final BundleBuilder putParcelable(String str, Parcelable parcelable) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(parcelable, "value");
        this.bundle.putParcelable(str, parcelable);
        return this;
    }

    public final BundleBuilder putParcelableArray(String str, Parcelable[] parcelableArr) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(parcelableArr, "value");
        this.bundle.putParcelableArray(str, parcelableArr);
        return this;
    }

    public final BundleBuilder putParcelableArrayList(String str, ArrayList<? extends Parcelable> arrayList) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(arrayList, "value");
        this.bundle.putParcelableArrayList(str, arrayList);
        return this;
    }

    public final BundleBuilder putSerializable(String str, Serializable serializable) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(serializable, "value");
        this.bundle.putSerializable(str, serializable);
        return this;
    }

    public final BundleBuilder putShort(String str, short s) {
        C0700j.m2715b(str, "key");
        this.bundle.putShort(str, s);
        return this;
    }

    public final BundleBuilder putShortArray(String str, short[] sArr) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(sArr, "value");
        this.bundle.putShortArray(str, sArr);
        return this;
    }

    public final BundleBuilder putSparseParcelableArray(String str, SparseArray<? extends Parcelable> sparseArray) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(sparseArray, "value");
        this.bundle.putSparseParcelableArray(str, sparseArray);
        return this;
    }

    public final BundleBuilder putStringArrayList(String str, ArrayList<String> arrayList) {
        C0700j.m2715b(str, "key");
        C0700j.m2715b(arrayList, "value");
        this.bundle.putStringArrayList(str, arrayList);
        return this;
    }

    public final Bundle build() {
        return this.bundle;
    }
}
