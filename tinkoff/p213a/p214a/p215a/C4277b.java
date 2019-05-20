package ru.tinkoff.p213a.p214a.p215a;

/* compiled from: SystemOutLogger */
/* renamed from: ru.tinkoff.a.a.a.b */
public class C4277b implements C2701a {
    /* renamed from: a */
    public void mo1930a(int i, Throwable th, String str, String str2) {
        System.out.println(String.format("%s: %s", new Object[]{str, str2}));
        if (th != null) {
            th.printStackTrace();
        }
    }
}
