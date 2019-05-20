package ru.tinkoff.acquiring.sdk;

/* compiled from: PaymentStatus */
public enum av {
    NEW,
    CANCELLED,
    PREAUTHORIZING,
    FORMSHOWED,
    AUTHORIZING,
    THREE_DS_CHECKING,
    THREE_DS_CHECKED,
    AUTHORIZED,
    REVERSING,
    REVERSED,
    CONFIRMING,
    CONFIRMED,
    REFUNDING,
    REFUNDED,
    REJECTED,
    UNKNOWN,
    LOOP_CHECKING,
    COMPLETED;

    /* renamed from: a */
    public static av m11324a(String str) {
        Object obj;
        int hashCode = str.hashCode();
        if (hashCode != -2099533750) {
            if (hashCode == -661032585) {
                if (str.equals("3DS_CHECKING")) {
                    obj = null;
                    switch (obj) {
                        case null:
                            return THREE_DS_CHECKING;
                        case 1:
                            return THREE_DS_CHECKED;
                        default:
                            return valueOf(str);
                    }
                }
            }
        } else if (str.equals("3DS_CHECKED")) {
            obj = 1;
            switch (obj) {
                case null:
                    return THREE_DS_CHECKING;
                case 1:
                    return THREE_DS_CHECKED;
                default:
                    return valueOf(str);
            }
        }
        obj = -1;
        switch (obj) {
            case null:
                return THREE_DS_CHECKING;
            case 1:
                return THREE_DS_CHECKED;
            default:
                return valueOf(str);
        }
    }

    public String toString() {
        if (this == THREE_DS_CHECKING) {
            return "3DS_CHECKING";
        }
        if (this == THREE_DS_CHECKED) {
            return "3DS_CHECKED";
        }
        return super.toString();
    }
}
