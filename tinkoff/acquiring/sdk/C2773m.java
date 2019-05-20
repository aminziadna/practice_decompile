package ru.tinkoff.acquiring.sdk;

/* compiled from: CardStatus */
/* renamed from: ru.tinkoff.acquiring.sdk.m */
public enum C2773m {
    ACTIVE('A'),
    INACTIVE('I'),
    DELETED('D');
    
    private char literal;

    /* renamed from: a */
    public static C2773m m11411a(char c) {
        if (c == 'A') {
            return ACTIVE;
        }
        if (c == 'D') {
            return DELETED;
        }
        if (c == 'I') {
            return INACTIVE;
        }
        throw new IllegalArgumentException(String.format("Unknown literal '%c'. Cannot construct CardStatus", new Object[]{Character.valueOf(c)}));
    }

    private C2773m(char c) {
        this.literal = c;
    }

    public String toString() {
        return String.valueOf(this.literal);
    }
}
