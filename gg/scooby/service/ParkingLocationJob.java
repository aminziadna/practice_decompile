package ru.gg.scooby.service;

import android.os.Bundle;
import com.evernote.android.job.C1164c;
import com.evernote.android.job.C1164c.C1161a;
import com.evernote.android.job.C1164c.C1162b;
import io.card.payment.BuildConfig;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ContextProvider;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.util.Log;

/* compiled from: ParkingLocationJob.kt */
public final class ParkingLocationJob extends C1164c {
    public static final Companion Companion = new Companion();
    private static final String TAG = TAG;

    /* compiled from: ParkingLocationJob.kt */
    public static final class Companion {
        private Companion() {
        }

        public final String getTAG() {
            return ParkingLocationJob.TAG;
        }
    }

    protected C1162b onRunJob(C1161a c1161a) {
        C0700j.m2715b(c1161a, "params");
        Log.INSTANCE.dTrace(BuildConfig.FLAVOR);
        if (ParkingManager.INSTANCE.getActiveParking() != null) {
            c1161a = new Bundle();
            c1161a.putInt(ParkingService.ARG_COMMAND_ID, 1);
            ParkingService.Companion.startService(ContextProvider.INSTANCE.getContext(), c1161a);
        }
        return C1162b.SUCCESS;
    }
}
