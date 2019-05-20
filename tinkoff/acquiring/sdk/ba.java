package ru.tinkoff.acquiring.sdk;

/* compiled from: Tax */
public enum ba {
    NONE("none"),
    VAT_0("vat0"),
    VAT_10("vat10"),
    VAT_18("vat18"),
    VAT_110("vat110"),
    VAT_118("vat118"),
    VAT_20("vat20"),
    VAT_120("vat120");
    
    private final String tax;

    private ba(String str) {
        this.tax = str;
    }

    public String toString() {
        return this.tax;
    }
}
