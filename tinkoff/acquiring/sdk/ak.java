package ru.tinkoff.acquiring.sdk;

/* compiled from: Language */
public enum ak {
    RUSSIAN("ru"),
    ENGLISH("en");
    
    private String locale;

    private ak(String str) {
        this.locale = str;
    }

    public String toString() {
        return this.locale;
    }
}
