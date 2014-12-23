package com.akturk.contextualview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

final class AttributeHelper {
    private CharSequence mPositiveText;
    private CharSequence mNegativeText;
    private int mPositiveTextColorResource;
    private int mNegativeTextColorResource;
    private int mBackgroundResource;

    AttributeHelper(Context context, AttributeSet attrs) {
        setDefaultValues();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ContextualView);
        mPositiveText = typedArray.getText(R.styleable.ContextualView_positiveText);
        mNegativeText = typedArray.getText(R.styleable.ContextualView_negativeTextColor);
        mPositiveTextColorResource = typedArray.getResourceId(R.styleable.ContextualView_positiveTextColor, android.R.color.black);
        mNegativeTextColorResource = typedArray.getResourceId(R.styleable.ContextualView_negativeTextColor, android.R.color.black);
        mBackgroundResource = typedArray.getResourceId(R.styleable.ContextualView_buttonBackground, android.R.color.transparent);

        typedArray.recycle();

    }

    private void setDefaultValues() {
        mPositiveText = "Positive";
        mNegativeText = "Negative";
        mBackgroundResource = android.R.color.transparent;
        mPositiveTextColorResource = android.R.color.black;
        mNegativeTextColorResource = android.R.color.black;
    }

    public CharSequence getPositiveText() {
        return mPositiveText;
    }

    public CharSequence getNegativeText() {
        return mNegativeText;
    }

    public int getPositiveTextColorResource() {
        return mPositiveTextColorResource;
    }

    public int getNegativeTextColorResource() {
        return mNegativeTextColorResource;
    }

    public int getBackgroundResource() {
        return mBackgroundResource;
    }
}
