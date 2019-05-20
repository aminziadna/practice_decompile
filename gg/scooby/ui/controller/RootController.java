package ru.gg.scooby.ui.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0819j;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import p042b.p043a.C4774r;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.Bus;
import ru.gg.scooby.manager.ScreenFlowController;
import ru.gg.scooby.network.ErrorInterceptor.ReAuthRequiredEvent;
import ru.gg.scooby.network.ErrorInterceptor.UpdateRequiredEvent;
import ru.skooby.R;

/* compiled from: RootController.kt */
public final class RootController extends BaseController {
    private C0818i childRouter;
    @BindView
    public ViewGroup container;

    public final ViewGroup getContainer() {
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            C0700j.m2716b("container");
        }
        return viewGroup;
    }

    public final void setContainer(ViewGroup viewGroup) {
        C0700j.m2715b(viewGroup, "<set-?>");
        this.container = viewGroup;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_root, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…r_root, container, false)");
        return inflate;
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        Bus.INSTANCE.register(this);
    }

    protected void onDetach(View view) {
        C0700j.m2715b(view, "view");
        super.onDetach(view);
        Bus.INSTANCE.unregister(this);
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        view = this.container;
        if (view == null) {
            C0700j.m2716b("container");
        }
        Object childRouter = getChildRouter(view);
        C0700j.m2711a(childRouter, "getChildRouter(container)");
        this.childRouter = childRouter;
        view = this.childRouter;
        if (view == null) {
            C0700j.m2716b("childRouter");
        }
        if (view.m3173p() == null) {
            view = this.childRouter;
            if (view == null) {
                C0700j.m2716b("childRouter");
            }
            Object a = C0820k.m3183a(ScreenFlowController.INSTANCE.getNextScreenController());
            C0700j.m2711a(a, "RouterTransaction.with(S…etNextScreenController())");
            C0819j.m3181a(view, a);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C0700j.m2715b(strArr, "permissions");
        C0700j.m2715b(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        C0818i c0818i = this.childRouter;
        if (c0818i == null) {
            C0700j.m2716b("childRouter");
        }
        if (c0818i.m3171n() > 0) {
            c0818i = this.childRouter;
            if (c0818i == null) {
                C0700j.m2716b("childRouter");
            }
            C0818i c0818i2 = this.childRouter;
            if (c0818i2 == null) {
                C0700j.m2716b("childRouter");
            }
            Object o = c0818i2.m3172o();
            C0700j.m2711a(o, "childRouter.backstack");
            o = ((C0820k) C4774r.m22245e(o)).m3188b();
            C0700j.m2711a(o, "childRouter.backstack.last().controller()");
            c0818i.m3139a(o.getInstanceId(), i, strArr, iArr);
        }
    }

    public final void onEventMainThread(ReAuthRequiredEvent reAuthRequiredEvent) {
        C0700j.m2715b(reAuthRequiredEvent, "event");
        reAuthRequiredEvent = this.childRouter;
        if (reAuthRequiredEvent == null) {
            C0700j.m2716b("childRouter");
        }
        if (reAuthRequiredEvent.m3172o().size() > null) {
            reAuthRequiredEvent = this.childRouter;
            if (reAuthRequiredEvent == null) {
                C0700j.m2716b("childRouter");
            }
            Object o = reAuthRequiredEvent.m3172o();
            C0700j.m2711a(o, "childRouter.backstack");
            if ((((C0820k) C4774r.m22245e(o)).m3188b() instanceof PinController) != null) {
                return;
            }
        }
        reAuthRequiredEvent = this.childRouter;
        if (reAuthRequiredEvent == null) {
            C0700j.m2716b("childRouter");
        }
        Object b = C0820k.m3183a(ScreenFlowController.INSTANCE.getNextScreenController()).m3184a((C0814e) new C4409b()).m3189b(new C4409b());
        C0700j.m2711a(b, "RouterTransaction.with(S…orizontalChangeHandler())");
        C0819j.m3181a(reAuthRequiredEvent, b);
    }

    public final void onEventMainThread(UpdateRequiredEvent updateRequiredEvent) {
        C0700j.m2715b(updateRequiredEvent, "event");
        updateRequiredEvent = this.childRouter;
        if (updateRequiredEvent == null) {
            C0700j.m2716b("childRouter");
        }
        Object b = C0820k.m3183a((C0809d) new ForceUpdateController()).m3184a((C0814e) new C4409b()).m3189b(new C4409b());
        C0700j.m2711a(b, "RouterTransaction.with(F…orizontalChangeHandler())");
        C0819j.m3181a(updateRequiredEvent, b);
    }
}
