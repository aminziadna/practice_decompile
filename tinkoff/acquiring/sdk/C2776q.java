package ru.tinkoff.acquiring.sdk;

/* compiled from: CheckType */
/* renamed from: ru.tinkoff.acquiring.sdk.q */
public enum C2776q {
    NO("NO"),
    HOLD("HOLD"),
    THREE_DS("3DS"),
    THREE_DS_HOLD("3DSHOLD");
    
    private final String checkType;

    private C2776q(String str) {
        this.checkType = str;
    }

    public String toString() {
        return this.checkType;
    }
}
