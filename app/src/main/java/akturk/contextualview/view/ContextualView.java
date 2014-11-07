package akturk.contextualview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import akturk.contextualview.R;
import akturk.contextualview.interfaces.ContextualButtonClickListener;

public class ContextualView extends LinearLayout implements View.OnClickListener {

    private Button mButtonPositive;
    private Button mButtonNegative;
    private ContextualButtonClickListener mListener;

    public ContextualView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            initView();
            initAttributes(attrs);
        }
    }

    public ContextualView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode()) {
            initView();
            initAttributes(attrs);
        }
    }

    private void initView() {
        inflate(getContext(), R.layout.cell_contextual, this);

        mButtonNegative = (Button) findViewById(R.id.contextualview_button_negative);
        mButtonNegative.setOnClickListener(this);

        mButtonPositive = (Button) findViewById(R.id.contextualview_button_positive);
        mButtonPositive.setOnClickListener(this);
    }

    private void initAttributes(AttributeSet attributeSet) {
        TypedArray mTypedArray = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.ContextualView, 0, 0);

        try {
            CharSequence mTextNegative = mTypedArray.getText(R.styleable.ContextualView_text_negative);
            setNegativeButtonText(mTextNegative);

            CharSequence mTextPositive = mTypedArray.getText(R.styleable.ContextualView_text_positive);
            setPositiveButtonText(mTextPositive);

            int mNegativeIconPadding = ((int) mTypedArray.getDimension(R.styleable.ContextualView_padding_icon_negative, 0));
            mButtonNegative.setPadding(mNegativeIconPadding, 0, 0, 0);

            int mPositivePadding = ((int) mTypedArray.getDimension(R.styleable.ContextualView_padding_icon_negative, 0));
            mButtonNegative.setPadding(mPositivePadding, 0, 0, 0);
        } finally {
            mTypedArray.recycle();
        }
    }

    @Override
    public void onClick(View view) {
        if (mListener == null)
            return;

        switch (view.getId()) {
            case R.id.contextualview_button_negative:
                mListener.onNegativeButtonClick();
                return;
            case R.id.contextualview_button_positive:
                mListener.onPositiveButtonClick();
                return;
        }
    }

    public void setOnContextualButtonClickListener(ContextualButtonClickListener callback) {
        mListener = callback;
    }

    public void setNegativeButtonText(CharSequence text) {
        if (TextUtils.isEmpty(text))
            return;

        mButtonNegative.setText(text);
    }

    public void setPositiveButtonText(CharSequence text) {
        if (TextUtils.isEmpty(text))
            return;

        mButtonPositive.setText(text);
    }

    public void setNegativeButtonIcon(@Nullable Drawable icon) {
        mButtonNegative.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
    }

    public void setPositiveButtonIcon(@Nullable Drawable icon) {
        mButtonPositive.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
    }

    public void setNegativeButtonIconResource(@DrawableRes int id) {
        Drawable mDrawable = getResources().getDrawable(id);
        mButtonNegative.setCompoundDrawablesWithIntrinsicBounds(mDrawable, null, null, null);
    }

    public void setPositiveButtonIconResource(@DrawableRes int id) {
        Drawable mDrawable = getResources().getDrawable(id);
        mButtonPositive.setCompoundDrawablesWithIntrinsicBounds(mDrawable, null, null, null);
    }
}
