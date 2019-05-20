package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class ProfileNameController_ViewBinding implements Unbinder {
    private ProfileNameController target;

    public ProfileNameController_ViewBinding(ProfileNameController profileNameController, View view) {
        this.target = profileNameController;
        profileNameController.nameText = (TextView) C0730b.m2751a(view, R.id.name_edit_text, "field 'nameText'", TextView.class);
        profileNameController.submitButton = (TextView) C0730b.m2751a(view, R.id.btn_submit, "field 'submitButton'", TextView.class);
        profileNameController.toolbar = (Toolbar) C0730b.m2751a(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    public void unbind() {
        ProfileNameController profileNameController = this.target;
        if (profileNameController != null) {
            this.target = null;
            profileNameController.nameText = null;
            profileNameController.submitButton = null;
            profileNameController.toolbar = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
