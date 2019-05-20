package ru.tinkoff.acquiring.sdk;

/* compiled from: Taxation */
public enum bc {
    OSN("osn"),
    USN_INCOME("usn_income"),
    USN_INCOME_OUTCOME("usn_income_outcome"),
    ENVD("envd"),
    ESN("esn"),
    PATENT("patent");
    
    private final String taxation;

    private bc(String str) {
        this.taxation = str;
    }

    public String toString() {
        return this.taxation;
    }
}
