package ru.tinkoff.acquiring.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: GooglePayParams */
/* renamed from: ru.tinkoff.acquiring.sdk.y */
public final class C2812y implements Parcelable {
    public static final Creator<C2812y> CREATOR = new C28111();
    /* renamed from: a */
    private String f8550a;
    /* renamed from: b */
    private String f8551b;
    /* renamed from: c */
    private boolean f8552c;
    /* renamed from: d */
    private boolean f8553d;
    /* renamed from: e */
    private int f8554e;
    /* renamed from: f */
    private int f8555f;
    /* renamed from: g */
    private int f8556g;
    /* renamed from: h */
    private int f8557h;

    /* compiled from: GooglePayParams */
    /* renamed from: ru.tinkoff.acquiring.sdk.y$1 */
    static class C28111 implements Creator<C2812y> {
        C28111() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m11434a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m11435a(i);
        }

        /* renamed from: a */
        public C2812y m11434a(Parcel parcel) {
            return new C2812y(parcel);
        }

        /* renamed from: a */
        public C2812y[] m11435a(int i) {
            return new C2812y[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    private C2812y() {
    }

    private C2812y(Parcel parcel) {
        this.f8550a = parcel.readString();
        this.f8551b = parcel.readString();
        boolean z = true;
        this.f8552c = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.f8553d = z;
        this.f8554e = parcel.readInt();
        this.f8555f = parcel.readInt();
        this.f8556g = parcel.readInt();
        this.f8557h = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8550a);
        parcel.writeString(this.f8551b);
        parcel.writeByte((byte) this.f8552c);
        parcel.writeByte((byte) this.f8553d);
        parcel.writeInt(this.f8554e);
        parcel.writeInt(this.f8555f);
        parcel.writeInt(this.f8556g);
        parcel.writeInt(this.f8557h);
    }

    /* renamed from: a */
    public boolean m11436a() {
        return this.f8552c;
    }

    /* renamed from: b */
    public boolean m11437b() {
        return this.f8553d;
    }

    /* renamed from: c */
    public int m11438c() {
        return this.f8554e;
    }
}
