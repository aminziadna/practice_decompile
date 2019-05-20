package ru.gg.scooby.model;

import p042b.p047e.p049b.C0700j;

/* compiled from: UserLocation.kt */
public final class UserLocationRequest {
    private final long advId;
    private final String date;
    private final double latitude;
    private final double longitude;
    private final String uuid;

    public static /* synthetic */ UserLocationRequest copy$default(UserLocationRequest userLocationRequest, long j, String str, double d, double d2, String str2, int i, Object obj) {
        UserLocationRequest userLocationRequest2 = userLocationRequest;
        return userLocationRequest.copy((i & 1) != 0 ? userLocationRequest2.advId : j, (i & 2) != 0 ? userLocationRequest2.date : str, (i & 4) != 0 ? userLocationRequest2.latitude : d, (i & 8) != 0 ? userLocationRequest2.longitude : d2, (i & 16) != 0 ? userLocationRequest2.uuid : str2);
    }

    public final long component1() {
        return this.advId;
    }

    public final String component2() {
        return this.date;
    }

    public final double component3() {
        return this.latitude;
    }

    public final double component4() {
        return this.longitude;
    }

    public final String component5() {
        return this.uuid;
    }

    public final UserLocationRequest copy(long j, String str, double d, double d2, String str2) {
        String str3 = str;
        C0700j.m2715b(str, "date");
        String str4 = str2;
        C0700j.m2715b(str4, "uuid");
        return new UserLocationRequest(j, str3, d, d2, str4);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof UserLocationRequest) {
                UserLocationRequest userLocationRequest = (UserLocationRequest) obj;
                if ((this.advId == userLocationRequest.advId ? 1 : null) != null && C0700j.m2713a(this.date, userLocationRequest.date) && Double.compare(this.latitude, userLocationRequest.latitude) == 0 && Double.compare(this.longitude, userLocationRequest.longitude) == 0 && C0700j.m2713a(this.uuid, userLocationRequest.uuid)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.advId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.date;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        i = (i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        doubleToLongBits = Double.doubleToLongBits(this.longitude);
        i = (i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        str = this.uuid;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserLocationRequest(advId=");
        stringBuilder.append(this.advId);
        stringBuilder.append(", date=");
        stringBuilder.append(this.date);
        stringBuilder.append(", latitude=");
        stringBuilder.append(this.latitude);
        stringBuilder.append(", longitude=");
        stringBuilder.append(this.longitude);
        stringBuilder.append(", uuid=");
        stringBuilder.append(this.uuid);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public UserLocationRequest(long j, String str, double d, double d2, String str2) {
        C0700j.m2715b(str, "date");
        C0700j.m2715b(str2, "uuid");
        this.advId = j;
        this.date = str;
        this.latitude = d;
        this.longitude = d2;
        this.uuid = str2;
    }

    public final long getAdvId() {
        return this.advId;
    }

    public final String getDate() {
        return this.date;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getUuid() {
        return this.uuid;
    }
}
