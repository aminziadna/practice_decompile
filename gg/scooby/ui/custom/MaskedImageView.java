package ru.gg.scooby.ui.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.util.HashMap;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.C2660R;
import ru.gg.scooby.util.UIUtils;

@SuppressLint({"AppCompatCustomView"})
/* compiled from: MaskedImageView.kt */
public class MaskedImageView extends ImageView {
    private HashMap _$_findViewCache;
    private BitmapShader bitmapShader;
    private int layoutHeight;
    private int layoutWidth;
    private Bitmap maskBitmap;
    private Bitmap originalBitmap;
    private int overlayColor;
    private Paint overlayPaint;
    private Paint paintShader;

    public MaskedImageView(Context context) {
        this(context, null, 2, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    public MaskedImageView(Context context, AttributeSet attributeSet) {
        C0700j.m2715b(context, "context");
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2660R.styleable.MaskedImageView);
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            this.overlayColor = obtainStyledAttributes.getColor(1, 0);
            if (this.overlayColor != 0) {
                this.overlayPaint = new Paint(1);
                Paint paint = this.overlayPaint;
                if (paint != null) {
                    paint.setColor(this.overlayColor);
                }
                paint = this.overlayPaint;
                if (paint != null) {
                    paint.setXfermode(new PorterDuffXfermode(Mode.OVERLAY));
                }
            }
            attributeSet = context.obtainStyledAttributes(attributeSet, new int[]{16842996, 16842997});
            this.layoutWidth = attributeSet.getLayoutDimension(0, 0);
            this.layoutHeight = attributeSet.getLayoutDimension(1, 0);
            this.maskBitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
            context = this.layoutWidth;
            if (context > null) {
                int i = this.layoutHeight;
                if (i > 0) {
                    this.maskBitmap = Bitmap.createScaledBitmap(this.maskBitmap, context, i, true).extractAlpha();
                    updateBitmapAndShader();
                    updateScaleMatrix();
                    obtainStyledAttributes.recycle();
                    attributeSet.recycle();
                }
            }
            context = this.maskBitmap;
            this.maskBitmap = context != null ? context.extractAlpha() : null;
            updateBitmapAndShader();
            updateScaleMatrix();
            obtainStyledAttributes.recycle();
            attributeSet.recycle();
        }
    }

    public /* synthetic */ MaskedImageView(Context context, AttributeSet attributeSet, int i, C0697g c0697g) {
        if ((i & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    private final void updateBitmapAndShader() {
        if (getDrawable() != null) {
            Paint paint;
            UIUtils uIUtils = UIUtils.INSTANCE;
            Object drawable = getDrawable();
            C0700j.m2711a(drawable, "drawable");
            this.originalBitmap = UIUtils.getBitmapFromDrawable$default(uIUtils, drawable, 0, 0, 6, null);
            this.bitmapShader = new BitmapShader(this.originalBitmap, TileMode.REPEAT, TileMode.REPEAT);
            if (this.paintShader == null) {
                this.paintShader = new Paint(1);
                paint = this.paintShader;
                if (paint != null) {
                    paint.setFilterBitmap(true);
                }
            }
            paint = this.paintShader;
            if (paint != null) {
                paint.setShader(this.bitmapShader);
            }
            updateScaleMatrix();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        updateBitmapAndShader();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        updateBitmapAndShader();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        updateBitmapAndShader();
    }

    private final void updateScaleMatrix() {
        if (this.originalBitmap != null) {
            Bitmap bitmap = this.maskBitmap;
            if (bitmap != null) {
                int i = this.layoutWidth;
                if (i <= 0) {
                    if (bitmap == null) {
                        C0700j.m2709a();
                    }
                    i = bitmap.getWidth();
                }
                int i2 = this.layoutHeight;
                if (i2 <= 0) {
                    bitmap = this.maskBitmap;
                    if (bitmap == null) {
                        C0700j.m2709a();
                    }
                    i2 = bitmap.getHeight();
                }
                Bitmap bitmap2 = this.originalBitmap;
                if (bitmap2 == null) {
                    C0700j.m2709a();
                }
                int width = bitmap2.getWidth();
                Bitmap bitmap3 = this.originalBitmap;
                if (bitmap3 == null) {
                    C0700j.m2709a();
                }
                float f = (float) i;
                float f2 = (float) width;
                float f3 = (float) i2;
                float height = (float) bitmap3.getHeight();
                float max = Math.max(f / f2, f3 / height);
                Matrix matrix = new Matrix();
                matrix.setScale(max, max);
                matrix.postTranslate((f - (f2 * max)) / 2.0f, (f3 - (height * max)) / 2.0f);
                BitmapShader bitmapShader = this.bitmapShader;
                if (bitmapShader != null) {
                    bitmapShader.setLocalMatrix(matrix);
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.layoutWidth == -2 && this.layoutHeight == -2) {
            i = this.maskBitmap;
            if (i != 0) {
                setMeasuredDimension(i.getWidth(), i.getHeight());
                return;
            }
            return;
        }
        setMeasuredDimension(getLayoutParams().width, getLayoutParams().height);
    }

    protected void onDraw(Canvas canvas) {
        C0700j.m2715b(canvas, "canvas");
        if (getWidth() > 0) {
            if (getHeight() > 0) {
                canvas.drawBitmap(this.maskBitmap, 0.0f, 0.0f, this.paintShader);
                Paint paint = this.overlayPaint;
                if (paint != null) {
                    canvas.drawBitmap(this.maskBitmap, 0.0f, 0.0f, paint);
                }
                return;
            }
        }
        super.onDraw(canvas);
    }
}
