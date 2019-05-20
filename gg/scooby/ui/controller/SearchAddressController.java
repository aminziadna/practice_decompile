package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import com.bluelinelabs.conductor.C0809d;
import java.util.List;
import p042b.C0724k;
import p042b.p043a.C4774r;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.ui.address.AddressAutoCompleteHelper;
import ru.gg.scooby.ui.address.AddressAutoCompleteHelper.AddressListener;
import ru.gg.scooby.ui.address.SelectAddressListener;
import ru.gg.scooby.util.AppUtils;
import ru.gg.scooby.util.UIUtils;
import ru.skooby.R;

/* compiled from: SearchAddressController.kt */
public final class SearchAddressController extends BaseController implements AddressListener {
    @BindView
    public EditText addressText;
    private AddressAutoCompleteHelper autoCompleteController;
    @BindView
    public TextView errorText;
    @BindView
    public View progressBar;
    @BindView
    public ListView searchResultsContainer;
    @BindView
    public View voiceInput;

    /* compiled from: SearchAddressController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SearchAddressController$a */
    static final class C2692a implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SearchAddressController f8315a;

        C2692a(SearchAddressController searchAddressController) {
            this.f8315a = searchAddressController;
        }

        public final void onClick(View view) {
            this.f8315a.startActivityForResult(AppUtils.getVoiceRecognitionIntent$default(AppUtils.INSTANCE, R.string.say_address, null, 2, null), 1);
        }
    }

    public final ListView getSearchResultsContainer() {
        ListView listView = this.searchResultsContainer;
        if (listView == null) {
            C0700j.m2716b("searchResultsContainer");
        }
        return listView;
    }

    public final void setSearchResultsContainer(ListView listView) {
        C0700j.m2715b(listView, "<set-?>");
        this.searchResultsContainer = listView;
    }

    public final EditText getAddressText() {
        EditText editText = this.addressText;
        if (editText == null) {
            C0700j.m2716b("addressText");
        }
        return editText;
    }

    public final void setAddressText(EditText editText) {
        C0700j.m2715b(editText, "<set-?>");
        this.addressText = editText;
    }

    public final View getProgressBar() {
        View view = this.progressBar;
        if (view == null) {
            C0700j.m2716b("progressBar");
        }
        return view;
    }

    public final void setProgressBar(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.progressBar = view;
    }

    public final TextView getErrorText() {
        TextView textView = this.errorText;
        if (textView == null) {
            C0700j.m2716b("errorText");
        }
        return textView;
    }

    public final void setErrorText(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.errorText = textView;
    }

    public final View getVoiceInput() {
        View view = this.voiceInput;
        if (view == null) {
            C0700j.m2716b("voiceInput");
        }
        return view;
    }

    public final void setVoiceInput(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.voiceInput = view;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_search_address, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…ddress, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.white_alternative), false, 8, null));
        UIUtils uIUtils = UIUtils.INSTANCE;
        Object activity2 = getActivity();
        if (activity2 == null) {
            C0700j.m2709a();
        }
        C0700j.m2711a(activity2, "activity!!");
        Context context = (Context) activity2;
        EditText editText = this.addressText;
        if (editText == null) {
            C0700j.m2716b("addressText");
        }
        uIUtils.showKeyboard(context, editText);
        Object context2 = view.getContext();
        C0700j.m2711a(context2, "view.context");
        view = this.searchResultsContainer;
        if (view == null) {
            C0700j.m2716b("searchResultsContainer");
        }
        View view2 = view;
        EditText editText2 = this.addressText;
        if (editText2 == null) {
            C0700j.m2716b("addressText");
        }
        View view3 = this.progressBar;
        if (view3 == null) {
            C0700j.m2716b("progressBar");
        }
        TextView textView = this.errorText;
        if (textView == null) {
            C0700j.m2716b("errorText");
        }
        this.autoCompleteController = new AddressAutoCompleteHelper(context2, view2, editText2, view3, textView);
        view = this.autoCompleteController;
        if (view != null) {
            view.setAddressListener(this);
        }
        view = this.autoCompleteController;
        if (view != null) {
            view.onPostCreate();
        }
        view = this.voiceInput;
        if (view == null) {
            C0700j.m2716b("voiceInput");
        }
        view.setOnClickListener(new C2692a(this));
    }

    protected void onDetach(View view) {
        C0700j.m2715b(view, "view");
        super.onDetach(view);
        view = this.autoCompleteController;
        if (view != null) {
            view.onDestroy();
        }
    }

    public void onAddressSelected(Address address) {
        C0700j.m2715b(address, "address");
        UIUtils uIUtils = UIUtils.INSTANCE;
        Activity activity = getActivity();
        if (activity == null) {
            C0700j.m2709a();
        }
        C0700j.m2711a((Object) activity, "activity!!");
        uIUtils.hideKeyboard(activity);
        getRouter().m3169l();
        C0809d targetController = getTargetController();
        if (targetController != null) {
            ((SelectAddressListener) targetController).onAddressSelected(address);
            return;
        }
        throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.address.SelectAddressListener");
    }

    public void onAddressListLoaded(List<? extends Address> list) {
        ListView listView = this.searchResultsContainer;
        if (listView == null) {
            C0700j.m2716b("searchResultsContainer");
        }
        list = (list == null || list.isEmpty() != 1) ? null : 8;
        listView.setVisibility(list);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1 && intent != null) {
            i = intent.getExtras();
            if (i != 0) {
                i = i.getStringArrayList("android.speech.extra.RESULTS");
                if (i != 0) {
                    String str = (String) C4774r.m22244d((List) i);
                    if (str != null) {
                        i2 = this.addressText;
                        if (i2 == 0) {
                            C0700j.m2716b("addressText");
                        }
                        i2.setText(str);
                    }
                }
            }
        }
    }
}
