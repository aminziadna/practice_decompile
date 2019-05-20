package ru.gg.scooby.ui.address;

import android.content.Context;
import android.database.DataSetObserver;
import android.location.Address;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p185b.C2468b;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p042b.C0724k;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.manager.RecentManager;
import ru.gg.scooby.network.GeocoderManager;
import ru.gg.scooby.util.Log;
import ru.skooby.R;

/* compiled from: AddressAutoCompleteHelper.kt */
public final class AddressAutoCompleteHelper implements Callback, TextWatcher {
    private static final long ADDRESS_REQUEST_DELAY = ADDRESS_REQUEST_DELAY;
    public static final Companion Companion = new Companion();
    private static final int MSG_ADDRESS_REQUEST = 1;
    private final AddressesAdapter adapter = new AddressesAdapter(this.context, R.layout.list_item_address, (List) new ArrayList());
    public AddressListener addressListener;
    private final Context context;
    private String currentCompletingQuery;
    private final EditText editText;
    private final TextView errorTextView;
    private C2468b geocoderSubscription;
    private final Handler handler = new Handler(this);
    private final View listViewContainer;
    private final View progressBar;
    private final List<Address> recentAddresses = RecentManager.INSTANCE.getAddressList();

    /* compiled from: AddressAutoCompleteHelper.kt */
    public interface AddressListener {
        void onAddressListLoaded(List<? extends Address> list);

        void onAddressSelected(Address address);
    }

    /* compiled from: AddressAutoCompleteHelper.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: AddressAutoCompleteHelper.kt */
    /* renamed from: ru.gg.scooby.ui.address.AddressAutoCompleteHelper$a */
    static final class C4616a extends C3038k implements C0690b<List<? extends Address>, C0727n> {
        final /* synthetic */ String $query;
        final /* synthetic */ AddressAutoCompleteHelper this$0;

        C4616a(AddressAutoCompleteHelper addressAutoCompleteHelper, String str) {
            this.this$0 = addressAutoCompleteHelper;
            this.$query = str;
            super(1);
        }

        /* renamed from: a */
        public final void m20483a(List<? extends Address> list) {
            AddressAutoCompleteHelper addressAutoCompleteHelper = this.this$0;
            String str = this.$query;
            C0700j.m2711a((Object) list, "it");
            addressAutoCompleteHelper.onAddressListResult(str, list);
        }
    }

    /* compiled from: AddressAutoCompleteHelper.kt */
    /* renamed from: ru.gg.scooby.ui.address.AddressAutoCompleteHelper$b */
    static final class C4617b extends C3038k implements C0690b<Throwable, C0727n> {
        /* renamed from: a */
        public static final C4617b f14123a = new C4617b();

        C4617b() {
            super(1);
        }

        /* renamed from: a */
        public final void m20485a(Throwable th) {
            C0700j.m2715b(th, "it");
            Log.e$default(Log.INSTANCE, th, false, 2, null);
        }
    }

    public void afterTextChanged(Editable editable) {
        C0700j.m2715b(editable, "s");
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C0700j.m2715b(charSequence, "s");
    }

    public AddressAutoCompleteHelper(Context context, View view, EditText editText, View view2, TextView textView) {
        C0700j.m2715b(context, "context");
        C0700j.m2715b(view, "listViewContainer");
        C0700j.m2715b(editText, "editText");
        C0700j.m2715b(view2, "progressBar");
        C0700j.m2715b(textView, "errorTextView");
        this.context = context;
        this.listViewContainer = view;
        this.editText = editText;
        this.progressBar = view2;
        this.errorTextView = textView;
        this.adapter.setNotifyOnChange(true);
        this.adapter.addAll((Collection) this.recentAddresses);
        this.adapter.registerDataSetObserver((DataSetObserver) new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                this.getListViewContainer().setVisibility(this.adapter.isEmpty() ? 8 : 0);
            }
        });
        context = this.listViewContainer.findViewById(R.id.list_view);
        if (context != null) {
            ListView listView = (ListView) context;
            listView.setAdapter((ListAdapter) this.adapter);
            listView.setOnItemClickListener((OnItemClickListener) new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    Object obj = (Address) this.adapter.getItem(i);
                    view = RecentManager.INSTANCE;
                    C0700j.m2711a(obj, "address");
                    view.addAddress(obj);
                    this.getAddressListener().onAddressSelected(obj);
                }
            });
            return;
        }
        throw new C0724k("null cannot be cast to non-null type android.widget.ListView");
    }

    public final Context getContext() {
        return this.context;
    }

    public final View getListViewContainer() {
        return this.listViewContainer;
    }

    public final EditText getEditText() {
        return this.editText;
    }

    public final View getProgressBar() {
        return this.progressBar;
    }

    public final TextView getErrorTextView() {
        return this.errorTextView;
    }

    public final AddressListener getAddressListener() {
        AddressListener addressListener = this.addressListener;
        if (addressListener == null) {
            C0700j.m2716b("addressListener");
        }
        return addressListener;
    }

    public final void setAddressListener(AddressListener addressListener) {
        C0700j.m2715b(addressListener, "<set-?>");
        this.addressListener = addressListener;
    }

    public final void onPostCreate() {
        this.editText.addTextChangedListener(this);
    }

    public final void onDestroy() {
        this.editText.removeTextChangedListener(this);
    }

    private final void cancelScheduledMessages() {
        this.handler.removeMessages(MSG_ADDRESS_REQUEST);
    }

    private final void postLoadAddresses(String str) {
        this.handler.removeMessages(MSG_ADDRESS_REQUEST);
        this.handler.sendMessageDelayed(this.handler.obtainMessage(MSG_ADDRESS_REQUEST, str), ADDRESS_REQUEST_DELAY);
    }

    private final void loadAddresses(String str) {
        int i = 8;
        this.errorTextView.setVisibility(8);
        View view = this.progressBar;
        if (this.adapter.isEmpty()) {
            i = 0;
        }
        view.setVisibility(i);
        this.currentCompletingQuery = str;
        Object a = GeocoderManager.geocodeQuery$default(GeocoderManager.INSTANCE, str, null, 2, null).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
        C0700j.m2711a(a, "GeocoderManager.geocodeQ…dSchedulers.mainThread())");
        this.geocoderSubscription = C2517a.m10349a(a, (C0690b) C4617b.f14123a, null, new C4616a(this, str), 2, null);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C0700j.m2715b(charSequence, "s");
        charSequence = this.editText.getText().toString();
        if (charSequence.length() > 0) {
            postLoadAddresses(charSequence);
            return;
        }
        cancelScheduledMessages();
        charSequence = this.geocoderSubscription;
        if (charSequence != null) {
            charSequence.mo1727a();
        }
        this.adapter.clear();
        this.errorTextView.setVisibility(8);
    }

    public final void onAddressListResult(String str, List<? extends Address> list) {
        C0700j.m2715b(str, "query");
        C0700j.m2715b(list, "addressList");
        if ((C0700j.m2713a((Object) str, this.currentCompletingQuery) ^ 1) == null) {
            this.currentCompletingQuery = null;
            this.progressBar.setVisibility(8);
            str = this.addressListener;
            if (str == null) {
                C0700j.m2716b("addressListener");
            }
            str.onAddressListLoaded(list);
            if (list.isEmpty() == 1) {
                this.errorTextView.setVisibility(0);
                CharSequence text = this.editText.getText();
                if (text != null) {
                    if (text.length() != null) {
                        str = null;
                        if (str == null) {
                            this.adapter.setNotifyOnChange(false);
                            this.adapter.clear();
                            this.adapter.setNotifyOnChange(true);
                            this.adapter.addAll(this.recentAddresses);
                        } else {
                            this.adapter.clear();
                        }
                    }
                }
                str = true;
                if (str == null) {
                    this.adapter.clear();
                } else {
                    this.adapter.setNotifyOnChange(false);
                    this.adapter.clear();
                    this.adapter.setNotifyOnChange(true);
                    this.adapter.addAll(this.recentAddresses);
                }
            } else {
                this.errorTextView.setVisibility(8);
                this.adapter.setNotifyOnChange(false);
                this.adapter.clear();
                this.adapter.setNotifyOnChange(true);
                this.adapter.addAll(list);
            }
        }
    }

    public boolean handleMessage(Message message) {
        C0700j.m2715b(message, "msg");
        if (message.what != MSG_ADDRESS_REQUEST) {
            return null;
        }
        message = message.obj;
        if (message != null) {
            loadAddresses((String) message);
            return true;
        }
        throw new C0724k("null cannot be cast to non-null type kotlin.String");
    }
}
