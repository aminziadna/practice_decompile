package ru.gg.scooby.ui.controller.panel;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class ActiveTripController_ViewBinding implements Unbinder {
    private ActiveTripController target;
    private View view7f090087;
    private View view7f090090;

    public ActiveTripController_ViewBinding(final ActiveTripController activeTripController, View view) {
        this.target = activeTripController;
        activeTripController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        activeTripController.textAddress = (TextView) C0730b.m2751a(view, R.id.text_address, "field 'textAddress'", TextView.class);
        activeTripController.textCarNumber = (TextView) C0730b.m2751a(view, R.id.text_car_number, "field 'textCarNumber'", TextView.class);
        activeTripController.textCarModel = (TextView) C0730b.m2751a(view, R.id.text_car_model, "field 'textCarModel'", TextView.class);
        activeTripController.textCarColor = (TextView) C0730b.m2751a(view, R.id.text_car_color, "field 'textCarColor'", TextView.class);
        View a = C0730b.m2750a(view, R.id.btn_finish, "method 'onFinishClick'");
        this.view7f090090 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ActiveTripController_ViewBinding f12822c;

            /* renamed from: a */
            public void mo1911a(View view) {
                activeTripController.onFinishClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_call, "method 'onCallClick'");
        this.view7f090087 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ActiveTripController_ViewBinding f12824c;

            /* renamed from: a */
            public void mo1911a(View view) {
                activeTripController.onCallClick();
            }
        });
    }

    public void unbind() {
        ActiveTripController activeTripController = this.target;
        if (activeTripController != null) {
            this.target = null;
            activeTripController.imageAvatar = null;
            activeTripController.textAddress = null;
            activeTripController.textCarNumber = null;
            activeTripController.textCarModel = null;
            activeTripController.textCarColor = null;
            this.view7f090090.setOnClickListener(null);
            this.view7f090090 = null;
            this.view7f090087.setOnClickListener(null);
            this.view7f090087 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
