package ru.gg.scooby.ui.controller.panel;

import android.view.View;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class PhotoActionsPanelController_ViewBinding implements Unbinder {
    private PhotoActionsPanelController target;
    private View view7f09004e;
    private View view7f0901c0;
    private View view7f0901dc;
    private View view7f0901e0;

    public PhotoActionsPanelController_ViewBinding(final PhotoActionsPanelController photoActionsPanelController, View view) {
        this.target = photoActionsPanelController;
        View a = C0730b.m2750a(view, R.id.background_view, "method 'dismiss'");
        this.view7f09004e = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ PhotoActionsPanelController_ViewBinding f12830c;

            /* renamed from: a */
            public void mo1911a(View view) {
                photoActionsPanelController.dismiss();
            }
        });
        a = C0730b.m2750a(view, R.id.text_choose_from_gallery, "method 'handleClick'");
        this.view7f0901c0 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ PhotoActionsPanelController_ViewBinding f12832c;

            /* renamed from: a */
            public void mo1911a(View view) {
                photoActionsPanelController.handleClick(view);
            }
        });
        a = C0730b.m2750a(view, R.id.text_remove_current, "method 'handleClick'");
        this.view7f0901dc = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ PhotoActionsPanelController_ViewBinding f12834c;

            /* renamed from: a */
            public void mo1911a(View view) {
                photoActionsPanelController.handleClick(view);
            }
        });
        view = C0730b.m2750a(view, R.id.text_take_photo, "method 'handleClick'");
        this.view7f0901e0 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ PhotoActionsPanelController_ViewBinding f12836c;

            /* renamed from: a */
            public void mo1911a(View view) {
                photoActionsPanelController.handleClick(view);
            }
        });
    }

    public void unbind() {
        if (this.target != null) {
            this.target = null;
            this.view7f09004e.setOnClickListener(null);
            this.view7f09004e = null;
            this.view7f0901c0.setOnClickListener(null);
            this.view7f0901c0 = null;
            this.view7f0901dc.setOnClickListener(null);
            this.view7f0901dc = null;
            this.view7f0901e0.setOnClickListener(null);
            this.view7f0901e0 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
