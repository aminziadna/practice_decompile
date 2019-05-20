package ru.gg.scooby.model;

import android.location.Address;
import io.card.payment.BuildConfig;
import java.util.Locale;
import p042b.p047e.p049b.C0700j;

/* compiled from: SimpleAddress.kt */
public final class SimpleAddress {
    public static final Companion Companion = new Companion();
    private final double latitude;
    private final double longitude;
    private final String subTitle;
    private final String title;

    /* compiled from: SimpleAddress.kt */
    public static final class Companion {
        private Companion() {
        }

        public final SimpleAddress fromAddress(Address address) {
            C0700j.m2715b(address, "address");
            String addressLine = address.getAddressLine(0);
            if (addressLine == null) {
                addressLine = BuildConfig.FLAVOR;
            }
            String str = addressLine;
            addressLine = address.getLocality();
            if (addressLine == null) {
                addressLine = BuildConfig.FLAVOR;
            }
            return new SimpleAddress(str, addressLine, address.getLatitude(), address.getLongitude());
        }
    }

    public static /* synthetic */ SimpleAddress copy$default(SimpleAddress simpleAddress, String str, String str2, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = simpleAddress.title;
        }
        if ((i & 2) != 0) {
            str2 = simpleAddress.subTitle;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            d = simpleAddress.latitude;
        }
        double d3 = d;
        if ((i & 8) != 0) {
            d2 = simpleAddress.longitude;
        }
        return simpleAddress.copy(str, str3, d3, d2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final double component3() {
        return this.latitude;
    }

    public final double component4() {
        return this.longitude;
    }

    public final SimpleAddress copy(String str, String str2, double d, double d2) {
        C0700j.m2715b(str, "title");
        C0700j.m2715b(str2, "subTitle");
        return new SimpleAddress(str, str2, d, d2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SimpleAddress) {
                SimpleAddress simpleAddress = (SimpleAddress) obj;
                if (C0700j.m2713a(this.title, simpleAddress.title) && C0700j.m2713a(this.subTitle, simpleAddress.subTitle) && Double.compare(this.latitude, simpleAddress.latitude) == 0 && Double.compare(this.longitude, simpleAddress.longitude) == 0) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subTitle;
        if (str2 != null) {
            i = str2.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        hashCode = (hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        doubleToLongBits = Double.doubleToLongBits(this.longitude);
        return hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SimpleAddress(title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", subTitle=");
        stringBuilder.append(this.subTitle);
        stringBuilder.append(", latitude=");
        stringBuilder.append(this.latitude);
        stringBuilder.append(", longitude=");
        stringBuilder.append(this.longitude);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SimpleAddress(String str, String str2, double d, double d2) {
        C0700j.m2715b(str, "title");
        C0700j.m2715b(str2, "subTitle");
        this.title = str;
        this.subTitle = str2;
        this.latitude = d;
        this.longitude = d2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final Address toAddress() {
        Address address = new Address(Locale.getDefault());
        address.setAddressLine(0, this.title);
        address.setLocality(this.subTitle);
        address.setLatitude(this.latitude);
        address.setLongitude(this.longitude);
        return address;
    }
}
