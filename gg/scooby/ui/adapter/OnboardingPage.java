package ru.gg.scooby.ui.adapter;

/* compiled from: OnboardingPage.kt */
public enum OnboardingPage {
    ;
    
    public static final Companion Companion = null;
    private final int description;
    private final int image;
    private final int title;

    /* compiled from: OnboardingPage.kt */
    public static final class Companion {
        private Companion() {
        }

        public final OnboardingPage byPosition(int i) {
            switch (i) {
                case 0:
                    return OnboardingPage.Skooby;
                case 1:
                    return OnboardingPage.Park;
                default:
                    return OnboardingPage.Earn;
            }
        }
    }

    protected OnboardingPage(int i, int i2, int i3) {
        this.image = i;
        this.title = i2;
        this.description = i3;
    }

    public final int getDescription() {
        return this.description;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getTitle() {
        return this.title;
    }

    static {
        Companion = new Companion();
    }
}
