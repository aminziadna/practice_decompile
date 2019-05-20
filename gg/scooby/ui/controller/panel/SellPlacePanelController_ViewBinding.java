package ru.gg.scooby.ui.controller.panel;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class SellPlacePanelController_ViewBinding implements Unbinder {
    private SellPlacePanelController target;
    private View view7f090052;
    private View view7f090054;
    private View view7f090066;
    private View view7f09006f;
    private View view7f09008c;
    private View view7f09009e;

    public SellPlacePanelController_ViewBinding(final SellPlacePanelController sellPlacePanelController, View view) {
        this.target = sellPlacePanelController;
        sellPlacePanelController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        sellPlacePanelController.textAddress = (TextView) C0730b.m2751a(view, R.id.text_address, "field 'textAddress'", TextView.class);
        sellPlacePanelController.progressAddress = C0730b.m2750a(view, R.id.progress_address, "field 'progressAddress'");
        sellPlacePanelController.textPriceTitle = (TextView) C0730b.m2751a(view, R.id.text_price_title, "field 'textPriceTitle'", TextView.class);
        sellPlacePanelController.textPriceSubtitle = (TextView) C0730b.m2751a(view, R.id.text_price_subtitle, "field 'textPriceSubtitle'", TextView.class);
        sellPlacePanelController.textTimeTitle = (TextView) C0730b.m2751a(view, R.id.text_time_title, "field 'textTimeTitle'", TextView.class);
        sellPlacePanelController.textTimeSubtitle = (TextView) C0730b.m2751a(view, R.id.text_time_subtitle, "field 'textTimeSubtitle'", TextView.class);
        sellPlacePanelController.textCarTitle = (TextView) C0730b.m2751a(view, R.id.text_auto_title, "field 'textCarTitle'", TextView.class);
        sellPlacePanelController.containerActions = C0730b.m2750a(view, R.id.container_actions, "field 'containerActions'");
        View a = C0730b.m2750a(view, R.id.btn_publish, "field 'publishButton' and method 'onPublish'");
        sellPlacePanelController.publishButton = (TextView) C0730b.m2753b(a, R.id.btn_publish, "field 'publishButton'", TextView.class);
        this.view7f09009e = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SellPlacePanelController_ViewBinding f12838c;

            /* renamed from: a */
            public void mo1911a(View view) {
                sellPlacePanelController.onPublish();
            }
        });
        a = C0730b.m2750a(view, R.id.btn_close, "method 'onClose'");
        this.view7f09008c = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SellPlacePanelController_ViewBinding f12840c;

            /* renamed from: a */
            public void mo1911a(View view) {
                sellPlacePanelController.onClose();
            }
        });
        a = C0730b.m2750a(view, R.id.block_address, "method 'onAddressEdit'");
        this.view7f090052 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SellPlacePanelController_ViewBinding f12842c;

            /* renamed from: a */
            public void mo1911a(View view) {
                sellPlacePanelController.onAddressEdit();
            }
        });
        a = C0730b.m2750a(view, R.id.block_time, "method 'onTimeEdit'");
        this.view7f09006f = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SellPlacePanelController_ViewBinding f12844c;

            /* renamed from: a */
            public void mo1911a(View view) {
                sellPlacePanelController.onTimeEdit();
            }
        });
        a = C0730b.m2750a(view, R.id.block_price, "method 'onPriceEdit'");
        this.view7f090066 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SellPlacePanelController_ViewBinding f12846c;

            /* renamed from: a */
            public void mo1911a(View view) {
                sellPlacePanelController.onPriceEdit();
            }
        });
        view = C0730b.m2750a(view, R.id.block_auto, "method 'onCarEdit'");
        this.view7f090054 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SellPlacePanelController_ViewBinding f12848c;

            /* renamed from: a */
            public void mo1911a(View view) {
                sellPlacePanelController.onCarEdit();
            }
        });
    }

    public void unbind() {
        SellPlacePanelController sellPlacePanelController = this.target;
        if (sellPlacePanelController != null) {
            this.target = null;
            sellPlacePanelController.imageAvatar = null;
            sellPlacePanelController.textAddress = null;
            sellPlacePanelController.progressAddress = null;
            sellPlacePanelController.textPriceTitle = null;
            sellPlacePanelController.textPriceSubtitle = null;
            sellPlacePanelController.textTimeTitle = null;
            sellPlacePanelController.textTimeSubtitle = null;
            sellPlacePanelController.textCarTitle = null;
            sellPlacePanelController.containerActions = null;
            sellPlacePanelController.publishButton = null;
            this.view7f09009e.setOnClickListener(null);
            this.view7f09009e = null;
            this.view7f09008c.setOnClickListener(null);
            this.view7f09008c = null;
            this.view7f090052.setOnClickListener(null);
            this.view7f090052 = null;
            this.view7f09006f.setOnClickListener(null);
            this.view7f09006f = null;
            this.view7f090066.setOnClickListener(null);
            this.view7f090066 = null;
            this.view7f090054.setOnClickListener(null);
            this.view7f090054 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
