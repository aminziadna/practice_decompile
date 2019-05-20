package ru.gg.scooby.model;

/* compiled from: UserLocation.kt */
public final class UserLocationResponse {
    private final double latitude;
    private final double longitude;

    public static /* synthetic */ UserLocationResponse copy$default(UserLocationResponse userLocationResponse, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = userLocationResponse.latitude;
        }
        if ((i & 2) != 0) {
            d2 = userLocationResponse.longitude;
        }
        return userLocationResponse.copy(d, d2);
    }

    public final double component1() {
        return this.latitude;
    }

    public final double component2() {
        return this.longitude;
    }

    public final UserLocationResponse copy(double d, double d2) {
        return new UserLocationResponse(d, d2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof UserLocationResponse) {
                UserLocationResponse userLocationResponse = (UserLocationResponse) obj;
                if (Double.compare(this.latitude, userLocationResponse.latitude) == 0 && Double.compare(this.longitude, userLocationResponse.longitude) == 0) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return i + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserLocationResponse(latitude=");
        stringBuilder.append(this.latitude);
        stringBuilder.append(", longitude=");
        stringBuilder.append(this.longitude);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public UserLocationResponse(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }
}
