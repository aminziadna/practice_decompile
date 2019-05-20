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
import ru.gg.scooby.model.Car;
import ru.skooby.R;

/* compiled from: CarsAdapter.kt */
public final class CarsAdapter extends C0586a<ViewHolder> {
    private final C4745a<Car> clickListenerSubject;
    private final List<Car> items = ((List) new ArrayList());
    private final LayoutInflater layoutInflater;

    /* compiled from: CarsAdapter.kt */
    public static final class ClickListener implements OnClickListener {
        private final CarsAdapter adapter;
        private final C4745a<Car> clickObservable;
        private final ViewHolder holder;

        public ClickListener(C4745a<Car> c4745a, ViewHolder viewHolder, CarsAdapter carsAdapter) {
            C0700j.m2715b(c4745a, "clickObservable");
            C0700j.m2715b(viewHolder, "holder");
            C0700j.m2715b(carsAdapter, "adapter");
            this.clickObservable = c4745a;
            this.holder = viewHolder;
            this.adapter = carsAdapter;
        }

        public final CarsAdapter getAdapter() {
            return this.adapter;
        }

        public final C4745a<Car> getClickObservable() {
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

    /* compiled from: CarsAdapter.kt */
    public static final class ViewHolder extends C0615x {
        @BindView
        public TextView textModel;
        @BindView
        public TextView textNumber;
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

        public final TextView getTextModel() {
            TextView textView = this.textModel;
            if (textView == null) {
                C0700j.m2716b("textModel");
            }
            return textView;
        }

        public final void setTextModel(TextView textView) {
            C0700j.m2715b(textView, "<set-?>");
            this.textModel = textView;
        }

        public final TextView getTextNumber() {
            TextView textView = this.textNumber;
            if (textView == null) {
                C0700j.m2716b("textNumber");
            }
            return textView;
        }

        public final void setTextNumber(TextView textView) {
            C0700j.m2715b(textView, "<set-?>");
            this.textNumber = textView;
        }

        public final void bind(Car car) {
            C0700j.m2715b(car, "item");
            TextView textView = this.textModel;
            if (textView == null) {
                C0700j.m2716b("textModel");
            }
            textView.setText(car.getCommonCarName());
            textView = this.textNumber;
            if (textView == null) {
                C0700j.m2716b("textNumber");
            }
            textView.setText(car.getNumber());
        }
    }

    public final class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.textModel = (TextView) C0730b.m2751a(view, R.id.text_first, "field 'textModel'", TextView.class);
            viewHolder.textNumber = (TextView) C0730b.m2751a(view, R.id.text_second, "field 'textNumber'", TextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.textModel = null;
                viewHolder.textNumber = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public CarsAdapter(LayoutInflater layoutInflater) {
        C0700j.m2715b(layoutInflater, "layoutInflater");
        this.layoutInflater = layoutInflater;
        Object f = C4745a.m21633f();
        C0700j.m2711a(f, "PublishSubject.create()");
        this.clickListenerSubject = f;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.layoutInflater;
    }

    public final C4745a<Car> getClickListenerSubject() {
        return this.clickListenerSubject;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C0700j.m2715b(viewHolder, "holder");
        viewHolder.bind((Car) this.items.get(i));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0700j.m2715b(viewGroup, "parent");
        Object inflate = this.layoutInflater.inflate(R.layout.list_item_with_arrow, viewGroup, false);
        C0700j.m2711a(inflate, "view");
        i = new ViewHolder(inflate);
        inflate.setOnClickListener(new ClickListener(this.clickListenerSubject, i, this));
        return i;
    }

    public final void updateItems(List<Car> list) {
        C0700j.m2715b(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }
}
