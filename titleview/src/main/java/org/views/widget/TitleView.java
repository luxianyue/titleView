package org.views.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.views.R;


/**
 *
 * Created by Jarek on 2016/9/5.
 */
public class TitleView extends FrameLayout {

    private TextView mTvLeft;
    private TextView mTvCenter;
    private TextView mTvRight;

    public TitleView(Context context) {
        this(context, null);
    }

    public TitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        initView(context, attrs);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }


    /**
     * initview
     * @param context Context
     * @param attrs AttributeSet
     */
    private void initView (Context context, AttributeSet attrs) {
        TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.TitleViewAttr);

        mTvLeft = new TextView(context);
        mTvCenter = new TextView(context);
        mTvRight = new TextView(context);

        mTvLeft.setId(R.id.title_left);
        mTvCenter.setId(R.id.title_center);
        mTvRight.setId(R.id.title_right);

        mTvLeft.setGravity(Gravity.CENTER_VERTICAL);
        mTvCenter.setGravity(Gravity.CENTER_VERTICAL);
        mTvRight.setGravity(Gravity.CENTER_VERTICAL);

        int minValue = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 46, context.getResources().getDisplayMetrics());
        mTvLeft.setMinWidth(minValue);
        mTvCenter.setMinWidth(minValue);
        mTvRight.setMinWidth(minValue);

        mTvLeft.setMinHeight(minValue);
        mTvCenter.setMinHeight(minValue);
        mTvRight.setMinHeight(minValue);

        mTvLeft.setText(typeArray.getText(R.styleable.TitleViewAttr_left_text));
        mTvCenter.setText(typeArray.getText(R.styleable.TitleViewAttr_center_text));
        mTvRight.setText(typeArray.getText(R.styleable.TitleViewAttr_right_text));

        mTvLeft.setTextSize(typeArray.getFloat(R.styleable.TitleViewAttr_left_text_size, 16));
        mTvCenter.setTextSize(typeArray.getFloat(R.styleable.TitleViewAttr_center_text_size, 16));
        mTvRight.setTextSize(typeArray.getFloat(R.styleable.TitleViewAttr_right_text_size, 16));

        mTvLeft.setTextColor(typeArray.getColor(R.styleable.TitleViewAttr_left_text_color, Color.WHITE));
        mTvCenter.setTextColor(typeArray.getColor(R.styleable.TitleViewAttr_center_text_color, Color.WHITE));
        mTvRight.setTextColor(typeArray.getColor(R.styleable.TitleViewAttr_right_text_color, Color.WHITE));

        Drawable leftLeftDrawable = typeArray.getDrawable(R.styleable.TitleViewAttr_left_left_drawable);
        Drawable centerLeftDrawable = typeArray.getDrawable(R.styleable.TitleViewAttr_center_left_drawable);
        Drawable rightLeftDrawable = typeArray.getDrawable(R.styleable.TitleViewAttr_right_left_drawable);
        if (leftLeftDrawable != null) {
            leftLeftDrawable.setBounds(0, 0, leftLeftDrawable.getIntrinsicWidth(), leftLeftDrawable.getIntrinsicHeight());
            mTvLeft.setCompoundDrawables(leftLeftDrawable, null, null, null);
        }
        if (centerLeftDrawable != null) {
            centerLeftDrawable.setBounds(0, 0, centerLeftDrawable.getIntrinsicWidth(), centerLeftDrawable.getIntrinsicHeight());
            mTvLeft.setCompoundDrawables(centerLeftDrawable, null, null, null);
        }
        if (rightLeftDrawable != null) {
            rightLeftDrawable.setBounds(0, 0, rightLeftDrawable.getIntrinsicWidth(), rightLeftDrawable.getIntrinsicHeight());
            mTvLeft.setCompoundDrawables(rightLeftDrawable, null, null, null);
        }

        typeArray.recycle();

        LayoutParams leftParam = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParam.gravity = Gravity.CENTER_VERTICAL;

        LayoutParams centerParam = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        centerParam.gravity = Gravity.CENTER;

        LayoutParams rightParam = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParam.gravity = Gravity.CENTER_VERTICAL|Gravity.RIGHT;

        mTvLeft.setLayoutParams(leftParam);
        mTvCenter.setLayoutParams(centerParam);
        mTvRight.setLayoutParams(rightParam);

        addView(mTvLeft, leftParam);
        addView(mTvCenter, centerParam);
        addView(mTvRight, rightParam);
    }


    public TextView getLeftTextView() {
        return mTvLeft;
    }

    public TextView getCenterTextView() {
        return mTvCenter;
    }

    public TextView getRightTextView() {
        return mTvRight;
    }

}

