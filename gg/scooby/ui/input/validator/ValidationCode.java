package ru.gg.scooby.ui.input.validator;

import java.io.IOException;
import p042b.p047e.p049b.C0700j;
import p165d.C2342r;
import ru.gg.scooby.network.ApiManager.ApiException;
import ru.gg.scooby.util.Log;

/* compiled from: ValidationCode.kt */
public enum ValidationCode {
    ;
    
    public static final Companion Companion = null;
    private final int errorMessage;
    private final boolean isFieldNameRequired;

    /* compiled from: ValidationCode.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ValidationCode getCodeByResponse(C2342r<?> c2342r) {
            C0700j.m2715b(c2342r, "response");
            if (c2342r.m9826c()) {
                return ValidationCode.Ok;
            }
            c2342r = c2342r.m9824a();
            if (c2342r == 403) {
                c2342r = ValidationCode.WrongPin;
            } else if (c2342r != 423) {
                c2342r = ValidationCode.UnknownError;
            } else {
                c2342r = ValidationCode.WrongPinLocked;
            }
            return c2342r;
        }

        private final <T> ru.gg.scooby.ui.input.validator.ValidationCode getCodeBySmsResponse(p165d.C2342r<T> r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
            /*
            r5 = this;
            r0 = "T";
            r1 = 4;
            p042b.p047e.p049b.C0700j.m2710a(r1, r0);
            r0 = java.lang.Object.class;
            r2 = ru.gg.scooby.model.GetVerifyCodeResponse.class;
            r0 = p042b.p047e.p049b.C0700j.m2713a(r0, r2);
            r2 = 0;
            r3 = 0;
            if (r0 == 0) goto L_0x0073;
        L_0x0012:
            r0 = ru.gg.scooby.network.ResponseConverter.INSTANCE;
            r0 = r6.m9826c();
            if (r0 == 0) goto L_0x001f;
        L_0x001a:
            r0 = r6.m9827d();
            goto L_0x003e;
        L_0x001f:
            r0 = ru.gg.scooby.network.ApiManager.INSTANCE;
            r0 = r0.getRetrofit();
            r4 = "T";
            p042b.p047e.p049b.C0700j.m2710a(r1, r4);
            r1 = java.lang.Object.class;
            r1 = (java.lang.reflect.Type) r1;
            r2 = new java.lang.annotation.Annotation[r2];
            r0 = r0.m9844b(r1, r2);
            r1 = r6.m9828e();	 Catch:{ Exception -> 0x003d }
            r0 = r0.mo1722a(r1);	 Catch:{ Exception -> 0x003d }
            goto L_0x003e;
        L_0x003d:
            r0 = r3;
        L_0x003e:
            r0 = (ru.gg.scooby.model.GetVerifyCodeResponse) r0;
            if (r0 == 0) goto L_0x004c;
        L_0x0042:
            r1 = r0.getSmsRequest();
            if (r1 == 0) goto L_0x004c;
        L_0x0048:
            r3 = r1.getStatus();
        L_0x004c:
            if (r3 != 0) goto L_0x0050;
        L_0x004e:
            goto L_0x00e6;
        L_0x0050:
            r1 = ru.gg.scooby.ui.input.validator.ValidationCode.Companion.WhenMappings.$EnumSwitchMapping$0;
            r2 = r3.ordinal();
            r1 = r1[r2];
            switch(r1) {
                case 1: goto L_0x0070;
                case 2: goto L_0x006d;
                case 3: goto L_0x005d;
                default: goto L_0x005b;
            };
        L_0x005b:
            goto L_0x00e6;
        L_0x005d:
            r6 = r0.getUserStatus();
            r6 = r6.getUntilDate();
            if (r6 == 0) goto L_0x006a;
        L_0x0067:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsTemporaryBlocked;
            return r6;
        L_0x006a:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsPermanentBlocked;
            return r6;
        L_0x006d:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsTimeout;
            return r6;
        L_0x0070:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.Ok;
            return r6;
        L_0x0073:
            r0 = "T";
            p042b.p047e.p049b.C0700j.m2710a(r1, r0);
            r0 = java.lang.Object.class;
            r4 = ru.gg.scooby.model.PostVerifyCodeResponse.class;
            r0 = p042b.p047e.p049b.C0700j.m2713a(r0, r4);
            if (r0 == 0) goto L_0x00e6;
        L_0x0082:
            r0 = ru.gg.scooby.network.ResponseConverter.INSTANCE;
            r0 = r6.m9826c();
            if (r0 == 0) goto L_0x008f;
        L_0x008a:
            r6 = r6.m9827d();
            goto L_0x00ae;
        L_0x008f:
            r0 = ru.gg.scooby.network.ApiManager.INSTANCE;
            r0 = r0.getRetrofit();
            r4 = "T";
            p042b.p047e.p049b.C0700j.m2710a(r1, r4);
            r1 = java.lang.Object.class;
            r1 = (java.lang.reflect.Type) r1;
            r2 = new java.lang.annotation.Annotation[r2];
            r0 = r0.m9844b(r1, r2);
            r6 = r6.m9828e();	 Catch:{ Exception -> 0x00ad }
            r6 = r0.mo1722a(r6);	 Catch:{ Exception -> 0x00ad }
            goto L_0x00ae;
        L_0x00ad:
            r6 = r3;
        L_0x00ae:
            r6 = (ru.gg.scooby.model.PostVerifyCodeResponse) r6;
            if (r6 == 0) goto L_0x00b6;
        L_0x00b2:
            r3 = r6.getResult();
        L_0x00b6:
            r0 = ru.gg.scooby.model.VerifiedCodeResult.VALID;
            if (r3 != r0) goto L_0x00bd;
        L_0x00ba:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.Ok;
            return r6;
        L_0x00bd:
            if (r6 == 0) goto L_0x00d0;
        L_0x00bf:
            r0 = r6.getUserStatus();
            if (r0 == 0) goto L_0x00d0;
        L_0x00c5:
            r0 = r0.getCode();
            r1 = -152; // 0xffffffffffffff68 float:NaN double:NaN;
            if (r0 != r1) goto L_0x00d0;
        L_0x00cd:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsPermanentBlocked;
            return r6;
        L_0x00d0:
            if (r6 == 0) goto L_0x00e3;
        L_0x00d2:
            r6 = r6.getUserStatus();
            if (r6 == 0) goto L_0x00e3;
        L_0x00d8:
            r6 = r6.getCode();
            r0 = -157; // 0xffffffffffffff63 float:NaN double:NaN;
            if (r6 != r0) goto L_0x00e3;
        L_0x00e0:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsTemporaryBlocked;
            return r6;
        L_0x00e3:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsWrongCode;
            return r6;
        L_0x00e6:
            r0 = r5;
            r0 = (ru.gg.scooby.ui.input.validator.ValidationCode.Companion) r0;
            r6 = r0.getCodeByResponse(r6);
            return r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.ui.input.validator.ValidationCode.Companion.getCodeBySmsResponse(d.r):ru.gg.scooby.ui.input.validator.ValidationCode");
        }

        public final ValidationCode getCodeByThrowable(Throwable th) {
            C0700j.m2715b(th, "throwable");
            Log.INSTANCE.m11189e(th, false);
            if (th instanceof ApiException) {
                th = ((ApiException) th).getCode();
                if (th == 401) {
                    th = ValidationCode.AuthRequired;
                } else if (th != 426) {
                    th = ValidationCode.UnknownError;
                } else {
                    th = ValidationCode.UpdateRequired;
                }
                return th;
            } else if ((th instanceof IOException) != null) {
                return ValidationCode.NoInternet;
            } else {
                return ValidationCode.UnknownError;
            }
        }
    }

    protected ValidationCode(int i, boolean z) {
        this.errorMessage = i;
        this.isFieldNameRequired = z;
    }

    public final int getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean isFieldNameRequired() {
        return this.isFieldNameRequired;
    }

    static {
        Companion = new Companion();
    }
}
