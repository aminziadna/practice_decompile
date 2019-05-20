package ru.gg.scooby.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.p141a.C1687c;
import p042b.p047e.p049b.C0700j;

/* compiled from: Car.kt */
public final class Color implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final String hex;
    @C1687c(a = "color")
    private final String name;

    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            C0700j.m2715b(parcel, "in");
            return new Color(parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new Color[i];
        }
    }

    public static /* synthetic */ Color copy$default(Color color, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = color.name;
        }
        if ((i & 2) != 0) {
            str2 = color.hex;
        }
        return color.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.hex;
    }

    public final Color copy(String str, String str2) {
        C0700j.m2715b(str, "name");
        C0700j.m2715b(str2, "hex");
        return new Color(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Color) {
                Color color = (Color) obj;
                if (C0700j.m2713a(this.name, color.name) && C0700j.m2713a(this.hex, color.hex)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.hex;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0700j.m2715b(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.hex);
    }

    public Color(String str, String str2) {
        C0700j.m2715b(str, "name");
        C0700j.m2715b(str2, "hex");
        this.name = str;
        this.hex = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getHex() {
        return this.hex;
    }

    public String toString() {
        return this.name;
    }
}
