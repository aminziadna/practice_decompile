package ru.tinkoff.acquiring.sdk;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import io.card.payment.BuildConfig;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: MoneyUtils */
public class ao {
    /* renamed from: a */
    public static final Locale f8382a = new Locale("ru", "RU");
    /* renamed from: b */
    public static final DecimalFormat f8383b;
    /* renamed from: c */
    public static final DecimalFormat f8384c;

    /* compiled from: MoneyUtils */
    /* renamed from: ru.tinkoff.acquiring.sdk.ao$a */
    public static class C2734a implements TextWatcher {
        /* renamed from: a */
        protected final EditText f8378a;
        /* renamed from: b */
        private Pattern f8379b;
        /* renamed from: c */
        private String f8380c = BuildConfig.FLAVOR;
        /* renamed from: d */
        private boolean f8381d;

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public C2734a(EditText editText) {
            this.f8378a = editText;
            m11306a(7);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f8381d == 0) {
                this.f8380c = charSequence.toString();
            }
        }

        public void afterTextChanged(Editable editable) {
            if (!this.f8381d) {
                CharSequence replace = ao.m11307a(editable.toString()).replace('.', ',');
                CharSequence b = !TextUtils.isEmpty(replace) ? !this.f8379b.matcher(replace).matches() ? this.f8380c : ao.m11309b(replace) : replace;
                this.f8381d = true;
                editable.replace(0, editable.length(), b, 0, b.length());
                this.f8381d = null;
            }
        }

        /* renamed from: a */
        public void m11306a(int i) {
            this.f8379b = Pattern.compile(String.format(Locale.getDefault(), "^((\\d%s?){1,%d})?(%s\\d{0,2})?$", new Object[]{Character.valueOf(' '), Integer.valueOf(i), Character.valueOf(44)}));
        }
    }

    static {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(f8382a);
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator(' ');
        f8383b = new DecimalFormat("#,##0.##", decimalFormatSymbols);
        f8384c = new DecimalFormat("#,##0.####", decimalFormatSymbols);
    }

    /* renamed from: a */
    public static String m11307a(String str) {
        return str.replace(String.valueOf(','), ".").replace(String.valueOf(' '), BuildConfig.FLAVOR);
    }

    /* renamed from: b */
    public static String m11309b(String str) {
        String str2 = BuildConfig.FLAVOR;
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            String substring = str.substring(0, indexOf);
            str2 = str.substring(indexOf, str.length());
            str = substring;
        }
        if (str.length() == 0) {
            return str2;
        }
        str = m11308a(new BigDecimal(m11307a(str)));
        return String.format("%s%s", new Object[]{str, str2});
    }

    /* renamed from: a */
    public static String m11308a(BigDecimal bigDecimal) {
        return f8383b.format(bigDecimal);
    }

    /* renamed from: c */
    public static String m11310c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0.00";
        }
        str = m11307a(str);
        StringBuilder stringBuilder;
        if (!str.contains(Character.toString('.'))) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".00");
            return stringBuilder.toString();
        } else if (str.charAt(0) != '.') {
            return str;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("0");
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
    }
}
