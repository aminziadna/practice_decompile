package ru.gg.scooby.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.C0586a;
import androidx.recyclerview.widget.RecyclerView.C0615x;
import io.card.payment.BuildConfig;
import io.p181b.p234i.C4745a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p042b.p047e.p049b.C0700j;
import p042b.p053i.C4773o;
import ru.gg.scooby.model.Color;
import ru.skooby.R;

/* compiled from: CarAttributeAdapter.kt */
public final class CarAttributeAdapter extends C0586a<ViewHolder> {
    private final C4745a<Object> clickListenerSubject;
    private final int itemResId;
    private final List<Object> items = ((List) new ArrayList());
    private final LayoutInflater layoutInflater;
    private final List<Object> originalItems = ((List) new ArrayList());

    /* compiled from: CarAttributeAdapter.kt */
    public static final class ClickListener implements OnClickListener {
        private final CarAttributeAdapter adapter;
        private final C4745a<Object> clickObservable;
        private final ViewHolder holder;

        public ClickListener(C4745a<Object> c4745a, ViewHolder viewHolder, CarAttributeAdapter carAttributeAdapter) {
            C0700j.m2715b(c4745a, "clickObservable");
            C0700j.m2715b(viewHolder, "holder");
            C0700j.m2715b(carAttributeAdapter, "adapter");
            this.clickObservable = c4745a;
            this.holder = viewHolder;
            this.adapter = carAttributeAdapter;
        }

        public final CarAttributeAdapter getAdapter() {
            return this.adapter;
        }

        public final C4745a<Object> getClickObservable() {
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

    /* compiled from: CarAttributeAdapter.kt */
    public static final class ViewHolder extends C0615x {
        private ImageView colorView = ((ImageView) this.view.findViewById(R.id.ic_color));
        private TextView textView;
        private final View view;

        public ViewHolder(View view) {
            C0700j.m2715b(view, "view");
            super(view);
            this.view = view;
            Object findViewById = this.view.findViewById(R.id.text);
            C0700j.m2711a(findViewById, "view.findViewById(R.id.text)");
            this.textView = (TextView) findViewById;
        }

        public final View getView() {
            return this.view;
        }

        public final TextView getTextView() {
            return this.textView;
        }

        public final void setTextView(TextView textView) {
            C0700j.m2715b(textView, "<set-?>");
            this.textView = textView;
        }

        public final ImageView getColorView() {
            return this.colorView;
        }

        public final void setColorView(ImageView imageView) {
            this.colorView = imageView;
        }

        public final void bind(Object obj) {
            C0700j.m2715b(obj, "item");
            this.textView.setText(obj.toString());
            if (obj instanceof Color) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('#');
                stringBuilder.append(((Color) obj).getHex());
                obj = android.graphics.Color.parseColor(stringBuilder.toString());
                if (obj == -1) {
                    obj = this.colorView;
                    if (obj != null) {
                        obj.setColorFilter(null);
                        return;
                    }
                    return;
                }
                ImageView imageView = this.colorView;
                if (imageView != null) {
                    imageView.setColorFilter(obj);
                }
            }
        }
    }

    public final LayoutInflater getLayoutInflater() {
        return this.layoutInflater;
    }

    public CarAttributeAdapter(LayoutInflater layoutInflater, int i) {
        C0700j.m2715b(layoutInflater, "layoutInflater");
        this.layoutInflater = layoutInflater;
        this.itemResId = i;
        Object f = C4745a.m21633f();
        C0700j.m2711a(f, "PublishSubject.create()");
        this.clickListenerSubject = f;
    }

    public final int getItemResId() {
        return this.itemResId;
    }

    public final C4745a<Object> getClickListenerSubject() {
        return this.clickListenerSubject;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C0700j.m2715b(viewHolder, "holder");
        viewHolder.bind(this.items.get(i));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0700j.m2715b(viewGroup, "parent");
        Object inflate = this.layoutInflater.inflate(this.itemResId, viewGroup, false);
        C0700j.m2711a(inflate, "view");
        i = new ViewHolder(inflate);
        inflate.setOnClickListener(new ClickListener(this.clickListenerSubject, i, this));
        return i;
    }

    public final void filter(String str) {
        C0700j.m2715b(str, "query");
        this.items.clear();
        CharSequence charSequence = str;
        if ((charSequence.length() == 0 ? 1 : null) != null) {
            this.items.addAll(this.originalItems);
        } else {
            List list = this.items;
            Collection arrayList = new ArrayList();
            for (Object next : this.originalItems) {
                if (C4773o.m22228a((CharSequence) next.toString(), charSequence, true)) {
                    arrayList.add(next);
                }
            }
            list.addAll((List) arrayList);
        }
        notifyDataSetChanged();
    }

    public final void updateItems(List<? extends Object> list) {
        C0700j.m2715b(list, "list");
        this.originalItems.clear();
        this.originalItems.addAll(list);
        filter(BuildConfig.FLAVOR);
    }
}
