package ru.tinkoff.acquiring.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.C4746d;
import androidx.appcompat.view.C0119b;
import androidx.appcompat.view.C0119b.C0118a;
import androidx.fragment.app.C2968d;
import java.util.ArrayList;
import java.util.List;
import ru.tinkoff.acquiring.sdk.ax.C2740f;
import ru.tinkoff.acquiring.sdk.ax.C2741g;
import ru.tinkoff.acquiring.sdk.ax.C2742h;
import ru.tinkoff.acquiring.sdk.ax.C2743i;

/* compiled from: CardListFragment */
/* renamed from: ru.tinkoff.acquiring.sdk.j */
public class C4679j extends C2968d implements OnItemClickListener, OnItemLongClickListener, ac {
    /* renamed from: a */
    public static String f14142a = "customer_key";
    /* renamed from: b */
    private ListView f14143b;
    /* renamed from: c */
    private C2769b f14144c;
    /* renamed from: d */
    private String f14145d;
    /* renamed from: e */
    private C0119b f14146e;

    /* compiled from: CardListFragment */
    /* renamed from: ru.tinkoff.acquiring.sdk.j$b */
    private static class C2769b extends BaseAdapter {
        /* renamed from: a */
        private List<C2770c> f8502a = new ArrayList();
        /* renamed from: b */
        private Activity f8503b;
        /* renamed from: c */
        private C2771k f8504c;
        /* renamed from: d */
        private final boolean f8505d;
        /* renamed from: e */
        private int f8506e = -1;

        public boolean areAllItemsEnabled() {
            return false;
        }

        public long getItemId(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public /* synthetic */ Object getItem(int i) {
            return m11396b(i);
        }

        public C2769b(Activity activity, boolean z) {
            this.f8503b = activity;
            this.f8505d = z;
            this.f8504c = new be(activity);
        }

        public boolean isEnabled(int i) {
            return m11396b(i).f8507a != 0;
        }

        /* renamed from: a */
        public void m11394a(int i) {
            this.f8506e = i;
        }

        /* renamed from: a */
        public void m11395a(C2766h[] c2766hArr) {
            List arrayList = new ArrayList();
            if (c2766hArr != null && c2766hArr.length > 0) {
                for (C2766h c2770c : c2766hArr) {
                    arrayList.add(new C2770c(c2770c));
                }
                arrayList.add(new C2770c());
            }
            arrayList.add(new C2770c(2));
            this.f8502a = arrayList;
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.f8502a.size();
        }

        /* renamed from: b */
        public C2770c m11396b(int i) {
            return (C2770c) this.f8502a.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            boolean z = false;
            if (itemViewType == 0) {
                if (view == null) {
                    view = LayoutInflater.from(this.f8503b).inflate(C2741g.acq_item_divider, viewGroup, false);
                }
                return view;
            } else if (itemViewType == 1) {
                C2766h c2766h = (C2766h) m11396b(i).f8508b;
                if (view == null) {
                    view = LayoutInflater.from(this.f8503b).inflate(C2741g.acq_item_card, viewGroup, false);
                }
                viewGroup = c2766h.m11386a();
                ((ImageView) view.findViewById(C2740f.iv_icon)).setImageBitmap(this.f8504c.m11401a(this.f8503b, viewGroup));
                ((TextView) view.findViewById(C2740f.tv_card_name)).setText(viewGroup);
                view.findViewById(C2740f.iv_daw).setVisibility(((PayFormActivity) this.f8503b).m22194h() == c2766h ? 0 : 8);
                viewGroup = this.f8506e;
                if (viewGroup != -1 && i == viewGroup) {
                    z = true;
                }
                view.setSelected(z);
                return view;
            } else if (itemViewType == 2) {
                if (view == null) {
                    view = LayoutInflater.from(this.f8503b).inflate(C2741g.acq_item_new_card, viewGroup, false);
                }
                return view;
            } else {
                view = new StringBuilder();
                view.append("no views for type ");
                view.append(itemViewType);
                throw new IllegalStateException(view.toString());
            }
        }

        public int getItemViewType(int i) {
            return m11396b(i).f8507a;
        }

        /* renamed from: a */
        C2766h m11393a() {
            int i = this.f8506e;
            if (i >= 0) {
                if (i <= this.f8502a.size()) {
                    if (getItemViewType(this.f8506e) == 1) {
                        return (C2766h) m11396b(this.f8506e).f8508b;
                    }
                    return null;
                }
            }
            return null;
        }
    }

    /* compiled from: CardListFragment */
    /* renamed from: ru.tinkoff.acquiring.sdk.j$c */
    private static class C2770c {
        /* renamed from: a */
        private int f8507a;
        /* renamed from: b */
        private Object f8508b;

        public C2770c() {
            this.f8507a = 0;
        }

        public C2770c(C2766h c2766h) {
            this.f8508b = c2766h;
            this.f8507a = 1;
        }

        public C2770c(int i) {
            this.f8507a = i;
        }
    }

    /* compiled from: CardListFragment */
    /* renamed from: ru.tinkoff.acquiring.sdk.j$a */
    private class C4320a implements C0118a {
        /* renamed from: a */
        final /* synthetic */ C4679j f12957a;

        /* renamed from: b */
        public boolean mo90b(C0119b c0119b, Menu menu) {
            return false;
        }

        private C4320a(C4679j c4679j) {
            this.f12957a = c4679j;
        }

        /* renamed from: a */
        public void mo87a(C0119b c0119b) {
            this.f12957a.f14144c.m11394a(-1);
            this.f12957a.f14144c.notifyDataSetChanged();
            this.f12957a.f14146e = null;
        }

        /* renamed from: a */
        public boolean mo88a(C0119b c0119b, Menu menu) {
            c0119b.mo151a().inflate(C2742h.menu_delete_card, menu);
            return true;
        }

        /* renamed from: a */
        public boolean mo89a(C0119b c0119b, MenuItem menuItem) {
            if (menuItem.getItemId() != C2740f.action_delete) {
                return null;
            }
            C4679j.m20643b(((PayFormActivity) this.f12957a.m12446l()).mo2593f(), this.f12957a.f14144c.m11393a(), this.f12957a.f14145d, this.f12957a.m12390a(C2743i.acq_cant_delete_card_message));
            c0119b.mo159c();
            return true;
        }
    }

    /* renamed from: a */
    public static C4679j m20640a(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(f14142a, str);
        bundle.putBoolean("charge_mode", z);
        str = new C4679j();
        str.m12435g(bundle);
        return str;
    }

    /* renamed from: a */
    public View mo2392a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C2741g.acq_fragment_card_list, viewGroup, false);
        this.f14143b = (ListView) layoutInflater.findViewById(C2740f.lv_cards);
        this.f14144c = new C2769b(m12446l(), m12434g().getBoolean("charge_mode", false));
        this.f14143b.setAdapter(this.f14144c);
        this.f14143b.setOnItemClickListener(this);
        this.f14143b.setOnItemLongClickListener(this);
        return layoutInflater;
    }

    /* renamed from: d */
    public void mo2063d(Bundle bundle) {
        super.mo2063d(bundle);
        this.f14145d = m12434g().getString(f14142a);
        PayFormActivity payFormActivity = (PayFormActivity) m12446l();
        PayFormActivity.m22170a(this.f14145d, ((PayFormActivity) m12446l()).m22190d());
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PayFormActivity payFormActivity = (PayFormActivity) m12446l();
        C2766h c2766h = (C2766h) this.f14144c.m11396b(i).f8508b;
        C0119b c0119b = this.f14146e;
        if (c0119b == null || c2766h == null) {
            view = this.f14146e;
            if (view != null) {
                view.mo159c();
                return;
            }
            payFormActivity.m22198l().m11431a(101, Bundle.EMPTY);
            payFormActivity.m22188b(c2766h);
            payFormActivity.m22201o();
            return;
        }
        c0119b.mo160d();
        this.f14144c.m11394a(i);
        view.setSelected(true);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (((C2766h) this.f14144c.m11396b(i).f8508b) == null) {
            return null;
        }
        C4746d c4746d = (C4746d) m12446l();
        this.f14144c.m11394a(i);
        view.setSelected(true);
        view = this.f14146e;
        if (view != null) {
            view.mo160d();
        } else {
            this.f14146e = c4746d.startSupportActionMode(new C4320a());
        }
        return true;
    }

    /* renamed from: a */
    public void mo2056a() {
        this.f14144c.m11395a(((PayFormActivity) m12446l()).m22193g());
    }

    /* renamed from: b */
    private static void m20643b(final C4307c c4307c, final C2766h c2766h, final String str, final String str2) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (c4307c.m18459a(str, c2766h.m11387b())) {
                        ar.f8385a.obtainMessage(1, c2766h).sendToTarget();
                        return;
                    }
                    throw new C2757d(new RuntimeException(str2));
                } catch (Exception e) {
                    C2777r.f8527a.obtainMessage(4, e).sendToTarget();
                }
            }
        }).start();
    }
}
