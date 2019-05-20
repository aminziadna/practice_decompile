package ru.tinkoff.acquiring.sdk.p235a.p236a;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.C2968d;
import io.card.payment.BuildConfig;
import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;
import java.util.Locale;
import ru.tinkoff.acquiring.sdk.C4323s;
import ru.tinkoff.acquiring.sdk.ab;
import ru.tinkoff.acquiring.sdk.ae;

/* compiled from: CameraCardIOScanner */
/* renamed from: ru.tinkoff.acquiring.sdk.a.a.a */
public class C4286a implements ab {
    /* renamed from: a */
    public void mo1942a(C2968d c2968d, int i) {
        c2968d.startActivityForResult(m18306a(c2968d.m12446l()), i);
    }

    /* renamed from: a */
    public boolean mo1943a(Intent intent) {
        return intent.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT);
    }

    /* renamed from: b */
    public ae mo1944b(Intent intent) {
        String str = BuildConfig.FLAVOR;
        String str2 = BuildConfig.FLAVOR;
        CreditCard creditCard = (CreditCard) intent.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);
        String formattedCardNumber = creditCard.getFormattedCardNumber();
        if (!(creditCard.expiryMonth == 0 || creditCard.expiryYear == 0)) {
            int i = creditCard.expiryYear % 100;
            str = String.format(Locale.getDefault(), "%02d%02d", new Object[]{Integer.valueOf(creditCard.expiryMonth), Integer.valueOf(i)});
        }
        return new C4323s(formattedCardNumber, str, str2);
    }

    /* renamed from: a */
    private Intent m18306a(Activity activity) {
        Intent intent = new Intent(activity, CardIOActivity.class);
        intent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true);
        intent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false);
        intent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false);
        intent.putExtra(CardIOActivity.EXTRA_SUPPRESS_CONFIRMATION, true);
        return intent;
    }
}
