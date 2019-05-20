package ru.tinkoff.acquiring.sdk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;

/* compiled from: FragmentsCommunicator */
/* renamed from: ru.tinkoff.acquiring.sdk.w */
class C2809w {
    /* renamed from: a */
    private C2808a f8547a;

    /* compiled from: FragmentsCommunicator */
    /* renamed from: ru.tinkoff.acquiring.sdk.w$a */
    public static class C2808a extends SparseArray<Bundle> implements Parcelable {
        public static final Creator<C2808a> CREATOR = new C28071();

        /* compiled from: FragmentsCommunicator */
        /* renamed from: ru.tinkoff.acquiring.sdk.w$a$1 */
        static class C28071 implements Creator<C2808a> {
            C28071() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m11428a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m11429a(i);
            }

            /* renamed from: a */
            public C2808a m11428a(Parcel parcel) {
                C2808a c2808a = new C2808a();
                int readInt = parcel.readInt();
                for (int i = 0; i < readInt; i++) {
                    c2808a.put(parcel.readInt(), parcel.readBundle());
                }
                return c2808a;
            }

            /* renamed from: a */
            public C2808a[] m11429a(int i) {
                return new C2808a[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(size());
            for (i = 0; i < size(); i++) {
                int keyAt = keyAt(i);
                parcel.writeInt(keyAt);
                parcel.writeBundle((Bundle) get(keyAt));
            }
        }
    }

    C2809w() {
    }

    /* renamed from: a */
    public void m11432a(Bundle bundle) {
        if (bundle != null) {
            this.f8547a = (C2808a) bundle.getParcelable("FragmentsCommunicator.state");
        } else {
            this.f8547a = new C2808a();
        }
    }

    /* renamed from: b */
    public void m11433b(Bundle bundle) {
        bundle.putParcelable("FragmentsCommunicator.state", this.f8547a);
    }

    /* renamed from: a */
    public void m11431a(int i, Bundle bundle) {
        this.f8547a.put(i, bundle);
    }

    /* renamed from: a */
    public Bundle m11430a(int i) {
        Bundle bundle = (Bundle) this.f8547a.get(i);
        this.f8547a.delete(i);
        return bundle;
    }
}
