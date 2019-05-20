package ru.gg.scooby.ui.controller.panel;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class ParkingPostedController_ViewBinding implements Unbinder {
    private ParkingPostedController target;
    private View view7f09008d;
    private View view7f09008f;

    public ParkingPostedController_ViewBinding(final ParkingPostedController parkingPostedController, View view) {
        this.target = parkingPostedController;
        parkingPostedController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        parkingPostedController.textAddress = (TextView) C0730b.m2751a(view, R.id.text_address, "field 'textAddress'", TextView.class);
        parkingPostedController.textPriceTitle = (TextView) C0730b.m2751a(view, R.id.text_price_title, "field 'textPriceTitle'", TextView.class);
        parkingPostedController.textDate = (TextView) C0730b.m2751a(view, R.id.text_date, "field 'textDate'", TextView.class);
        View a = C0730b.m2750a(view, R.id.btn_delete, "method 'onDelete'");
        this.view7f09008d = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ParkingPostedController_ViewBinding f12826c;

            /* renamed from: a */
            public void mo1911a(View view) {
                parkingPostedController.onDelete();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_edit, "method 'onEdit'");
        this.view7f09008f = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ParkingPostedController_ViewBinding f12828c;

            /* renamed from: a */
            public void mo1911a(View view) {
                parkingPostedController.onEdit();
            }
        });
    }

    public void unbind() {
        ParkingPostedController parkingPostedController = this.target;
        if (parkingPostedController != null) {
            this.target = null;
            parkingPostedController.imageAvatar = null;
            parkingPostedController.textAddress = null;
            parkingPostedController.textPriceTitle = null;
            parkingPostedController.textDate = null;
            this.view7f09008d.setOnClickListener(null);
            this.view7f09008d = null;
            this.view7f09008f.setOnClickListener(null);
            this.view7f09008f = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
