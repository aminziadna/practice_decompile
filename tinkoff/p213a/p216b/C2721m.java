package ru.tinkoff.p213a.p216b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

/* compiled from: NfcRecognizer */
/* renamed from: ru.tinkoff.a.b.m */
public class C2721m {
    /* renamed from: a */
    NfcAdapter f8341a = null;
    /* renamed from: b */
    boolean f8342b = false;
    /* renamed from: c */
    private C2720c f8343c = new C2720c();
    /* renamed from: d */
    private Handler f8344d;
    /* renamed from: e */
    private C2709g<Bundle> f8345e;
    /* renamed from: f */
    private C2706d f8346f;
    /* renamed from: g */
    private BroadcastReceiver f8347g = new C27161(this);
    /* renamed from: h */
    private PendingIntent f8348h;
    /* renamed from: i */
    private C2718a f8349i;
    /* renamed from: j */
    private C2719b f8350j;

    /* compiled from: NfcRecognizer */
    /* renamed from: ru.tinkoff.a.b.m$1 */
    class C27161 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C2721m f8337a;

        C27161(C2721m c2721m) {
            this.f8337a = c2721m;
        }

        public void onReceive(Context context, Intent intent) {
            this.f8337a.m11220a((Tag) intent.getParcelableExtra("android.nfc.extra.TAG"));
        }
    }

    /* compiled from: NfcRecognizer */
    /* renamed from: ru.tinkoff.a.b.m$a */
    public interface C2718a {
        /* renamed from: a */
        void mo1931a(Bundle bundle);

        /* renamed from: a */
        void mo1932a(Exception exception);

        /* renamed from: c */
        void mo1935c();

        /* renamed from: d */
        void mo1936d();
    }

    /* compiled from: NfcRecognizer */
    /* renamed from: ru.tinkoff.a.b.m$b */
    public interface C2719b {
        /* renamed from: a */
        void mo1933a(C2712j c2712j);

        /* renamed from: a */
        void mo1934a(C2713k c2713k);
    }

    @SuppressLint({"HandlerLeak"})
    /* compiled from: NfcRecognizer */
    /* renamed from: ru.tinkoff.a.b.m$c */
    private class C2720c extends Handler {
        /* renamed from: a */
        final /* synthetic */ C2721m f8340a;

        private C2720c(C2721m c2721m) {
            this.f8340a = c2721m;
        }

        public void handleMessage(Message message) {
            if (this.f8340a.f8349i != null) {
                switch (message.what) {
                    case 1:
                        this.f8340a.f8349i.mo1931a((Bundle) message.obj);
                        break;
                    case 4:
                        if (this.f8340a.f8350j != null) {
                            this.f8340a.f8350j.mo1933a((C2712j) message.obj);
                            break;
                        }
                    case 3:
                        if (this.f8340a.f8350j != null) {
                            this.f8340a.f8350j.mo1934a((C2713k) message.obj);
                            break;
                        }
                    case 2:
                        this.f8340a.f8349i.mo1932a((Exception) message.obj);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public C2721m(C2710h c2710h, C2708f c2708f) {
        C2709g c4279c = new C4279c();
        c4279c.m18292a(c2708f);
        c4279c.m18293a(c2710h);
        this.f8345e = c4279c;
    }

    /* renamed from: a */
    public void m11221a(C2718a c2718a) {
        this.f8349i = c2718a;
    }

    /* renamed from: a */
    public void m11222a(C2719b c2719b) {
        this.f8350j = c2719b;
    }

    /* renamed from: a */
    public void m11218a() {
        this.f8349i = null;
        this.f8350j = null;
    }

    /* renamed from: a */
    public void m11219a(Activity activity) {
        this.f8346f = new C2706d();
        this.f8348h = PendingIntent.getBroadcast(activity, 0, new Intent("ru.tinkoff.core.nfc.NEW_TAG"), 0);
    }

    /* renamed from: b */
    public boolean m11223b(Activity activity) {
        this.f8341a = NfcAdapter.getDefaultAdapter(activity);
        NfcAdapter nfcAdapter = this.f8341a;
        if (nfcAdapter == null) {
            activity = this.f8349i;
            if (activity != null) {
                activity.mo1935c();
            }
            this.f8342b = false;
            return false;
        } else if (nfcAdapter.isEnabled()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ru.tinkoff.core.nfc.NEW_TAG");
            activity.registerReceiver(this.f8347g, intentFilter);
            new IntentFilter().addAction("android.nfc.action.TAG_DISCOVERED");
            NfcAdapter nfcAdapter2 = this.f8341a;
            PendingIntent pendingIntent = this.f8348h;
            IntentFilter[] intentFilterArr = new IntentFilter[]{intentFilter};
            r0 = new String[3][];
            r0[0] = new String[]{"android.nfc.tech.NfcA"};
            r0[1] = new String[]{"android.nfc.tech.NfcB"};
            r0[2] = new String[]{"android.nfc.tech.IsoDep"};
            nfcAdapter2.enableForegroundDispatch(activity, pendingIntent, intentFilterArr, r0);
            activity = new HandlerThread("nfc-thread");
            activity.start();
            activity = activity.getLooper();
            this.f8344d = new Handler(activity, new Callback(this) {
                /* renamed from: b */
                final /* synthetic */ C2721m f8339b;

                public boolean handleMessage(Message message) {
                    int i = message.what;
                    if (i == 1) {
                        this.f8339b.m11217b((Tag) message.obj);
                        return true;
                    } else if (i != 0) {
                        return null;
                    } else {
                        activity.quit();
                        return true;
                    }
                }
            });
            this.f8342b = true;
            return true;
        } else {
            activity = this.f8349i;
            if (activity != null) {
                activity.mo1936d();
            }
            this.f8342b = false;
            return false;
        }
    }

    /* renamed from: c */
    public void m11224c(Activity activity) {
        if (this.f8342b) {
            this.f8341a.disableForegroundDispatch(activity);
            activity.unregisterReceiver(this.f8347g);
            this.f8344d.obtainMessage(0).sendToTarget();
            this.f8344d = null;
        }
        this.f8342b = false;
    }

    /* renamed from: a */
    public void m11220a(Tag tag) {
        Handler handler = this.f8344d;
        if (handler != null) {
            handler.obtainMessage(1, tag).sendToTarget();
        }
    }

    /* renamed from: b */
    private void m11217b(Tag tag) {
        try {
            this.f8343c.obtainMessage(1, (Bundle) this.f8346f.m11199a(tag, this.f8345e)).sendToTarget();
        } catch (Tag tag2) {
            this.f8343c.obtainMessage(3, tag2).sendToTarget();
        } catch (Tag tag22) {
            this.f8343c.obtainMessage(4, tag22).sendToTarget();
        } catch (Tag tag222) {
            this.f8343c.obtainMessage(2, tag222).sendToTarget();
        }
    }
}
