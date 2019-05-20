package ru.gg.scooby.helper;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.recyclerview.widget.C3016d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C0586a;
import androidx.recyclerview.widget.RecyclerView.C0595h;
import androidx.recyclerview.widget.RecyclerView.C0598i;
import com.google.android.material.snackbar.Snackbar;
import io.p181b.p197g.C2517a;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p042b.C0724k;
import p042b.C0727n;
import p042b.p043a.C4774r;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p042b.p053i.C4773o;
import ru.gg.scooby.manager.ColorsManager;
import ru.gg.scooby.manager.ModelsManager;
import ru.gg.scooby.model.Color;
import ru.gg.scooby.ui.adapter.CarAttributeAdapter;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.skooby.R;

/* compiled from: CarAttributeSearchHelper.kt */
public final class CarAttributeSearchHelper implements TextWatcher {
    private final CarAttributeAdapter adapter;
    private final String brand;
    private final Context context;
    private final EditText editText;
    private final RecyclerView listViewContainer;
    private final View progressBar;
    private final int type;

    /* compiled from: CarAttributeSearchHelper.kt */
    /* renamed from: ru.gg.scooby.helper.CarAttributeSearchHelper$a */
    static final class C4591a extends C3038k implements C0690b<List<? extends Color>, C0727n> {
        final /* synthetic */ CarAttributeSearchHelper this$0;

        C4591a(CarAttributeSearchHelper carAttributeSearchHelper) {
            this.this$0 = carAttributeSearchHelper;
            super(1);
        }

        /* renamed from: a */
        public final void m20433a(List<Color> list) {
            C0700j.m2715b(list, "it");
            this.this$0.getProgressBar().setVisibility(8);
            if ((list.isEmpty() ^ 1) != 0) {
                this.this$0.adapter.updateItems(list);
            } else {
                Snackbar.m15345a((View) this.this$0.getListViewContainer(), ValidationCode.UnknownError.getErrorMessage(), -1).mo1269f();
            }
        }
    }

    /* compiled from: CarAttributeSearchHelper.kt */
    /* renamed from: ru.gg.scooby.helper.CarAttributeSearchHelper$b */
    static final class C4592b extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ CarAttributeSearchHelper this$0;

        C4592b(CarAttributeSearchHelper carAttributeSearchHelper) {
            this.this$0 = carAttributeSearchHelper;
            super(1);
        }

        /* renamed from: a */
        public final void m20435a(Throwable th) {
            C0700j.m2715b(th, "it");
            this.this$0.getProgressBar().setVisibility(8);
            Snackbar.m15345a((View) this.this$0.getListViewContainer(), ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), -1).mo1269f();
        }
    }

    /* compiled from: CarAttributeSearchHelper.kt */
    /* renamed from: ru.gg.scooby.helper.CarAttributeSearchHelper$c */
    static final class C4593c extends C3038k implements C0690b<Map<String, ? extends List<? extends String>>, C0727n> {
        final /* synthetic */ CarAttributeSearchHelper this$0;

        C4593c(CarAttributeSearchHelper carAttributeSearchHelper) {
            this.this$0 = carAttributeSearchHelper;
            super(1);
        }

        /* renamed from: a */
        public final void m20437a(Map<String, ? extends List<String>> map) {
            C0700j.m2715b(map, "it");
            this.this$0.getProgressBar().setVisibility(8);
            if (this.this$0.getType() == 0) {
                map = C4774r.m22240b(map.keySet());
            } else {
                map = (List) map.get(this.this$0.getBrand());
            }
            if (map == null || (((Collection) map).isEmpty() ^ 1) != 1) {
                Snackbar.m15345a((View) this.this$0.getListViewContainer(), ValidationCode.UnknownError.getErrorMessage(), -1).mo1269f();
            } else {
                this.this$0.adapter.updateItems(map);
            }
        }
    }

    /* compiled from: CarAttributeSearchHelper.kt */
    /* renamed from: ru.gg.scooby.helper.CarAttributeSearchHelper$d */
    static final class C4594d extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ CarAttributeSearchHelper this$0;

        C4594d(CarAttributeSearchHelper carAttributeSearchHelper) {
            this.this$0 = carAttributeSearchHelper;
            super(1);
        }

        /* renamed from: a */
        public final void m20439a(Throwable th) {
            C0700j.m2715b(th, "it");
            this.this$0.getProgressBar().setVisibility(8);
            Snackbar.m15345a((View) this.this$0.getListViewContainer(), ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), -1).mo1269f();
        }
    }

    public void afterTextChanged(Editable editable) {
        C0700j.m2715b(editable, "s");
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C0700j.m2715b(charSequence, "s");
    }

    public CarAttributeSearchHelper(Context context, int i, String str, RecyclerView recyclerView, EditText editText, View view) {
        C0700j.m2715b(context, "context");
        C0700j.m2715b(str, "brand");
        C0700j.m2715b(recyclerView, "listViewContainer");
        C0700j.m2715b(editText, "editText");
        C0700j.m2715b(view, "progressBar");
        this.context = context;
        this.type = i;
        this.brand = str;
        this.listViewContainer = recyclerView;
        this.editText = editText;
        this.progressBar = view;
        Object from;
        if (this.type != 2) {
            from = LayoutInflater.from(this.listViewContainer.getContext());
            C0700j.m2711a(from, "LayoutInflater.from(listViewContainer.context)");
            context = new CarAttributeAdapter(from, R.layout.list_item_car_attribute);
        } else {
            from = LayoutInflater.from(this.listViewContainer.getContext());
            C0700j.m2711a(from, "LayoutInflater.from(listViewContainer.context)");
            context = new CarAttributeAdapter(from, R.layout.list_item_color);
        }
        this.adapter = context;
        this.listViewContainer.setHasFixedSize(true);
        this.listViewContainer.setAdapter((C0586a) this.adapter);
        context = this.listViewContainer;
        context.setLayoutManager((C0598i) new LinearLayoutManager(context.getContext()));
        context = this.listViewContainer;
        str = new C3016d(context.getContext(), 1);
        str.m12907a(this.listViewContainer.getResources().getDrawable(R.drawable.bg_divider));
        context.m20860a((C0595h) str);
        context = this.editText;
        switch (this.type) {
            case 0:
                i = R.string.brand_hint;
                break;
            case 1:
                i = R.string.model_hint;
                break;
            case 2:
                i = R.string.color_hint;
                break;
            default:
                i = 0;
                break;
        }
        context.setHint(i);
        fillAdapter();
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getType() {
        return this.type;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final RecyclerView getListViewContainer() {
        return this.listViewContainer;
    }

    public final EditText getEditText() {
        return this.editText;
    }

    public final View getProgressBar() {
        return this.progressBar;
    }

    public final void fillAdapter() {
        this.progressBar.setVisibility(0);
        if (this.type != 2) {
            C2517a.m10349a(ModelsManager.INSTANCE.getModels(), new C4594d(this), null, new C4593c(this), 2, null);
            return;
        }
        C2517a.m10349a(ColorsManager.INSTANCE.getColors(), new C4592b(this), null, new C4591a(this), 2, null);
    }

    public final void onPostCreate() {
        this.editText.addTextChangedListener(this);
    }

    public final void onDestroy() {
        this.editText.removeTextChangedListener(this);
    }

    private final void filterList(String str) {
        CarAttributeAdapter carAttributeAdapter = this.adapter;
        if (str != null) {
            carAttributeAdapter.filter(C4773o.m22222a(str).toString());
            return;
        }
        throw new C0724k("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C0700j.m2715b(charSequence, "s");
        filterList(this.editText.getText().toString());
    }
}
