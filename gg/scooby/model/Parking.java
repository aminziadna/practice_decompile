package ru.gg.scooby.model;

import com.google.gson.p141a.C1687c;
import io.card.payment.BuildConfig;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0698h;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ContextProvider;
import ru.gg.scooby.util.DateUtils;
import ru.gg.scooby.util.PriceExKt;
import ru.skooby.R;

/* compiled from: Parking.kt */
public class Parking {
    public static final Companion Companion = new Companion();
    private String address;
    private long carId;
    private final Long id;
    @C1687c(a = "latitude")
    private double lat;
    @C1687c(a = "longitude")
    private double lng;
    private long price;
    private final int status;
    private String time;

    /* compiled from: Parking.kt */
    public static final class Companion {
        private Companion() {
        }

        public final String getPriceForUI(double d) {
            if (((int) d) == 0) {
                Object string = ContextProvider.INSTANCE.getContext().getString(R.string.free);
                C0700j.m2711a(string, "ContextProvider.context.getString(R.string.free)");
                return string;
            }
            string = ContextProvider.INSTANCE.getContext().getString(R.string.price_with_currency, new Object[]{PriceExKt.formatPriceWithOptionalDecimalPart(Double.valueOf(d))});
            C0700j.m2711a(string, "ContextProvider.context.…ithOptionalDecimalPart())");
            return string;
        }
    }

    public Parking() {
        this(null, 0.0d, 0.0d, 0, null, 0, null, 0, 255, null);
    }

    public Parking(Long l, double d, double d2, long j, String str, long j2, String str2, int i) {
        C0700j.m2715b(str, "time");
        this.id = l;
        this.lat = d;
        this.lng = d2;
        this.price = j;
        this.time = str;
        this.carId = j2;
        this.address = str2;
        this.status = i;
    }

    public /* synthetic */ Parking(Long l, double d, double d2, long j, String str, long j2, String str2, int i, int i2, C0697g c0697g) {
        int i3 = i2;
        this((i3 & 1) != 0 ? (Long) null : l, (i3 & 2) != 0 ? C0698h.f2043a.m2705a() : d, (i3 & 4) != 0 ? C0698h.f2043a.m2705a() : d2, (i3 & 8) != 0 ? 0 : j, (i3 & 16) != 0 ? BuildConfig.FLAVOR : str, (i3 & 32) != 0 ? -1 : j2, (i3 & 64) != 0 ? (String) null : str2, (i3 & 128) != 0 ? AdvStatus.ADV_UNKNOWN.getCode() : i);
    }

    public final Long getId() {
        return this.id;
    }

    public final double getLat() {
        return this.lat;
    }

    public final void setLat(double d) {
        this.lat = d;
    }

    public final double getLng() {
        return this.lng;
    }

    public final void setLng(double d) {
        this.lng = d;
    }

    public final long getPrice() {
        return this.price;
    }

    public final void setPrice(long j) {
        this.price = j;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String str) {
        C0700j.m2715b(str, "<set-?>");
        this.time = str;
    }

    public final long getCarId() {
        return this.carId;
    }

    public final void setCarId(long j) {
        this.carId = j;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setTimeLong(long j) {
        this.time = DateUtils.INSTANCE.toIso(j);
    }

    public final long getTimeLong() {
        return DateUtils.INSTANCE.fromIso(this.time);
    }

    public final AdvStatus getStatusEnum() {
        return AdvStatus.Companion.byCode(this.status);
    }

    public final double getNormalizedPrice() {
        return PriceExKt.toNormalizedPrice(this.price);
    }

    public final boolean isFree() {
        return this.price == 0;
    }

    public final ParkingForSell toSellObject() {
        double d = this.lat;
        double d2 = this.lng;
        long j = this.price;
        String str = this.time;
        long j2 = this.carId;
        String str2 = this.address;
        if (str2 == null) {
            C0700j.m2709a();
        }
        return new ParkingForSell(d, d2, j, str, j2, str2);
    }
}
