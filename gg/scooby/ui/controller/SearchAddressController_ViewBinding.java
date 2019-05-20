package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class SearchAddressController_ViewBinding implements Unbinder {
    private SearchAddressController target;

    public SearchAddressController_ViewBinding(SearchAddressController searchAddressController, View view) {
        this.target = searchAddressController;
        searchAddressController.searchResultsContainer = (ListView) C0730b.m2751a(view, R.id.list_view, "field 'searchResultsContainer'", ListView.class);
        searchAddressController.addressText = (EditText) C0730b.m2751a(view, R.id.edit_text_input, "field 'addressText'", EditText.class);
        searchAddressController.progressBar = C0730b.m2750a(view, R.id.progress_bar, "field 'progressBar'");
        searchAddressController.errorText = (TextView) C0730b.m2751a(view, R.id.error_text, "field 'errorText'", TextView.class);
        searchAddressController.voiceInput = C0730b.m2750a(view, R.id.btn_voice_input, "field 'voiceInput'");
    }

    public void unbind() {
        SearchAddressController searchAddressController = this.target;
        if (searchAddressController != null) {
            this.target = null;
            searchAddressController.searchResultsContainer = null;
            searchAddressController.addressText = null;
            searchAddressController.progressBar = null;
            searchAddressController.errorText = null;
            searchAddressController.voiceInput = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
