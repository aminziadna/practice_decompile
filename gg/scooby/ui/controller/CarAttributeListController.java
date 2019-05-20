package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d;
import io.card.payment.BuildConfig;
import io.p181b.p197g.C2517a;
import java.util.List;
import p042b.C0724k;
import p042b.C0727n;
import p042b.p043a.C4774r;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.helper.CarAttributeSearchHelper;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.ui.adapter.CarAttributeAdapter;
import ru.gg.scooby.util.AppUtils;
import ru.gg.scooby.util.BundleBuilder;
import ru.skooby.R;

/* compiled from: CarAttributeListController.kt */
public final class CarAttributeListController extends BaseController {
    public static final String ARG_BRAND = "ARG_BRAND";
    public static final String ARG_TYPE = "ARG_TYPE";
    public static final Companion Companion = new Companion();
    public static final int TYPE_BRANDS = 0;
    public static final int TYPE_COLORS = 2;
    public static final int TYPE_MODELS = 1;
    public static final int TYPE_NUMBER = 3;
    @BindView
    public TextView errorText;
    @BindView
    public View progressBar;
    public CarAttributeSearchHelper searchHelper;
    @BindView
    public RecyclerView searchResultsContainer;
    @BindView
    public EditText searchText;

    /* compiled from: CarAttributeListController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: CarAttributeListController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.CarAttributeListController$a */
    static final class C4625a extends C3038k implements C0690b<Object, C0727n> {
        final /* synthetic */ CarAttributeListController this$0;

        C4625a(CarAttributeListController carAttributeListController) {
            this.this$0 = carAttributeListController;
            super(1);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo2124a(Object obj) {
            m20501b(obj);
            return C0727n.f2066a;
        }

        /* renamed from: b */
        public final void m20501b(Object obj) {
            C0809d targetController = this.this$0.getTargetController();
            if (targetController != null) {
                CarAttributeListener carAttributeListener = (CarAttributeListener) targetController;
                int i = this.this$0.getArgs().getInt("ARG_TYPE");
                C0700j.m2711a(obj, "it");
                carAttributeListener.onAttributeSelected(i, obj);
                this.this$0.getRouter().m3169l();
                return;
            }
            throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.controller.CarAttributeListener");
        }
    }

    public CarAttributeListController(int i, String str) {
        C0700j.m2715b(str, "brand");
        this(new BundleBuilder(new Bundle()).putInt("ARG_TYPE", i).putString(ARG_BRAND, str).build());
    }

    public /* synthetic */ CarAttributeListController(int i, String str, int i2, C0697g c0697g) {
        if ((i2 & 2) != 0) {
            str = BuildConfig.FLAVOR;
        }
        this(i, str);
    }

    public CarAttributeListController(Bundle bundle) {
        C0700j.m2715b(bundle, "bundle");
        super(bundle);
    }

    public final RecyclerView getSearchResultsContainer() {
        RecyclerView recyclerView = this.searchResultsContainer;
        if (recyclerView == null) {
            C0700j.m2716b("searchResultsContainer");
        }
        return recyclerView;
    }

    public final void setSearchResultsContainer(RecyclerView recyclerView) {
        C0700j.m2715b(recyclerView, "<set-?>");
        this.searchResultsContainer = recyclerView;
    }

    public final EditText getSearchText() {
        EditText editText = this.searchText;
        if (editText == null) {
            C0700j.m2716b("searchText");
        }
        return editText;
    }

    public final void setSearchText(EditText editText) {
        C0700j.m2715b(editText, "<set-?>");
        this.searchText = editText;
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

    public final CarAttributeSearchHelper getSearchHelper() {
        CarAttributeSearchHelper carAttributeSearchHelper = this.searchHelper;
        if (carAttributeSearchHelper == null) {
            C0700j.m2716b("searchHelper");
        }
        return carAttributeSearchHelper;
    }

    public final void setSearchHelper(CarAttributeSearchHelper carAttributeSearchHelper) {
        C0700j.m2715b(carAttributeSearchHelper, "<set-?>");
        this.searchHelper = carAttributeSearchHelper;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_car_attribute_list, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…e_list, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.white_alternative), false, 8, null));
        Object context = view.getContext();
        C0700j.m2711a(context, "view.context");
        int i = getArgs().getInt("ARG_TYPE");
        Object string = getArgs().getString(ARG_BRAND);
        C0700j.m2711a(string, "args.getString(ARG_BRAND)");
        RecyclerView recyclerView = this.searchResultsContainer;
        if (recyclerView == null) {
            C0700j.m2716b("searchResultsContainer");
        }
        EditText editText = this.searchText;
        if (editText == null) {
            C0700j.m2716b("searchText");
        }
        View view2 = this.progressBar;
        if (view2 == null) {
            C0700j.m2716b("progressBar");
        }
        this.searchHelper = new CarAttributeSearchHelper(context, i, string, recyclerView, editText, view2);
        view = this.searchHelper;
        if (view == null) {
            C0700j.m2716b("searchHelper");
        }
        view.onPostCreate();
        view = this.searchHelper;
        if (view == null) {
            C0700j.m2716b("searchHelper");
        }
        view.fillAdapter();
        view = this.searchResultsContainer;
        if (view == null) {
            C0700j.m2716b("searchResultsContainer");
        }
        view = view.getAdapter();
        if (view != null) {
            C2517a.m10349a(((CarAttributeAdapter) view).getClickListenerSubject(), null, null, (C0690b) new C4625a(this), 3, null);
            return;
        }
        throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.adapter.CarAttributeAdapter");
    }

    protected void onDestroyView(View view) {
        C0700j.m2715b(view, "view");
        super.onDestroyView(view);
        view = this.searchHelper;
        if (view == null) {
            C0700j.m2716b("searchHelper");
        }
        view.onDestroy();
    }

    @OnClick
    public final void onVoiceInputClick() {
        startActivityForResult(AppUtils.getVoiceRecognitionIntent$default(AppUtils.INSTANCE, 0, null, 3, null), 1);
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
                        i2 = this.searchText;
                        if (i2 == 0) {
                            C0700j.m2716b("searchText");
                        }
                        i2.setText(str);
                    }
                }
            }
        }
    }
}
