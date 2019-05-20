package ru.tinkoff.acquiring.sdk.p217b.p219b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.tinkoff.acquiring.sdk.ax.C2740f;
import ru.tinkoff.acquiring.sdk.ax.C2741g;

/* compiled from: PayCellInflater */
/* renamed from: ru.tinkoff.acquiring.sdk.b.b.a */
public class C2749a {
    /* renamed from: a */
    public static final C2750b[] f8430a = new C2750b[]{C2750b.PRODUCT_TITLE, C2750b.PRODUCT_DESCRIPTION, C2750b.AMOUNT, C2750b.PAYMENT_CARD_REQUISITES, C2750b.EMAIL, C2750b.PAY_BUTTON, C2750b.EMPTY_FLEXIBLE_SPACE, C2750b.SECURE_LOGOS};
    /* renamed from: b */
    private final LayoutInflater f8431b;
    /* renamed from: c */
    private final C2750b[] f8432c;

    private C2749a(LayoutInflater layoutInflater, C2750b[] c2750bArr) {
        this.f8431b = layoutInflater;
        this.f8432c = c2750bArr;
    }

    /* renamed from: a */
    public static C2749a m11331a(LayoutInflater layoutInflater, C2750b[] c2750bArr) {
        return new C2749a(layoutInflater, c2750bArr);
    }

    /* renamed from: a */
    public View m11334a(ViewGroup viewGroup) {
        r0 = new C2750b[3];
        int i = 0;
        r0[0] = C2750b.PAYMENT_CARD_REQUISITES;
        r0[1] = C2750b.PAY_BUTTON;
        r0[2] = C2750b.SECURE_LOGOS;
        m11332a(r0);
        viewGroup = this.f8431b.inflate(C2741g.acq_fragment_enter_card_base, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(C2740f.ll_container_layout);
        C2750b[] c2750bArr = this.f8432c;
        int length = c2750bArr.length;
        while (i < length) {
            switch (c2750bArr[i]) {
                case PRODUCT_TITLE:
                    this.f8431b.inflate(C2741g.acq_cell_product_title, viewGroup2, true);
                    break;
                case PRODUCT_DESCRIPTION:
                    this.f8431b.inflate(C2741g.acq_cell_product_description, viewGroup2, true);
                    break;
                case AMOUNT:
                    this.f8431b.inflate(C2741g.acq_cell_amount, viewGroup2, true);
                    break;
                case PAYMENT_CARD_REQUISITES:
                    this.f8431b.inflate(C2741g.acq_cell_payment_card_requisites, viewGroup2, true);
                    break;
                case EMAIL:
                    this.f8431b.inflate(C2741g.acq_cell_email, viewGroup2, true);
                    break;
                case PAY_BUTTON:
                    this.f8431b.inflate(C2741g.acq_cell_pay_button, viewGroup2, true);
                    break;
                case SECURE_LOGOS:
                    this.f8431b.inflate(C2741g.acq_cell_secure_logs, viewGroup2, true);
                    break;
                case EMPTY_FLEXIBLE_SPACE:
                    this.f8431b.inflate(C2741g.acq_cell_flexible_space, viewGroup2, true);
                    break;
                case EMPTY_16DP:
                    this.f8431b.inflate(C2741g.acq_cell_empty_16, viewGroup2, true);
                    break;
                case EMPTY_8DP:
                    this.f8431b.inflate(C2741g.acq_cell_empty_8, viewGroup2, true);
                    break;
                default:
                    break;
            }
            i++;
        }
        return viewGroup;
    }

    /* renamed from: a */
    private void m11332a(C2750b... c2750bArr) {
        int length = c2750bArr.length;
        int i = 0;
        while (i < length) {
            C2750b c2750b = c2750bArr[i];
            if (m11333a(c2750b)) {
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("PayCellType: ");
                stringBuilder.append(c2750b);
                stringBuilder.append(" must contains only once");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    private boolean m11333a(C2750b c2750b) {
        int i = 0;
        for (C2750b c2750b2 : this.f8432c) {
            if (c2750b2 == c2750b) {
                i++;
            }
        }
        return i == 1 ? true : null;
    }
}
