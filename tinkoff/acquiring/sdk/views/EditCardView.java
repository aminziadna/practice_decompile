package ru.tinkoff.acquiring.sdk.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import io.card.payment.BuildConfig;
import ru.tinkoff.acquiring.sdk.ax.C2738d;
import ru.tinkoff.acquiring.sdk.ax.C2739e;
import ru.tinkoff.acquiring.sdk.ax.C2744j;
import ru.tinkoff.acquiring.sdk.p222e.C2763b;

public class EditCardView extends ViewGroup {
    public static final Property<EditCardView, Float> CARD_SYSTEM_LOGO_ANIMATION_FACTOR = new Property<EditCardView, Float>(Float.class, "card_view_logo_animation_factor") {
        public Float get(EditCardView editCardView) {
            return Float.valueOf(editCardView.getCardSystemLogoAnimationFactor());
        }

        public void set(EditCardView editCardView, Float f) {
            editCardView.setCardSystemLogoAnimationFactor(f.floatValue());
        }
    };
    private static final String DATE_MASK = "••/••";
    private static final int FLAG_CARD_SYSTEM_LOGO = 1;
    private static final int FLAG_CHANGE_MODE_BUTTON = 8;
    private static final int FLAG_FULL_CARD_NUMBER = 2;
    private static final int FLAG_ONLY_NUMBER_STATE = 16;
    private static final int FLAG_RECURRENT_MODE = 64;
    private static final int FLAG_SAVED_CARD_STATE = 32;
    private static final int FLAG_SCAN_CARD_BUTTON = 4;
    private static final int MIN_CARD_NUMBER_LENGTH = 4;
    private static Actions NO_ACTIONS = new Actions() {
        public void onPressScanCard(EditCardView editCardView) {
        }

        public void onUpdate(EditCardView editCardView) {
        }
    };
    public static final Property<Paint, Integer> PAINT_ALPHA = new Property<Paint, Integer>(Integer.class, "paint_alpha") {
        public Integer get(Paint paint) {
            return Integer.valueOf(paint.getAlpha());
        }

        public void set(Paint paint, Integer num) {
            paint.setAlpha(num.intValue());
        }
    };
    private Actions actions = NO_ACTIONS;
    private SimpleButton btnChangeMode;
    private SimpleButton btnScanCard;
    private boolean buttonsAvailable = true;
    private CardFormatter cardFormatter;
    private int cardLogoMargin;
    private String cardNumberHint;
    private CardSystemIconsHolder cardSystemIconsHolder;
    private Bitmap cardSystemLogo;
    private float cardSystemLogoAnimationFactor = 1.0f;
    private Paint cardSystemLogoPaint;
    private int cardTextMargin;
    private C2763b cardValidator;
    private String cvcHint;
    private String dateHint;
    private CardNumberEditText etCardNumber;
    private EditText etCvc;
    private EditText etDate;
    private int flags;
    private boolean forbidTextWatcher = false;
    private int nextResId = 0;
    private Paint paint;
    private Animator pendingAnimation;
    private int scanResId = 0;
    private int textColor;
    private Runnable update;

    /* renamed from: ru.tinkoff.acquiring.sdk.views.EditCardView$1 */
    class C27931 implements Runnable {
        C27931() {
        }

        public void run() {
            Object obj;
            CardNumberEditText access$100;
            int i;
            int access$700;
            EditText access$800;
            int access$7002;
            if (!(C2763b.m11375a(EditCardView.this.cardFormatter.getNormalizedNumber(EditCardView.this.etCardNumber.getText().toString(), " ")) || EditCardView.this.check(32))) {
                if (!EditCardView.this.check(64)) {
                    obj = null;
                    if (obj == null && EditCardView.this.check(8)) {
                        EditCardView.this.hideChangeModeButton();
                    }
                    if (!(obj == null || EditCardView.this.cardFormatter.isLimited() || !EditCardView.this.isCardNumberFocused() || EditCardView.this.check(32) || EditCardView.this.check(64))) {
                        EditCardView.this.showChangeModeButton();
                    }
                    access$100 = EditCardView.this.etCardNumber;
                    i = -65536;
                    access$700 = (EditCardView.this.cardFormatter.isNeedToCheck(EditCardView.this.etCardNumber.length()) || obj != null) ? EditCardView.this.textColor : -65536;
                    access$100.setTextColor(access$700);
                    access$800 = EditCardView.this.etDate;
                    access$7002 = (EditCardView.this.etDate.length() == 5 || C2763b.m11377c(EditCardView.this.etDate.getText().toString()) || EditCardView.this.check(32) || EditCardView.this.check(64)) ? EditCardView.this.textColor : -65536;
                    access$800.setTextColor(access$7002);
                    access$800 = EditCardView.this.etCvc;
                    if (EditCardView.this.etCvc.length() == 3 || C2763b.m11376b(EditCardView.this.etCvc.getText().toString())) {
                        i = EditCardView.this.textColor;
                    }
                    access$800.setTextColor(i);
                    EditCardView.this.actions.onUpdate(EditCardView.this);
                }
            }
            obj = 1;
            EditCardView.this.hideChangeModeButton();
            EditCardView.this.showChangeModeButton();
            access$100 = EditCardView.this.etCardNumber;
            i = -65536;
            if (EditCardView.this.cardFormatter.isNeedToCheck(EditCardView.this.etCardNumber.length())) {
            }
            access$100.setTextColor(access$700);
            access$800 = EditCardView.this.etDate;
            if (EditCardView.this.etDate.length() == 5) {
            }
            access$800.setTextColor(access$7002);
            access$800 = EditCardView.this.etCvc;
            if (EditCardView.this.etCvc.length() == 3) {
            }
            i = EditCardView.this.textColor;
            access$800.setTextColor(i);
            EditCardView.this.actions.onUpdate(EditCardView.this);
        }
    }

    /* renamed from: ru.tinkoff.acquiring.sdk.views.EditCardView$2 */
    class C27942 implements TextWatcher {
        int[] sel = new int[2];

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        C27942() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onTextChanged(java.lang.CharSequence r8, int r9, int r10, int r11) {
            /*
            r7 = this;
            r8 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r8 = r8.forbidTextWatcher;
            if (r8 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r8 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r8 = r8.etCardNumber;
            r8 = r8.getText();
            r8 = r8.toString();
            r9 = android.text.TextUtils.isEmpty(r8);
            r0 = 4;
            r1 = 0;
            r2 = 1;
            if (r9 != 0) goto L_0x0109;
        L_0x0020:
            r9 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r9 = r9.etCardNumber;
            r9.removeTextChangedListener(r7);
            r9 = r8.charAt(r1);
            r3 = 50;
            r4 = 2;
            if (r9 == r3) goto L_0x0053;
        L_0x0032:
            r3 = 52;
            if (r9 == r3) goto L_0x0053;
        L_0x0036:
            r3 = 53;
            if (r9 != r3) goto L_0x003b;
        L_0x003a:
            goto L_0x0053;
        L_0x003b:
            r3 = 54;
            if (r9 != r3) goto L_0x0049;
        L_0x003f:
            r9 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r9 = r9.cardFormatter;
            r9.setType(r4);
            goto L_0x005c;
        L_0x0049:
            r9 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r9 = r9.cardFormatter;
            r9.setType(r1);
            goto L_0x005c;
        L_0x0053:
            r9 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r9 = r9.cardFormatter;
            r9.setType(r2);
        L_0x005c:
            r9 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r9 = r9.etCardNumber;
            r3 = new android.text.InputFilter[r2];
            r5 = new android.text.InputFilter$LengthFilter;
            r6 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r6 = r6.cardFormatter;
            r6 = r6.getMaxLength();
            r5.<init>(r6);
            r3[r1] = r5;
            r9.setFilters(r3);
            r9 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r9 = r9.cardFormatter;
            r3 = " ";
            r9 = r9.format(r8, r3);
            if (r10 <= r11) goto L_0x0088;
        L_0x0086:
            r10 = 1;
            goto L_0x0089;
        L_0x0088:
            r10 = 0;
        L_0x0089:
            r7.populateCardNumber(r9, r10);
            r9 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r9 = r9.etCardNumber;
            r9.addTextChangedListener(r7);
            r9 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r9 = r9.cardFormatter;
            r10 = " ";
            r9 = r9.getNormalizedNumber(r8, r10);
            r10 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r10 = r10.pendingAnimation;
            if (r10 != 0) goto L_0x0109;
        L_0x00a9:
            r10 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r10 = r10.check(r4);
            r11 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r11 = r11.cardFormatter;
            r11 = r11.isLimited();
            if (r10 == 0) goto L_0x0109;
        L_0x00bb:
            r10 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r3 = 32;
            r10 = r10.check(r3);
            if (r11 == 0) goto L_0x00d0;
        L_0x00c5:
            r11 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r11.cardValidator;
            r11 = ru.tinkoff.acquiring.sdk.p222e.C2763b.m11375a(r9);
            if (r11 != 0) goto L_0x00d2;
        L_0x00d0:
            if (r10 == 0) goto L_0x00e1;
        L_0x00d2:
            r10 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r11 = 16;
            r10 = r10.check(r11);
            if (r10 != 0) goto L_0x00e1;
        L_0x00dc:
            r10 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r10.showCvcAndDate();
        L_0x00e1:
            r10 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r10 = r10.check(r0);
            r11 = 15;
            if (r10 == 0) goto L_0x00f6;
        L_0x00eb:
            r10 = r9.length();
            if (r10 <= r11) goto L_0x00f6;
        L_0x00f1:
            r10 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r10.hideScanButton();
        L_0x00f6:
            r10 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r10 = r10.check(r0);
            if (r10 != 0) goto L_0x0109;
        L_0x00fe:
            r9 = r9.length();
            if (r9 > r11) goto L_0x0109;
        L_0x0104:
            r9 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r9.showScanButton();
        L_0x0109:
            if (r8 == 0) goto L_0x0111;
        L_0x010b:
            r8 = r8.length();
            if (r8 >= r0) goto L_0x0112;
        L_0x0111:
            r1 = 1;
        L_0x0112:
            if (r1 == 0) goto L_0x0122;
        L_0x0114:
            r8 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r8 = r8.check(r2);
            if (r8 == 0) goto L_0x0122;
        L_0x011c:
            r8 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r8.hideCardSystemLogo();
            return;
        L_0x0122:
            if (r1 != 0) goto L_0x0132;
        L_0x0124:
            r8 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r8 = r8.check(r2);
            if (r8 != 0) goto L_0x0132;
        L_0x012c:
            r8 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r8.showCardSystemLogo();
            return;
        L_0x0132:
            r8 = ru.tinkoff.acquiring.sdk.views.EditCardView.this;
            r8 = r8.update;
            r8.run();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.acquiring.sdk.views.EditCardView.2.onTextChanged(java.lang.CharSequence, int, int, int):void");
        }

        private void populateCardNumber(String str, boolean z) {
            this.sel[0] = EditCardView.this.etCardNumber.getSelectionStart();
            this.sel[1] = EditCardView.this.etCardNumber.getSelectionEnd();
            int countMatchesBeforeIndex = (countMatchesBeforeIndex(str, " ", this.sel[0]) - countMatchesBeforeIndex(EditCardView.this.etCardNumber.getText().toString(), " ", this.sel[0])) + 0;
            EditCardView.this.etCardNumber.setText(str);
            EditCardView.this.etCardNumber.setSelection(Math.min(EditCardView.this.etCardNumber.length(), Math.max(this.sel[0] + countMatchesBeforeIndex, 0)));
        }

        public int countMatchesBeforeIndex(String str, String str2, int i) {
            int i2 = 0;
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    int i3 = 0;
                    while (true) {
                        i2 = str.indexOf(str2, i2);
                        if (i2 == -1 || i2 >= i) {
                            return i3;
                        }
                        i3++;
                        i2 += str2.length();
                    }
                    return i3;
                }
            }
            return 0;
        }
    }

    /* renamed from: ru.tinkoff.acquiring.sdk.views.EditCardView$3 */
    class C27953 implements OnTouchListener {
        C27953() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == null && EditCardView.this.check(2) == null) {
                return true;
            }
            if (motionEvent.getAction() == 1 && EditCardView.this.pendingAnimation == null && EditCardView.this.check(2) == null && EditCardView.this.check(32) == null) {
                EditCardView.this.hideCvcAndDate();
            }
            return null;
        }
    }

    /* renamed from: ru.tinkoff.acquiring.sdk.views.EditCardView$4 */
    class C27964 implements OnFocusChangeListener {
        C27964() {
        }

        public void onFocusChange(View view, boolean z) {
            if (z && EditCardView.this.pendingAnimation == null && EditCardView.this.check(true) == null && EditCardView.this.check(true) == null) {
                EditCardView.this.hideCvcAndDate();
            }
        }
    }

    /* renamed from: ru.tinkoff.acquiring.sdk.views.EditCardView$5 */
    class C27975 implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        C27975() {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (EditCardView.this.forbidTextWatcher == 0 && EditCardView.this.check(32) == 0) {
                EditCardView.this.etDate.removeTextChangedListener(this);
                i2 = charSequence.toString().replace("/", BuildConfig.FLAVOR);
                if (i3 != 0 && charSequence.length() > 1) {
                    charSequence = new StringBuilder();
                    charSequence.append(i2.substring(0, 2));
                    charSequence.append("/");
                    charSequence.append(i2.substring(2));
                    charSequence = charSequence.toString();
                    EditCardView.this.etDate.setText(charSequence);
                    i2 = EditCardView.this.etDate;
                    i = (i + i3) + 1;
                    if (i > charSequence.length()) {
                        i = charSequence.length();
                    }
                    i2.setSelection(i);
                } else if (i == 2) {
                    EditCardView.this.etDate.setText(i2.substring(0, 1));
                    EditCardView.this.etDate.setSelection(EditCardView.this.etDate.length());
                } else {
                    EditCardView.this.etDate.setSelection(i + i3);
                }
                EditCardView.this.update.run();
                EditCardView.this.cardValidator;
                if (C2763b.m11377c(EditCardView.this.etDate.getText().toString()) != null) {
                    EditCardView.this.dispatchFocus();
                }
                EditCardView.this.etDate.addTextChangedListener(this);
            }
        }
    }

    /* renamed from: ru.tinkoff.acquiring.sdk.views.EditCardView$6 */
    class C27986 implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        C27986() {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (EditCardView.this.forbidTextWatcher == null) {
                EditCardView.this.update.run();
            }
        }
    }

    /* renamed from: ru.tinkoff.acquiring.sdk.views.EditCardView$7 */
    class C27997 implements AnimatorUpdateListener {
        C27997() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            EditCardView.this.invalidate();
        }
    }

    /* renamed from: ru.tinkoff.acquiring.sdk.views.EditCardView$8 */
    class C28008 extends AnimatorListenerAdapter {
        C28008() {
        }

        public void onAnimationEnd(Animator animator) {
            EditCardView.this.requestLayout();
            EditCardView.this.invalidate();
        }
    }

    /* renamed from: ru.tinkoff.acquiring.sdk.views.EditCardView$9 */
    class C28019 implements AnimatorUpdateListener {
        C28019() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            EditCardView.this.invalidate();
        }
    }

    public interface Actions {
        void onPressScanCard(EditCardView editCardView);

        void onUpdate(EditCardView editCardView);
    }

    public class CardFormatter {
        public static final int DEFAULT = 1;
        public static final int MAESTRO = 2;
        public static final int UNKNOWN = 0;
        private int[] defaultRangers = new int[]{19};
        private int[] maestroRangers = new int[]{14, 15, 16, 17, 18, 19, 20};
        private int maxLength;
        private int type;
        private int[] unknownRangers = new int[]{2147483644};

        public String format(String str, CharSequence charSequence) {
            return doFormat(getNormalizedNumber(str, charSequence), charSequence);
        }

        public void setType(int i) {
            this.type = i;
            i = 0;
            this.maxLength = 0;
            int[] validationRanges = getValidationRanges();
            int length = validationRanges.length;
            while (i < length) {
                int i2 = validationRanges[i];
                if (i2 > this.maxLength) {
                    this.maxLength = i2;
                }
                i++;
            }
        }

        public boolean isLimited() {
            return this.type == 1;
        }

        public boolean isNeedToCheck(int i) {
            for (int i2 : getValidationRanges()) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public int getMaxLength() {
            return this.maxLength;
        }

        public int[] getValidationRanges() {
            int i = this.type;
            if (i == 1) {
                return this.defaultRangers;
            }
            if (i == 2) {
                return this.maestroRangers;
            }
            return this.unknownRangers;
        }

        private String getNormalizedNumber(String str, CharSequence charSequence) {
            return str.replace(charSequence, BuildConfig.FLAVOR);
        }

        protected String doFormat(String str, CharSequence charSequence) {
            int i = this.type;
            int i2 = 1;
            if (i == 1) {
                char[] toCharArray = str.toCharArray();
                StringBuilder stringBuilder = new StringBuilder(str);
                str = null;
                while (i2 < toCharArray.length) {
                    if (i2 % 4 == 0) {
                        stringBuilder.insert(i2 + str, charSequence);
                        str++;
                    }
                    i2++;
                }
                return stringBuilder.toString().trim();
            } else if (i != 2) {
                return i == 0 ? str : null;
            } else {
                if (str.length() < 8) {
                    return str;
                }
                StringBuilder stringBuilder2 = new StringBuilder(str);
                stringBuilder2.insert(8, charSequence);
                return stringBuilder2.toString().trim();
            }
        }
    }

    @SuppressLint({"AppCompatCustomView"})
    public static class CardNumberEditText extends EditText {
        public static final Property<CardNumberEditText, Float> ANIMATION_FACTOR = new Property<CardNumberEditText, Float>(Float.class, "card_number_animation_factor") {
            public Float get(CardNumberEditText cardNumberEditText) {
                return Float.valueOf(cardNumberEditText.getAnimationFactor());
            }

            public void set(CardNumberEditText cardNumberEditText, Float f) {
                cardNumberEditText.setAnimationFactor(f.floatValue());
            }
        };
        public static final int FULL_MODE = 0;
        public static final int SHORT_MODE = 1;
        private float animationFactor = null;
        private int charsCount = 4;
        private OnFocusChangeListener customOnFocusChangedListener;
        private int mode;

        public boolean bringPointIntoView(int i) {
            return false;
        }

        public CardNumberEditText(Context context) {
            super(context);
        }

        public CardNumberEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void setMode(int i) {
            this.mode = i;
            setAnimationFactor(i == 0 ? 0 : 1065353216);
        }

        protected void onDraw(Canvas canvas) {
            String obj = getText().toString();
            int length = obj.length();
            Paint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            float measureText = paint.measureText(obj.substring(0, Math.max(0, length - this.charsCount)));
            int i = this.mode;
            if (i == 0) {
                canvas.save();
                canvas.translate((-measureText) * this.animationFactor, 0.0f);
                super.onDraw(canvas);
                canvas.restore();
            } else if (i == 1) {
                canvas.drawText(obj, Math.max(0, length - this.charsCount), length, 0.0f, (float) getBaseline(), paint);
            }
        }

        public void setAnimationFactor(float f) {
            this.animationFactor = f;
            invalidate();
        }

        public float getAnimationFactor() {
            return this.animationFactor;
        }

        public int getMode() {
            return this.mode;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.mode == 1) {
                return null;
            }
            return super.onTouchEvent(motionEvent);
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            i = this.customOnFocusChangedListener;
            if (i != 0) {
                i.onFocusChange(this, z);
            }
        }

        public OnFocusChangeListener getCustomOnFocusChangedListener() {
            return this.customOnFocusChangedListener;
        }

        public void setCustomOnFocusChangedListener(OnFocusChangeListener onFocusChangeListener) {
            this.customOnFocusChangedListener = onFocusChangeListener;
        }
    }

    public interface CardSystemIconsHolder {
        Bitmap getCardSystemBitmap(String str);
    }

    private static class DisableCopyPasteActionModeCallback implements Callback {
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        private DisableCopyPasteActionModeCallback() {
        }
    }

    private static class MutableColorSpan extends CharacterStyle implements UpdateAppearance {
        public static final Property<MutableColorSpan, Integer> ALPHA = new Property<MutableColorSpan, Integer>(Integer.class, "span_alpha") {
            public Integer get(MutableColorSpan mutableColorSpan) {
                return Integer.valueOf(mutableColorSpan.getAlpha());
            }

            public void set(MutableColorSpan mutableColorSpan, Integer num) {
                mutableColorSpan.setAlpha(num.intValue());
            }
        };
        private int color;

        public MutableColorSpan(int i) {
            this.color = i;
        }

        public void setAlpha(int i) {
            this.color = (i << 24) | (this.color & 16777215);
        }

        public int getAlpha() {
            return this.color >>> 24;
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.color);
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C28041();
        float animationFactor;
        int cardNumberMode;
        String date;
        int flags;
        int nextResId;
        String pan;
        int scanResId;

        /* renamed from: ru.tinkoff.acquiring.sdk.views.EditCardView$SavedState$1 */
        static class C28041 implements Creator<SavedState> {
            C28041() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.flags = parcel.readInt();
            this.pan = parcel.readString();
            this.date = parcel.readString();
            this.nextResId = parcel.readInt();
            this.scanResId = parcel.readInt();
            this.animationFactor = parcel.readFloat();
            this.cardNumberMode = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.flags);
            parcel.writeString(this.pan);
            parcel.writeString(this.date);
            parcel.writeInt(this.nextResId);
            parcel.writeInt(this.scanResId);
            parcel.writeFloat(this.animationFactor);
            parcel.writeInt(this.cardNumberMode);
        }
    }

    private class SimpleButton {
        private Bitmap bitmap;
        private boolean isVisible = true;
        private Rect rect = new Rect();

        public SimpleButton(Bitmap bitmap) {
            this.bitmap = bitmap;
            if (bitmap != null) {
                layoutIn(bitmap.getWidth() >> 1, bitmap.getHeight() >> 1);
            }
        }

        private boolean handleAction(MotionEvent motionEvent) {
            motionEvent = (int) motionEvent.getX();
            return (motionEvent <= this.rect.left || motionEvent >= this.rect.right) ? null : true;
        }

        protected void layoutIn(int i, int i2) {
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                int width = bitmap.getWidth() >> 1;
                int height = this.bitmap.getHeight() >> 1;
                this.rect.set(i - width, i2 - height, i + width, i2 + height);
                return;
            }
            this.rect.set(i, i2, i, i2);
        }

        public void setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
            layoutIn(this.rect.centerX(), this.rect.centerY());
        }

        protected void drawWithPaint(Canvas canvas, Paint paint) {
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                if (this.isVisible) {
                    canvas.drawBitmap(bitmap, null, this.rect, paint);
                }
            }
        }

        public int getWidth() {
            return this.rect.width();
        }

        public int getHeight() {
            return this.rect.height();
        }

        public boolean isVisible() {
            return this.isVisible;
        }

        public void setVisibility(boolean z) {
            this.isVisible = z;
        }
    }

    public EditCardView(Context context) {
        super(context);
        init(null);
    }

    public EditCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public EditCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    public String getCardNumber() {
        return this.cardFormatter.getNormalizedNumber(this.etCardNumber.getText().toString(), " ");
    }

    public String getCvc() {
        return this.etCvc.getText().toString();
    }

    public String getExpireDate() {
        return this.etDate.getText().toString();
    }

    public boolean isFilledAndCorrect() {
        boolean z = true;
        if (check(64)) {
            return true;
        }
        if (check(32)) {
            return C2763b.m11376b(this.etCvc.getText().toString());
        }
        if (!C2763b.m11375a(getCardNumber())) {
            return false;
        }
        if (!check(16)) {
            if (!C2763b.m11377c(this.etDate.getText().toString()) || !C2763b.m11376b(this.etCvc.getText().toString())) {
                z = false;
            }
        }
        return z;
    }

    private void init(AttributeSet attributeSet) {
        setAddStatesFromChildren(true);
        this.btnChangeMode = new SimpleButton(null);
        this.btnScanCard = new SimpleButton(null);
        this.flags = 0;
        Context context = getContext();
        this.cardValidator = new C2763b();
        if (attributeSet == null) {
            this.etCardNumber = new CardNumberEditText(context);
            this.etDate = new EditText(context);
            this.etCvc = new EditText(context);
        } else {
            this.etCardNumber = new CardNumberEditText(context, attributeSet);
            this.etDate = new EditText(context, attributeSet);
            this.etCvc = new EditText(context, attributeSet);
        }
        this.textColor = this.etCardNumber.getCurrentTextColor();
        applyBehaviour(this.etCardNumber, this.etCvc, this.etDate);
        EditText editText = this.etCvc;
        editText.setInputType(editText.getInputType() | 16);
        this.update = new C27931();
        this.etDate.setGravity(17);
        this.etCvc.setGravity(17);
        this.etCardNumber.setGravity(19);
        addView(this.etCardNumber);
        addView(this.etCvc);
        addView(this.etDate);
        this.etCardNumber.addTextChangedListener(new C27942());
        this.etCardNumber.setOnTouchListener(new C27953());
        this.etCardNumber.setCustomOnFocusChangedListener(new C27964());
        this.etDate.addTextChangedListener(new C27975());
        this.etCvc.addTextChangedListener(new C27986());
        showScanButton();
        setMode(true);
        this.etCardNumber.requestFocus();
        this.etCardNumber.setHint(BuildConfig.FLAVOR);
        this.etDate.setHint(BuildConfig.FLAVOR);
        this.etCvc.setHint(BuildConfig.FLAVOR);
        this.etDate.setFilters(new InputFilter[]{new LengthFilter(5)});
        this.etCvc.setFilters(new InputFilter[]{new LengthFilter(3)});
        this.cardSystemLogoPaint = new Paint(1);
        this.paint = new Paint(1);
        this.cardFormatter = new CardFormatter();
        attributeSet = context.getTheme().obtainStyledAttributes(attributeSet, C2744j.EditCardView, 0, 0);
        this.cardLogoMargin = attributeSet.getDimensionPixelSize(C2744j.EditCardView_cardLogoMargin, getResources().getDimensionPixelSize(C2738d.acq_default_card_logo_margin));
        this.cardTextMargin = attributeSet.getDimensionPixelSize(C2744j.EditCardView_cardTextMargin, getResources().getDimensionPixelSize(C2738d.acq_default_card_text_margin));
        this.cardNumberHint = attributeSet.getString(C2744j.EditCardView_numberHint);
        this.dateHint = attributeSet.getString(C2744j.EditCardView_dateHint);
        this.cvcHint = attributeSet.getString(C2744j.EditCardView_cvcHint);
        this.etCardNumber.setHint(this.cardNumberHint);
        this.etDate.setHint(this.dateHint);
        this.etCvc.setHint(this.cvcHint);
        setBtnScanIcon(attributeSet.getResourceId(C2744j.EditCardView_scanIcon, C2739e.acq_scan_grey));
        setChangeModeIcon(attributeSet.getResourceId(C2744j.EditCardView_changeModeIcon, C2739e.acq_next_grey));
        attributeSet.recycle();
    }

    public void setEnabled(boolean z) {
        setAddStatesFromChildren(z);
        super.setEnabled(z);
        this.etCardNumber.setEnabled(z);
        this.etDate.setEnabled(z);
        this.etCvc.setEnabled(z);
        if (z) {
            showScanButton();
            return;
        }
        hideScanButton();
        hideChangeModeButton();
    }

    public void setFocusable(boolean z) {
        super.setFocusable(z);
        setFocusableInTouchMode(z);
        this.etCardNumber.setFocusable(z);
        this.etCardNumber.setFocusableInTouchMode(z);
        this.etDate.setFocusable(z);
        this.etDate.setFocusableInTouchMode(z);
        this.etCvc.setFocusable(z);
        this.etCvc.setFocusableInTouchMode(z);
    }

    public void clearFocus() {
        super.clearFocus();
        this.etCardNumber.clearFocus();
        this.etDate.clearFocus();
        this.etCvc.clearFocus();
    }

    public void disableCopyPaste() {
        Callback disableCopyPasteActionModeCallback = new DisableCopyPasteActionModeCallback();
        this.etCardNumber.setCustomSelectionActionModeCallback(disableCopyPasteActionModeCallback);
        this.etDate.setCustomSelectionActionModeCallback(disableCopyPasteActionModeCallback);
        this.etCvc.setCustomSelectionActionModeCallback(disableCopyPasteActionModeCallback);
    }

    public void dispatchFocus() {
        if (!check(64)) {
            if (check(32)) {
                activate(this.etCvc);
            } else if (check(2)) {
                activate(this.etCardNumber);
            } else if (this.etDate.length() == 5) {
                activate(this.etCvc);
            } else {
                activate(this.etDate);
            }
        }
    }

    protected EditText onCreateField(Context context, AttributeSet attributeSet) {
        return attributeSet == null ? new EditText(context) : new EditText(context, attributeSet);
    }

    public void setFullCardNumberModeEnable(boolean z) {
        if (z) {
            this.flags &= -17;
        } else {
            this.flags |= 16;
        }
        requestLayout();
        invalidate();
    }

    public void setSavedCardState(boolean z) {
        if (check(32) == z) {
            normalizeMode();
            return;
        }
        if (z) {
            setMode(false);
            hideChangeModeButton();
            hideScanButton();
            this.flags |= true;
            this.etDate.setText(DATE_MASK);
            this.etCvc.setText(BuildConfig.FLAVOR);
            this.etDate.setEnabled(false);
            this.etCardNumber.setEnabled(false);
        } else {
            setMode(true);
            showScanButton();
            this.flags &= -33;
            this.etDate.setEnabled(true);
            this.etCardNumber.setEnabled(true);
            this.etCardNumber.setMode(0);
            this.etCardNumber.setText(BuildConfig.FLAVOR);
            this.etCvc.setText(BuildConfig.FLAVOR);
            this.etDate.setText(BuildConfig.FLAVOR);
        }
        requestLayout();
    }

    public void setRecurrentPaymentMode(boolean z) {
        if (z) {
            setMode(false);
            hideChangeModeButton();
            hideScanButton();
            this.flags |= 64;
            this.etCardNumber.setEnabled(false);
            this.etDate.setText(DATE_MASK);
            this.etDate.setEnabled(false);
            this.etCvc.setText(BuildConfig.FLAVOR);
            this.etCvc.setEnabled(false);
            this.etCvc.setHint(BuildConfig.FLAVOR);
            requestLayout();
            return;
        }
        this.flags &= -65;
        this.etCvc.setEnabled(true);
        this.etCvc.setFocusable(true);
        this.etCvc.setFocusableInTouchMode(true);
        this.etCvc.setHint(this.cvcHint);
        setSavedCardState(true);
    }

    protected void applyBehaviour(EditText... editTextArr) {
        int i = 1;
        for (EditText editText : editTextArr) {
            editText.setId(i);
            i++;
            editText.setSingleLine(true);
            editText.setPadding(0, 0, 0, 0);
            if (VERSION.SDK_INT < 16) {
                editText.setBackgroundDrawable(null);
            } else {
                editText.setBackground(null);
            }
            editText.setInputType(2);
        }
    }

    public void setHints(String str, String str2, String str3) {
        this.etCardNumber.setHint(str);
        this.etDate.setHint(str2);
        this.etCvc.setHint(str3);
    }

    public void setCardNumber(String str) {
        String cardNumber;
        if (str != null) {
            if (str.length() != 0) {
                this.flags |= 1;
                CardSystemIconsHolder cardSystemIconsHolder = this.cardSystemIconsHolder;
                this.cardSystemLogo = cardSystemIconsHolder == null ? null : cardSystemIconsHolder.getCardSystemBitmap(str);
                cardNumber = getCardNumber();
                if (!(cardNumber == null || cardNumber.length() <= 0 || cardNumber.equals(str))) {
                    this.etCvc.setText(BuildConfig.FLAVOR);
                }
                this.etCardNumber.setText(str);
                if (!(check(32) == null && check(64) == null)) {
                    this.etCardNumber.setMode(1);
                }
                requestLayout();
                dispatchFocus();
            }
        }
        this.flags &= -2;
        cardNumber = getCardNumber();
        this.etCvc.setText(BuildConfig.FLAVOR);
        this.etCardNumber.setText(str);
        this.etCardNumber.setMode(1);
        requestLayout();
        dispatchFocus();
    }

    public void setExpireDate(String str) {
        this.etDate.setText(str);
        dispatchFocus();
    }

    public void clear() {
        if (this.pendingAnimation != null) {
            clearPendingAnimations();
        }
        if (!check(4)) {
            this.flags = 4 | this.flags;
        }
        setMode(true);
        this.etCardNumber.setMode(0);
        this.etCardNumber.setText(BuildConfig.FLAVOR);
        this.etDate.setText(BuildConfig.FLAVOR);
        this.etCvc.setText(BuildConfig.FLAVOR);
        dispatchFocus();
    }

    public String getCardNumberHint() {
        return this.cardNumberHint;
    }

    public String getDateHint() {
        return this.dateHint;
    }

    public String getCvcHint() {
        return this.cvcHint;
    }

    private void clearPendingAnimations() {
        this.pendingAnimation.removeAllListeners();
        this.pendingAnimation.end();
        this.pendingAnimation.cancel();
        this.pendingAnimation = null;
    }

    protected void onMeasure(int i, int i2) {
        if (this.cardSystemIconsHolder != null && check(1)) {
            this.cardSystemLogo = this.cardSystemIconsHolder.getCardSystemBitmap(this.etCardNumber.getText().toString());
        }
        int mode = MeasureSpec.getMode(i2);
        i = MeasureSpec.getSize(i);
        i2 = MeasureSpec.getSize(i2);
        boolean check = check(2);
        int i3 = 0;
        int calculateCardLogoWidth = check(1) ? calculateCardLogoWidth() : 0;
        int calculateScanButtonWidth = check(4) ? calculateScanButtonWidth() + 0 : 0;
        if (check(8)) {
            calculateScanButtonWidth += calculateChangeModeWidth();
        }
        calculateCardLogoWidth = (((i - calculateCardLogoWidth) - calculateScanButtonWidth) - getRealCardLogoTextMargin()) - (getPaddingRight() + getPaddingLeft());
        calculateScanButtonWidth = MeasureSpec.makeMeasureSpec(calculateCardLogoWidth / 3, 1073741824);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.etCardNumber.measure(check ? MeasureSpec.makeMeasureSpec(calculateCardLogoWidth, 1073741824) : calculateScanButtonWidth, makeMeasureSpec);
        this.etDate.measure(calculateScanButtonWidth, makeMeasureSpec);
        this.etCvc.measure(calculateScanButtonWidth, makeMeasureSpec);
        calculateCardLogoWidth = Math.max(calculateChangeModeHeight(), calculateScanButtonHeight());
        Bitmap bitmap = this.cardSystemLogo;
        if (bitmap != null) {
            i3 = bitmap.getHeight();
        }
        calculateCardLogoWidth = Math.max(Math.max(i3, calculateCardLogoWidth), Math.max(this.etCardNumber.getMeasuredHeight(), Math.max(this.etCvc.getMeasuredHeight(), this.etDate.getMeasuredHeight()))) + (getPaddingTop() + getPaddingBottom());
        if (mode != 1073741824) {
            i2 = mode == LinearLayoutManager.INVALID_OFFSET ? Math.min(i2, calculateCardLogoWidth) : calculateCardLogoWidth;
        }
        setMeasuredDimension(i, i2);
    }

    private int calculateCardLogoWidth() {
        Bitmap bitmap = this.cardSystemLogo;
        return bitmap == null ? 0 : (int) (((float) bitmap.getWidth()) * this.cardSystemLogoAnimationFactor);
    }

    private int calculateScanButtonWidth() {
        return this.btnScanCard.getWidth();
    }

    private int calculateChangeModeWidth() {
        return this.btnChangeMode.getWidth();
    }

    private int calculateScanButtonHeight() {
        return this.btnScanCard.getHeight();
    }

    private int calculateChangeModeHeight() {
        return this.btnChangeMode.getHeight();
    }

    private boolean check(int i) {
        return (this.flags & i) == i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        i2 = 0;
        i = ((check(1) != 0 ? calculateCardLogoWidth() : 0) + getPaddingLeft()) + getRealCardLogoTextMargin();
        i3 = (getWidth() - getPaddingRight()) - getPaddingLeft();
        i4 = ((getHeight() - getPaddingTop()) - getPaddingBottom()) >> 1;
        if (check(4)) {
            i2 = 0 + calculateScanButtonWidth();
            SimpleButton simpleButton = this.btnScanCard;
            simpleButton.layoutIn(((i3 - i2) + (simpleButton.getWidth() >> 1)) + getPaddingLeft(), getPaddingTop() + i4);
        }
        if (check(8)) {
            i2 += calculateChangeModeWidth();
            simpleButton = this.btnChangeMode;
            simpleButton.layoutIn(((i3 - i2) + (simpleButton.getWidth() >> 1)) + getPaddingLeft(), i4 + getPaddingTop());
        }
        i2 = (getHeight() - this.etCardNumber.getMeasuredHeight()) >> 1;
        i3 = this.etCardNumber.getMeasuredWidth() + i;
        i4 = this.etCardNumber;
        i4.layout(i, i2, i3, i4.getMeasuredHeight() + i2);
        i = (getHeight() - this.etDate.getMeasuredHeight()) >> 1;
        i2 = this.etDate.getMeasuredWidth() + i3;
        i4 = this.etDate;
        i4.layout(i3, i, i2, i4.getMeasuredHeight() + i);
        z = (getHeight() - this.etCvc.getMeasuredHeight()) >> 1;
        i = this.etCvc.getMeasuredWidth() + i2;
        i3 = this.etCvc;
        i3.layout(i2, z, i, i3.getMeasuredHeight() + z);
    }

    protected void dispatchDraw(Canvas canvas) {
        if (check(1) && this.cardSystemLogo != null) {
            canvas.drawBitmap(this.cardSystemLogo, (float) this.cardLogoMargin, (float) ((getHeight() - this.cardSystemLogo.getHeight()) >> 1), this.cardSystemLogoPaint);
        }
        if (check(8)) {
            this.btnChangeMode.drawWithPaint(canvas, this.paint);
        }
        if (check(4)) {
            this.btnScanCard.drawWithPaint(canvas, this.paint);
        }
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (check(8) && this.btnChangeMode.handleAction(motionEvent) && this.buttonsAvailable) {
                showCvcAndDate();
                return true;
            } else if (check(4) && this.btnScanCard.handleAction(motionEvent) && this.buttonsAvailable) {
                this.actions.onPressScanCard(this);
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMode(boolean z) {
        if (z) {
            this.flags |= 2;
        } else {
            this.flags &= -3;
        }
        normalizeMode();
    }

    private int getRealCardLogoTextMargin() {
        return (!check(1) || this.cardSystemLogo == null) ? 0 : this.cardTextMargin;
    }

    private void normalizeMode() {
        if (check(2)) {
            this.etCvc.setVisibility(8);
            this.etDate.setVisibility(8);
        } else {
            this.etCvc.setVisibility(0);
            this.etDate.setVisibility(0);
        }
        requestLayout();
    }

    private void showCardSystemLogo() {
        this.cardSystemLogo = this.cardSystemIconsHolder.getCardSystemBitmap(this.etCardNumber.getText().toString());
        this.flags |= 1;
        this.cardSystemLogoPaint.setAlpha(0);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.cardSystemLogoPaint, PAINT_ALPHA, new int[]{0, 255});
        ofInt.setDuration(150);
        ofInt.addUpdateListener(new C27997());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, CARD_SYSTEM_LOGO_ANIMATION_FACTOR, new float[]{0.0f, 1.0f});
        ofFloat.setDuration(150);
        ofFloat.setInterpolator(new OvershootInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofFloat, ofInt});
        animatorSet.addListener(new C28008());
        animatorSet.start();
    }

    private void hideCardSystemLogo() {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.cardSystemLogoPaint, PAINT_ALPHA, new int[]{255, 0});
        ofInt.setDuration(150);
        ofInt.addUpdateListener(new C28019());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, CARD_SYSTEM_LOGO_ANIMATION_FACTOR, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(150);
        ofFloat.setInterpolator(new OvershootInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofInt, ofFloat});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                animator = EditCardView.this;
                animator.flags = animator.flags & -2;
                EditCardView.this.requestLayout();
                EditCardView.this.invalidate();
            }
        });
        animatorSet.start();
    }

    private void showCvcAndDate() {
        hideChangeModeButton();
        final MutableColorSpan mutableColorSpan = new MutableColorSpan(this.textColor);
        this.etCardNumber.getText().setSpan(mutableColorSpan, 0, Math.max(this.etCardNumber.length() - 4, 0), 33);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(mutableColorSpan, MutableColorSpan.ALPHA, new int[]{255, 0});
        ofInt.setDuration(200);
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (EditCardView.this.etCardNumber.getMode() == null) {
                    EditCardView.this.etCardNumber.getText().setSpan(mutableColorSpan, 0, Math.max(EditCardView.this.etCardNumber.length() - 4, 0), 33);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.etCardNumber, CardNumberEditText.ANIMATION_FACTOR, new float[]{0.0f, 1.0f});
        ofFloat.setStartDelay(140);
        ofFloat.setDuration(210);
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                EditCardView.this.etCardNumber.setMode(1);
            }
        });
        this.etDate.setVisibility(0);
        this.etDate.setAlpha(0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.etDate, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat2.setDuration(200);
        ofFloat2.setStartDelay(200);
        this.etCvc.setVisibility(0);
        this.etCvc.setAlpha(0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.etCvc, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat3.setDuration(200);
        ofFloat3.setStartDelay(280);
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofInt, ofFloat, ofFloat3, ofFloat2});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                EditCardView.this.setMode(false);
                EditCardView.this.pendingAnimation = null;
                EditCardView.this.dispatchFocus();
            }
        });
        this.pendingAnimation = animatorSet;
        animatorSet.start();
    }

    private void hideCvcAndDate() {
        final MutableColorSpan mutableColorSpan = new MutableColorSpan(this.textColor);
        mutableColorSpan.setAlpha(0);
        Animator ofInt = ObjectAnimator.ofInt(mutableColorSpan, MutableColorSpan.ALPHA, new int[]{0, 255});
        ofInt.setDuration(250);
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.setStartDelay(200);
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (EditCardView.this.etCardNumber.getMode() == null) {
                    EditCardView.this.etCardNumber.getText().setSpan(mutableColorSpan, 0, Math.max(EditCardView.this.etCardNumber.length() - 4, 0), 33);
                }
            }
        });
        Animator ofFloat = ObjectAnimator.ofFloat(this.etCardNumber, CardNumberEditText.ANIMATION_FACTOR, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(200);
        Animator ofFloat2 = ObjectAnimator.ofFloat(this.etDate, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat2.setDuration(150);
        ofFloat2.setStartDelay(80);
        ofFloat2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                EditCardView.this.etCardNumber.setMode(0);
                EditCardView.this.etCardNumber.setSelection(EditCardView.this.etCardNumber.length());
                EditCardView.this.etCardNumber.getText().setSpan(mutableColorSpan, 0, Math.max(EditCardView.this.etCardNumber.length() - 4, 0), 33);
                EditCardView.this.setMode(true);
            }
        });
        Animator ofFloat3 = ObjectAnimator.ofFloat(this.etCvc, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat3.setDuration(150);
        Animator animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat3).with(ofFloat2).before(ofFloat).before(ofInt);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                EditCardView.this.pendingAnimation = null;
                animator = EditCardView.this;
                animator.activate(animator.etCardNumber);
                EditCardView.this.showChangeModeButton();
            }
        });
        this.pendingAnimation = animatorSet;
        animatorSet.start();
    }

    private void showChangeModeButton() {
        this.flags |= 8;
        requestLayout();
    }

    private void hideChangeModeButton() {
        this.flags &= -9;
        requestLayout();
    }

    private void showScanButton() {
        this.flags |= 4;
        requestLayout();
    }

    private void hideScanButton() {
        this.flags &= -5;
        requestLayout();
    }

    private void activate(final EditText editText) {
        editText.requestFocus();
        editText.post(new Runnable() {
            public void run() {
                EditText editText = editText;
                editText.setSelection(editText.length());
            }
        });
    }

    private boolean isCardNumberFocused() {
        return (!this.etCardNumber.isFocused() || this.etDate.isFocused() || this.etCvc.isFocused()) ? false : true;
    }

    public void setCardHint(String str) {
        this.etCardNumber.setHint(str);
    }

    public void setCardSystemLogoAnimationFactor(float f) {
        this.cardSystemLogoAnimationFactor = f;
        requestLayout();
        invalidate();
    }

    public float getCardSystemLogoAnimationFactor() {
        return this.cardSystemLogoAnimationFactor;
    }

    public void setCardSystemIconsHolder(CardSystemIconsHolder cardSystemIconsHolder) {
        this.cardSystemIconsHolder = cardSystemIconsHolder;
        requestLayout();
    }

    public void setBtnScanIcon(int i) {
        this.scanResId = i;
        this.btnScanCard.setBitmap(BitmapFactory.decodeResource(getResources(), i));
        requestLayout();
    }

    public void setChangeModeIcon(int i) {
        this.nextResId = i;
        this.btnChangeMode.setBitmap(BitmapFactory.decodeResource(getResources(), i));
        requestLayout();
    }

    public void setActions(Actions actions) {
        if (actions != null) {
            this.actions = actions;
        } else {
            this.actions = NO_ACTIONS;
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.flags = this.flags;
        savedState.pan = getCardNumber();
        savedState.date = getExpireDate();
        savedState.scanResId = this.scanResId;
        savedState.nextResId = this.nextResId;
        savedState.animationFactor = this.etCardNumber.animationFactor;
        savedState.cardNumberMode = this.etCardNumber.mode;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.flags = savedState.flags;
        setCardNumber(savedState.pan);
        setExpireDate(savedState.date);
        setChangeModeIcon(savedState.nextResId);
        setBtnScanIcon(savedState.scanResId);
        this.etCardNumber.animationFactor = savedState.animationFactor;
        this.etCardNumber.setMode(savedState.cardNumberMode);
        parcelable = (check(32) == null && check(64) == null) ? true : null;
        this.etDate.setEnabled(parcelable);
        this.etCardNumber.setEnabled(parcelable);
        normalizeMode();
    }

    public boolean onCheckIsTextEditor() {
        return super.onCheckIsTextEditor();
    }
}
