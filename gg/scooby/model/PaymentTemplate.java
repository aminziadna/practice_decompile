package ru.gg.scooby.model;

import android.os.Parcel;
import android.os.Parcelable;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;

/* compiled from: PaymentTemplate.kt */
public final class PaymentTemplate implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final String account;
    private final String bik;
    private final String fullName;
    private Long id;
    private final String templateName;

    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            C0700j.m2715b(parcel, "in");
            return new PaymentTemplate(parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new PaymentTemplate[i];
        }
    }

    public static /* synthetic */ PaymentTemplate copy$default(PaymentTemplate paymentTemplate, Long l, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            l = paymentTemplate.id;
        }
        if ((i & 2) != 0) {
            str = paymentTemplate.fullName;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = paymentTemplate.account;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = paymentTemplate.bik;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = paymentTemplate.templateName;
        }
        return paymentTemplate.copy(l, str5, str6, str7, str4);
    }

    public final Long component1() {
        return this.id;
    }

    public final String component2() {
        return this.fullName;
    }

    public final String component3() {
        return this.account;
    }

    public final String component4() {
        return this.bik;
    }

    public final String component5() {
        return this.templateName;
    }

    public final PaymentTemplate copy(Long l, String str, String str2, String str3, String str4) {
        C0700j.m2715b(str, "fullName");
        C0700j.m2715b(str2, "account");
        C0700j.m2715b(str3, "bik");
        C0700j.m2715b(str4, "templateName");
        return new PaymentTemplate(l, str, str2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PaymentTemplate) {
                PaymentTemplate paymentTemplate = (PaymentTemplate) obj;
                if (C0700j.m2713a(this.id, paymentTemplate.id) && C0700j.m2713a(this.fullName, paymentTemplate.fullName) && C0700j.m2713a(this.account, paymentTemplate.account) && C0700j.m2713a(this.bik, paymentTemplate.bik) && C0700j.m2713a(this.templateName, paymentTemplate.templateName)) {
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
        String str = this.fullName;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.account;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.bik;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.templateName;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PaymentTemplate(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", fullName=");
        stringBuilder.append(this.fullName);
        stringBuilder.append(", account=");
        stringBuilder.append(this.account);
        stringBuilder.append(", bik=");
        stringBuilder.append(this.bik);
        stringBuilder.append(", templateName=");
        stringBuilder.append(this.templateName);
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
        parcel.writeString(this.fullName);
        parcel.writeString(this.account);
        parcel.writeString(this.bik);
        parcel.writeString(this.templateName);
    }

    public PaymentTemplate(Long l, String str, String str2, String str3, String str4) {
        C0700j.m2715b(str, "fullName");
        C0700j.m2715b(str2, "account");
        C0700j.m2715b(str3, "bik");
        C0700j.m2715b(str4, "templateName");
        this.id = l;
        this.fullName = str;
        this.account = str2;
        this.bik = str3;
        this.templateName = str4;
    }

    public /* synthetic */ PaymentTemplate(Long l, String str, String str2, String str3, String str4, int i, C0697g c0697g) {
        this((i & 1) != 0 ? null : l, str, str2, str3, str4);
    }

    public final Long getId() {
        return this.id;
    }

    public final void setId(Long l) {
        this.id = l;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getAccount() {
        return this.account;
    }

    public final String getBik() {
        return this.bik;
    }

    public final String getTemplateName() {
        return this.templateName;
    }
}
