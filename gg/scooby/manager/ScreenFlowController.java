package ru.gg.scooby.manager;

import com.bluelinelabs.conductor.C0809d;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.settings.DeviceSettings;
import ru.gg.scooby.ui.controller.CarController;
import ru.gg.scooby.ui.controller.MapController;
import ru.gg.scooby.ui.controller.OnboardingController;
import ru.gg.scooby.ui.controller.PhoneInputController;
import ru.gg.scooby.ui.controller.PinController;
import ru.gg.scooby.ui.controller.ProfileNameController;

/* compiled from: ScreenFlowController.kt */
public final class ScreenFlowController {
    public static final ScreenFlowController INSTANCE = new ScreenFlowController();

    private ScreenFlowController() {
    }

    public final C0809d getNextScreenController() {
        if (!DeviceSettings.INSTANCE.getOnboardingShown()) {
            return new OnboardingController();
        }
        if (UserManager.INSTANCE.getUser() == null) {
            return new PhoneInputController();
        }
        if (!UserManager.INSTANCE.getPinSet()) {
            return new PinController(0);
        }
        int i = 1;
        if (!UserManager.INSTANCE.getLoggedIn()) {
            return new PinController(1);
        }
        String name;
        CharSequence charSequence;
        User user = UserManager.INSTANCE.getUser();
        if (user != null) {
            Profile profile = user.getProfile();
            if (profile != null) {
                name = profile.getName();
                charSequence = name;
                if (charSequence != null) {
                    if (charSequence.length() == 0) {
                        i = 0;
                    }
                }
                if (i == 0 && UserManager.INSTANCE.getAskToSetName()) {
                    return new ProfileNameController(0, null, 2, null);
                }
                if (UserManager.INSTANCE.getCars().isEmpty() || !UserManager.INSTANCE.getAskToSetCar()) {
                    return new MapController();
                }
                return new CarController(2, null, 2, null);
            }
        }
        name = null;
        charSequence = name;
        if (charSequence != null) {
            if (charSequence.length() == 0) {
                i = 0;
            }
        }
        if (i == 0) {
        }
        if (UserManager.INSTANCE.getCars().isEmpty()) {
        }
        return new MapController();
    }
}
