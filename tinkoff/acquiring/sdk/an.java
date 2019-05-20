package ru.tinkoff.acquiring.sdk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/* compiled from: Money */
public class an implements Serializable, Comparable<an> {
    private String integralDivider;
    private String integralFractionDivider;
    private final long valueCoins;

    public /* synthetic */ int compareTo(Object obj) {
        return m11301a((an) obj);
    }

    /* renamed from: a */
    public static an m11298a(BigDecimal bigDecimal) {
        return new an(bigDecimal.setScale(2, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100, new MathContext(0))).longValue());
    }

    /* renamed from: a */
    public static an m11297a(long j) {
        return new an(j);
    }

    public an() {
        this(0);
    }

    private an(long j) {
        this.integralDivider = " ";
        this.integralFractionDivider = ",";
        this.valueCoins = j;
    }

    /* renamed from: a */
    public long m11302a() {
        return this.valueCoins;
    }

    public String toString() {
        long j = this.valueCoins;
        if (j % 100 == 0) {
            return m11300c(j);
        }
        return String.format("%s%s%s", new Object[]{m11300c(j), m11305d(), m11299b(j % 100)});
    }

    /* renamed from: b */
    private String m11299b(long j) {
        return String.format("%02d", new Object[]{Long.valueOf(j)});
    }

    /* renamed from: b */
    public String m11303b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toString());
        stringBuilder.append(" P");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                if (this.valueCoins != ((an) obj).valueCoins) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.valueCoins;
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: c */
    public String m11304c() {
        return this.integralDivider;
    }

    /* renamed from: d */
    public String m11305d() {
        return this.integralFractionDivider;
    }

    /* renamed from: c */
    private String m11300c(long j) {
        if (j < 100) {
            return "0";
        }
        StringBuilder stringBuilder;
        j = String.valueOf(j);
        j = j.substring(0, j.length() - 2);
        int length = j.length() % 3;
        if (length > 0) {
            stringBuilder = new StringBuilder(j.substring(0, length));
        } else {
            stringBuilder = new StringBuilder();
        }
        int i = length;
        while (i < j.length()) {
            if ((i - length) % 3 == 0 && i != j.length() - 1) {
                stringBuilder.append(m11304c());
            }
            stringBuilder.append(j.charAt(i));
            i++;
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public int m11301a(an anVar) {
        return Long.valueOf(this.valueCoins).compareTo(Long.valueOf(anVar.m11302a()));
    }
}
