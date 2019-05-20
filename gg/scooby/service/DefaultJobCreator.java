package ru.gg.scooby.service;

import com.evernote.android.job.C1164c;
import com.evernote.android.job.C1171f;
import p042b.p047e.p049b.C0700j;

/* compiled from: DefaultJobCreator.kt */
public final class DefaultJobCreator implements C1171f {
    public C1164c create(String str) {
        C0700j.m2715b(str, "tag");
        return C0700j.m2713a((Object) str, ParkingLocationJob.Companion.getTAG()) != null ? (C1164c) new ParkingLocationJob() : null;
    }
}
