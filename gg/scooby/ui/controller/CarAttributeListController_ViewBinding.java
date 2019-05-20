package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class CarAttributeListController_ViewBinding implements Unbinder {
    private CarAttributeListController target;
    private View view7f0900a7;

    public CarAttributeListController_ViewBinding(final CarAttributeListController carAttributeListController, View view) {
        this.target = carAttributeListController;
        carAttributeListController.searchResultsContainer = (RecyclerView) C0730b.m2751a(view, R.id.list_view, "field 'searchResultsContainer'", RecyclerView.class);
        carAttributeListController.searchText = (EditText) C0730b.m2751a(view, R.id.edit_text_input, "field 'searchText'", EditText.class);
        carAttributeListController.progressBar = C0730b.m2750a(view, R.id.progress_bar, "field 'progressBar'");
        carAttributeListController.errorText = (TextView) C0730b.m2751a(view, R.id.error_text, "field 'errorText'", TextView.class);
        view = C0730b.m2750a(view, R.id.btn_voice_input, "method 'onVoiceInputClick'");
        this.view7f0900a7 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ CarAttributeListController_ViewBinding f12710c;

            /* renamed from: a */
            public void mo1911a(View view) {
                carAttributeListController.onVoiceInputClick();
            }
        });
    }

    public void unbind() {
        CarAttributeListController carAttributeListController = this.target;
        if (carAttributeListController != null) {
            this.target = null;
            carAttributeListController.searchResultsContainer = null;
            carAttributeListController.searchText = null;
            carAttributeListController.progressBar = null;
            carAttributeListController.errorText = null;
            this.view7f0900a7.setOnClickListener(null);
            this.view7f0900a7 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
