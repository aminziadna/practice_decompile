package ru.tinkoff.acquiring.sdk.p217b.p218a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.tinkoff.acquiring.sdk.ax.C2740f;
import ru.tinkoff.acquiring.sdk.ax.C2741g;

/* compiled from: AttachCellInflater */
/* renamed from: ru.tinkoff.acquiring.sdk.b.a.a */
public class C2746a {
    /* renamed from: a */
    public static final C2747b[] f8416a = new C2747b[]{C2747b.TITLE, C2747b.DESCRIPTION, C2747b.PAYMENT_CARD_REQUISITES, C2747b.EMAIL, C2747b.ATTACH_BUTTON, C2747b.EMPTY_FLEXIBLE_SPACE, C2747b.SECURE_LOGOS};
    /* renamed from: b */
    private final LayoutInflater f8417b;
    /* renamed from: c */
    private final C2747b[] f8418c;

    private C2746a(LayoutInflater layoutInflater, C2747b[] c2747bArr) {
        this.f8417b = layoutInflater;
        this.f8418c = c2747bArr;
    }

    /* renamed from: a */
    public static C2746a m11325a(LayoutInflater layoutInflater, C2747b[] c2747bArr) {
        return new C2746a(layoutInflater, c2747bArr);
    }

    /* renamed from: a */
    public View m11328a(ViewGroup viewGroup) {
        r0 = new C2747b[3];
        int i = 0;
        r0[0] = C2747b.PAYMENT_CARD_REQUISITES;
        r0[1] = C2747b.ATTACH_BUTTON;
        r0[2] = C2747b.SECURE_LOGOS;
        m11326a(r0);
        viewGroup = this.f8417b.inflate(C2741g.acq_fragment_attach_card_base, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(C2740f.ll_container_layout);
        C2747b[] c2747bArr = this.f8418c;
        int length = c2747bArr.length;
        while (i < length) {
            switch (c2747bArr[i]) {
                case TITLE:
                    this.f8417b.inflate(C2741g.acq_cell_product_title, viewGroup2, true);
                    break;
                case DESCRIPTION:
                    this.f8417b.inflate(C2741g.acq_cell_product_description, viewGroup2, true);
                    break;
                case PAYMENT_CARD_REQUISITES:
                    this.f8417b.inflate(C2741g.acq_cell_payment_card_requisites_attach, viewGroup2, true);
                    break;
                case EMAIL:
                    this.f8417b.inflate(C2741g.acq_cell_email, viewGroup2, true);
                    break;
                case ATTACH_BUTTON:
                    this.f8417b.inflate(C2741g.acq_cell_attach_button, viewGroup2, true);
                    break;
                case SECURE_LOGOS:
                    this.f8417b.inflate(C2741g.acq_cell_secure_logs, viewGroup2, true);
                    break;
                case EMPTY_FLEXIBLE_SPACE:
                    this.f8417b.inflate(C2741g.acq_cell_flexible_space, viewGroup2, true);
                    break;
                case EMPTY_16DP:
                    this.f8417b.inflate(C2741g.acq_cell_empty_16, viewGroup2, true);
                    break;
                case EMPTY_8DP:
                    this.f8417b.inflate(C2741g.acq_cell_empty_8, viewGroup2, true);
                    break;
                default:
                    break;
            }
            i++;
        }
        return viewGroup;
    }

    /* renamed from: a */
    private void m11326a(C2747b... c2747bArr) {
        int length = c2747bArr.length;
        int i = 0;
        while (i < length) {
            C2747b c2747b = c2747bArr[i];
            if (m11327a(c2747b)) {
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AttachCellType: ");
                stringBuilder.append(c2747b);
                stringBuilder.append(" must contains only once");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    private boolean m11327a(C2747b c2747b) {
        int i = 0;
        for (C2747b c2747b2 : this.f8418c) {
            if (c2747b2 == c2747b) {
                i++;
            }
        }
        return i == 1 ? true : null;
    }
}
