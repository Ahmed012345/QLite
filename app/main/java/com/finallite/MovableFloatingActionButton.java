package com.finallite;


import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.nightonke.boommenu.Animation.AnimationManager;
import com.nightonke.boommenu.Animation.Ease;
import com.nightonke.boommenu.Animation.EaseEnum;
import com.nightonke.boommenu.BMBShadow;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Util;
import com.finallite.app.main.custom.ExampleMaterialAboutActivity;
import com.nightonke.boommenu.R;

public class MovableFloatingActionButton extends FrameLayout  {

    protected static final String TAG = "BoomMenuButton";

    // Basic
    private Context context;
    private boolean needToLayout = true;
    private boolean inList;

    // Shadow
    private boolean shadowEffect;
    private int shadowOffsetX;
    private int shadowOffsetY;
    private int shadowRadius;
    private int shadowColor;
    private BMBShadow shadow;

    // Button
    private int buttonRadius;
    private ButtonEnum buttonEnum = ButtonEnum.Unknown;
    private boolean backgroundEffect;
    private boolean rippleEffect;
    private int normalColor;
    private int highlightedColor;
    private int unableColor;
    private boolean draggable;
    private float startPositionX;
    private float startPositionY;
    private boolean ableToStartDragging = false;
    private boolean isDragging = false;
    private float lastMotionX = -1;
    private float lastMotionY = -1;
    private Rect edgeInsetsInParentView;
    private FrameLayout button;

    public MovableFloatingActionButton(Context context) {
        super(context);
        init(context, null);
    }

    public MovableFloatingActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MovableFloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;

        LayoutInflater.from(context).inflate(R.layout.bmb, this, true);
        initAttrs(context, attrs);
        initShadow();
        initButton();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(
                attrs, R.styleable.BoomMenuButton, 0, 0);
        if (typedArray == null) return;
        try {
            // Basic
            inList = Util.getBoolean(typedArray, R.styleable.BoomMenuButton_bmb_inList, R.bool.default_bmb_inList);

            // Shadow
            shadowEffect = Util.getBoolean(typedArray, R.styleable.BoomMenuButton_bmb_shadowEffect, R.bool.default_bmb_shadow_effect);
            shadowRadius = Util.getDimenSize(typedArray, R.styleable.BoomMenuButton_bmb_shadowRadius, R.dimen.default_bmb_shadow_radius);
            shadowOffsetX = Util.getDimenOffset(typedArray, R.styleable.BoomMenuButton_bmb_shadowOffsetX, R.dimen.default_bmb_shadow_offset_x);
            shadowOffsetY = Util.getDimenOffset(typedArray, R.styleable.BoomMenuButton_bmb_shadowOffsetY, R.dimen.default_bmb_shadow_offset_y);
            shadowColor = Util.getColor(typedArray, R.styleable.BoomMenuButton_bmb_shadowColor, R.color.default_bmb_shadow_color);

            // Button
            buttonRadius = Util.getDimenSize(typedArray, R.styleable.BoomMenuButton_bmb_buttonRadius, R.dimen.default_bmb_button_radius);
            buttonEnum = ButtonEnum.getEnum(Util.getInt(typedArray, R.styleable.BoomMenuButton_bmb_buttonEnum, R.integer.default_bmb_button_enum));
            backgroundEffect = Util.getBoolean(typedArray, R.styleable.BoomMenuButton_bmb_backgroundEffect, R.bool.default_bmb_background_effect);
            rippleEffect = Util.getBoolean(typedArray, R.styleable.BoomMenuButton_bmb_rippleEffect, R.bool.default_bmb_ripple_effect);
            normalColor = Util.getColor(typedArray, R.styleable.BoomMenuButton_bmb_normalColor, R.color.default_bmb_normal_color);
            highlightedColor = Util.getColor(typedArray, R.styleable.BoomMenuButton_bmb_highlightedColor, R.color.default_bmb_highlighted_color);
            if (highlightedColor == Color.TRANSPARENT) highlightedColor = Util.getDarkerColor(normalColor);
            unableColor = Util.getColor(typedArray, R.styleable.BoomMenuButton_bmb_unableColor, R.color.default_bmb_unable_color);
            if (unableColor == Color.TRANSPARENT) unableColor = Util.getLighterColor(normalColor);
            draggable = Util.getBoolean(typedArray, R.styleable.BoomMenuButton_bmb_draggable, R.bool.default_bmb_draggable);
            edgeInsetsInParentView = new Rect(0, 0, 0, 0);
            edgeInsetsInParentView.left = Util.getDimenOffset(typedArray, R.styleable.BoomMenuButton_bmb_edgeInsetsLeft, R.dimen.default_bmb_edgeInsetsLeft);
            edgeInsetsInParentView.top = Util.getDimenOffset(typedArray, R.styleable.BoomMenuButton_bmb_edgeInsetsTop, R.dimen.default_bmb_edgeInsetsTop);
            edgeInsetsInParentView.right = Util.getDimenOffset(typedArray, R.styleable.BoomMenuButton_bmb_edgeInsetsRight, R.dimen.default_bmb_edgeInsetsRight);
            edgeInsetsInParentView.bottom = Util.getDimenOffset(typedArray, R.styleable.BoomMenuButton_bmb_edgeInsetsBottom, R.dimen.default_bmb_edgeInsetsBottom);
          } finally {
            typedArray.recycle();
        }
    }

    private void initShadow() {
        if (shadow == null) shadow = (BMBShadow) findViewById(R.id.shadow);
        boolean hasShadow = shadowEffect && backgroundEffect && !inList;
        shadow.setShadowEffect(hasShadow);
        if (hasShadow) {
            shadow.setShadowOffsetX(shadowOffsetX);
            shadow.setShadowOffsetY(shadowOffsetY);
            shadow.setShadowColor(shadowColor);
            shadow.setShadowRadius(shadowRadius);
            shadow.setShadowCornerRadius(shadowRadius + buttonRadius);
        } else {
            shadow.clearShadow();
        }
    }

    private void initButton() {
        if (button == null) button = (FrameLayout) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(v.getContext(), ExampleMaterialAboutActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                v.getContext().startActivity(i);          }
        });
        initDraggableTouchListener();

        setButtonSize();
        setButtonBackground();
    }



    private void setButtonSize() {
        LayoutParams params = (LayoutParams) button.getLayoutParams();
        params.width = buttonRadius * 2;
        params.height = buttonRadius * 2;
        button.setLayoutParams(params);
    }

    private void setButtonBackground() {
        if (backgroundEffect && !inList) {
            if (rippleEffect && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                RippleDrawable rippleDrawable = new RippleDrawable(
                        ColorStateList.valueOf(highlightedColor),
                        Util.getOvalDrawable(button, normalColor),
                        null);
                Util.setDrawable(button, rippleDrawable);
            } else {
                StateListDrawable stateListDrawable = Util.getOvalStateListBitmapDrawable(
                        button,
                        buttonRadius,
                        normalColor,
                        highlightedColor,
                        unableColor);
                Util.setDrawable(button, stateListDrawable);
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Util.setDrawable(button, Util.getSystemDrawable(context, android.R.attr.selectableItemBackgroundBorderless));
            } else {
                Util.setDrawable(button, Util.getSystemDrawable(context, android.R.attr.selectableItemBackground));
            }
        }
    }

    private void initDraggableTouchListener() {
        if (button == null) return;
        if (!draggable) button.setOnTouchListener(null);
        else {
            button.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:
                            if (draggable) {
                                startPositionX = getX() - event.getRawX();
                                startPositionY = getY() - event.getRawY();
                                lastMotionX = event.getRawX();
                                lastMotionY = event.getRawY();
                            }
                            break;
                        case MotionEvent.ACTION_MOVE:
                            if (Math.abs(lastMotionX - event.getRawX()) > 10
                                    || Math.abs(lastMotionY - event.getRawY()) > 10)
                                ableToStartDragging = true;
                            if (draggable && ableToStartDragging) {
                                isDragging = true;
                                if (shadow != null) {
                                    setX(event.getRawX() + startPositionX);
                                    setY(event.getRawY() + startPositionY);
                                }
                            } else {
                                ableToStartDragging = false;
                            }
                            break;
                        case MotionEvent.ACTION_UP:
                            if (isDragging) {
                                ableToStartDragging = false;
                                isDragging = false;
                                preventDragOutside();
                                button.setPressed(false);
                                return true;
                            }
                            break;
                        case MotionEvent.ACTION_CANCEL:
                            if (isDragging) {
                                ableToStartDragging = false;
                                isDragging = false;
                                preventDragOutside();
                                return true;
                            }
                            break;
                    }
                    return false;
                }
            });
        }
    }




    private void preventDragOutside() {
        boolean needToAdjustXY = false;
        float newX = getX();
        float newY = getY();
        ViewGroup parentView = (ViewGroup) getParent();

        if (newX < edgeInsetsInParentView.left) {
            newX = edgeInsetsInParentView.left;
            needToAdjustXY = true;
        }

        if (newY < edgeInsetsInParentView.top) {
            newY = edgeInsetsInParentView.top;
            needToAdjustXY = true;
        }

        if (newX > parentView.getWidth() - edgeInsetsInParentView.right - getWidth()) {
            newX = parentView.getWidth() - edgeInsetsInParentView.right - getWidth();
            needToAdjustXY = true;
        }

        if (newY > parentView.getHeight() - edgeInsetsInParentView.bottom - getHeight()) {
            newY = parentView.getHeight() - edgeInsetsInParentView.bottom - getHeight();
            needToAdjustXY = true;
        }

        if (needToAdjustXY) {
            AnimationManager.animate(this, "x", 0, 300, Ease.getInstance(EaseEnum.EaseOutBack), getX(), newX);
            AnimationManager.animate(this, "y", 0, 300, Ease.getInstance(EaseEnum.EaseOutBack), getY(), newY);
        }
    }

    private void toLayout() {
        if (needToLayout) return;
        needToLayout = true;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            if (!isInLayout()) requestLayout();
        } else {
            requestLayout();
        }
    }


    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        button.setEnabled(enabled);
        setButtonBackground();
    }


    public boolean isRippleEffect() {
        return rippleEffect;
    }

    /**
     * Whether the BMB should have a ripple-effect.
     * The ripple effect is disable below LOLLIPOP.
     *
     * @param rippleEffect ripple effect
     */
    public void setRippleEffect(boolean rippleEffect) {
        if (this.rippleEffect == rippleEffect) return;
        this.rippleEffect = rippleEffect;
        setButtonBackground();
        toLayout();
    }

    public int getNormalColor() {
        return normalColor;
    }

    /**
     * Set the color of BMB at normal-state.
     *
     * @param normalColor the color of BMB at normal-state
     */
    public void setNormalColor(int normalColor) {
        if (this.normalColor == normalColor) return;
        this.normalColor = normalColor;
        setButtonBackground();
        toLayout();
    }

    public int getHighlightedColor() {
        return highlightedColor;
    }

    /**
     * Set the color of BMB at highlighted-state.
     *
     * @param highlightedColor the color of BMB at highlighted-state
     */
    public void setHighlightedColor(int highlightedColor) {
        if (this.highlightedColor == highlightedColor) return;
        this.highlightedColor = highlightedColor;
        setButtonBackground();
        toLayout();
    }

    public int getUnableColor() {
        return unableColor;
    }

    /**
     * Set the color of BMB at unable-state.
     *
     * @param unableColor the color of BMB at unable-state
     */
    public void setUnableColor(int unableColor) {
        if (this.unableColor == unableColor) return;
        this.unableColor = unableColor;
        setButtonBackground();
        toLayout();
    }

    public boolean isDraggable() {
        return draggable;
    }

    /**
     * Make BMB draggable or not.
     *
     * @param draggable draggable or not.
     */
    public void setDraggable(boolean draggable) {
        if (this.draggable == draggable) return;
        this.draggable = draggable;
        initDraggableTouchListener();
    }

    public Rect getEdgeInsetsInParentView() {
        return edgeInsetsInParentView;
    }



    //endregion
}
