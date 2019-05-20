package ru.gg.scooby.ui.map;

import android.location.Location;
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
import io.card.payment.BuildConfig;
import io.p181b.p234i.C4745a;
import java.util.ArrayList;
import java.util.List;
import p042b.C0724k;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.model.Parking;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.util.DateUtils;
import ru.gg.scooby.util.LocationUtils;
import ru.skooby.R;

/* compiled from: ParkingBlockAdapter.kt */
public final class ParkingBlockAdapter extends C0586a<C0615x> implements OnClickListener {
    public static final Companion Companion = new Companion();
    public static final int TYPE_BUY = 1;
    public static final int TYPE_SELL = 0;
    private final C4745a<Integer> blockClickSubject;
    private final C4745a<ParkingAdvert> buyClickSubject;
    private Location currentUserLocation;
    private final List<ParkingAdvert> items = ((List) new ArrayList());
    private final LayoutInflater layoutInflater;
    private final C4745a<Object> sellClickSubject;

    /* compiled from: ParkingBlockAdapter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: ParkingBlockAdapter.kt */
    public static final class BuyViewHolder extends C0615x {
        private final ParkingBlockAdapter adapter;
        @BindView
        public TextView buyButton;
        @BindView
        public TextView dateText;
        @BindView
        public TextView distanceText;
        @BindView
        public AvatarImageView imageAvatar;
        @BindView
        public TextView likesText;

        public BuyViewHolder(View view, ParkingBlockAdapter parkingBlockAdapter) {
            C0700j.m2715b(view, "itemView");
            C0700j.m2715b(parkingBlockAdapter, "adapter");
            super(view);
            this.adapter = parkingBlockAdapter;
            ButterKnife.m2745a(this, view);
            view.setOnClickListener(this.adapter);
            view = this.buyButton;
            if (view == null) {
                C0700j.m2716b("buyButton");
            }
            view.setOnClickListener(this.adapter);
        }

        public final ParkingBlockAdapter getAdapter() {
            return this.adapter;
        }

        public final AvatarImageView getImageAvatar() {
            AvatarImageView avatarImageView = this.imageAvatar;
            if (avatarImageView == null) {
                C0700j.m2716b("imageAvatar");
            }
            return avatarImageView;
        }

        public final void setImageAvatar(AvatarImageView avatarImageView) {
            C0700j.m2715b(avatarImageView, "<set-?>");
            this.imageAvatar = avatarImageView;
        }

        public final TextView getDateText() {
            TextView textView = this.dateText;
            if (textView == null) {
                C0700j.m2716b("dateText");
            }
            return textView;
        }

        public final void setDateText(TextView textView) {
            C0700j.m2715b(textView, "<set-?>");
            this.dateText = textView;
        }

        public final TextView getDistanceText() {
            TextView textView = this.distanceText;
            if (textView == null) {
                C0700j.m2716b("distanceText");
            }
            return textView;
        }

        public final void setDistanceText(TextView textView) {
            C0700j.m2715b(textView, "<set-?>");
            this.distanceText = textView;
        }

        public final TextView getLikesText() {
            TextView textView = this.likesText;
            if (textView == null) {
                C0700j.m2716b("likesText");
            }
            return textView;
        }

        public final void setLikesText(TextView textView) {
            C0700j.m2715b(textView, "<set-?>");
            this.likesText = textView;
        }

        public final TextView getBuyButton() {
            TextView textView = this.buyButton;
            if (textView == null) {
                C0700j.m2716b("buyButton");
            }
            return textView;
        }

        public final void setBuyButton(TextView textView) {
            C0700j.m2715b(textView, "<set-?>");
            this.buyButton = textView;
        }

        public final void bind(ParkingAdvert parkingAdvert) {
            C0700j.m2715b(parkingAdvert, "item");
            TextView textView = this.likesText;
            if (textView == null) {
                C0700j.m2716b("likesText");
            }
            Profile profile = parkingAdvert.getProfile();
            String str = null;
            textView.setText(String.valueOf(profile != null ? profile.getLikes() : null));
            textView = this.buyButton;
            if (textView == null) {
                C0700j.m2716b("buyButton");
            }
            textView.setText(Parking.Companion.getPriceForUI(parkingAdvert.getParking().getNormalizedPrice()));
            Location currentUserLocation = this.adapter.getCurrentUserLocation();
            if (currentUserLocation != null) {
                float[] fArr = new float[1];
                Location.distanceBetween(parkingAdvert.getParking().getLat(), parkingAdvert.getParking().getLng(), currentUserLocation.getLatitude(), currentUserLocation.getLongitude(), fArr);
                textView = this.distanceText;
                if (textView == null) {
                    C0700j.m2716b("distanceText");
                }
                textView.setText(LocationUtils.INSTANCE.formatDistance(fArr[0]));
            } else {
                textView = this.distanceText;
                if (textView == null) {
                    C0700j.m2716b("distanceText");
                }
                textView.setText(BuildConfig.FLAVOR);
            }
            textView = this.buyButton;
            if (textView == null) {
                C0700j.m2716b("buyButton");
            }
            textView.setTag(parkingAdvert);
            Object obj = this.itemView;
            C0700j.m2711a(obj, "itemView");
            obj.setTag(Integer.valueOf(getAdapterPosition()));
            AvatarImageView avatarImageView = this.imageAvatar;
            if (avatarImageView == null) {
                C0700j.m2716b("imageAvatar");
            }
            profile = parkingAdvert.getProfile();
            if (profile != null) {
                str = profile.getAvatarUrl();
            }
            avatarImageView.setTargetImageUrl(str);
            textView = this.dateText;
            if (textView == null) {
                C0700j.m2716b("dateText");
            }
            textView.setText(DateUtils.INSTANCE.relativeStringDate(parkingAdvert.getParking().getTimeLong()));
        }
    }

    public final class BuyViewHolder_ViewBinding implements Unbinder {
        private BuyViewHolder target;

        public BuyViewHolder_ViewBinding(BuyViewHolder buyViewHolder, View view) {
            this.target = buyViewHolder;
            buyViewHolder.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
            buyViewHolder.dateText = (TextView) C0730b.m2751a(view, R.id.text_date, "field 'dateText'", TextView.class);
            buyViewHolder.distanceText = (TextView) C0730b.m2751a(view, R.id.text_distance, "field 'distanceText'", TextView.class);
            buyViewHolder.likesText = (TextView) C0730b.m2751a(view, R.id.text_likes, "field 'likesText'", TextView.class);
            buyViewHolder.buyButton = (TextView) C0730b.m2751a(view, R.id.btn_buy, "field 'buyButton'", TextView.class);
        }

        public void unbind() {
            BuyViewHolder buyViewHolder = this.target;
            if (buyViewHolder != null) {
                this.target = null;
                buyViewHolder.imageAvatar = null;
                buyViewHolder.dateText = null;
                buyViewHolder.distanceText = null;
                buyViewHolder.likesText = null;
                buyViewHolder.buyButton = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* compiled from: ParkingBlockAdapter.kt */
    public static final class SellViewHolder extends C0615x {
        @BindView
        public TextView addressText;
        @BindView
        public View sellButton;

        public SellViewHolder(View view, OnClickListener onClickListener) {
            C0700j.m2715b(view, "itemView");
            C0700j.m2715b(onClickListener, "buttonClickListener");
            super(view);
            ButterKnife.m2745a(this, view);
            view.setOnClickListener(onClickListener);
            view = this.sellButton;
            if (view == null) {
                C0700j.m2716b("sellButton");
            }
            view.setOnClickListener(onClickListener);
        }

        public final TextView getAddressText() {
            TextView textView = this.addressText;
            if (textView == null) {
                C0700j.m2716b("addressText");
            }
            return textView;
        }

        public final void setAddressText(TextView textView) {
            C0700j.m2715b(textView, "<set-?>");
            this.addressText = textView;
        }

        public final View getSellButton() {
            View view = this.sellButton;
            if (view == null) {
                C0700j.m2716b("sellButton");
            }
            return view;
        }

        public final void setSellButton(View view) {
            C0700j.m2715b(view, "<set-?>");
            this.sellButton = view;
        }

        public final void bind(String str) {
            C0700j.m2715b(str, "address");
            TextView textView = this.addressText;
            if (textView == null) {
                C0700j.m2716b("addressText");
            }
            textView.setText(str);
            Object obj = this.itemView;
            C0700j.m2711a(obj, "itemView");
            obj.setTag(Integer.valueOf(getAdapterPosition()));
        }
    }

    public final class SellViewHolder_ViewBinding implements Unbinder {
        private SellViewHolder target;

        public SellViewHolder_ViewBinding(SellViewHolder sellViewHolder, View view) {
            this.target = sellViewHolder;
            sellViewHolder.addressText = (TextView) C0730b.m2751a(view, R.id.text_address, "field 'addressText'", TextView.class);
            sellViewHolder.sellButton = C0730b.m2750a(view, R.id.btn_sell, "field 'sellButton'");
        }

        public void unbind() {
            SellViewHolder sellViewHolder = this.target;
            if (sellViewHolder != null) {
                this.target = null;
                sellViewHolder.addressText = null;
                sellViewHolder.sellButton = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    public ParkingBlockAdapter(LayoutInflater layoutInflater) {
        C0700j.m2715b(layoutInflater, "layoutInflater");
        this.layoutInflater = layoutInflater;
        Object f = C4745a.m21633f();
        C0700j.m2711a(f, "PublishSubject.create()");
        this.sellClickSubject = f;
        f = C4745a.m21633f();
        C0700j.m2711a(f, "PublishSubject.create()");
        this.buyClickSubject = f;
        f = C4745a.m21633f();
        C0700j.m2711a(f, "PublishSubject.create()");
        this.blockClickSubject = f;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.layoutInflater;
    }

    public final C4745a<Object> getSellClickSubject() {
        return this.sellClickSubject;
    }

    public final C4745a<ParkingAdvert> getBuyClickSubject() {
        return this.buyClickSubject;
    }

    public final C4745a<Integer> getBlockClickSubject() {
        return this.blockClickSubject;
    }

    public final List<ParkingAdvert> getItems() {
        return this.items;
    }

    public final Location getCurrentUserLocation() {
        return this.currentUserLocation;
    }

    public final void setCurrentUserLocation(Location location) {
        this.currentUserLocation = location;
    }

    public void onBindViewHolder(C0615x c0615x, int i) {
        C0700j.m2715b(c0615x, "holder");
        if (c0615x instanceof SellViewHolder) {
            ((SellViewHolder) c0615x).bind(BuildConfig.FLAVOR);
        } else if (c0615x instanceof BuyViewHolder) {
            ((BuyViewHolder) c0615x).bind((ParkingAdvert) this.items.get(i - 1));
        }
    }

    public int getItemCount() {
        return this.items.size() + 1;
    }

    public C0615x onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0700j.m2715b(viewGroup, "parent");
        if (i != 0) {
            Object inflate = this.layoutInflater.inflate(R.layout.block_item_buy_parking, viewGroup, false);
            C0700j.m2711a(inflate, "layoutInflater.inflate(R…y_parking, parent, false)");
            return (C0615x) new BuyViewHolder(inflate, this);
        }
        inflate = this.layoutInflater.inflate(R.layout.block_item_sell_parking, viewGroup, false);
        C0700j.m2711a(inflate, "layoutInflater.inflate(R…l_parking, parent, false)");
        return (C0615x) new SellViewHolder(inflate, this);
    }

    public void onClick(View view) {
        C4745a c4745a;
        if (view == null || view.getId() != R.id.block_root_view) {
            if ((view != null ? view.getTag() : null) instanceof ParkingAdvert) {
                c4745a = this.buyClickSubject;
                view = view.getTag();
                if (view != null) {
                    c4745a.a_((ParkingAdvert) view);
                    return;
                }
                throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.model.ParkingAdvert");
            }
            this.sellClickSubject.a_(new Object());
            return;
        }
        c4745a = this.blockClickSubject;
        view = view.getTag();
        if (view != null) {
            c4745a.a_((Integer) view);
            return;
        }
        throw new C0724k("null cannot be cast to non-null type kotlin.Int");
    }

    public final void updateItems(List<ParkingAdvert> list) {
        C0700j.m2715b(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }
}
