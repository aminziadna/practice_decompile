package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class TripCanceledController_ViewBinding implements Unbinder {
    private TripCanceledController target;
    private View view7f090090;

    public TripCanceledController_ViewBinding(final TripCanceledController tripCanceledController, View view) {
        this.target = tripCanceledController;
        tripCanceledController.textCancelTitle = (TextView) C0730b.m2751a(view, R.id.text_cancel_title, "field 'textCancelTitle'", TextView.class);
        tripCanceledController.textCancelDescription = (TextView) C0730b.m2751a(view, R.id.text_cancel_description, "field 'textCancelDescription'", TextView.class);
        view = C0730b.m2750a(view, R.id.btn_finish, "method 'onFinishClick'");
        this.view7f090090 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ TripCanceledController_ViewBinding f12820c;

            /* renamed from: a */
            public void mo1911a(View view) {
                tripCanceledController.onFinishClick();
            }
        });
    }

    public void unbind() {
        TripCanceledController tripCanceledController = this.target;
        if (tripCanceledController != null) {
            this.target = null;
            tripCanceledController.textCancelTitle = null;
            tripCanceledController.textCancelDescription = null;
            this.view7f090090.setOnClickListener(null);
            this.view7f090090 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
