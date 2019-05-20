package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.model.AdvStatus;
import ru.gg.scooby.model.DealCompleteStatus;
import ru.gg.scooby.model.Parking;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.ParkingStatus;
import ru.skooby.R;

/* compiled from: TripCanceledController.kt */
public final class TripCanceledController extends BaseController {
    public static final String ARG_PARKING = "ARG_PARKING";
    public static final String ARG_TYPE = "ARG_TYPE";
    public static final Companion Companion = new Companion();
    public ParkingStatus parking;
    @BindView
    public TextView textCancelDescription;
    @BindView
    public TextView textCancelTitle;

    /* compiled from: TripCanceledController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public TripCanceledController() {
        this(0, null, 3, null);
    }

    public TripCanceledController(int i, ParkingStatus parkingStatus) {
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_TYPE", i);
        bundle.putParcelable(ARG_PARKING, parkingStatus);
        super(bundle);
    }

    public /* synthetic */ TripCanceledController(int i, ParkingStatus parkingStatus, int i2, C0697g c0697g) {
        if ((i2 & 1) != null) {
            i = -1;
        }
        if ((i2 & 2) != 0) {
            parkingStatus = null;
        }
        this(i, parkingStatus);
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_trip_canceled, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…nceled, container, false)");
        return inflate;
    }

    public final TextView getTextCancelTitle() {
        TextView textView = this.textCancelTitle;
        if (textView == null) {
            C0700j.m2716b("textCancelTitle");
        }
        return textView;
    }

    public final void setTextCancelTitle(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textCancelTitle = textView;
    }

    public final TextView getTextCancelDescription() {
        TextView textView = this.textCancelDescription;
        if (textView == null) {
            C0700j.m2716b("textCancelDescription");
        }
        return textView;
    }

    public final void setTextCancelDescription(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textCancelDescription = textView;
    }

    public final ParkingStatus getParking() {
        ParkingStatus parkingStatus = this.parking;
        if (parkingStatus == null) {
            C0700j.m2716b("parking");
        }
        return parkingStatus;
    }

    public final void setParking(ParkingStatus parkingStatus) {
        C0700j.m2715b(parkingStatus, "<set-?>");
        this.parking = parkingStatus;
    }

    public void onViewBound(View view) {
        boolean isFree;
        Activity activity;
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Object parcelable = getArgs().getParcelable(ARG_PARKING);
        C0700j.m2711a(parcelable, "args.getParcelable(ARG_PARKING)");
        this.parking = (ParkingStatus) parcelable;
        ParkingAdvert lastKnownParking = ParkingManager.INSTANCE.getLastKnownParking();
        if (lastKnownParking != null) {
            Parking parking = lastKnownParking.getParking();
            if (parking != null) {
                isFree = parking.isFree();
                activity = getActivity();
                addLifecycleListener(new StatusBarColorHelper(activity == null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.red), false));
                if (C0700j.m2713a(getArgs().get("ARG_TYPE"), Integer.valueOf(0)) == null) {
                    view = this.parking;
                    if (view == null) {
                        C0700j.m2716b("parking");
                    }
                    if (view.getStatusEnum() == AdvStatus.ADV_DISPUTE) {
                        view = this.parking;
                        if (view == null) {
                            C0700j.m2716b("parking");
                        }
                        if (view.getDealCompleteBuyer() != DealCompleteStatus.COMPLETED) {
                            view = this.textCancelTitle;
                            if (view == null) {
                                C0700j.m2716b("textCancelTitle");
                            }
                            view.setText(R.string.unsuccess_are_you_sure_you_parked);
                            view = this.textCancelDescription;
                            if (view == null) {
                                C0700j.m2716b("textCancelDescription");
                            }
                            view.setText(R.string.buyer_dispute_seller_canceled);
                        }
                        view = this.textCancelTitle;
                        if (view == null) {
                            C0700j.m2716b("textCancelTitle");
                        }
                        view.setText(R.string.unsuccess_you_canceled);
                        view = this.textCancelDescription;
                        if (view == null) {
                            C0700j.m2716b("textCancelDescription");
                        }
                        view.setText(R.string.buyer_buyer_canceled_trip_text);
                        return;
                    } else if (isFree) {
                        view = this.textCancelDescription;
                        if (view == null) {
                            C0700j.m2716b("textCancelDescription");
                        }
                        view.setText(R.string.buyer_seller_canceled_trip_money_refund);
                    } else {
                        view = this.textCancelDescription;
                        if (view == null) {
                            C0700j.m2716b("textCancelDescription");
                        }
                        view.setText(R.string.buyer_seller_canceled_trip);
                    }
                }
                view = this.parking;
                if (view == null) {
                    C0700j.m2716b("parking");
                }
                if (view.getStatusEnum() != AdvStatus.ADV_DISPUTE) {
                    view = this.parking;
                    if (view == null) {
                        C0700j.m2716b("parking");
                    }
                    if (view.getDealCompleteBuyer() != DealCompleteStatus.COMPLETED) {
                        view = this.textCancelTitle;
                        if (view == null) {
                            C0700j.m2716b("textCancelTitle");
                        }
                        view.setText(R.string.unsuccess_you_canceled);
                        view = this.textCancelDescription;
                        if (view == null) {
                            C0700j.m2716b("textCancelDescription");
                        }
                        view.setText(R.string.seller_dispute_buyer_ok);
                        return;
                    }
                    view = this.textCancelTitle;
                    if (view == null) {
                        C0700j.m2716b("textCancelTitle");
                    }
                    view.setText(R.string.unsuccess_parking_canceled_by_buyer);
                    view = this.textCancelDescription;
                    if (view == null) {
                        C0700j.m2716b("textCancelDescription");
                    }
                    view.setText(R.string.seller_dispute_buyer_canceled);
                    return;
                }
                view = this.textCancelTitle;
                if (view == null) {
                    C0700j.m2716b("textCancelTitle");
                }
                view.setText(R.string.unsuccess_parking_canceled);
                view = this.textCancelDescription;
                if (view == null) {
                    C0700j.m2716b("textCancelDescription");
                }
                view.setText(R.string.buyer_canceled_trip);
                return;
            }
        }
        isFree = true;
        activity = getActivity();
        if (activity == null) {
        }
        addLifecycleListener(new StatusBarColorHelper(activity == null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.red), false));
        if (C0700j.m2713a(getArgs().get("ARG_TYPE"), Integer.valueOf(0)) == null) {
            view = this.parking;
            if (view == null) {
                C0700j.m2716b("parking");
            }
            if (view.getStatusEnum() != AdvStatus.ADV_DISPUTE) {
                view = this.textCancelTitle;
                if (view == null) {
                    C0700j.m2716b("textCancelTitle");
                }
                view.setText(R.string.unsuccess_parking_canceled);
                view = this.textCancelDescription;
                if (view == null) {
                    C0700j.m2716b("textCancelDescription");
                }
                view.setText(R.string.buyer_canceled_trip);
                return;
            }
            view = this.parking;
            if (view == null) {
                C0700j.m2716b("parking");
            }
            if (view.getDealCompleteBuyer() != DealCompleteStatus.COMPLETED) {
                view = this.textCancelTitle;
                if (view == null) {
                    C0700j.m2716b("textCancelTitle");
                }
                view.setText(R.string.unsuccess_parking_canceled_by_buyer);
                view = this.textCancelDescription;
                if (view == null) {
                    C0700j.m2716b("textCancelDescription");
                }
                view.setText(R.string.seller_dispute_buyer_canceled);
                return;
            }
            view = this.textCancelTitle;
            if (view == null) {
                C0700j.m2716b("textCancelTitle");
            }
            view.setText(R.string.unsuccess_you_canceled);
            view = this.textCancelDescription;
            if (view == null) {
                C0700j.m2716b("textCancelDescription");
            }
            view.setText(R.string.seller_dispute_buyer_ok);
            return;
        }
        view = this.parking;
        if (view == null) {
            C0700j.m2716b("parking");
        }
        if (view.getStatusEnum() == AdvStatus.ADV_DISPUTE) {
            view = this.parking;
            if (view == null) {
                C0700j.m2716b("parking");
            }
            if (view.getDealCompleteBuyer() != DealCompleteStatus.COMPLETED) {
                view = this.textCancelTitle;
                if (view == null) {
                    C0700j.m2716b("textCancelTitle");
                }
                view.setText(R.string.unsuccess_you_canceled);
                view = this.textCancelDescription;
                if (view == null) {
                    C0700j.m2716b("textCancelDescription");
                }
                view.setText(R.string.buyer_buyer_canceled_trip_text);
                return;
            }
            view = this.textCancelTitle;
            if (view == null) {
                C0700j.m2716b("textCancelTitle");
            }
            view.setText(R.string.unsuccess_are_you_sure_you_parked);
            view = this.textCancelDescription;
            if (view == null) {
                C0700j.m2716b("textCancelDescription");
            }
            view.setText(R.string.buyer_dispute_seller_canceled);
        } else if (isFree) {
            view = this.textCancelDescription;
            if (view == null) {
                C0700j.m2716b("textCancelDescription");
            }
            view.setText(R.string.buyer_seller_canceled_trip_money_refund);
        } else {
            view = this.textCancelDescription;
            if (view == null) {
                C0700j.m2716b("textCancelDescription");
            }
            view.setText(R.string.buyer_seller_canceled_trip);
        }
    }

    @OnClick
    public final void onFinishClick() {
        getRouter().m3169l();
    }
}
