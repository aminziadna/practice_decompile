package ru.tinkoff.acquiring.sdk.views;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.core.content.C0317a;
import ru.tinkoff.acquiring.sdk.ax.C2737c;
import ru.tinkoff.acquiring.sdk.ax.C2744j;

public class KeyView extends View {
    private static final int CIRCLE_ANIMATION_DURATION_MILLIS = 200;
    private static final String DEFAULT_FONT_FAMILY = "sans-serif-light";
    private static final float KEY_DEFAULT_TEXT_SIZE_DP = 34.0f;
    private static final float KEY_SCALE_X = 0.333f;
    private static final float KEY_SCALE_Y = 0.25f;
    private ValueAnimator circleAnimator;
    private PointF circleCenter;
    private Paint circlePaint;
    private float circleRadius;
    private Bitmap contentImage;
    private Paint contentPaint;
    private String contentText;
    private boolean drawingPressAnimation = null;
    private int keyCode;
    private float textWidth;

    /* renamed from: ru.tinkoff.acquiring.sdk.views.KeyView$1 */
    class C28051 implements AnimatorUpdateListener {
        C28051() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            KeyView.this.circleRadius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            KeyView.this.invalidate();
        }
    }

    /* renamed from: ru.tinkoff.acquiring.sdk.views.KeyView$2 */
    class C28062 implements AnimatorListener {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        C28062() {
        }

        public void onAnimationEnd(Animator animator) {
            KeyView.this.drawingPressAnimation = false;
            KeyView.this.invalidate();
        }
    }

    private static float dpToPx(float f) {
        return f * Resources.getSystem().getDisplayMetrics().density;
    }

    public KeyView(Context context) {
        super(context);
        init(null);
    }

    public KeyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public KeyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    @TargetApi(21)
    public KeyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        setClickable(true);
        this.contentPaint = new Paint();
        this.contentPaint.setTextSize(dpToPx(KEY_DEFAULT_TEXT_SIZE_DP));
        this.contentPaint.setAntiAlias(true);
        this.contentPaint.setColor(C0317a.m1287c(getContext(), C2737c.acq_colorKeyText));
        this.contentPaint.setTypeface(Typeface.create(DEFAULT_FONT_FAMILY, 0));
        this.circlePaint = new Paint();
        this.circlePaint.setColor(C0317a.m1287c(getContext(), C2737c.acq_colorKeyCircle));
        applyAttrs(attributeSet);
    }

    private void applyAttrs(AttributeSet attributeSet) {
        if (attributeSet != null) {
            attributeSet = getContext().getTheme().obtainStyledAttributes(attributeSet, C2744j.KeyView, 0, 0);
            try {
                this.keyCode = attributeSet.getInt(C2744j.KeyView_keyCode, -1);
                float dimension = attributeSet.getDimension(C2744j.KeyView_keyTextSize, -1.0f);
                if (dimension != -1.0f) {
                    this.contentPaint.setTextSize(dpToPx(dimension));
                }
                String string = attributeSet.getString(C2744j.KeyView_keyTextFontFamily);
                if (string != null) {
                    this.contentPaint.setTypeface(Typeface.create(string, 0));
                }
                this.contentText = attributeSet.getString(C2744j.KeyView_keyText);
                if (this.contentText != null) {
                    this.textWidth = this.contentPaint.measureText(this.contentText);
                }
                int resourceId = attributeSet.getResourceId(C2744j.KeyView_keyImage, -1);
                if (resourceId != -1) {
                    this.contentImage = BitmapFactory.decodeResource(getResources(), resourceId);
                }
                this.contentPaint.setColor(attributeSet.getColor(C2744j.KeyView_keyTextColor, this.contentPaint.getColor()));
                this.circlePaint.setColor(attributeSet.getColor(C2744j.KeyView_keyCircleColor, this.circlePaint.getColor()));
            } finally {
                attributeSet.recycle();
            }
        }
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    public void setKeyCode(int i) {
        this.keyCode = i;
    }

    public String getContentText() {
        return this.contentText;
    }

    public void setContentText(String str) {
        this.contentText = str;
    }

    public Bitmap getContentImage() {
        return this.contentImage;
    }

    public void setContentImage(Bitmap bitmap) {
        this.contentImage = bitmap;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.drawingPressAnimation) {
            this.circleAnimator.cancel();
        }
        this.drawingPressAnimation = true;
        this.circleCenter = new PointF(motionEvent.getX(), motionEvent.getY());
        this.circleAnimator = createCircleAnimator();
        this.circleAnimator.start();
        return super.onTouchEvent(motionEvent);
    }

    private ValueAnimator createCircleAnimator() {
        float max = ((float) Math.max(getWidth(), getHeight())) * 0.8f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, max});
        ofFloat.setDuration(200);
        ofFloat.addUpdateListener(new C28051());
        ofFloat.addListener(new C28062());
        return ofFloat;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension((int) (((float) MeasureSpec.getSize(i)) * 1051361018), (int) (((float) MeasureSpec.getSize(i2)) * 1048576000));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.contentText != null) {
            canvas.drawText(this.contentText, ((float) (getWidth() / 2)) - (this.textWidth / 2.0f), ((float) (getHeight() / 2)) - ((this.contentPaint.descent() + this.contentPaint.ascent()) / 2.0f), this.contentPaint);
        }
        Bitmap bitmap = this.contentImage;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (float) ((getWidth() / 2) - (this.contentImage.getWidth() / 2)), (float) ((getHeight() / 2) - (this.contentImage.getHeight() / 2)), this.contentPaint);
        }
        if (this.drawingPressAnimation) {
            canvas.drawCircle(this.circleCenter.x, this.circleCenter.y, this.circleRadius, this.circlePaint);
        }
    }
}
