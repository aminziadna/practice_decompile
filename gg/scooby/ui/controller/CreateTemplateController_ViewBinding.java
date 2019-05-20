package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class CreateTemplateController_ViewBinding implements Unbinder {
    private CreateTemplateController target;
    private View view7f090092;
    private View view7f090093;
    private View view7f090094;
    private View view7f090095;
    private View view7f090098;

    public CreateTemplateController_ViewBinding(final CreateTemplateController createTemplateController, View view) {
        this.target = createTemplateController;
        createTemplateController.toolbar = (Toolbar) C0730b.m2751a(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View a = C0730b.m2750a(view, R.id.btn_next, "field 'nextButton' and method 'onNextClick'");
        createTemplateController.nextButton = (TextView) C0730b.m2753b(a, R.id.btn_next, "field 'nextButton'", TextView.class);
        this.view7f090098 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ CreateTemplateController_ViewBinding f12730c;

            /* renamed from: a */
            public void mo1911a(View view) {
                createTemplateController.onNextClick();
            }
        });
        createTemplateController.textFio = (EditText) C0730b.m2751a(view, R.id.edit_text_fio, "field 'textFio'", EditText.class);
        createTemplateController.textAccount = (EditText) C0730b.m2751a(view, R.id.edit_text_account, "field 'textAccount'", EditText.class);
        createTemplateController.textBik = (EditText) C0730b.m2751a(view, R.id.edit_text_bik, "field 'textBik'", EditText.class);
        createTemplateController.textTemplateName = (EditText) C0730b.m2751a(view, R.id.edit_text_template_name, "field 'textTemplateName'", EditText.class);
        a = C0730b.m2750a(view, R.id.btn_info_fio, "method 'onInfoFioClick'");
        this.view7f090094 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ CreateTemplateController_ViewBinding f12732c;

            /* renamed from: a */
            public void mo1911a(View view) {
                createTemplateController.onInfoFioClick();
            }
        });
        a = C0730b.m2750a(view, R.id.btn_info_account, "method 'onInfoAccountClick'");
        this.view7f090092 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ CreateTemplateController_ViewBinding f12734c;

            /* renamed from: a */
            public void mo1911a(View view) {
                createTemplateController.onInfoAccountClick();
            }
        });
        a = C0730b.m2750a(view, R.id.btn_info_bik, "method 'onInfoBikClick'");
        this.view7f090093 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ CreateTemplateController_ViewBinding f12736c;

            /* renamed from: a */
            public void mo1911a(View view) {
                createTemplateController.onInfoBikClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_info_name, "method 'onInfoNameClick'");
        this.view7f090095 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ CreateTemplateController_ViewBinding f12738c;

            /* renamed from: a */
            public void mo1911a(View view) {
                createTemplateController.onInfoNameClick();
            }
        });
    }

    public void unbind() {
        CreateTemplateController createTemplateController = this.target;
        if (createTemplateController != null) {
            this.target = null;
            createTemplateController.toolbar = null;
            createTemplateController.nextButton = null;
            createTemplateController.textFio = null;
            createTemplateController.textAccount = null;
            createTemplateController.textBik = null;
            createTemplateController.textTemplateName = null;
            this.view7f090098.setOnClickListener(null);
            this.view7f090098 = null;
            this.view7f090094.setOnClickListener(null);
            this.view7f090094 = null;
            this.view7f090092.setOnClickListener(null);
            this.view7f090092 = null;
            this.view7f090093.setOnClickListener(null);
            this.view7f090093 = null;
            this.view7f090095.setOnClickListener(null);
            this.view7f090095 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
