package ru.gg.scooby.ui.controller.panel;

import android.view.View;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class TripFinishPanelController_ViewBinding implements Unbinder {
    private TripFinishPanelController target;
    private View view7f09004e;
    private View view7f0901ba;
    private View view7f0901c7;

    public TripFinishPanelController_ViewBinding(final TripFinishPanelController tripFinishPanelController, View view) {
        this.target = tripFinishPanelController;
        View a = C0730b.m2750a(view, R.id.background_view, "method 'dismiss'");
        this.view7f09004e = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ TripFinishPanelController_ViewBinding f12850c;

            /* renamed from: a */
            public void mo1911a(View view) {
                tripFinishPanelController.dismiss();
            }
        });
        a = C0730b.m2750a(view, R.id.text_cancel_booking, "method 'handleClick'");
        this.view7f0901ba = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ TripFinishPanelController_ViewBinding f12852c;

            /* renamed from: a */
            public void mo1911a(View view) {
                tripFinishPanelController.handleClick(view);
            }
        });
        view = C0730b.m2750a(view, R.id.text_finish_trip, "method 'handleClick'");
        this.view7f0901c7 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ TripFinishPanelController_ViewBinding f12854c;

            /* renamed from: a */
            public void mo1911a(View view) {
                tripFinishPanelController.handleClick(view);
            }
        });
    }

    public void unbind() {
        if (this.target != null) {
            this.target = null;
            this.view7f09004e.setOnClickListener(null);
            this.view7f09004e = null;
            this.view7f0901ba.setOnClickListener(null);
            this.view7f0901ba = null;
            this.view7f0901c7.setOnClickListener(null);
            this.view7f0901c7 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
