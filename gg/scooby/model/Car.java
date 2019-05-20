package ru.gg.scooby.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.p141a.C1687c;
import io.card.payment.BuildConfig;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;

/* compiled from: Car.kt */
public final class Car implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private String brand;
    @C1687c(a = "car-color")
    private Color color;
    private final Long id;
    private String model;
    private String number;

    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            C0700j.m2715b(parcel, "in");
            return new Car(parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Color) Color.CREATOR.createFromParcel(parcel) : null);
        }

        public final Object[] newArray(int i) {
            return new Car[i];
        }
    }

    public Car() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ Car copy$default(Car car, Long l, String str, String str2, String str3, Color color, int i, Object obj) {
        if ((i & 1) != 0) {
            l = car.id;
        }
        if ((i & 2) != 0) {
            str = car.brand;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = car.model;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = car.number;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            color = car.color;
        }
        return car.copy(l, str4, str5, str6, color);
    }

    public final Long component1() {
        return this.id;
    }

    public final String component2() {
        return this.brand;
    }

    public final String component3() {
        return this.model;
    }

    public final String component4() {
        return this.number;
    }

    public final Color component5() {
        return this.color;
    }

    public final Car copy(Long l, String str, String str2, String str3, Color color) {
        C0700j.m2715b(str, "brand");
        C0700j.m2715b(str2, "model");
        C0700j.m2715b(str3, "number");
        return new Car(l, str, str2, str3, color);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Car) {
                Car car = (Car) obj;
                if (C0700j.m2713a(this.id, car.id) && C0700j.m2713a(this.brand, car.brand) && C0700j.m2713a(this.model, car.model) && C0700j.m2713a(this.number, car.number) && C0700j.m2713a(this.color, car.color)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Long l = this.id;
        int i = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.brand;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.model;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.number;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Color color = this.color;
        if (color != null) {
            i = color.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Car(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", brand=");
        stringBuilder.append(this.brand);
        stringBuilder.append(", model=");
        stringBuilder.append(this.model);
        stringBuilder.append(", number=");
        stringBuilder.append(this.number);
        stringBuilder.append(", color=");
        stringBuilder.append(this.color);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0700j.m2715b(parcel, "parcel");
        Long l = this.id;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.brand);
        parcel.writeString(this.model);
        parcel.writeString(this.number);
        Parcelable parcelable = this.color;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public Car(Long l, String str, String str2, String str3, Color color) {
        C0700j.m2715b(str, "brand");
        C0700j.m2715b(str2, "model");
        C0700j.m2715b(str3, "number");
        this.id = l;
        this.brand = str;
        this.model = str2;
        this.number = str3;
        this.color = color;
    }

    public /* synthetic */ Car(Long l, String str, String str2, String str3, Color color, int i, C0697g c0697g) {
        if ((i & 1) != null) {
            l = null;
        }
        this(l, (i & 2) != null ? BuildConfig.FLAVOR : str, (i & 4) != null ? BuildConfig.FLAVOR : str2, (i & 8) != null ? BuildConfig.FLAVOR : str3, (i & 16) != null ? null : color);
    }

    public final Long getId() {
        return this.id;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final void setBrand(String str) {
        C0700j.m2715b(str, "<set-?>");
        this.brand = str;
    }

    public final String getModel() {
        return this.model;
    }

    public final void setModel(String str) {
        C0700j.m2715b(str, "<set-?>");
        this.model = str;
    }

    public final String getNumber() {
        return this.number;
    }

    public final void setNumber(String str) {
        C0700j.m2715b(str, "<set-?>");
        this.number = str;
    }

    public final Color getColor() {
        return this.color;
    }

    public final void setColor(Color color) {
        this.color = color;
    }

    public final String getPrimaryCarName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.brand);
        stringBuilder.append(' ');
        stringBuilder.append(this.number);
        return stringBuilder.toString();
    }

    public final String getCommonCarName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.brand);
        stringBuilder.append(' ');
        stringBuilder.append(this.model);
        return stringBuilder.toString();
    }

    public final boolean isFilled() {
        if ((((CharSequence) this.brand).length() > 0 ? 1 : null) != null) {
            if ((((CharSequence) this.model).length() > 0 ? 1 : null) != null) {
                if (!((((CharSequence) this.number).length() > 0 ? 1 : null) == null || this.color == null)) {
                    return true;
                }
            }
        }
        return false;
    }
}
