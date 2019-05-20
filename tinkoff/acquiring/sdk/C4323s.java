package ru.tinkoff.acquiring.sdk;

/* compiled from: CreditCard */
/* renamed from: ru.tinkoff.acquiring.sdk.s */
public class C4323s implements ae {
    private final String cardNumber;
    private final String cardholderName;
    private final String expireDate;

    public C4323s(String str, String str2, String str3) {
        this.cardNumber = str;
        this.expireDate = str2;
        this.cardholderName = str3;
    }

    /* renamed from: a */
    public String mo1954a() {
        return this.cardNumber;
    }

    /* renamed from: b */
    public String mo1955b() {
        return this.expireDate;
    }
}
