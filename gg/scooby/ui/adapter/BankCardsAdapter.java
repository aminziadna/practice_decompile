package ru.gg.scooby.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.C0586a;
import androidx.recyclerview.widget.RecyclerView.C0615x;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.p054a.C0730b;
import io.p181b.p234i.C4745a;
import java.util.ArrayList;
import java.util.List;
import p042b.p047e.p049b.C0700j;
import ru.skooby.R;
import ru.tinkoff.acquiring.sdk.C2766h;

/* compiled from: BankCardsAdapter.kt */
public final class BankCardsAdapter extends C0586a<ViewHolder> {
    private final C4745a<C2766h> clickListenerSubject;
    private final List<C2766h> items = ((List) new ArrayList());
    private final LayoutInflater layoutInflater;

    /* compiled from: BankCardsAdapter.kt */
    public static final class ClickListener implements OnClickListener {
        private final BankCardsAdapter adapter;
        private final C4745a<C2766h> clickObservable;
        private final ViewHolder holder;

        public ClickListener(C4745a<C2766h> c4745a, ViewHolder viewHolder, BankCardsAdapter bankCardsAdapter) {
            C0700j.m2715b(c4745a, "clickObservable");
            C0700j.m2715b(viewHolder, "holder");
            C0700j.m2715b(bankCardsAdapter, "adapter");
            this.clickObservable = c4745a;
            this.holder = viewHolder;
            this.adapter = bankCardsAdapter;
        }

        public final BankCardsAdapter getAdapter() {
            return this.adapter;
        }

        public final C4745a<C2766h> getClickObservable() {
            return this.clickObservable;
        }

        public final ViewHolder getHolder() {
            return this.holder;
        }

        public void onClick(View view) {
            if (this.holder.getAdapterPosition() >= null) {
                if (this.holder.getAdapterPosition() < this.adapter.getItemCount()) {
                    this.clickObservable.a_(this.adapter.items.get(this.holder.getAdapterPosition()));
                }
            }
        }
    }

    /* compiled from: BankCardsAdapter.kt */
    public static final class ViewHolder extends C0615x {
        @BindView
        public TextView textPan;
        private final View view;

        public ViewHolder(View view) {
            C0700j.m2715b(view, "view");
            super(view);
            this.view = view;
            ButterKnife.m2745a(this, this.view);
        }

        public final View getView() {
            return this.view;
        }

        public final TextView getTextPan() {
            TextView textView = this.textPan;
            if (textView == null) {
                C0700j.m2716b("textPan");
            }
            return textView;
        }

        public final void setTextPan(TextView textView) {
            C0700j.m2715b(textView, "<set-?>");
            this.textPan = textView;
        }

        public final void bind(C2766h c2766h) {
            C0700j.m2715b(c2766h, "item");
            TextView textView = this.textPan;
            if (textView == null) {
                C0700j.m2716b("textPan");
            }
            textView.setText(c2766h.m11386a());
        }
    }

    public final class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.textPan = (TextView) C0730b.m2751a(view, R.id.text_first, "field 'textPan'", TextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.textPan = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public BankCardsAdapter(LayoutInflater layoutInflater) {
        C0700j.m2715b(layoutInflater, "layoutInflater");
        this.layoutInflater = layoutInflater;
        Object f = C4745a.m21633f();
        C0700j.m2711a(f, "PublishSubject.create()");
        this.clickListenerSubject = f;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.layoutInflater;
    }

    public final C4745a<C2766h> getClickListenerSubject() {
        return this.clickListenerSubject;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C0700j.m2715b(viewHolder, "holder");
        viewHolder.bind((C2766h) this.items.get(i));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0700j.m2715b(viewGroup, "parent");
        Object inflate = this.layoutInflater.inflate(R.layout.list_item_with_arrow, viewGroup, false);
        C0700j.m2711a(inflate, "view");
        i = new ViewHolder(inflate);
        inflate.setOnClickListener(new ClickListener(this.clickListenerSubject, i, this));
        return i;
    }

    public final void updateItems(List<? extends C2766h> list) {
        C0700j.m2715b(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }
}
