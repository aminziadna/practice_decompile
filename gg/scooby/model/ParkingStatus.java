package ru.gg.scooby.model;

import android.os.Parcel;
import android.os.Parcelable;
import p042b.p047e.p049b.C0700j;

/* compiled from: ParkingAdvert.kt */
public final class ParkingStatus implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final DealCompleteStatus dealCompleteBuyer;
    private final DealCompleteStatus dealCompleteSeller;
    private final long id;
    private final int status;

    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            C0700j.m2715b(parcel, "in");
            return new ParkingStatus(parcel.readLong(), parcel.readInt(), (DealCompleteStatus) Enum.valueOf(DealCompleteStatus.class, parcel.readString()), (DealCompleteStatus) Enum.valueOf(DealCompleteStatus.class, parcel.readString()));
        }

        public final Object[] newArray(int i) {
            return new ParkingStatus[i];
        }
    }

    public static /* synthetic */ ParkingStatus copy$default(ParkingStatus parkingStatus, long j, int i, DealCompleteStatus dealCompleteStatus, DealCompleteStatus dealCompleteStatus2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = parkingStatus.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            i = parkingStatus.status;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            dealCompleteStatus = parkingStatus.dealCompleteSeller;
        }
        DealCompleteStatus dealCompleteStatus3 = dealCompleteStatus;
        if ((i2 & 8) != 0) {
            dealCompleteStatus2 = parkingStatus.dealCompleteBuyer;
        }
        return parkingStatus.copy(j2, i3, dealCompleteStatus3, dealCompleteStatus2);
    }

    public static /* synthetic */ void statusEnum$annotations() {
    }

    public final long component1() {
        return this.id;
    }

    public final int component2() {
        return this.status;
    }

    public final DealCompleteStatus component3() {
        return this.dealCompleteSeller;
    }

    public final DealCompleteStatus component4() {
        return this.dealCompleteBuyer;
    }

    public final ParkingStatus copy(long j, int i, DealCompleteStatus dealCompleteStatus, DealCompleteStatus dealCompleteStatus2) {
        C0700j.m2715b(dealCompleteStatus, "dealCompleteSeller");
        C0700j.m2715b(dealCompleteStatus2, "dealCompleteBuyer");
        return new ParkingStatus(j, i, dealCompleteStatus, dealCompleteStatus2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ParkingStatus) {
                ParkingStatus parkingStatus = (ParkingStatus) obj;
                if ((this.id == parkingStatus.id ? 1 : null) != null) {
                    if ((this.status == parkingStatus.status ? 1 : null) != null && C0700j.m2713a(this.dealCompleteSeller, parkingStatus.dealCompleteSeller) && C0700j.m2713a(this.dealCompleteBuyer, parkingStatus.dealCompleteBuyer)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + this.status) * 31;
        DealCompleteStatus dealCompleteStatus = this.dealCompleteSeller;
        int i2 = 0;
        i = (i + (dealCompleteStatus != null ? dealCompleteStatus.hashCode() : 0)) * 31;
        dealCompleteStatus = this.dealCompleteBuyer;
        if (dealCompleteStatus != null) {
            i2 = dealCompleteStatus.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ParkingStatus(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", dealCompleteSeller=");
        stringBuilder.append(this.dealCompleteSeller);
        stringBuilder.append(", dealCompleteBuyer=");
        stringBuilder.append(this.dealCompleteBuyer);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0700j.m2715b(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeInt(this.status);
        parcel.writeString(this.dealCompleteSeller.name());
        parcel.writeString(this.dealCompleteBuyer.name());
    }

    public ParkingStatus(long j, int i, DealCompleteStatus dealCompleteStatus, DealCompleteStatus dealCompleteStatus2) {
        C0700j.m2715b(dealCompleteStatus, "dealCompleteSeller");
        C0700j.m2715b(dealCompleteStatus2, "dealCompleteBuyer");
        this.id = j;
        this.status = i;
        this.dealCompleteSeller = dealCompleteStatus;
        this.dealCompleteBuyer = dealCompleteStatus2;
    }

    public final long getId() {
        return this.id;
    }

    public final int getStatus() {
        return this.status;
    }

    public final DealCompleteStatus getDealCompleteSeller() {
        return this.dealCompleteSeller;
    }

    public final DealCompleteStatus getDealCompleteBuyer() {
        return this.dealCompleteBuyer;
    }

    public final AdvStatus getStatusEnum() {
        return AdvStatus.Companion.byCode(this.status);
    }
}
