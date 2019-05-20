package ru.tinkoff.acquiring.sdk.views;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import ru.tinkoff.acquiring.sdk.ax.C2740f;
import ru.tinkoff.acquiring.sdk.ax.C2741g;

public class BankKeyboard extends FrameLayout implements OnClickListener, OnFocusChangeListener, OnLongClickListener {
    public static final int ASCII_CODE_OF_ZERO = 48;
    public static final int CUSTOM_KEYBOARD_HIDE_DELAY_MILLIS = 50;
    public static final int KEYBOARD_ANIMATION_MILLIS = 50;
    public static final int KEYBOARD_SHOW_DELAY_MILLIS = 500;
    public static final int SYSTEM_KEYBOARD_HIDE_DELAY_MILLIS = 100;
    private Runnable hidePerformer = new C27881();
    private boolean shouldHide;

    /* renamed from: ru.tinkoff.acquiring.sdk.views.BankKeyboard$1 */
    class C27881 implements Runnable {
        C27881() {
        }

        public void run() {
            if (BankKeyboard.this.shouldHide) {
                BankKeyboard.this.shouldHide = false;
                BankKeyboard.this.setEnabled(false);
                BankKeyboard.this.createVisibilityAnimator(false).start();
            }
        }
    }

    /* renamed from: ru.tinkoff.acquiring.sdk.views.BankKeyboard$2 */
    class C27892 implements Runnable {
        C27892() {
        }

        public void run() {
            BankKeyboard.this.createVisibilityAnimator(true).start();
        }
    }

    /* renamed from: ru.tinkoff.acquiring.sdk.views.BankKeyboard$3 */
    class C27903 implements OnClickListener {
        C27903() {
        }

        public void onClick(View view) {
            EditText editText = (EditText) view;
            if (editText.isEnabled() && editText.isFocusable()) {
                BankKeyboard.this.showFor(editText);
            }
        }
    }

    public BankKeyboard(Context context) {
        super(context);
        init();
    }

    public BankKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BankKeyboard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @TargetApi(21)
    public BankKeyboard(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        int i = 0;
        setEnabled(false);
        LayoutInflater.from(getContext()).inflate(C2741g.acq_widget_keyboard, this, true);
        ViewGroup viewGroup = (ViewGroup) findViewById(C2740f.acq_gl_keys);
        while (i < viewGroup.getChildCount()) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof KeyView) {
                childAt.setOnClickListener(this);
            }
            i++;
        }
    }

    public void attachToView(View view) {
        if (view instanceof EditText) {
            registerEditText((EditText) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                attachToView(viewGroup.getChildAt(i));
            }
        }
    }

    public void showFor(EditText editText) {
        this.shouldHide = false;
        hideSystemKeyboardFor(editText);
        if (isEnabled() == null) {
            setEnabled(true);
            postDelayed(new C27892(), 500);
        }
    }

    public boolean hide() {
        if (!isEnabled() || this.shouldHide) {
            return false;
        }
        this.shouldHide = true;
        postDelayed(this.hidePerformer, 50);
        return true;
    }

    private void registerEditText(EditText editText) {
        editText.setOnFocusChangeListener(this);
        editText.setOnLongClickListener(this);
        editText.setTextIsSelectable(false);
        editText.setOnClickListener(new C27903());
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            showFor((EditText) view);
        } else {
            hide();
        }
    }

    public boolean onLongClick(View view) {
        showFor((EditText) view);
        return true;
    }

    public void onClick(View view) {
        if (view instanceof KeyView) {
            if (getContext() instanceof Activity) {
                View currentFocus = ((Activity) getContext()).getWindow().getCurrentFocus();
                if (currentFocus != null) {
                    if (currentFocus instanceof EditText) {
                        processKeyPress((KeyView) view, (EditText) currentFocus);
                    }
                }
            }
        }
    }

    private void processKeyPress(KeyView keyView, EditText editText) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        editText = editText.getSelectionEnd();
        if (editText > selectionStart) {
            text.delete(selectionStart, editText);
        }
        keyView = keyView.getKeyCode();
        if (keyView <= 9) {
            text.insert(selectionStart, String.valueOf((char) (keyView + 48)));
        } else if (selectionStart > 0) {
            text.delete(selectionStart - 1, selectionStart);
        }
    }

    private void hideSystemKeyboardFor(final View view) {
        if (view != null) {
            if (view.hasFocus()) {
                Runnable c27914 = new Runnable() {
                    public void run() {
                        ((InputMethodManager) BankKeyboard.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                };
                c27914.run();
                for (int i = 0; i <= 100; i += 10) {
                    view.postDelayed(c27914, (long) i);
                }
            }
        }
    }

    private Animator createVisibilityAnimator(final boolean z) {
        float f;
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getSize(new Point());
        float f2 = 0.0f;
        if (z) {
            f2 = (float) getHeight();
            f = 0.0f;
        } else {
            f = (float) getHeight();
        }
        Animator ofFloat = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, new float[]{f2, f});
        ofFloat.setDuration(50);
        ofFloat.addListener(new AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                if (z != null) {
                    BankKeyboard.this.setVisibility(0);
                }
            }

            public void onAnimationEnd(Animator animator) {
                if (z == null) {
                    BankKeyboard.this.setVisibility(8);
                }
            }
        });
        return ofFloat;
    }
}
