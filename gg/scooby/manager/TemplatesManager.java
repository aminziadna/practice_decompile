package ru.gg.scooby.manager;

import io.p181b.C2518g;
import io.p181b.C4050f;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p187d.C2482d;
import io.p181b.p187d.C2483e;
import io.p181b.p198h.C2527a;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import p042b.p043a.C3033j;
import p042b.p043a.C4774r;
import p042b.p047e.p049b.C0700j;
import p165d.C2342r;
import ru.gg.scooby.Bus;
import ru.gg.scooby.manager.UserManager.UserLoggedOutEvent;
import ru.gg.scooby.model.PaymentTemplate;
import ru.gg.scooby.model.TransferRequest;
import ru.gg.scooby.model.TransferResponse;
import ru.gg.scooby.network.ApiManager;

/* compiled from: TemplatesManager.kt */
public final class TemplatesManager {
    public static final TemplatesManager INSTANCE;
    private static List<PaymentTemplate> templates;

    /* compiled from: TemplatesManager.kt */
    /* renamed from: ru.gg.scooby.manager.TemplatesManager$a */
    static final class C2666a<V> implements Callable<C2518g<? extends T>> {
        /* renamed from: a */
        public static final C2666a f8284a = new C2666a();

        /* compiled from: TemplatesManager.kt */
        /* renamed from: ru.gg.scooby.manager.TemplatesManager$a$1 */
        static final class C41571<T, R> implements C2483e<T, R> {
            /* renamed from: a */
            public static final C41571 f12666a = new C41571();

            C41571() {
            }

            /* renamed from: a */
            public final List<PaymentTemplate> m18119a(C2342r<List<PaymentTemplate>> c2342r) {
                C0700j.m2715b(c2342r, "it");
                List list = (List) c2342r.m9827d();
                return list != null ? list : C3033j.m13044a();
            }
        }

        /* compiled from: TemplatesManager.kt */
        /* renamed from: ru.gg.scooby.manager.TemplatesManager$a$2 */
        static final class C41582<T> implements C2482d<List<? extends PaymentTemplate>> {
            /* renamed from: a */
            public static final C41582 f12667a = new C41582();

            C41582() {
            }

            /* renamed from: a */
            public final void m18121a(List<PaymentTemplate> list) {
                if (list != null) {
                    TemplatesManager templatesManager = TemplatesManager.INSTANCE;
                    C0700j.m2711a((Object) list, "it");
                    templatesManager.setTemplates(C4774r.m22239a((Collection) list));
                }
            }
        }

        C2666a() {
        }

        public /* synthetic */ Object call() {
            return m11180a();
        }

        /* renamed from: a */
        public final C4050f<List<PaymentTemplate>> m11180a() {
            return ApiManager.INSTANCE.getPaymentTemplates().m17729b(C2527a.m10359b()).m17728b((C2483e) C41571.f12666a).m17723a(C2466a.m10262a()).m17714a((C2482d) C41582.f12667a);
        }
    }

    static {
        TemplatesManager templatesManager = new TemplatesManager();
        INSTANCE = templatesManager;
        Bus.INSTANCE.register(templatesManager);
    }

    private TemplatesManager() {
    }

    /* renamed from: getTemplates */
    public final List<PaymentTemplate> m22253getTemplates() {
        return templates;
    }

    public final void setTemplates(List<PaymentTemplate> list) {
        templates = list;
    }

    public final C4050f<List<PaymentTemplate>> getTemplates() {
        Object a = C4050f.m17705a((Callable) C2666a.f8284a);
        C0700j.m2711a(a, "Observable.defer {\n     …              }\n        }");
        return a;
    }

    public final C4050f<C2342r<PaymentTemplate>> addTemplate(PaymentTemplate paymentTemplate) {
        C0700j.m2715b(paymentTemplate, "paymentTemplate");
        return ApiManager.INSTANCE.getService().addPaymentTemplate(UserManager.INSTANCE.getPhone(), paymentTemplate);
    }

    public final C4050f<C2342r<Void>> deleteTemplate(long j) {
        return ApiManager.INSTANCE.getService().deletePaymentTemplate(UserManager.INSTANCE.getPhone(), j);
    }

    public final C4050f<C2342r<TransferResponse>> withdraw(long j, long j2) {
        return ApiManager.INSTANCE.getService().withdrawFunds(UserManager.INSTANCE.getPhone(), new TransferRequest(j, j2));
    }

    public final void onEventMainThread(UserLoggedOutEvent userLoggedOutEvent) {
        C0700j.m2715b(userLoggedOutEvent, "event");
        templates = (List) null;
    }
}
