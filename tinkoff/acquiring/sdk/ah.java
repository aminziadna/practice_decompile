package ru.tinkoff.acquiring.sdk;

/* compiled from: JavaLogger */
class ah implements al {
    ah() {
    }

    /* renamed from: a */
    public void mo1945a(CharSequence charSequence) {
        System.out.println(String.format("%s: %s", new Object[]{"Tinkoff Acquiring SDK", charSequence}));
    }

    /* renamed from: a */
    public void mo1946a(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }
}
