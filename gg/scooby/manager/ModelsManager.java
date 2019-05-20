package ru.gg.scooby.manager;

import io.p181b.C2518g;
import io.p181b.C4050f;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p187d.C2482d;
import io.p181b.p187d.C2483e;
import io.p181b.p198h.C2527a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import p042b.p047e.p049b.C0700j;
import p165d.C2342r;
import ru.gg.scooby.model.Model;
import ru.gg.scooby.network.ApiManager;

/* compiled from: ModelsManager.kt */
public final class ModelsManager {
    public static final ModelsManager INSTANCE = new ModelsManager();
    private static final LinkedHashMap<String, List<String>> models = new LinkedHashMap();

    /* compiled from: ModelsManager.kt */
    /* renamed from: ru.gg.scooby.manager.ModelsManager$a */
    static final class C2664a<V> implements Callable<C2518g<? extends T>> {
        /* renamed from: a */
        public static final C2664a f8282a = new C2664a();

        /* compiled from: ModelsManager.kt */
        /* renamed from: ru.gg.scooby.manager.ModelsManager$a$1 */
        static final class C41471<T, R> implements C2483e<T, R> {
            /* renamed from: a */
            public static final C41471 f12653a = new C41471();

            C41471() {
            }

            /* renamed from: a */
            public final Map<String, List<String>> m18099a(C2342r<List<Model>> c2342r) {
                C0700j.m2715b(c2342r, "it");
                List<Model> list = (List) c2342r.m9827d();
                if (list == null) {
                    return null;
                }
                Map<String, List<String>> linkedHashMap = new LinkedHashMap();
                for (Model model : list) {
                    String brand = model.getBrand();
                    ArrayList arrayList = linkedHashMap.get(brand);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(brand, arrayList);
                    }
                    arrayList.add(model.getModel());
                }
                return linkedHashMap;
            }
        }

        /* compiled from: ModelsManager.kt */
        /* renamed from: ru.gg.scooby.manager.ModelsManager$a$2 */
        static final class C41482<T> implements C2482d<Map<String, ? extends List<? extends String>>> {
            /* renamed from: a */
            public static final C41482 f12654a = new C41482();

            C41482() {
            }

            /* renamed from: a */
            public final void m18101a(Map<String, ? extends List<String>> map) {
                if (map != null) {
                    ModelsManager.models.clear();
                    ModelsManager.models.putAll(map);
                }
            }
        }

        C2664a() {
        }

        public /* synthetic */ Object call() {
            return m11178a();
        }

        /* renamed from: a */
        public final C4050f<? extends Map<String, List<String>>> m11178a() {
            if ((ModelsManager.models.isEmpty() ^ 1) != 0) {
                return C4050f.m17704a(ModelsManager.models);
            }
            return ApiManager.INSTANCE.getService().getCarModels().m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a()).m17728b((C2483e) C41471.f12653a).m17714a((C2482d) C41482.f12654a);
        }
    }

    private ModelsManager() {
    }

    public final C4050f<Map<String, List<String>>> getModels() {
        Object a = C4050f.m17705a((Callable) C2664a.f8282a);
        C0700j.m2711a(a, "Observable.defer {\n     …}\n            }\n        }");
        return a;
    }
}
