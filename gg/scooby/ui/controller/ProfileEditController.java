package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import com.google.android.material.snackbar.Snackbar;
import io.card.payment.BuildConfig;
import io.p181b.p197g.C2517a;
import java.util.UUID;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p165d.C2342r;
import ru.gg.scooby.Bus;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.FileUploadManager;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.manager.UserManager.UserUpdatedEvent;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.settings.Settings;
import ru.gg.scooby.ui.changehandler.BottomPanelChangeHandler;
import ru.gg.scooby.ui.controller.panel.OptionClickListener;
import ru.gg.scooby.ui.controller.panel.PhotoActionsPanelController;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.util.PhoneUtils;
import ru.skooby.R;

/* compiled from: ProfileEditController.kt */
public final class ProfileEditController extends BaseController implements OptionClickListener {
    @BindView
    public AvatarImageView imageAvatar;
    @BindView
    public TextView textName;
    @BindView
    public TextView textPhone;
    @BindView
    public TextView textTitle;

    /* compiled from: ProfileEditController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.ProfileEditController$a */
    static final class C4647a extends C3038k implements C0690b<C2342r<Void>, C0727n> {
        final /* synthetic */ ProfileEditController this$0;

        C4647a(ProfileEditController profileEditController) {
            this.this$0 = profileEditController;
            super(1);
        }

        /* renamed from: a */
        public final void m20545a(C2342r<Void> c2342r) {
            C0700j.m2715b(c2342r, "it");
            FileUploadManager.INSTANCE.deleteTempFile();
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            if (c2342r.m9826c()) {
                c2342r = Settings.INSTANCE;
                Object uuid = UUID.randomUUID().toString();
                C0700j.m2711a(uuid, "UUID.randomUUID().toString()");
                c2342r.setAvatarSignature(uuid);
                UserManager.INSTANCE.refreshUserFromBackend();
                View view = this.this$0.getView();
                if (view == null) {
                    C0700j.m2709a();
                }
                Snackbar.m15345a(view, (int) R.string.changes_saved, -1).mo1269f();
                return;
            }
            View view2 = this.this$0.getView();
            if (view2 == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view2, ValidationCode.Companion.getCodeByResponse(c2342r).getErrorMessage(), -1).mo1269f();
        }
    }

    /* compiled from: ProfileEditController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.ProfileEditController$b */
    static final class C4648b extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ ProfileEditController this$0;

        C4648b(ProfileEditController profileEditController) {
            this.this$0 = profileEditController;
            super(1);
        }

        /* renamed from: a */
        public final void m20547a(Throwable th) {
            C0700j.m2715b(th, "it");
            FileUploadManager.INSTANCE.deleteTempFile();
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            View view = this.this$0.getView();
            if (view == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), -1).mo1269f();
        }
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

    public final TextView getTextTitle() {
        TextView textView = this.textTitle;
        if (textView == null) {
            C0700j.m2716b("textTitle");
        }
        return textView;
    }

    public final void setTextTitle(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textTitle = textView;
    }

    public final TextView getTextName() {
        TextView textView = this.textName;
        if (textView == null) {
            C0700j.m2716b("textName");
        }
        return textView;
    }

    public final void setTextName(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textName = textView;
    }

    public final TextView getTextPhone() {
        TextView textView = this.textPhone;
        if (textView == null) {
            C0700j.m2716b("textPhone");
        }
        return textView;
    }

    public final void setTextPhone(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textPhone = textView;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_profile_edit, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…e_edit, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        String str = null;
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.profile_status_bar), false, 8, null));
        view = this.textTitle;
        if (view == null) {
            C0700j.m2716b("textTitle");
        }
        view.setText(R.string.profile_edit);
        view = this.imageAvatar;
        if (view == null) {
            C0700j.m2716b("imageAvatar");
        }
        User user = UserManager.INSTANCE.getUser();
        if (user != null) {
            Profile profile = user.getProfile();
            if (profile != null) {
                str = profile.getAvatarUrl();
            }
        }
        view.setTargetImageUrl(str);
    }

    @OnClick
    public final void onBackClick() {
        getRouter().m3169l();
    }

    @OnClick
    public final void onAvatarClick() {
        C0818i router = getRouter();
        PhotoActionsPanelController photoActionsPanelController = new PhotoActionsPanelController();
        photoActionsPanelController.setTargetController(this);
        router.m3151b(C0820k.m3183a((C0809d) photoActionsPanelController).m3184a((C0814e) new BottomPanelChangeHandler()).m3189b(new BottomPanelChangeHandler()));
    }

    @OnClick
    public final void onChangeNameClick() {
        String name;
        C0818i router = getRouter();
        User user = UserManager.INSTANCE.getUser();
        if (user != null) {
            Profile profile = user.getProfile();
            if (profile != null) {
                name = profile.getName();
                if (name != null) {
                    router.m3151b(C0820k.m3183a((C0809d) new ProfileNameController(1, name)).m3189b(new C4409b()).m3184a((C0814e) new C4409b()));
                }
            }
        }
        name = BuildConfig.FLAVOR;
        router.m3151b(C0820k.m3183a((C0809d) new ProfileNameController(1, name)).m3189b(new C4409b()).m3184a((C0814e) new C4409b()));
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        view = UserManager.INSTANCE.getUser();
        if (view != null) {
            view = view.getProfile();
            if (view != null) {
                TextView textView = this.textName;
                if (textView == null) {
                    C0700j.m2716b("textName");
                }
                textView.setText(view.getName());
                textView = this.textPhone;
                if (textView == null) {
                    C0700j.m2716b("textPhone");
                }
                textView.setText(PhoneUtils.INSTANCE.formatPhoneNumber(view.getPhoneNumber()));
            }
        }
        Bus.INSTANCE.register(this);
    }

    protected void onDetach(View view) {
        C0700j.m2715b(view, "view");
        Bus.INSTANCE.unregister(this);
        super.onDetach(view);
    }

    public void onOptionClick(int i) {
        if (i == R.id.text_choose_from_gallery) {
            chooseFromGallery();
        } else if (i == R.id.text_remove_current) {
            removeCurrent();
        } else if (i == R.id.text_take_photo) {
            takePhoto();
        }
    }

    public final void removeCurrent() {
        uploadImage(null);
    }

    public final void takePhoto() {
        FileUploadManager.INSTANCE.fromCamera(this);
    }

    public final void chooseFromGallery() {
        FileUploadManager.INSTANCE.fromGallery(this);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            i = i == 2 ? FileUploadManager.INSTANCE.getTempFileUri() : intent != null ? intent.getData() : 0;
            if (i != 0) {
                uploadImage(i);
                return;
            }
            return;
        }
        FileUploadManager.INSTANCE.deleteTempFile();
    }

    public static /* synthetic */ void uploadImage$default(ProfileEditController profileEditController, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        profileEditController.uploadImage(uri);
    }

    public final void uploadImage(Uri uri) {
        ControllerExKt.showProgress$default(this, null, 1, null);
        C2517a.m10349a(ApiManager.INSTANCE.uploadFile(UserManager.INSTANCE.getPhone(), uri), (C0690b) new C4648b(this), null, (C0690b) new C4647a(this), 2, null);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C0700j.m2715b(strArr, "permissions");
        C0700j.m2715b(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 2) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            ControllerExKt.showPermissionDeniedSnackbar(this, R.string.please_provide_camera);
        } else {
            FileUploadManager.INSTANCE.sendCameraIntent(this);
        }
    }

    public final void onEventMainThread(UserUpdatedEvent userUpdatedEvent) {
        String avatarUrl;
        C0700j.m2715b(userUpdatedEvent, "event");
        userUpdatedEvent = this.imageAvatar;
        if (userUpdatedEvent == null) {
            C0700j.m2716b("imageAvatar");
        }
        User user = UserManager.INSTANCE.getUser();
        if (user != null) {
            Profile profile = user.getProfile();
            if (profile != null) {
                avatarUrl = profile.getAvatarUrl();
                userUpdatedEvent.setTargetImageUrl(avatarUrl);
            }
        }
        avatarUrl = null;
        userUpdatedEvent.setTargetImageUrl(avatarUrl);
    }
}
