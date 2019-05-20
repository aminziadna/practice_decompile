package ru.gg.scooby.model;

import com.google.gson.p141a.C1687c;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.util.PriceExKt;

/* compiled from: User.kt */
public final class Profile {
    private final String avatarUrl;
    private long balance;
    @C1687c(a = "rate")
    private final Integer likes;
    private String name;
    private final String phoneNumber;
    private String uuid;

    public Profile(String str, String str2, String str3, String str4, Integer num, long j) {
        C0700j.m2715b(str, "uuid");
        C0700j.m2715b(str3, "phoneNumber");
        this.uuid = str;
        this.name = str2;
        this.phoneNumber = str3;
        this.avatarUrl = str4;
        this.likes = num;
        this.balance = j;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final void setUuid(String str) {
        C0700j.m2715b(str, "<set-?>");
        this.uuid = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public /* synthetic */ Profile(String str, String str2, String str3, String str4, Integer num, long j, int i, C0697g c0697g) {
        this(str, str2, str3, str4, (i & 16) != 0 ? Integer.valueOf(0) : num, (i & 32) != 0 ? 0 : j);
    }

    public final Integer getLikes() {
        return this.likes;
    }

    public final long getBalance() {
        return this.balance;
    }

    public final void setBalance(long j) {
        this.balance = j;
    }

    public final double getNormalizedBalance() {
        return PriceExKt.toNormalizedPrice(this.balance);
    }
}
