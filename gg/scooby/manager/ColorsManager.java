package ru.gg.scooby.manager;

import io.p181b.C2518g;
import io.p181b.C4050f;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p187d.C2482d;
import io.p181b.p187d.C2483e;
import io.p181b.p198h.C2527a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import p042b.p043a.C3033j;
import p042b.p047e.p049b.C0700j;
import p165d.C2342r;
import ru.gg.scooby.model.Color;
import ru.gg.scooby.network.ApiManager;

/* compiled from: ColorsManager.kt */
public final class ColorsManager {
    public static final ColorsManager INSTANCE = new ColorsManager();
    private static final List<Color> colors = new ArrayList();

    /* compiled from: ColorsManager.kt */
    /* renamed from: ru.gg.scooby.manager.ColorsManager$a */
    static final class C2663a<V> implements Callable<C2518g<? extends T>> {
        /* renamed from: a */
        public static final C2663a f8281a = new C2663a();

        /* compiled from: ColorsManager.kt */
        /* renamed from: ru.gg.scooby.manager.ColorsManager$a$1 */
        static final class C41451<T, R> implements C2483e<T, R> {
            /* renamed from: a */
            public static final C41451 f12651a = new C41451();

            C41451() {
            }

            /* renamed from: a */
            public final List<Color> m18095a(C2342r<List<Color>> c2342r) {
                C0700j.m2715b(c2342r, "it");
                List list = (List) c2342r.m9827d();
                return list != null ? list : C3033j.m13044a();
            }
        }

        /* compiled from: ColorsManager.kt */
        /* renamed from: ru.gg.scooby.manager.ColorsManager$a$2 */
        static final class C41462<T> implements C2482d<List<? extends Color>> {
            /* renamed from: a */
            public static final C41462 f12652a = new C41462();

            C41462() {
            }

            /* renamed from: a */
            public final void m18097a(List<Color> list) {
                if (list != null) {
                    ColorsManager.colors.clear();
                    List access$getColors$p = ColorsManager.colors;
                    C0700j.m2711a((Object) list, "it");
                    access$getColors$p.addAll(list);
                }
            }
        }

        C2663a() {
        }

        public /* synthetic */ Object call() {
            return m11177a();
        }

        /* renamed from: a */
        public final C4050f<? extends List<Color>> m11177a() {
            if ((ColorsManager.colors.isEmpty() ^ 1) != 0) {
                return C4050f.m17704a(ColorsManager.colors);
            }
            return ApiManager.INSTANCE.getService().getCarColors().m17729b(C2527a.m10359b()).m17728b((C2483e) C41451.f12651a).m17723a(C2466a.m10262a()).m17714a((C2482d) C41462.f12652a);
        }
    }

    private ColorsManager() {
    }

    public final C4050f<List<Color>> getColors() {
        Object a = C4050f.m17705a((Callable) C2663a.f8281a);
        C0700j.m2711a(a, "Observable.defer {\n     …}\n            }\n        }");
        return a;
    }
}
